public class World {
    private static final int SIZE = 10;

    /* At any position, if the element is null, then there is no Calabash Brother */
    private CalabashBrother[][] worldMap;

    public World() {
        worldMap = new CalabashBrother[SIZE][SIZE];
    }

    public CalabashBrother get(int x, int y) {
        return worldMap[x][y];
    }

    public void place(CalabashBrother brother, int x, int y) {
        /* Place this Calabash Brother on the world map */
        brother.setX(x);
        brother.setY(y);
        worldMap[x][y] = brother;
    }

    public void exchange(CalabashBrother brotherOne, CalabashBrother brotherTwo) {
        int oneX = brotherOne.getX(), oneY = brotherOne.getY();
        int twoX = brotherTwo.getX(), twoY = brotherTwo.getY();
        brotherOne.to(twoX, twoY);
        brotherTwo.to(oneX, oneY);
        worldMap[oneX][oneY] = brotherTwo;
        worldMap[twoX][twoY] = brotherOne;
    }
}
