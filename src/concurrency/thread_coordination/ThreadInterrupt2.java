package concurrency.thread_coordination;

import java.math.BigInteger;

public class ThreadInterrupt2 {
    public static void main(String[] args) {
        Thread thread = new Thread(new LongComputationThread(new BigInteger("200000"), new BigInteger("1000000")));
        thread.start();

        thread.interrupt(); // we do not have any logic to handle it, so no use here
    }

    private static class LongComputationThread implements Runnable {
        private BigInteger base;
        private BigInteger power;

        public LongComputationThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            System.out.println(compute(this.base, this.power));
        }

        private static BigInteger compute(BigInteger base, BigInteger power) {
            var result = BigInteger.ONE;
            for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("stoping now,,,");
                    return BigInteger.ZERO;
                }
                result = result.multiply(base);
            }
            return result;
        }
    }
}
