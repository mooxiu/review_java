package generics;

public class Holder1 {
    private Automobile a;

    public Holder1(Automobile a1) {
        this.a = a;
    }

    Automobile get() {
        return a;
    }
}

class Automobile {}