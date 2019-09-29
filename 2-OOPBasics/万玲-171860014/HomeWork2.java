
class Huluwa
{
    int num;//兄弟排行
    String ChineseNum;//汉字排行，例如老大
    int pos;//位置编号
    String color;
    Huluwa(int n, int p)
    {
        num=n;
        pos=p;
        switch(n)
        {
            case 1:ChineseNum="老大";color="红色";break;
            case 2:ChineseNum="老二";color="橙色";break;
            case 3:ChineseNum="老三";color="黄色";break;
            case 4:ChineseNum="老四";color="绿色";break;
            case 5:ChineseNum="老五";color="青色";break;
            case 6:ChineseNum="老六";color="蓝色";break;
            case 7:ChineseNum="老七";color="紫色";break;
            default:break;
        }
    }
    void changePos(int x)
    {
        pos=x;
    }
    void sayNum()
    {
        System.out.print(ChineseNum);
    }
    /*void sayPos()
    {
        System.out.println(pos);
    }*/
    void sayColor()
    {
        System.out.println(color);
    }
}
public class HomeWork2
{
    
    public static void main(String[] args) 
    {
        Huluwa[] bro;
        bro=new Huluwa[7];
        Huluwa h1=new Huluwa(1,6);bro[6]=h1;
        Huluwa h2=new Huluwa(2,4);bro[4]=h2;
        Huluwa h3=new Huluwa(3,0);bro[0]=h3;
        Huluwa h4=new Huluwa(4,2);bro[2]=h4;
        Huluwa h5=new Huluwa(5,1);bro[1]=h5;
        Huluwa h6=new Huluwa(6,5);bro[5]=h6;
        Huluwa h7=new Huluwa(7,3);bro[3]=h7;
        System.out.println("初始化乱序为：");
        for(int i=0;i<7;i++)
        {
            bro[i].sayNum();
        }
        System.out.println(" ");
        //冒泡排序
        System.out.println("1、冒泡排序过程：");
        for(int i=0;i<6;i++)
        {
            for(int j=0;j<7-i-1;j++)
            {
                if(bro[j].num>bro[j+1].num)
                {
                    //交换j和j+1的位置
                    

                    bro[j].sayNum();System.out.println(":"+j+"->"+(j+1));
                    bro[j+1].sayNum();System.out.println(":"+(j+1)+"->"+j);
                    bro[j].changePos(j+1);
                    bro[j+1].changePos(j);
                    Huluwa tmp=new Huluwa(0);
                    tmp=bro[j];
                    bro[j]=bro[j+1];
                    bro[j+1]=tmp;
                }
            }
        }
        System.out.println("冒泡排序后依次报数：");
        for(int i=0;i<7;i++)
        {
            bro[i].sayNum();
            
        }
        System.out.println(" ");
        //重新打乱
        bro[6]=h1;bro[4]=h2;bro[0]=h3;bro[2]=h4;bro[1]=h5;bro[5]=h6;bro[3]=h7;
        System.out.println("重新打乱顺序为：");
        for(int i=0;i<7;i++)
        {
            bro[i].sayNum();
            //System.out.println(" ");
        }
        System.out.println(" ");
        //System.out.println("-------------------");
        //二分排序
        System.out.println("2、二分排序过程：");
        binarySort(bro, 7);
        System.out.println("二分排序结果为：");
        for(int i=0;i<7;i++)
        {
            bro[i].sayColor();
        }

    }
    public static void binarySort(Huluwa []a,int len)
    {
        int start=0,mid=0,end=0;
        Huluwa tmp=new Huluwa(0);
        for(int i=1;i<len;i++)
        {
            start=0;
            mid=0;
            end=i-1;
            tmp=a[i];
            while(start<=end)
            {
                mid=(start+end)/2;
                if(a[mid].num>a[i].num)
                {
                    end=mid-1;
                }
                else
                {
                    start=mid+1;
                }
            }
            for(int j=i-1;j>=end+1;j--)
            {
                a[j].sayNum();System.out.println(":"+j+"->"+(j+1));
                a[j+1]=a[j];
                
            }
            if(end+1!=i)
                {tmp.sayNum();System.out.println(":"+i+"->"+(end+1));}
            a[end+1]=tmp;

        }
        
    }
}