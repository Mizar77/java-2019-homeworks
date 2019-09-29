import java.util.*;


enum COLOR{RED,ORANGE,YELLOW,GREEN,CYAN,BLUE,PURPLE};           //采用枚举实现颜色之间的顺序比较


class HuluWa{                                                   //葫芦娃结构

   int rank;
   String name;
   COLOR color;
   HuluWa(int rank, String name, COLOR color){
       this.rank = rank;
       this.name = name;
       this.color = color;
   }

}


class SortForHuluwa{

    HuluWa[] HuluBrothers = new HuluWa[7];                      //初始化

    SortForHuluwa(){
        HuluBrothers[0] = new HuluWa(1, "老大", COLOR.RED);
        HuluBrothers[1] = new HuluWa(2, "老二", COLOR.ORANGE);
        HuluBrothers[2] = new HuluWa(3, "老三", COLOR.YELLOW);
        HuluBrothers[3] = new HuluWa(4, "老四", COLOR.GREEN);
        HuluBrothers[4] = new HuluWa(5, "老五", COLOR.CYAN);
        HuluBrothers[5] = new HuluWa(6, "老六", COLOR.BLUE);
        HuluBrothers[6] = new HuluWa(7, "老七", COLOR.PURPLE);
    }


    void bubbleSort(){                                          //根据葫芦娃的排行进行冒泡排序
        System.out.println("冒泡排序开始");
        for (int i = 7; i > 0 ; i--){
            for (int j = 0; j < i - 1; j++){
                if (HuluBrothers[j].rank > HuluBrothers[j + 1].rank){
                    System.out.println(HuluBrothers[j + 1].name+": "+ (j + 2) +" -> "+ (j + 1));
                    System.out.println(HuluBrothers[j].name+": "+ (j + 1) + " -> " + (j + 2));
                    HuluWa temp = HuluBrothers[j];
                    HuluBrothers[j] = HuluBrothers[j + 1];
                    HuluBrothers[j + 1] = temp;
                }
            }
        }
        System.out.println("\n" + "冒泡排序结束，当前顺序为: ");
        for (int i = 0; i < 7; i++) {
            System.out.print(HuluBrothers[i].name + " ");
        }
        System.out.println("\n");
    }

    void halfSort(){                                            //根据葫芦娃的颜色进行二分排序
        System.out.println("二分排序开始");
        for (int i = 1; i < 7; i++) {
            HuluWa temp = HuluBrothers[i];
            int low = 0;
            int high = i - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (HuluBrothers[mid].color.ordinal() > temp.color.ordinal()){
                    high = mid - 1;
                }else if(HuluBrothers[mid].color.ordinal() < temp.color.ordinal()){
                    low = mid + 1;
                }
            }
            for (int j = i - 1; j >= low; j--){
                HuluBrothers[j + 1] = HuluBrothers[j];
            }
            HuluBrothers[low] = temp;
            System.out.println(temp.name + ": " + (i + 1) + " -> " + (low + 1) );
        }
        System.out.println("\n" + "二分排序结束，当前顺序为: ");
        for (int i = 0; i < 7; i++) {
            System.out.print(HuluBrothers[i].name + " ");
        }
        System.out.println("\n");
    }

    void Randomhuluwa(){                                        //随机排列葫芦娃
        System.out.println();
        for (int i = 7; i > 0; i--){
            Random random = new Random();
            int rand = random.nextInt(i);
            HuluWa temp = HuluBrothers[rand];
            HuluBrothers[rand] = HuluBrothers[i - 1];
            HuluBrothers[i - 1] = temp;
        }
        System.out.println("葫芦娃随机站队完成，当前顺序为: ");
        for (int i = 0; i < 7; i++) {
            System.out.print(HuluBrothers[i].name + " ");
        }
        System.out.println("\n");
    }

}


public class hw2 {

    public static void main(String[] args) {                                                                             //...
        SortForHuluwa mysort = new SortForHuluwa();
        mysort.Randomhuluwa();
        mysort.bubbleSort();
        mysort.Randomhuluwa();
        mysort.halfSort();
    }

}
