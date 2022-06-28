package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Snow {
}

class Powder extends Snow {
}

class Light extends Snow {
}

class Heavy extends Snow {
}

class Crusty extends Snow {
}

class Slush extends Snow {
}

public class AsListInference {
    public static void main(String[] args) {
        List<Snow> snows1 = Arrays.asList(new Crusty(), new Slush(), new Powder());

        List<Snow> snows2 = Arrays.asList(new Light(), new Heavy());

        List<Snow> snows3 = new ArrayList<>();
        Collections.addAll(snows3, new Light(), new Heavy(), new Powder());
        snows3.add(new Crusty());
        /**
         * Notice the generics part
         */
        List<Snow> snows4 = Arrays.<Snow>asList(new Light(), new Heavy(), new Slush());
    }
}
