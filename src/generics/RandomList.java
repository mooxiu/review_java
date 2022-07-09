package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomList<T> extends ArrayList<T> {
    private final Random rand = new Random(47);

    // select random select one of its element
    public T select() {
        return this.get(rand.nextInt(this.size()));
    }

    public static void main(String[] args) {
        var rs = new RandomList<String>();
        rs.addAll(Arrays.asList(("The quick brown fox jumped over " + "the lazy brown dog.")
                .split(" ")));
        IntStream.range(0, 11).forEach(i -> System.out.print(i + " : " + rs.select() + " "));
    }
}
