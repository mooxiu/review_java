package classes;

import java.lang.reflect.InvocationTargetException;

/*
Use reflect to invoke method
 */
public class reflectOnMethod {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        var cl = new RefTest2();
        Object r = cl.getClass().getMethod("guessNumber").invoke(cl);
        System.out.println((double) r);
    }
}

class RefTest2 {
    public double guessNumber() {
        return Math.floor(10000 * Math.random());
    }
}
