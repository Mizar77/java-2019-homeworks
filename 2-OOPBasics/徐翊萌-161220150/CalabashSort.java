import java.util.Random;

enum CalabashBrother {
    CB1("老大", "红色", 1),
    CB2("老二", "橙色", 2),
    CB3("老三", "黄色", 3),
    CB4("老四", "绿色", 4),
    CB5("老五", "青色", 5),
    CB6("老六", "蓝色", 6),
    CB7("老七", "紫色", 7);
    private String name;
    private String color;
    private int num;

    CalabashBrother(String name, String color, int num) {
        this.name = name;
        this.color = color;
        this.num = num;
    }

    public String getName() { return name; }

    public String getColor() { return color; }

    public int getNum() { return num; }
}

public class CalabashSort {
    public void Shuffle(CalabashBrother[] queue) {
        Random rand = new Random();
        for (int i = 6; i > 0; i--) {
            int r = rand.nextInt(i);
            CalabashBrother tmp = queue[i];
            queue[i] = queue[r];
            queue[r] = tmp;
        }
    }

    public void CountByName(CalabashBrother[] queue) {
        for (int i = 0; i < 7; i++)
            System.out.print(queue[i].getName() + ' ');
        System.out.println(' ');
    }

    public void CountByColor(CalabashBrother[] queue) {
        for (int i = 0; i < 7; i++)
            System.out.print(queue[i].getColor() + ' ');
        System.out.println(' ');
    }

    public void BubbleSort(CalabashBrother[] queue) {
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 7; j++) {
                if (queue[j-1].getNum() > queue[j].getNum()) {
                    System.out.print(queue[j-1].getName()+": "+(j-1)+"->"+j+"\t");
                    System.out.println(queue[j].getName()+": "+(j)+"->"+(j-1)+"\t");
                    CalabashBrother tmp = queue[j-1];
                    queue[j-1] = queue[j];
                    queue[j] = tmp;
                }
            }
        }
    }

    public void BinarySort(CalabashBrother[] queue) {
        for (int i = 1; i < 7; i++) {
            int left = 0;
            int right = i-1;
            int mid = 0;
            CalabashBrother tmp = queue[i];
            while (left <= right) {
                mid = (left+right)/2;
                if (tmp.getNum() < queue[mid].getNum())
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            for (int j = i - 1; j >= left; j--) {
                System.out.print(queue[j].getName()+": "+j+"->"+(j+1)+"\t");
                queue[j+1] = queue[j];
            }
            if (left != i) {
                System.out.print(tmp.getName()+": "+i+"->"+left);
                System.out.println(' ');
                queue[left] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        CalabashBrother[] queue = new CalabashBrother[7];
        for (int i = 0; i < 7; i++)
            queue[i] = CalabashBrother.values()[i];
        CalabashSort cs = new CalabashSort();

        System.out.println("冒泡排序\n排序前队列");
        cs.Shuffle(queue);
        cs.CountByName(queue);
        System.out.println("排序过程");
        cs.BubbleSort(queue);
        System.out.println("排序后队列");
        cs.CountByName(queue);

        System.out.println("\n二分排序\n排序前队列");
        cs.Shuffle(queue);
        cs.CountByColor(queue);
        System.out.println("排序过程");
        cs.BinarySort(queue);
        System.out.println("排序后队列");
        cs.CountByColor(queue);
    }
}
