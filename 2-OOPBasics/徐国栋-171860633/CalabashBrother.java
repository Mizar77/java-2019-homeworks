import java.awt.Color;

final class CalabashBrother extends Creature {// 葫芦娃类，继承自生物类，表示一个葫芦娃
    public int rank; // 葫芦娃类特有的家族排行，范围：[0,6]

    public String rank2String(int _rank) {// 映射到家族排行称呼，老大，老二，...
        switch (_rank) {
        case 0:
            return "老大";
        case 1:
            return "老二";
        case 2:
            return "老三";
        case 3:
            return "老四";
        case 4:
            return "老五";
        case 5:
            return "老六";
        case 6:
            return "老七";
        default: // 如果葫芦娃可以召唤分身，利用模运算把排行映射到真身
            return rank2String(Math.abs(_rank) % 7) + "的分身";
        }
    }

    public CalabashBrother(int _rank, Color _color) {
        rank = _rank;
        name = rank2String(_rank);
        apperrance.color = _color;
    }

    public void printRank() {
        System.out.print(rank2String(rank) + ",");
    }

    public void printColor() {
        String tmp = apperrance.color2String();
        /* 颜色无法在cmd上正常显示，不予使用 */
        if (tmp == "红色")
            System.out.print("\033[31;1m" + tmp + "\033[0m");
        else if (tmp == "橙色")
            System.out.print("\033[33;7m" + tmp + "\033[0m");
        else if (tmp == "黄色")
            System.out.print("\033[33;1m" + tmp + "\033[0m");
        else if (tmp == "绿色")
            System.out.print("\033[32;1m" + tmp + "\033[0m");
        else if (tmp == "青色")
            System.out.print("\033[36;1m" + tmp + "\033[0m");
        else if (tmp == "蓝色")
            System.out.print("\033[34;1m" + tmp + "\033[0m");
        else if (tmp == "紫色")
            System.out.print("\033[35;1m" + tmp + "\033[0m");
        else
            System.out.print("其它颜色");
    }
}