package interfaces;

/*
Resolve inherit a class and implement an interface and when they have same methods
 */

public class DefaultMethodConflicts2 extends Animal implements Dog {
    public static void main(String[] args) {
        var d = new DefaultMethodConflicts2();
        // class wins
        System.out.println(d.bark());
    }
}

class Animal {
    public String bark() {
        return "bark";
    }
}

interface Dog {
    default String bark() {
        return "dog bark";
    }
}

