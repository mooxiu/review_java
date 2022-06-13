import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.Arrays;

public class reflectGenericArrayTest {
    /*
    The problem of this method, you cannot cast object[] to ExampleClass[]
     */
    public static Object @NotNull [] badCopy(Object[] a, int newLen) {
        var newArray = new Object[newLen];
        System.arraycopy(a, 0, newArray, 0, Math.min(a.length, newLen));
        return newArray;
    }

    /*
        Like what we do using Golang's interface{}
     */
    public static Object goodCopy(Object a, int newLen) {
        Class cl = a.getClass();
        if (!cl.isArray()) {
            return null;
        }
        int length = Array.getLength(a);
        Object newArray = Array.newInstance(cl.getComponentType(), newLen);
        System.arraycopy(a, 0, newArray, 0, Math.min(length, newLen));
        return newArray;
    }

    public static void main(String[] args) {
        var a = new ExampleClass[100];
        // we want to achieve copy method as following
        a = Arrays.copyOf(a, 2 * a.length);


        var b = new int[]{1, 2, 3, 4, 5};
        b = (int[]) goodCopy(b, 10);
        for (var i: b) {
            System.out.println(i);
        }
    }
}

class ExampleClass {

}
