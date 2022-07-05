package generics;

public class GenericHolder<T> {
    private T a;

    public GenericHolder() {
    }

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }

    public static void main(String[] args) {
        GenericHolder<Automobile> h3 = new GenericHolder<>();
        h3.setA(new Automobile());
        Automobile a = h3.getA();

        /*
        if we want to hold other instance rather than an automobile
         */
//         h3.setA("not an automobile"); // Error
    }
}
