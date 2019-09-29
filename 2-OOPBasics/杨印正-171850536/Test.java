import java.util.concurrent.Callable;
class Test {
    final static int MAX=7;
    public static void main(String[] args){
CalabashBrother [] huluwa=new CalabashBrother[MAX];
        huluwa[0]=new CalabashBrother(1,0,"老大","红色");//七个葫芦娃
        huluwa[1]=new CalabashBrother(2,0,"老二","橙色");
        huluwa[2]=new CalabashBrother(3,0,"老三","黄色");
        huluwa[3]=new CalabashBrother(4,0,"老四","绿色");
        huluwa[4]=new CalabashBrother(5,0,"老五","青色");
        huluwa[5]=new CalabashBrother(6,0,"老六","蓝色");
        huluwa[6]=new CalabashBrother(7,0,"老七","紫色");
String random1="3576412";//随机坐标
for(int i=0;i<7;i++) {
    huluwa[i].location = random1.charAt(i) - '0';
System.out.println(huluwa[i].location+"号位置："+huluwa[i].seniority);//显示初始坐标
}
System.out.println("排序前：");
        for(int j=1;j<8;j++) {
            for (int i=0; i<7; i++) {
                if (huluwa[i].location == j)
                {System.out.println(huluwa[i].location+"号位置：");
                    huluwa[i].report("seniority");
                }
            }
        }//输出当前排位
for(int h=1;h<MAX+1;h++) {//冒泡排序
    for (int i = 1; i < MAX +1-h; i++) {
        for (int j = 0; j < MAX; j++) {
            for (int k = 0; k < MAX; k++){
                if (huluwa[j].location == i&&huluwa[k].location == i + 1 && huluwa[j].number > huluwa[k].number)//bubble
                {
                    huluwa[j].report("seniority");
                    System.out.print(":");
                    huluwa[j].report("location");
                    System.out.print("->");
                    huluwa[k].report("location");
                    huluwa[k].report("seniority");
                    System.out.print(":");
                    huluwa[k].report("location");
                    System.out.print("->");
                    huluwa[j].report("location");
                    huluwa[j].change(huluwa[k]);
                }
            }
        }
    }
}
System.out.println("排序后：");
for(int j=1;j<8;j++) {//按坐标输出排序完坐标
    for (int i=0; i<7; i++) {
        if (huluwa[i].location == j)
        {System.out.println(huluwa[i].location+"号位置：");
            huluwa[i].report("seniority");

            }
    }
}
String random2="5762341";
        System.out.println("排序前：");
        for(int i=0;i<7;i++) {
            huluwa[i].location = random2.charAt(i) - '0';
            System.out.println(huluwa[i].location+huluwa[i].seniority);
        }
        for(int j=1;j<8;j++) {
            for (int i=0; i<7; i++) {
                if (huluwa[i].location == j)
                {
                    huluwa[i].report("seniority");
                }
            }
        }
       BinarySort.binarysort(huluwa);//二分法排序
        System.out.println("排序后：");
      for(int j=1;j<8;j++) {
            for (int i=0; i<7; i++) {
                if (huluwa[i].location == j)
                {
                    huluwa[i].report("seniority");
                    huluwa[i].report("color");
                }
            }
        }
    }
}

