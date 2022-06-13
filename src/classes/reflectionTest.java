package classes;

import java.lang.reflect.InvocationTargetException;

public class reflectionTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        RefTest e = new RefTest();
        // class type hold runtime type identification
        Class cl = e.getClass();
        // class name
        System.out.println(cl.getName());
        // class methods
        System.out.println("---------------get methods:");
        for (var i : cl.getMethods()) {
            System.out.println(i.getName());
        }
        System.out.println("---------------get declared methods:");
        for (var j : cl.getDeclaredMethods()) {
            System.out.println(j.getName());
        }
        System.out.println("=========");
        // class fields
        // can only get public field, not private field
        System.out.println("--------------get fields");
        for (var i : cl.getFields()) {
            System.out.println(i.getName());
        }
        System.out.println("--------------get declared fields");
        for (var j : cl.getDeclaredFields()) {
            System.out.println(j.getName());
        }


        // also by using the class name
        System.out.println("=================");
        try {
            var cl2 = Class.forName("classes.RefTest");
            System.out.println(cl2);
            for (var i : cl2.getMethods()) {
                System.out.println(i.getName());
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found!");
        }

        // class for array
        System.out.println("===========array class name==========");
        var a = new RefTest[100];
        System.out.println(a.getClass().getName());
    }
}

class RefTest extends RefTestFather {
    private int field1;
    public int field2;

    public static void StaticFunc() {
        System.out.println("This is a test static method");
        return;
    }

    public int getField1() {
        return field1;
    }

    public void setField1(int field1) {
        this.field1 = field1;
    }
}

class RefTestFather {
    public int field3;
}