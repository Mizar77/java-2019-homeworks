import java.util.Random;
public class HuLuWaSortMain
{
    public static void main(String[] args) throws Exception 
    {
        HuLuWaSort hlwsort = new HuLuWaSort();
        System.out.println("随机排序");
        hlwsort.shuffle();
        System.out.println("冒泡排序前:");
        hlwsort.allBaoShu(0);
        System.out.println("开始冒泡排序:");
        hlwsort.bubbleSort();
        System.out.println("冒泡排序后:");
        hlwsort.allBaoShu(0);
        System.out.println("随机排序");
        hlwsort.shuffle();
        System.out.println("二分排序前");
        hlwsort.allBaoShu(1);
        System.out.println("开始二分排序:");
        hlwsort.divideSort(0, hlwsort.getSize()-1);
        System.out.println("二分排序后");
        hlwsort.allBaoShu(1);
    }
}
class HuLuWaSort {
    private static HuLuWa[] hlwarr;
    private static Random rand = new Random();
    final static int size = 7;
    HuLuWaSort()
    {
        hlwarr = new HuLuWa[7];
        hlwarr[0] = new HuLuWa(1,"大娃","红色");
        hlwarr[1] = new HuLuWa(2,"二娃","橙色");
        hlwarr[2] = new HuLuWa(3,"三娃","黄色");
        hlwarr[3] = new HuLuWa(4,"四娃","绿色");
        hlwarr[4] = new HuLuWa(5,"五娃","青色");
        hlwarr[5] = new HuLuWa(6,"六娃","蓝色");
        hlwarr[6] = new HuLuWa(7,"七娃","紫色");
    }
    public int getSize()
    {
        return size;
    }
    public  void shuffle()
    {
        for(int i = size;i > 0;i--)
        {
            int randInt = rand.nextInt(i);
            hlwarr[i - 1].swap(false,hlwarr[randInt],i - 1,randInt);
        }
    }
    public  void bubbleSort()
    {
        for(int i = size;i > 0;i--)
        {
            for(int j = 0;j < i - 1;j++)
            {
                if(hlwarr[j].getId()>hlwarr[j+1].getId())
                {
                    hlwarr[j].swap(true,hlwarr[j+1],j,j+1);
                    allBaoShu(0);
                }
            }
        }
    }
    public void divideSort(int i,int j)
    {
        if(i >= j)
            return;
        boolean changeflg = true;
        int m = (i+j)/2;
        divideSort(i,m);
        divideSort(m+1,j);
        System.out.println("位置"+i+"-"+j+"开始排序");
        HuLuWa[] temparr = new HuLuWa[j - i + 1];
        for(int ii = 0;ii < j - i + 1;ii++)
            temparr[ii] = new HuLuWa(0,"","");
        int p1 = i;
        int p2 = m + 1;
        int p3 = 0;
        while(p1 <= m && p2 <= j)
        {
            if(hlwarr[p1].getId() < hlwarr[p2].getId())
            {
                temparr[p3].copy(true,hlwarr[p1],p1,i+p3);
                p3++;
                p1++;
            }
            else
            {
                temparr[p3].copy(true,hlwarr[p2],p2,i+p3);
                p3++;
                p2++;
            }
        }
        if(p2 == m + 1)
            changeflg = false;
        for(;p1<=m;p1++)
        {
            temparr[p3].copy(true,hlwarr[p1],p1,i+p3);
            p3++;
        }
        for(;p2<=j;p2++)
        {
            temparr[p3].copy(true,hlwarr[p2],p2,i+p3);
            p3++;
        }
        for(int p4 = i,p5 = 0;p4 <= j;p4++,p5++)
        {
            hlwarr[p4].copy(false,temparr[p5],p4,p5);
        }
        if(changeflg)
        {
            System.out.println("位置"+i+"-"+j+"排列完成,发生改变");
            allBaoShu(1);
        }
        else
        {
            System.out.println("位置"+i+"-"+j+"排列完成,未发生改变");
        }

    }
    public void allBaoShu(int flg)
    {
        if(flg == 0)
        {
             for(HuLuWa i:hlwarr)
                i.baoShu1();
        }
        else if(flg == 1)
        {
            for(HuLuWa i:hlwarr)
                i.baoShu2();
        }
        System.out.println("");
    }
  
}
class HuLuWa
{
    private int id;
    private String name;
    private String color;
    HuLuWa(int i,String a,String b)
    {
        id = i;
        name = a;
        color = b;
    }
    public void baoShu1()
    {
        System.out.print(name + " ");
    }
    public void baoShu2()
    {
        System.out.print(color + " ");
    }
    public int getId()
    {
        return id;
    }
    public void copy(boolean flg,HuLuWa hlw,int place1,int place2)
    {
        id = hlw.id;
        name = hlw.name;
        color = hlw.color;
        if(flg && place1 != place2)
            System.out.println(name+"("+color+")"+": "+place1+"->"+place2);
    }
    public void swap(boolean flag,HuLuWa hlw,int place1,int place2)
    {
        if(flag)
        {
            System.out.println(name+"("+color+")"+": "+place1+"->"+place2);
            System.out.println(hlw.name+"("+hlw.color+")"+": "+place2+"->"+place1);
        }
        int temp1 = hlw.id;
        String temp2 = hlw.name;
        String temp3 = hlw.color;
        hlw.id = id;
        hlw.name = name;
        hlw.color = color;
        id = temp1;
        name = temp2;
        color = temp3;
    }
}