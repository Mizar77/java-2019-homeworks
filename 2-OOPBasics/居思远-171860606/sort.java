
import java.util.Arrays;

class boy
{
    int name;
    int color;
}

class hulu{
    int number=7;
    boy member[]=new boy[7];
    public void create(){
        for(int jk=0;jk<number;jk++)
            member[jk]=new boy();
    }

    public void set()                               //随意站队
    {
        member[0].name=3;member[0].color=3;
        member[1].name=2;member[1].color=2;
        member[2].name=4;member[2].color=4;
        member[3].name=1;member[3].color=1;
        member[4].name=7;member[4].color=7;
        member[5].name=6;member[5].color=6;
        member[6].name=5;member[6].color=5;
    }

    public void inttoname(int n)                                //由编号转化为名字
    {
        switch(n)
        {
            case 1:System.out.print("老大");break;
            case 2:System.out.print("老二");break;
            case 3:System.out.print("老三");break;
            case 4:System.out.print("老四");break;
            case 5:System.out.print("老五");break;
            case 6:System.out.print("老六");break;
            case 7:System.out.print("老七");break;
        }
    }

    public void inttocolor(int n)                                //由编号转化为颜色
    {
        switch(n)
        {
            case 1:System.out.print("红色");break;
            case 2:System.out.print("橙色");break;
            case 3:System.out.print("黄色");break;
            case 4:System.out.print("绿色");break;
            case 5:System.out.print("青色");break;
            case 6:System.out.print("蓝色");break;
            case 7:System.out.print("紫色");break;
        }
    }

    public void inform(int member,int position1,int position2)
    {
        inttoname(member);
        System.out.printf(":%d->%d\n",position1,position2);
    }

    public void reportname()
    {
        for(int jk=0;jk<number;jk++){
            inttoname(member[jk].name);
            System.out.print(" ");
        }
        System.out.print("\n");
    }

    public void reportcolor()
    {
        for(int jk=0;jk<number;jk++){
            inttocolor(member[jk].color);
            System.out.print(" ");
        }
        System.out.print("\n");
    }

}

public class sort {

    public static hulu h=new hulu();

    public static void bubble(boy member[], int number)                //冒泡排序，按照排行排序
    {
        for(int jk=0;jk<number-1;jk++) {
            for(int jt=0;jt<number-1;jt++) {
                if(member[jt].name>member[jt+1].name) {                           //根据名字（排行）来进行排序
                    h.inform(member[jt].name,jt,jt+1);
                    h.inform(member[jt+1].name,jt+1,jt);
                    boy temp=member[jt];
                    member[jt]=member[jt+1];
                    member[jt+1]=temp;
                }
            }
        }
    }

    public static void dichotomy(boy member[], int number)
    {
        for(int jk=1;jk<number;jk++)
        {
            boy i=member[jk];
            int start=0, finish=jk-1;
            int mid;
            while(start<=finish)
            {
                mid=(start+finish)/2;
                if(i.color>member[mid].color){                                  //根据颜色进行排序
                    start=mid+1;
                }
                else{
                    finish=mid-1;
                }
            }
            for(int jt=jk-1;jt>=start;jt--)
            {
                h.inform(member[jt].name,jt,jt+1);
                member[jt+1]=member[jt];
            }

            member[start]=i;
            if(jk!=start){
                h.inform(i.name,jk,start);
            }

        }

    }

    public static void main(String args[])
    {
        System.out.println("第一次随意站队：");
        h.create();
        h.set();
        h.reportname();
        System.out.println("开始冒泡排序：");
        bubble(h.member,h.number);
        System.out.println("排序完成，开始报数（排行）：");
        h.reportname();
        System.out.println("第二次随意站队：");
        h.set();
        h.reportcolor();
        System.out.println("开始二分法排序：");
        dichotomy(h.member,h.number);
        System.out.println("排序完成，开始报数（颜色）：");
        h.reportcolor();
        System.out.println("完成");

    }

}


