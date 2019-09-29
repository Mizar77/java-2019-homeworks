package demo;

enum Color{
    red,orange,yellow,green,cyan,blue,purple
}

class huluwa{
    int number;  //葫芦娃大小排名  1到7
    //int position; //位置  0到6
    Color color;  //葫芦娃颜色


    void brith(int number,Color color){this.number = number; this.color = color; } //出生
   // void choose_a_hulu(){ this.position =  (int)(Math.random()*7);} //随机选择一个位置
   // boolean is_in_the_position(huluwa wa){ //询问某个葫芦娃是否跟自己要坐的位置相同
    //    if(wa.position != 0)
    //        if(wa.position == this.position) {return true;}
   //     return false;
   // }
    void translation(int i){
       switch (i){
           case 1:  System.out.print("老大");break;
           case 2:  System.out.print("老二");break;
           case 3:  System.out.print("老三");break;
           case 4:  System.out.print("老四");break;
           case 5:  System.out.print("老五");break;
           case 6:  System.out.print("老六");break;
           case 7:  System.out.print("老七");break;
       }
   } //转换称呼
    void translation1(int i){
        switch (i){
            case 1:  System.out.print("红色");break;
            case 2:  System.out.print("橙色");break;
            case 3:  System.out.print("黄色");break;
            case 4:  System.out.print("绿色");break;
            case 5:  System.out.print("青色");break;
            case 6:  System.out.print("蓝色");break;
            case 7:  System.out.print("紫色");break;
        }
    } //转换颜色
    void number_off(){ System.out.print(this.number);}  //报数
    void color_off(){System.out.print(this.color + " ");} //报告颜色
    void tell_change(int m,int n){
        translation(this.number);
        System.out.print(" : " + m + " ->" + n + "\n");
    }//位置改变时报告
}

public class Huluteng {
    huluwa[] hulu; //葫芦藤上的7个葫芦
    void initialize(){    //初始化
        huluwa wa1 = new huluwa();
        wa1.brith(1,Color.red);
        huluwa wa2 = new huluwa();
        wa2.brith(2,Color.orange);
        huluwa wa3 = new huluwa();
        wa3.brith(3,Color.yellow);
        huluwa wa4 = new huluwa();
        wa4.brith(4,Color.green);
        huluwa wa5 = new huluwa();
        wa5.brith(5,Color.cyan);
        huluwa wa6 = new huluwa();
        wa6.brith(6,Color.blue);
        huluwa wa7 = new huluwa();
        wa7.brith(7,Color.purple);
        hulu = new huluwa[7];
        hulu[0] = wa1;
        hulu[1] = wa2;
        hulu[2] = wa3;
        hulu[3] = wa4;
        hulu[4] = wa5;
        hulu[5] = wa6;
        hulu[6] = wa7;
    }
    void random_line() {
        for(int i=0;i<7;i++) {
            int a = (int)(Math.random()*7);
            huluwa temp = hulu[i];
            hulu[i] = hulu[a];
            hulu[a] = temp;
        }
    }   //随机排序
    void let_number_off() {
        for(int i=0;i<hulu.length;i++) {
            hulu[i].translation(hulu[i].number);
            System.out.print(" ");
        }
    }  //报数
    void let_color_off() {
        for(int i=0;i<hulu.length;i++) {
            hulu[i].translation1(hulu[i].number);
            System.out.print(" ");
        }
    }  //报颜色
    void bubble_sort(){
        System.out.print("bubblesort: " + "\n");
        for(int i=0;i<hulu.length;i++) {
            for(int j=0;j<hulu.length - i - 1;j++)
            {
                if(hulu[j].number > hulu[j + 1].number)
                {
                    hulu[j].tell_change(j,j+1);
                    huluwa temp = hulu[j+1];
                    hulu[j+1] = hulu[j];
                    hulu[j] = temp;
                }
            }
        }
    }      //冒泡排序
    void quickSort(){
        System.out.print("quickSort: " + "\n");
        sort(0,6);
    }
    private void sort(int start,int end) {
        if (start < end) {
            int index = getindex(start, end);
            sort(start, index - 1);
            sort(index + 1, end);
        }
    }
    private int getindex(int start,int end) {
        int i = start;
        int j = end;
        huluwa index = hulu[i];
        while(i < j )
        {
            while(i < j && hulu[j].number >= index.number)
                j--;
            if(i<j){
                hulu[i] = hulu[j];
                hulu[j].tell_change(j,i);
                i++;
            }
            while(i < j && hulu[i].number <= index.number)
                i++;
            if(i<j){
                hulu[j] = hulu[i];
                hulu[i].tell_change(i,j);
                j--;
            }
        }
        hulu[i] = index;
        return i;
    }

    public static void main(String[] args) {
        Huluteng huluteng = new Huluteng();
        huluteng.initialize();
        huluteng.random_line();
        huluteng.bubble_sort();
        huluteng.let_number_off();
        System.out.print("\n");
        huluteng.random_line();
        huluteng.quickSort();
        huluteng.let_color_off();
    }
}
