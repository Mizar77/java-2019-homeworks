public class Huluwa {
    private enum Color {
        RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE
    }
    private int rank;
    private Color color;
    public Huluwa(int rank) {
        this.rank = rank;
        color = Color.values()[rank-1];
    }
    public String rank2String() {
        String s = null;
        switch(rank) {
            case 1: s = "老大"; break;
            case 2: s = "老二"; break;
            case 3: s = "老三"; break;
            case 4: s = "老四"; break;
            case 5: s = "老五"; break;
            case 6: s = "老六"; break;
            case 7: s = "老七"; break;
            default: throw new RuntimeException("unknown rank");
        }
        return s;
    }
    public String color2String() {
        String s = null;
        switch(color) {
            case RED: s = "红色"; break;
            case ORANGE: s = "橙色"; break;
            case YELLOW: s = "黄色"; break;
            case GREEN: s = "绿色"; break;
            case CYAN: s = "青色"; break;
            case BLUE: s = "蓝色"; break;
            case PURPLE: s = "紫色"; break;
            default: throw new RuntimeException("unknown color");
        }
        return s;
    }
    // user-defined comparison method
    public static boolean cmpByRank(Huluwa a, Huluwa b) {
        return a.rank < b.rank;
    }
    // user-defined comparison method
    public static boolean cmpByColor(Huluwa a, Huluwa b) {
        return a.color.ordinal() < b.color.ordinal();
    }
    // override the method inherited from class Object
    @Override
    public String toString() {
       return rank2String() + "(" + color2String() + ")"; 
    }
}