package concurrency.thread_coordination;

public class ThreadInterrupt3 {
    private static class SleepingThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000000);
                } catch (InterruptedException e) {
                    System.out.println("trying to stop..");
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new SleepingThread());
        thread.start();
        thread.interrupt();
    }
}
