package functional;

public class RecursiveFibonacci {
    IntCall fib;

    public RecursiveFibonacci() {
        fib = i -> (i == 0 || i == 1) ? i : fib.call(i - 1) + fib.call(i - 2);
    }

    int fibonacci(int n) {
        return this.fib.call(n);
    }

    public static void main(String[] args) {
        RecursiveFibonacci rf = new RecursiveFibonacci();
        for (int i = 0; i <= 10; i++) {
            System.out.println(rf.fibonacci(i));
        }
    }
}
