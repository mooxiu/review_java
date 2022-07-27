package concurrency.thread_coordination;

import java.math.BigInteger;

public class ThreadInterrupt2WithDeamon {
    public static void main(String[] args) {
        Thread thread = new Thread(new LongComputationThread(new BigInteger("200000"), new BigInteger("1000000")));
        thread.setDaemon(true);
        thread.start();

        thread.interrupt();
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
                // do not need anything here
                result = result.multiply(base);
            }
            return result;
        }
    }
}
