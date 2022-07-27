package generics;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class IterableFibonacci
    extends Fibonacci
    implements Iterable<Integer> {

    private int n;

    public IterableFibonacci(int count) {
        this.n = count;
    }


    @NotNull
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
               n--;
               return IterableFibonacci.this.get();
            }
        };
    }

    public static void main(String[] args) {
        for (var i: new IterableFibonacci(18)) {
            System.out.println(i + " ");
        }
    }
}
