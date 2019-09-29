import java.util.Comparator;

public class CalabashBrother {
    /* Class used to represent Calabash Brothers */
    private int x;
    private int y;
    private int rank; /* Ranging from 0 to 6 */
    private String color;
    private String name;

    public CalabashBrother(int rank) {
        String[] names = {"老大", "老二", "老三", "老四", "老五", "老六", "老七"};
        String[] colorArray = {"红色", "橙色", "黄色", "绿色", "青色", "蓝色", "紫色"};
        this.rank = rank;
        color = colorArray[rank];
        name = names[rank];
    }

    public int getRank() {
        return rank;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void to(int newX, int newY) {
        /* Calabash brother goto (newX, newY) */
        System.out.println(name + ": " + "(" + x + "," + y + ")" + "->" + "(" + newX + "," + newY + ")");
        x = newX;
        y = newY;
    }
}

class CalabashColorComparator implements Comparator<CalabashBrother> {
    @Override
    public int compare(CalabashBrother brotherOne, CalabashBrother brotherTwo) {
        return brotherOne.getRank() - brotherTwo.getRank();
    }
}

class CalabashRankComparator implements Comparator<CalabashBrother> {
    @Override
    public int compare(CalabashBrother brotherOne, CalabashBrother brotherTwo) {
        return brotherOne.getRank() - brotherTwo.getRank();
    }
}