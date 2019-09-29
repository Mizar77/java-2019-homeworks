import java.util.*;
public class Main {
    public static void main(String[] args) {
        CalabashBrothers queue =new CalabashBrothers();//新建一个葫芦世界
        queue.shuffle();
        System.out.println("*****************冒泡排序（老大到老七）***************");
        System.out.println("随机数处理的随意站队为：");
        for(int i=0;i<7;i++){
            queue.calabashes[i].shoutName();
        }
        System.out.println();
        System.out.println("冒泡排序ing：");
        queue.bubbleSort();
        System.out.println("冒泡排序结束（按排行报数）：");
        for(int i=0;i<7;i++){
            queue.calabashes[i].shoutName();
        }
        System.out.println();
        System.out.println("*****************二分法排序（颜色）***************");
        queue.shuffle();
        System.out.println("随机数处理的随意站队为：");
        for(int i=0;i<7;i++){
            queue.calabashes[i].shoutColor();
        }
        System.out.println();
        System.out.println("二分法排序ing：");
        queue.quickSort();
        System.out.print("二分法排序结束（按颜色报数）：");
        for(int i=0;i<7;i++){
            queue.calabashes[i].shoutColor();
        }
        System.out.println();
    }
}
