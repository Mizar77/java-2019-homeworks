/*
    Homework-2
    Version 2.0
 */

import java.util.*;

class Calabash{
    private String name;

    private String color;

    private int index;  //在队伍中的位置

    Calabash(String n, String c, int i) {
        name = n;
        color = c;
        index = i;
    }

    public void sayMyName() {
        System.out.println("我叫" + name + "  ");
    }

    public void sayMyColor() {
        System.out.println("我是" + color + "  ");
    }

    public String tellYouMyName() {
        return name;
    }

    public String tellYouMyColor() {
        return color;
    }

    public void whereAmI(int i) {   //告诉葫芦娃在哪里
        index = i;
    }

    public void tellYouWhereAmI() {
        System.out.println("我在" + "第" + (index+1) +"个位置");
    }
}

public class CalabashBro {
    private static final int size = 7;

    private static final int CMP_COLOR = 1;

    private static final int CMP_NAME = 0;

    private List<Calabash> calabashBros;

    private static final String[] color = {"红色", "橙色", "黄色", "绿色", "青色", "蓝色", "紫色"};

    private static final String[] name = {"老大", "老二", "老三", "老四", "老五", "老六", "老七"};


    CalabashBro(){
        calabashBros = new ArrayList<>();
        for (int i = 0; i < size; ++i){
            calabashBros.add(new Calabash(name[i], color[i], i));
        }
    }

    public static boolean cmp(int tag, Calabash a, Calabash b){ //比较两个葫芦娃的大小,颜色关系
        int i,j;
        if (tag == CMP_COLOR) {
            String aFeature = a.tellYouMyColor(), bFeature = b.tellYouMyColor();
            for (i = 0; i < size; i++){
                if (aFeature.equals(color[i]))
                    break;
            }
            for (j = 0; j < size; j++){
                if (bFeature.equals(color[j]))
                    break;
            }
        } else {
            String aFeature = a.tellYouMyName(), bFeature = b.tellYouMyName();
            for (i = 0; i < size; i++){
                if (aFeature.equals(name[i]))
                    break;
            }
            for (j = 0; j < size; j++){
                if (bFeature.equals(name[j]))
                    break;
            }
        }
        return i < j;
    }

    public void bubbleSort(){
        for (int i = 0; i < size - 1; i++){
            for (int j = 0; j < size - 1 - i; j++){
                if (cmp(CMP_NAME,calabashBros.get(j+1),calabashBros.get(j))) {
                    calabashBros.get(j+1).sayMyName();
                    calabashBros.get(j+1).tellYouWhereAmI();
                    //交换
                    Collections.swap(calabashBros,j,j+1);

                    calabashBros.get(j+1).whereAmI(j);
                    calabashBros.get(j+1).tellYouWhereAmI();
                }
            }
        }
        System.out.print('\n');
    }

    public void binarySort(){
        int left, right, mid;
        for (int i = 1; i < size; i++){
            Calabash calabash = calabashBros.get(i);
            left = 0;
            right = i - 1;
            while (left <= right){
                mid =left + (right - left) / 2;
                if (cmp(CMP_COLOR, calabashBros.get(mid), calabash)){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
            for (int j = i - 1; j >= left; j--){
                calabashBros.get(j+1).sayMyName();
                calabashBros.get(j+1).tellYouWhereAmI();
                //移动位置
                calabashBros.set(j+1,calabashBros.get(j));

                calabashBros.get(j).whereAmI(j);
                calabashBros.get(j).tellYouWhereAmI();
            }

            calabash.sayMyName();
            calabash.tellYouWhereAmI();
            //移动calabash到left
            calabashBros.set(left,calabash);

            calabash.whereAmI(left);
            calabash.tellYouWhereAmI();
        }
        System.out.print('\n');
    }

    public void print(int tag){
        if (tag == CMP_NAME){      //报数
            System.out.println("报数:");
            for (Calabash calabash: calabashBros) {
                calabash.sayMyName();
            }
        }else { //报颜色
            System.out.println("报颜色:");
            for (Calabash calabash: calabashBros) {
                calabash.sayMyName();
                calabash.sayMyColor();
            }
        }
        System.out.print('\n');
    }

    public void confuseThem() { //打乱他们
        Collections.shuffle(calabashBros);

        for (int i = 0; i < size; i++) {
            //告诉葫芦娃他们在哪个位置
            calabashBros.get(i).whereAmI(i);
        }
    }

    public static void main(String []args){
        CalabashBro calabashBro = new CalabashBro();

        calabashBro.confuseThem();
        System.out.println("排序前：");
        calabashBro.print(CMP_NAME);
        System.out.println("开始排队!");
        calabashBro.bubbleSort();
        System.out.println("排序后:");
        calabashBro.print(CMP_NAME);

        System.out.println("************************");

        calabashBro.confuseThem();
        System.out.println("排序前:");
        calabashBro.print(CMP_COLOR);
        System.out.println("开始排队!");
        calabashBro.binarySort();
        System.out.println("排序后:");
        calabashBro.print(CMP_COLOR);
    }
}
