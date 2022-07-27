package generics.coffee;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class CoffeeSupplier implements Supplier<Coffee>, Iterable<Coffee> {
    private final Class<?>[] types = {
            Latte.class,
            Mocha.class,
            Cappuccino.class,
            Americano.class,
            Breve.class,
    };
    private static final Random rand = new Random(47);
    // for iteration
    private int size = 0;
    public CoffeeSupplier() {

    }
    public CoffeeSupplier(int sz) {
        this.size = sz;
    }


    @NotNull
    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    // to satisfy supplier
    @Override
    public Coffee get() {
        try {
            return (Coffee) types[rand.nextInt(this.types.length)].getConstructor().newInstance();
        } catch (InstantiationException |
                NoSuchMethodException|
                InvocationTargetException|
                IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    class CoffeeIterator implements Iterator<Coffee> {
        int count = size;
        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count--;
            return CoffeeSupplier.this.get();
        }
    }

    public static void main(String[] args) {
        Stream.generate(new CoffeeSupplier()).limit(5).forEach(System.out::println);
        for (var c: new CoffeeSupplier(5)) {
            System.out.println(c);
        }
    }
}
