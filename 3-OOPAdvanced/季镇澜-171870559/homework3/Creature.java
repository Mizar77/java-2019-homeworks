package homework3;

import javafx.util.Pair;

public class Creature {
    public String name;
    private Pair<Integer, Integer> location;

    Creature(String n) {
        name = n;
        location = new Pair<>(0, 0);
    }

    Creature(String n, int x, int y) {
        name = n;
        location = new Pair<>(x, y);
    }

    public void changeLocation(int x, int y) {
        location = new Pair<>(x, y);
    }
}

final class Huluwa extends Creature {
    public int rank;

    Huluwa(String n, int r) {
        super(n);
        rank = r;
    }

    Huluwa(String n, int x, int y, int r) {
        super(n, x, y);
        rank = r;
    }
}

