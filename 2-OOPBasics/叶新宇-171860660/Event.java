import java.util.*;

public class Event {
    public static void main(String[] args){
        HuluwaOperation huluwaOperation = new HuluwaOperation();
        huluwaOperation.shuffle();
        huluwaOperation.bubbleSort();
        huluwaOperation.shuffle();
        huluwaOperation.quickSort();
    }
}

//葫芦娃类，描述葫芦娃对象的性质及方法
class Huluwa {
    private String name;
    private String color;
    private int num;
    //葫芦娃具有以上三种标识信息：姓名，颜色及排行(用于确定他们之间的顺序)
    Huluwa(String n, String c, int m) {
        this.name = n;
        this.color = c;
        this.num = m;
    }
    //构造函数
    public int getNum() {
        return this.num;
    }
    //用作外部排序使用
    public void printName() {
        System.out.println(name);
    }
    public void printColor() {
        System.out.println(color);
    }
    public void report(int a, int b) {
        System.out.println(this.name + ":" + a + "->" + b);
    }
    //打印名称、颜色、报告位置变化
}

//葫芦娃操作类，描述对葫芦娃进行的打乱和排序操作
class HuluwaOperation {
    private Vector<Huluwa> HuluwaBrothers = new Vector<Huluwa>();
    HuluwaOperation() {
        //构造函数，在容器中添加七个葫芦娃成员
        this.HuluwaBrothers.addElement(new Huluwa("老大", "红色", 1));
        this.HuluwaBrothers.addElement(new Huluwa("老二", "橙色", 2));
        this.HuluwaBrothers.addElement(new Huluwa("老三", "黄色", 3));
        this.HuluwaBrothers.addElement(new Huluwa("老四", "绿色", 4));
        this.HuluwaBrothers.addElement(new Huluwa("老五", "青色", 5));
        this.HuluwaBrothers.addElement(new Huluwa("老六", "蓝色", 6));
        this.HuluwaBrothers.addElement(new Huluwa("老七", "紫色", 7));
    }
    public void shuffle() {
        //每次需要排序前，先随机打乱葫芦娃的顺序
        Collections.shuffle(HuluwaBrothers);
    }

    public void bubbleSort() {
        // 冒泡
        for (int i = 0; i < HuluwaBrothers.size(); i++) {
            for (int j = 0; j < HuluwaBrothers.size() - i - 1; j++) {
                if (HuluwaBrothers.get(j).getNum() > HuluwaBrothers.get(j + 1).getNum()) {
                    HuluwaBrothers.get(j).report(j,j + 1);
                    HuluwaBrothers.get(j + 1).report(j + 1, j);
                    Collections.swap(HuluwaBrothers, j, j + 1);
                }
            }
        }

        for (Huluwa i : HuluwaBrothers) {
            i.printName();
        }
    }

    private void quickSortPartition(int begin, int end) {
        if(begin >= end) return;
        int i = begin, j = begin;
        int key = HuluwaBrothers.get(begin).getNum();
        while (i < end) {
            if(HuluwaBrothers.get(i).getNum() < key) {
                j++;
                if(i != j) {
                    HuluwaBrothers.get(i).report(i, j);
                    HuluwaBrothers.get(j).report(j, i);
                    Collections.swap(HuluwaBrothers, i, j);
                }
            }
            i++;
        }
        if(j != begin) {
            HuluwaBrothers.get(j).report(j, begin);
            HuluwaBrothers.get(begin).report(begin, j);
            Collections.swap(HuluwaBrothers, j, begin);
        }

        quickSortPartition(begin, j);
        quickSortPartition(j + 1, end);
    }

    public void quickSort() {
        //快排
        quickSortPartition(0, HuluwaBrothers.size());
        for (Huluwa i : HuluwaBrothers) {
            i.printColor();
        }
    }
}