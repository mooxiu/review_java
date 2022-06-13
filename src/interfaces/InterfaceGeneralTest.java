package interfaces;

import java.util.Arrays;
import java.util.Stack;

public class InterfaceGeneralTest {
    public static void main(String[] args) {
        var staff = new Employ[3];
        staff[0] = new Employ(1);
        staff[1] = new Employ(39);
        staff[2] = new Employ(3);
        Arrays.sort(staff);

        for (var em : staff) {
            if (em instanceof Comparable) {
                System.out.println("true");
            }
            System.out.println(em.getLevel());
        }
    }
}

/*
All methods of an interface are automatically public
 */
