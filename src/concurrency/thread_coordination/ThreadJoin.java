package concurrency.thread_coordination;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        List<Long> inputNums = Arrays.asList(10000000000L, 3435L, 35435L, 2324L, 4656L, 23L, 5556L);
        // List<Long> inputNums = Arrays.asList(10L);
        List<FactorialThread> threads = new ArrayList<>();

        for (var l: inputNums) {
            threads.add(new FactorialThread(l));
        }

        for (var t : threads) {
            t.start();
        }

        for (var t: threads) {
            t.join();
        }

        for (int i = 0; i < inputNums.size(); i++) {
            FactorialThread factorialThread = threads.get(i);
            if (factorialThread.isFinished()) {
                System.out.println("Factorial of " + inputNums.get(i) + " is " + factorialThread.getResult());
            } else {
                System.out.println("The calculation for " + inputNums.get(i) + " is still in progress");
            }
        }
    }

    public static class FactorialThread extends Thread {
        private final long inputNum;
        private BigInteger result;
        private boolean finished = false;


        @Override
        public void run() {
            this.result = this.factorial(this.inputNum);
            this.finished = true;
        }

        public FactorialThread(long inputNum) {
            this.inputNum = inputNum;
        }

        public BigInteger factorial(long n) {
            var temp = BigInteger.ONE;
            for (long i = 0; i < n; i++ ) {
                temp = temp.multiply(new BigInteger(Long.toString(i)));
            }
            return temp;
        }

        public BigInteger getResult() {
            return this.result;
        }

        public boolean isFinished() {
            return this.finished;
        }
    }
}
