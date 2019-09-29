import java.util.ArrayList;
import java.util.Collections;

//葫芦娃
class CalabashbBrother{
    //中文字符问题   可使用javac -encoding utf-8 xx.java解决
    static String []names = {"老大", "老二", "老三", "老四", "老五", "老六", "老七"};
    static String []colors = {"红色", "橙色", "黄色", "绿色", "青色", "蓝色", "紫色"};
    String name;                        //名字
    String color;                       //颜色
    int order;                          //排行
    int position;                       //在队伍中的位置

    public CalabashbBrother(){}
    public CalabashbBrother(int i){
        name = names[i];
        color = colors[i];
        order = i + 1;
    }
    public void numberOffName(){        //按名字报数
        System.out.print(name + " ");
    }
    public void numberOffColor(){       //按颜色报数
        System.out.print(color + " ");
    }
    public void move(int dest){         //移动位置
        System.out.println(name + ": " + Integer.toString(position) + "->" + Integer.toString(dest));
        position = dest;
    }
}

//葫芦娃队伍
class Row{
    ArrayList<CalabashbBrother> row = new ArrayList<CalabashbBrother>();
    public Row(){
        for(int i = 0; i < 7; i++){
            row.add(new CalabashbBrother(i));
        }
    }

    public void randomRow(){            //随意站队
        Collections.shuffle(row);
        for(int i = 0; i < 7; i++){
            row.get(i).position = i;
        }
    }
    public void bubbleSort(){           //冒泡排序
        for(int i = 1; i <= 6; i++){
            for(int j = 0; j <= 6 - i; j++){
                if(row.get(j).order > row.get(j + 1).order){
                    row.get(j).move(j + 1);
                    row.get(j + 1).move(j);
                    CalabashbBrother temp = row.get(j + 1);
                    row.set(j + 1, row.get(j));
                    row.set(j, temp);
                }
            }
        }
    }
    public void binarySort(){           //二分排序
        for(int i = 1; i < 7; i++){
            int place = binarySearch(i);
            if(place != i){
                row.get(i).move(place);
                for(int j = place; j < i; j++){
                    row.get(j).move(j + 1);
                }
            }
            CalabashbBrother temp = row.get(i);
            row.remove(i);
            row.add(place, temp);
        }
        
    }
    private int binarySearch(int i){    //二分查找
        int first = 0, last = i - 1;
        while(first <= last){
            int mid = (first + last) / 2;
            if(row.get(mid).order < row.get(i).order){
                first = mid + 1;
                if(first > last)
                    return first;
            }
            else{
                last = mid - 1;
                if(last < first){
                    return mid;
                }
            }
        }
        return -1;
    }
    public void numberOffName(){        //队伍按照名字报数
        for(int i = 0; i < 7; i++){
            row.get(i).numberOffName();
        }
        System.out.println();
    }
    public void numberOffColor(){       //队伍按照颜色报数
        for(int i = 0; i < 7; i++){
            row.get(i).numberOffColor();
        }
        System.out.println();
    }
}

//爷爷，发出指令，指挥葫芦娃队伍
public class Grandfather{
    public static void main(String[] s){
        Row r = new Row();
        //冒泡排序
        r.randomRow();
        r.numberOffName();
        r.bubbleSort();
        r.numberOffName();

        System.out.println();

        //二分排序
        r.randomRow();
        r.numberOffColor();
        r.binarySort();
        r.numberOffColor();
    }
}