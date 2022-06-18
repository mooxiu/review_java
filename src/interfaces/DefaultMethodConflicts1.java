package interfaces;

/*
Resolve when we implement 2 interfaces and when they have same default methods
 */

public class DefaultMethodConflicts1 implements Person, Named {
    public String getName() {
        /*
            We have to explicitly assign one to resolve the conflict
         */
        return Person.super.getName();
    }

    public static void main(String[] args) {
        // what is hashcode method?
        var ins = new DefaultMethodConflicts1();
        System.out.println(ins.hashCode());
        System.out.println(ins.hashCode()); // should be exact same

        // implements both interface
        var s = ins.getName();
        System.out.println(s);

    }
}

interface Person {
    default String getName() {
        return "";
    }
}

interface Named {
    default String getName() {
        return getClass().getName() + "_" + hashCode();
    }
}