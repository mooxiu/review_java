package interfaces;

public interface InterfaceDefaultMethod {
    void hello();

    default int getNum() {
        return (int) (Math.random() * 1000);
    }
}

class Implementer implements InterfaceDefaultMethod {
    @Override
    public void hello() {
    }

    // do not need the default method here.
}
