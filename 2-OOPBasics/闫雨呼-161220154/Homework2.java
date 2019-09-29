import java.util.Random;

enum countKind{
    NAME,COLOR
}

//葫芦娃类
class HuLuWa{
    //葫芦娃的次序（排序的依据，老大为0，老二为1，以此类推）
    private int rank;
    //葫芦娃与次序对应的名字以及颜色
    private static String[] names={"老大","老二","老三","老四","老五","老六","老七"};
    private static String[] colors={"红色","橙色","黄色","绿色","青色","蓝色","紫色"};

    HuLuWa(int mRank){
        rank=mRank;
    }
    //葫芦娃进行报数
    public void count(countKind kind){
        if(kind==countKind.NAME)
            System.out.println(HuLuWa.names[rank]);
        else
            System.out.println(HuLuWa.colors[rank]);
    }
    //获取葫芦娃次序
    public int getRank(){
        return rank;
    }
    //葫芦娃位置移动，这里的src和dst表示的含义不是数组下标，而是第[src+1]个葫芦娃移动到第[dst+1]个葫芦娃的位置
    public void runTo(HuLuWa[] huLuWaBrothers,int src,int dst){
        System.out.println(HuLuWa.names[rank]+":"+(src+1)+"->"+(dst+1));
        huLuWaBrothers[dst]=this;
    }
    //葫芦娃达到空闲的中间位置，这个位置不属于葫芦娃队列中的位置
    public void runToTempPosition(){
        HuluwaQueue.tempPosition=this;
    }
    //葫芦娃从空闲的中间位置归位
    public static void returnFromTemp(HuLuWa[] huLuWaBrothers,int dst){
        huLuWaBrothers[dst]=HuluwaQueue.tempPosition;
    }
}

//葫芦娃队列：建立在葫芦娃与上帝之间的媒介，上帝只能操纵队列，不能直接操纵葫芦娃
class HuluwaQueue{
    private HuLuWa[] huLuWaBrothers;
    private int numberOfHuLuWa;
    public static HuLuWa tempPosition;
    HuluwaQueue(int number){
        huLuWaBrothers=new HuLuWa[number];
        numberOfHuLuWa=number;
        //初始化7个葫芦娃
        for(int i=0;i<number;i++)
            huLuWaBrothers[i]=new HuLuWa(i);
    }

    //两个葫芦娃交换位置：其中一个葫芦娃移动到一个暂时的中间位置，第二个葫芦娃到达第一个葫芦娃的位置，之后第一个葫芦娃从中间位置达到第二个葫芦娃原来所在位置完成交换
    private void swap(int p1,int p2){
        huLuWaBrothers[p2].runToTempPosition();
        huLuWaBrothers[p1].runTo(huLuWaBrothers,p1,p2);
        HuLuWa.returnFromTemp(huLuWaBrothers,p1);
    }
    //葫芦娃随机排序
    public void shuffle(){
        Random rand=new Random();
        for(int i=numberOfHuLuWa;i>1;i--){
            int randPos=rand.nextInt(i);
            swap(randPos,i-1);
        }
    }
    //冒泡排序
    public void bubbleSort(){
        for(int i=0;i<numberOfHuLuWa-1;i++){
            for(int j=0;j<numberOfHuLuWa-1-i;j++){
                if(huLuWaBrothers[j].getRank()>huLuWaBrothers[j+1].getRank())
                    swap(j,j+1);
            }
        }
    }
    //二分法插入排序
    public void binarySort(){
        int start,end,mid=-1,insertPos;
        HuLuWa temp=null;
        for(int i=1;i<numberOfHuLuWa;i++){
            temp=huLuWaBrothers[i];
            start=0;
            end=i-1;
            while(start<=end){
                mid=(start+end)/2;
                if(huLuWaBrothers[mid].getRank()<huLuWaBrothers[i].getRank())
                    start=mid+1;
                else
                    end=mid-1;
            }
            if(huLuWaBrothers[mid].getRank()<huLuWaBrothers[i].getRank())
                insertPos=mid+1;
            else
                insertPos=mid;
            for(int j=i;j>insertPos;j--)
                huLuWaBrothers[j-1].runTo(huLuWaBrothers,j-1,j);
            temp.runTo(huLuWaBrothers,i,insertPos);
        }
    }
    //报数函数，传入的参数用来区分是根据名字报数还是根据颜色报数
    public void count(countKind kind){
        for(int i=0;i<numberOfHuLuWa;i++){
            if(kind==countKind.NAME)
                huLuWaBrothers[i].count(countKind.NAME);
            else
                huLuWaBrothers[i].count(countKind.COLOR);
        }
    }
}

//虚拟一个上帝用来指挥葫芦娃队列完成各种操作
class God{
    //葫芦娃个数
    private static int HULUWA_NUM=7;
    private HuluwaQueue huLuWaQueue;
    God(){
        huLuWaQueue = new HuluwaQueue(HULUWA_NUM);
    }
    public void run(){
        System.out.println("Shuffle Begins!");
        huLuWaQueue.shuffle();
        System.out.println(" ");

        System.out.println("BubbleSort Begins!");
        huLuWaQueue.bubbleSort();
        System.out.println(" ");

        System.out.println("Count Begins(according to names)!");
        huLuWaQueue.count(countKind.NAME);
        System.out.println(" ");

        System.out.println("Shuffle Begins!");
        huLuWaQueue.shuffle();
        System.out.println(" ");

        System.out.println("BinarySort Begins!");
        huLuWaQueue.binarySort();
        System.out.println(" ");

        System.out.println("Count Begins(according to colors)!");
        huLuWaQueue.count(countKind.COLOR);
        System.out.println(" ");
    }
}

//实现本次作业所要求任务
public class Homework2 {
    public static void main(String[] args){
        God god = new God();
        god.run();
    }
}
