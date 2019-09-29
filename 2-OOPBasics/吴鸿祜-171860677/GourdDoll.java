import java.util.*;

class DollBrother
{
    private int rank;
    private int color;

    DollBrother(int rank)
    {
        this.rank=rank;
        this.color=rank;
    }


    public int getRank(){return rank;}

    public int getColor(){return color;}
}

public class GourdDoll
{
    public static DollBrother brothers[];

    GourdDoll(){};

    private String sayRank(DollBrother brother)
    {
        int rank=brother.getRank();
        switch(rank)
        {
            case 1: return "老大";
            case 2: return "老二";
            case 3: return "老三";
            case 4: return "老四";
            case 5: return "老五";
            case 6: return "老六";
            case 7: return "老七";
        }

        return null;
    }

    private String sayColor(DollBrother brother)
    {
        int color=brother.getColor();
        switch(color)
        {
            case 1: return "红色";
            case 2: return "橙色";
            case 3: return "黄色";
            case 4: return "绿色";
            case 5: return "青色";
            case 6: return "蓝色";
            case 7: return "紫色";
        }

        return null;
    }


    public void bubblesort()
    {
        brothers=new DollBrother[7];
        System.out.println("输入葫芦娃七兄弟的初次站位顺序：");
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<7;i++)
        {
            int rank=sc.nextInt();
            brothers[i]=new DollBrother(rank);
        }

        for(int i=0;i<6;i++)
        {
            for(int j=0;j<6-i;j++)
            {
                int currank=brothers[j].getRank();
                int nextrank=brothers[j+1].getRank();
                if(currank>nextrank)
                {
                    System.out.print(sayRank(brothers[j])+":"+j+"->"+(j+1)+" ");
                    System.out.println(sayRank(brothers[j+1])+":"+(j+1)+"->"+j);
                    DollBrother temp=new DollBrother(currank);
                    brothers[j]=brothers[j+1];
                    brothers[j+1]=temp;
                }
            }
        }

        System.out.println("排序结束开始报数：");
        for(int i=0;i<7;i++)
        {
            System.out.print(sayRank(brothers[i])+" ");
        }
        System.out.println('\n');
    }

    public void dichotomysort()
    {
        brothers=new DollBrother[7];
        System.out.println("再次输入葫芦娃七兄弟的站位顺序：");
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<7;i++)
        {
            int rank=sc.nextInt();
            brothers[i]=new DollBrother(rank);
        }

        for(int i=0;i<7;i++)
        {
            int start=0,end=i-1;
            int mid=-1;
            while(start<=end)
            {
                mid=(start+end)/2;
                if(brothers[mid].getColor()>brothers[i].getColor()) end=mid-1;
                else start=mid+1;
            }

            DollBrother temp=brothers[i];
            for(int j=i-1;j>end;j--)
            {
                //System.out.print(sayRank(brothers[j])+":"+j+"->"+(j+1)+" ");
                System.out.println(sayRank(brothers[j])+":"+j+"->"+(j+1));
                brothers[j+1]=brothers[j];
            }

            if(end+1!=i) System.out.println(sayRank(temp)+":"+i+"->"+(end+1));
            brothers[end + 1] = temp;

        }


        System.out.println("排序结束开始报数：");
        for(int i=0;i<7;i++)
        {
            System.out.print(sayColor(brothers[i])+" ");
        }
        System.out.println('\n');
    }

    public static  void main(String[] args)
    {
        GourdDoll family=new GourdDoll();
        family.bubblesort();
        family.dichotomysort();
    }
}
