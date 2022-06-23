package interfaces;

/*
should distinguish between interface `Comparable` and  `Comparator` interface
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ComparatorInterface {
    public static void main(String[] args) {
        String[] friends = {"John", "Paul", "George", "Ringo"};
        for (var i: friends) {
            System.out.println(i);
        }
        Arrays.sort(friends, new ageComp());
        for (var i: friends) {
            System.out.println(i);
        }
    }
}

class ageComp implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}
