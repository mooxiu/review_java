package concurrency.thread_creation;

public class ThreadCreation {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("name of this thread: " + Thread.currentThread().getName() + " with id: " + Thread.currentThread().getId());
                System.out.println("the priority of this thread is: " + Thread.currentThread().getPriority());
            }
        });
        thread.setName("myThread01");
        thread.setPriority(Thread.MAX_PRIORITY);

        System.out.println("name of the thread before we start: " + Thread.currentThread().getName());
        thread.start();
        System.out.println("name of the thread after we start: " + Thread.currentThread().getName());

        Thread.sleep(1000); // cause current executing thread to sleep
    }
}
