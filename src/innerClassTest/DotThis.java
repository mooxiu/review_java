package innerClassTest;

public class DotThis {
    void f() {
        System.out.println("DotThis.f()");
    }

    public class Inner {
        public DotThis outer() {
            return DotThis.this;
        };
    }

    public Inner inner() {
        return new Inner();
    }

    public static void main(String[] args) {
        var dt = new DotThis();
        var dti = dt.inner();
        dti.outer().f();
    }
}
