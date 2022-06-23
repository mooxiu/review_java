package lambdaExpressions;

import javax.swing.*;
import java.awt.*;
import java.time.Instant;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class lambdaTest {
    public static void main(String[] args) {
        var planets = new String[] { "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune" };
        System.out.println(Arrays.toString(planets));

        // in a lexicographical order
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));

        // in length order
        Arrays.sort(planets, (String first, String second) -> {
            return first.length() - second.length();
        });
        System.out.println(Arrays.toString(planets));


        // using a comparator interface
        Arrays.sort(planets, new TraditionalWay());
        System.out.println(Arrays.toString(planets));

        var timer = new Timer(1000, event -> {
            System.out.println("At the tone, the time is " + Instant.ofEpochMilli(event.getWhen()));
            Toolkit.getDefaultToolkit().beep();
        });

        BiFunction<String, String, Integer> comp = (first, second) -> first.length() - second.length();
        var k = comp.apply("hello", "word");
        System.out.println(k);
    }
}

class TraditionalWay implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o2.length() - o1.length();
    }
}