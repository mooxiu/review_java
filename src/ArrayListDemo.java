import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

/*
    Core Java Volume 1 Chapter 5
 */

public class ArrayListDemo {
    public static void main(String[] args) {
        /*
        API of arrayList
         */

        // can use traditional way to initiate
        ArrayList<Employ> staff = new ArrayList<Employ>();
        // also in Java 10, we can use var
        var staff2 = new ArrayList<Employ>();
        // use add keyword to add new element -> api for linkedlist?
        staff.add(new Employ("Harry Hacker"));
        // to avoid reallocation, you can set capacity if you know the count
        staff.ensureCapacity(100);
        // you can also initiate with capacity
        var staff3 = new ArrayList<Employ>(100);
        // get the size of arrayList
        System.out.println(staff.size());
        // this size of arrayList won't change, so you can trim the size, runs the GC
        staff.trimToSize();


        /*
        Accessing Array List Elements
         */
        // ArrayList class is not part of Java Programming Language...it is just utility class programmed by someone and supplied in the standard library
        // we can get access the element by using get and set method
        staff.set(0, new Employ("Harry"));
        var ele0 = staff.get(0);
        System.out.println(ele0);

        // use set to replace only, following code is wrong
        try {
            staff.set(1, new Employ("Kirk"));
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Exception: use set only for replace");
        }
        staff.add(new Employ("Kirk"));
        System.out.println(staff);

        //get best of both Array and ArrayList
        var list = new ArrayList<Employ>();
        for (int i = 0; i < 4; i++) {
            var randomName = UUID.randomUUID().toString();
            var em = new Employ(randomName);
            var b = list.add(em);
            if (!b) {
                break;
            }
        }
        System.out.println(list);

        var a = new Employ[list.size()];
        list.toArray(a);
        System.out.println(a);

        // add element in the middle of arraylist
        var index = list.size() / 2;
        list.add(index, new Employ("inserted"));
        System.out.println(list);
        // also, remove an element from the middle of an arrayList
        var e = list.remove(index);
        System.out.println(e);

        // foreach loop
        for (var ele : list) {
            System.out.println(ele.getName());
        }

        // use variable args of Employ
        var sum = ele0.varArgs(1, 2, 3, 4, 5);
        System.out.println(sum);
    }
}

class Employ {
    private String name;

    public Employ(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /*
    variable args method of java
     */
    public int varArgs(int... args) {
        var total = 0;
        for (var arg : args) {
            total += arg;
        }
        return total;
    }

    @Override
    public String toString() {
        return "Employ with name: " + this.name;
    }
}
