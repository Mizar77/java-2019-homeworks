import java.util.Random;

class Brother{
    int BrotherNo;//辈分位置，老大记为1
    String color;//葫芦娃的颜色
    String name;//名字（老大）

    int lineNo;//队中位置

    void reportName(){System.out.println(name);}
    void reportColor(){System.out.println(color);}

}

public class BrothersLine {
    Brother[] brothers;//临时用
    Brother[] queue;

    void initialize(){
        Brother one=new Brother();
        one.BrotherNo=1;
        one.color="红色";
        one.name="老大";//生老大
        Brother two=new Brother();
        two.BrotherNo=2;
        two.color="橙色";
        two.name="老二";//生老二
        Brother three=new Brother();
        three.BrotherNo=3;
        three.color="黄色";
        three.name="老三";//生老三
        Brother four=new Brother();
        four.BrotherNo=4;
        four.color="绿色";
        four.name="老四";//生老四
        Brother five=new Brother();
        five.BrotherNo=5;
        five.color="青色";
        five.name="老五";//生老五
        Brother six=new Brother();
        six.BrotherNo=6;
        six.color="蓝色";
        six.name="老六";//生老六
        Brother seven=new Brother();
        seven.BrotherNo=7;
        seven.color="紫色";
        seven.name="老七";//生老七
        brothers=new Brother[7];
        brothers[0]=one;
        brothers[1]=two;
        brothers[2]=three;
        brothers[3]=four;
        brothers[4]=five;
        brothers[5]=six;
        brothers[6]=seven;
    }//创建七兄弟

    void allocateSeat(){
        int[] line=new int[7];
        Random rand=new Random();
        queue=new Brother[7];
        for(int i=0;i<7;i++){
            line[i]=rand.nextInt(7)+1;
            for(int j=0;j<i;j++){
                if(line[i]==line[j]){
                    i--;
                    break;
                }
            }
        }//生成无重复的随机数
        for(int i=0;i<7;i++){
            brothers[i].lineNo=line[i];
        }

        for(int i=0;i<7;i++){
            for(int j=0;j<7;j++){
                if(i==brothers[j].lineNo-1)
                    queue[i]=brothers[j];
            }
        }

        //test
        /*int i=0;
        while(i<7){
            System.out.println(line[i]);
            i++;
        }*/


    }//随机分配座位

    void bubble(){
        for(int i=0;i<6;i++){
            for(int j=0;j<6-i;j++){
                if(queue[j].BrotherNo>queue[j+1].BrotherNo){
                    System.out.println(queue[j].name+":"+(j+1)+"->"+(j+2));
                    System.out.println(queue[j+1].name+":"+(j+2)+"->"+(j+1));
                    Brother temp=queue[j];
                    queue[j]=queue[j+1];
                    queue[j+1]=temp;
                }
            }
        }
        for(int i=0;i<7;i++){
            queue[i].reportName();
        }
    }//根据辈分排队

    void binary(){
        /*for(int i=0;i<7;i++){
            queue[i].reportName();
        }*/
        int begin=0;
        int end=1;
        while(end<7){
            int mid=0;
            int low=0;
            int high=end-1;
            Brother temp=queue[end];
            while(low<=high){

                mid=(low+high)/2;
                if(low==mid){
                    break;
                }
                if(queue[mid].BrotherNo>queue[end].BrotherNo){
                    high=mid;
                }else if(queue[mid].BrotherNo<queue[end].BrotherNo){
                    low=mid;
                }
            }
            if(temp.BrotherNo>queue[high].BrotherNo){
                end++;
                continue;
            }
            if(temp.BrotherNo>queue[mid].BrotherNo){
                for(int i=end-1;i>mid;i--){
                    System.out.println(queue[i].name+":"+(i+1)+"->"+(i+2));
                    queue[i+1]=queue[i];
                }
                if(end>=mid){
                    System.out.println(temp.name+":"+(end+1)+"->"+(mid+2));
                    queue[mid+1]=temp;
                }
            }
            else{
                for(int i=end-1;i>mid;i--){
                    System.out.println(queue[i].name+":"+(i+1)+"->"+(i+2));
                    queue[i+1]=queue[i];
                }
                System.out.println(queue[mid].name+":"+(mid+1)+"->"+(mid+2));
                System.out.println(temp.name+":"+(end+1)+"->"+(mid+1));
                queue[mid+1]=queue[mid];
                queue[mid]=temp;
            }

            end++;
        }
        for(int i=0;i<7;i++){
            queue[i].reportColor();
        }
    }

    public static void main(String[] args){
        //System.out.println("start");
        BrothersLine line=new BrothersLine();
        line.initialize();//初始化，生成7个兄弟
        line.allocateSeat();//随机分配位置
        line.bubble();//按辈分冒泡排序
        line.initialize();
        line.allocateSeat();//重新随机分配
        line.binary();
        //System.out.println("end");
    }
}
