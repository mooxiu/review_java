package generics;

public class Diamond<T> {
    public static void main(String[] args) {
        GenericHolder<Bob> h3 = new GenericHolder<>();
        h3.setA(new Bob());
    }
}

class Bob{};
