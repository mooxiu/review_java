package interfaces;

import org.jetbrains.annotations.NotNull;

public class Employ implements Comparable<Employ> {
    private int Level;

    public Employ(int level) {
        Level = level;
    }

    public int getLevel() {
        return Level;
    }

    @Override
    public int compareTo(@NotNull Employ o) {
        return Integer.compare(this.Level, o.Level);
    }
}
