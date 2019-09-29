enum One {
    hlw1(1, "老大", "红色"),
    hlw2(2, "老二", "橙色"),
    hlw3(3, "老三", "黄色"),
    hlw4(4, "老四", "绿色"),
    hlw5(5, "老五", "青色"),
    hlw6(6, "老六", "蓝色"),
    hlw7(7, "老七", "紫色");
    private int rank;
    private String name;
    private String color;

    One(int rank, String name, String color) {
        this.rank = rank;
        this.name = name;
        this.color = color;
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
}

public class Calabash extends Creature {
    protected int rank;
    protected String color;

    public Calabash(int index) {
        if (index == 1) {
            rank = One.hlw1.getRank();
            name = One.hlw1.getName();
            color = One.hlw1.getColor();
            type = "a";
        } else if (index == 2) {
            rank = One.hlw2.getRank();
            name = One.hlw2.getName();
            color = One.hlw2.getColor();
            type = "a";
        } else if (index == 3) {
            rank = One.hlw3.getRank();
            name = One.hlw3.getName();
            color = One.hlw3.getColor();
            type = "a";

        } else if (index == 4) {
            rank = One.hlw4.getRank();
            name = One.hlw4.getName();
            color = One.hlw4.getColor();
            type = "a";
        } else if (index == 5) {
            rank = One.hlw5.getRank();
            name = One.hlw5.getName();
            color = One.hlw5.getColor();
            type = "a";
        } else if (index == 6) {
            rank = One.hlw6.getRank();
            name = One.hlw6.getName();
            color = One.hlw6.getColor();
            type = "a";
        } else if (index == 7) {
            rank = One.hlw7.getRank();
            name = One.hlw7.getName();
            color = One.hlw7.getColor();
            type = "a";
        } else {

        }
    }

    public int getRank() {
        return rank;
    }

    public String getColor() {
        return color;
    }

}
