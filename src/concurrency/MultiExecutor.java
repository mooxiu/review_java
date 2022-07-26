package concurrency;

import reflection.interfacea.A;

import java.util.ArrayList;
import java.util.List;

public class MultiExecutor {

    // Add any necessary member variables here
    private ArrayList<Thread> threads;

    /*
     * @param tasks to executed concurrently
     */
    public MultiExecutor(List<Runnable> tasks) {
        this.threads = new ArrayList<>();
        // Complete your code here
        for (Runnable task: tasks) {
            Thread t = new Thread(task);
            this.threads.add(t);
        }
    }

    /**
     * Starts and executes all the tasks concurrently
     */
    public void executeAll() {
        // complete your code here
        for (Thread thread: this.threads) {
            thread.start();
        }
    }


    public static void main(String[] args) {
        ArrayList<Runnable> ar = new ArrayList<>();
        ar.add(new Runnable() {
            @Override
            public void run() {
                System.out.println("p1");
            }
        });
        var me = new MultiExecutor(ar);
        me.executeAll();
    }
}

