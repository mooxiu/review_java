package classes;

public class EnumTest {
    public static void main(String[] args) {
        System.out.println(Size.SMALL.getAbbreviation());
        Size.SMALL.setAbbreviation("Cool");
        System.out.println(Size.SMALL.getAbbreviation());

        // enum type has a static `values` method that returns all values
        System.out.println("==============");
        for (var v : Size.values()) {
            System.out.println(v + " : " + v.getAbbreviation());
        }
    }
}

/*
classes.Size is actually a kind of class, but with limited instance
 */
enum Size {
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");
    private String abbreviation;
    // constructor of enum can only be private, also can be omitted
    private Size(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
