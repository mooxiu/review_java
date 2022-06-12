import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
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

        System.out.println(staff.size());

    }
}

class Employ {
    private String name;

    public Employ(String name) {
        this.name = name;
    }
}
