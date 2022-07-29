package concurrency.performance.throughput;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThroughputHTTPServer {
    private static final String BOOK = "src/concurrency/performance/throughput/assets/war_and_peace.txt";

    public static void main(String[] args) {
        String text = null;
        try {
            text = new String(Files.readAllBytes(Paths.get(BOOK)));
        } catch (IOException e) {
            System.out.println("path not found");
            throw new RuntimeException(e);
        }
        try {
            startServer(text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void startServer(String text) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/search", new HttpHandler() {

            @Override
            public void handle(HttpExchange exchange) throws IOException {
                // parse the http request
                var query = exchange.getRequestURI().getQuery();
                var keyValues = query.split("=");
                var action = keyValues[0];
                var keyword = keyValues[1];
                if (!action.equals("word")) {
                    exchange.sendResponseHeaders(400, 0);
                    return;
                }

                // get result
                long count = countWord(keyword);

                // write result to response
                // head
                byte[] response = Long.toString(count).getBytes();
                exchange.sendResponseHeaders(200, response.length);
                // body
                OutputStream outputStream = exchange.getResponseBody();
                outputStream.write(response);
                outputStream.close();
            }

            private long countWord(String word) {
                long count = 0;
                int index = 0;
                while (index >= 0) {
                    index = text.indexOf(word, index);
                    if (index >= 0) {
                        count++;
                        index++;
                    }
                }
                return count;
            }
        });
        Executor executor = Executors.newFixedThreadPool(4);
        server.setExecutor(executor);
        server.start();
    }
}
