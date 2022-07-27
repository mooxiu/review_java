package concurrency.thread_creation;

public class ThreadException {
    public static void main(String[] args) {
//        var thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });

        var thread = new Thread(() -> {
            System.out.println("the name of the thread is: " + Thread.currentThread().getName());
            throw new RuntimeException("!!!!!!!!!!!!!!");
        });

        thread.setName("ProblemThread");
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("A critical error happend in thread: " + t.getName()
                    + " the error is " + e.getMessage());
            }
        });

        thread.start();
    }
}
