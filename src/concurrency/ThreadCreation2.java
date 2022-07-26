package concurrency;

public class ThreadCreation2 {
    public static void main(String[] args) {
        var thread = new myThread();
        thread.start();
    }

    private static class myThread extends Thread {
        public void run() {
            System.out.println("the name of this thread is " + Thread.currentThread().getName());
        }
    }
}
