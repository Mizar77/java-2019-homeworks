public class GourdEva {
    private String color, name;
    private int rank, position;

    GourdEva(int rank) {
        String[] colorRecord = {"红色", "橙色", "黄色", "绿色", "青色", "蓝色", "紫色"};
        String[] nameRecord = {"老大", "老二", "老三", "老四", "老五", "老六", "老七"};

        this.rank = rank;

        if (rank <= 6 && rank >= 0) {
            this.color = colorRecord[rank];
            this.name = nameRecord[rank];
        } else {
            this.color = "未知";
            this.name = "未知";
        }
    }

    public void saycolor() {
        System.out.print(color);
    }

    public void saymyname() {
        System.out.print(name);
    }

    public int getrank() {
        return rank;
    }

    public void setPositionWithOutTalk(int newPosition) {
        position = newPosition;
    }

    public void setPositionAndTalk(int newPosition) {
        if (newPosition == position)
            return;
        System.out.printf("%s：%d->%d\n", name, position + 1, newPosition + 1);
        position = newPosition;
    }
}
