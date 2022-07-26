package concurrency;

import reflection.interfacea.A;

import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.Random;

public class VaultHackingGame {
    public static final int MAX_PASSWORD = 9999;


    public static void main(String[] args) {
        var random = new Random();
        var vault = new Vault(random.nextInt(MAX_PASSWORD));

        ArrayList<Thread> threads = new ArrayList<>();
        threads.add(new AscendingHackerThread(vault));
        threads.add(new DescendingHackerThread(vault));
        threads.add(new PoliceThread());

        for (var t: threads) {
            t.start();
        }
    }

    private static class Vault {
        private final int password;

        public Vault(int password) {
            this.password = password;
        }

        public boolean VerifyPwd(int guess) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return guess == this.password;
        }
    }

    private static abstract class HackingThread extends Thread {
        protected Vault v;

        public HackingThread(Vault v) {
            this.v = v;
            this.setName(this.getClass().getSimpleName());
            this.setPriority(Thread.MAX_PRIORITY);
        }

        @Override
        public synchronized void start() {
            System.out.println("Starting thread: " + this.getName());
            super.start();
        }
    }

    private static class AscendingHackerThread extends HackingThread {
        public AscendingHackerThread(Vault v) {
            super(v);
        }

        @Override
        public void run() {
            for (int guess = 1; guess < MAX_PASSWORD; guess++) {
                if (v.VerifyPwd(guess)) {
                    System.out.println("break the vault: " + guess + " by " + this.getName());
                    System.exit(0);
                }
            }
        }
    }


    private static class DescendingHackerThread extends HackingThread {
        public DescendingHackerThread(Vault v) {
            super(v);
        }

        @Override
        public void run() {
            for (int guess = MAX_PASSWORD; guess > 0; guess--) {
                if (v.VerifyPwd(guess)) {
                    System.out.println("break the vault: " + guess + " by " + this.getName());
                    System.exit(0);
                }
            }
        }
    }

    private static class PoliceThread extends Thread {
        @Override
        public void run() {
            for (int i = 10; i > 0; i--) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(i);
            }
            System.out.println("Game over suckers!");
            System.out.println("catch all the hackers");
        }
    }
}
