import com.sun.jdi.event.StepEvent;

import java.util.Random;

class Position {
    private boolean occupied;
    HuLuWa huluwa;

    Position() {
        occupied = false;
        huluwa = null;
    }

    boolean accept(HuLuWa wa) {
        if(occupied)
            return false;
        else {
            huluwa = wa;
            occupied = true;
            return true;
        }
    }

    void leave() {
        occupied = false;
        huluwa = null;
    }
}

public class HuLuWa {
    private String name;
    private String color;

    void setAttr(String n, String c) {
        name = new String(n);
        color = new String(c);
    }

    String getName() { return name; }
    String getColor() { return color; }

    void report(String str) {
        System.out.println(str);
    }

    boolean moveTo(Position prePos, Position nxtPos) {
        prePos.leave();
        return nxtPos.accept(this);
    }
}

class Comparer {
    static boolean compName(HuLuWa wa1, HuLuWa wa2) {
        return nameRank(wa1.getName()) > nameRank(wa2.getName());
    }

    static boolean compColor(HuLuWa wa1, HuLuWa wa2) {
        return colorRank(wa1.getColor()) > colorRank(wa2.getColor());
    }

    static private int nameRank(String name) {
        switch (name) {
            case "老大": return 0;
            case "老二": return 1;
            case "老三": return 2;
            case "老四": return 3;
            case "老五": return 4;
            case "老六": return 5;
            case "老七": return 6;
            default:
                System.out.println("Unexpected name " + name);
                System.exit(-1);
        }
        return -1;
    }

    static private int colorRank(String color) {
        switch (color) {
            case "红色": return 0;
            case "橙色": return 1;
            case "黄色": return 2;
            case "绿色": return 3;
            case "青色": return 4;
            case "蓝色": return 5;
            case "紫色": return 6;
            default:
                System.out.println("Unexpected color " + color);
                System.exit(-1);
        }
        return -1;
    }
}

class Sorter {
    static void bubbleSort(Position pos[]) {
        for(int i = 0; i < 7; i++) {
            for(int j = 0; j < 7 - i - 1; j++){
                if(Comparer.compName(pos[j].huluwa, pos[j+1].huluwa)) {
                    pos[j+1].huluwa.report(pos[j+1].huluwa.getName() + "：" + (j+1) + "->" + 7);
                    pos[j+1].huluwa.moveTo(pos[j+1], pos[7]);
                    pos[j].huluwa.report(pos[j].huluwa.getName() + "：" + j + "->" + (j+1));
                    pos[j].huluwa.moveTo(pos[j], pos[j+1]);
                    pos[7].huluwa.report(pos[7].huluwa.getName() + "：" + 7 + "->" + j);
                    pos[7].huluwa.moveTo(pos[7], pos[j]);
                }
            }
        }
    }

    static void binaryInsertSort(Position pos[]) {
        for(int i = 0;i < 7;i++){
            int left = 0;
            int right = i - 1;
            int middle = 0;
            while(left <= right){
                middle = (left + right) / 2;
                if(Comparer.compColor(pos[middle].huluwa, pos[i].huluwa)){
                    right = middle - 1;
                }else{
                    left = middle + 1;
                }
            }
            pos[i].huluwa.report(pos[i].huluwa.getName() + "：" + i + "->" + 7);
            pos[i].huluwa.moveTo(pos[i], pos[7]);
            for(int j = i - 1;j >= left;j--){
                pos[j].huluwa.report(pos[j].huluwa.getName() + "：" + j + "->" + (j+1));
                pos[j].huluwa.moveTo(pos[j], pos[j+1]);
            }
            pos[7].huluwa.report(pos[7].huluwa.getName() + "：" + 7 + "->" + left);
            pos[7].huluwa.moveTo(pos[7], pos[left]);
        }
    }

    public static void main(String[] args) {
        Random ram = new Random();
        HuLuWa[] wa = new HuLuWa[7];
        Position[] pos = new Position[8];
        for(int i = 0; i < 7; i++)
            wa[i] = new HuLuWa();
        for(int i = 0; i < 8; i++)
            pos[i] = new Position();

        wa[0].setAttr("老大", "红色");
        wa[1].setAttr("老二", "橙色");
        wa[2].setAttr("老三", "黄色");
        wa[3].setAttr("老四", "绿色");
        wa[4].setAttr("老五", "青色");
        wa[5].setAttr("老六", "蓝色");
        wa[6].setAttr("老七", "紫色");

        int cnt = 0;
        while(cnt < 7) {
            int coord = ram.nextInt(7);
            if(wa[cnt].moveTo(pos[7], pos[coord]))
                cnt++;
        }

        bubbleSort(pos);
        for(int i = 0; i < 7; i++) {
            pos[i].huluwa.report(pos[i].huluwa.getName());
        }

        for(int i = 0; i < 7; i++)
            wa[i] = new HuLuWa();
        for(int i = 0; i < 8; i++)
            pos[i] = new Position();

        wa[0].setAttr("老大", "红色");
        wa[1].setAttr("老二", "橙色");
        wa[2].setAttr("老三", "黄色");
        wa[3].setAttr("老四", "绿色");
        wa[4].setAttr("老五", "青色");
        wa[5].setAttr("老六", "蓝色");
        wa[6].setAttr("老七", "紫色");

        cnt = 0;
        while(cnt < 7) {
            int coord = ram.nextInt(7);
            if(wa[cnt].moveTo(pos[7], pos[coord]))
                cnt++;
        }

        binaryInsertSort(pos);
        for(int i = 0; i < 7; i++) {
            pos[i].huluwa.report(pos[i].huluwa.getColor());
        }
    }
}