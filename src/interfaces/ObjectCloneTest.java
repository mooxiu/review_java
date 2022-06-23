package interfaces;

public class ObjectCloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        var original = new Employ2("John", 5000);
        Employ2 copy = original;
        copy.raiseSalary(10);

       /*
        Also change the original one, not what we want
        */
        System.out.println(original.f2);
        System.out.println(copy.f2);


        Employ2 copy2 = original.clone();
        copy2.raiseSalary(10);
        System.out.println(original.f2);
        System.out.println(copy2.f2);
        System.out.println(copy.f2);

    }
}

class Employ2 implements Cloneable{
    public String f1;
    public int f2;

    public Employ2(String f1, int f2) {
        this.f1 = f1;
        this.f2 = f2;
    }

    public void raiseSalary(int r) {
        this.f2 += r;
    }

    public Employ2 clone() throws CloneNotSupportedException {
        return (Employ2) super.clone();
    }
}
