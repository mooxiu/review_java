package generics;

public class ObjectHolder {
    private Object a;

    public ObjectHolder(Object a) {
        this.a = a;
    }

    public Object getA() {
        return a;
    }

    public void setA(Object a) {
        this.a = a;
    }

    public static void main(String[] args) {
        // holding an automobile now...
        ObjectHolder h2 = new ObjectHolder(new Automobile());
        Automobile a = (Automobile) h2.getA();
        // holding a string now...
        h2.setA("Not an Automobile");
        String s = (String) h2.getA();
        // holding an integer now...
        h2.setA(1);
        Integer x = (Integer) h2.getA();
    }
}
