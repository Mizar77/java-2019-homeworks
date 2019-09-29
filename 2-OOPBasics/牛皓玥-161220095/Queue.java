import com.sun.corba.se.impl.protocol.MinimalServantCacheLocalCRDImpl;

import javax.xml.soap.SAAJResult;
import java.util.*;

public class Queue {
    //葫芦娃队列
    List<Gourd> brothers = new ArrayList<Gourd>();

    //初始化葫芦娃兄弟列表
    Queue(){
        for(int i = 0;i< 7;i++) {
            //分为两步：创建一个葫芦娃，并赋予其位置
            brothers.add(new Gourd(i));
            brothers.get(i).setPosition(i);
        }
    }

    //随机排列
    public void Shuffle(){
        Collections.shuffle(brothers);
        for(int i = 0;i< 7;i++)
            brothers.get(i).setPosition(i);
    }

    //查看当前队伍顺序
    public void Show(){
        System.out.print("当前队伍顺序为：\n");
        for(int i = 0;i < brothers.size();i++)
            brothers.get(i).tellpos();
        System.out.print('\n');
        for(int i = 0;i < brothers.size();i++)
            brothers.get(i).tellnum();
        System.out.print("\n");
    }

    //冒泡排序
    public void BubbleSort(){
        System.out.print("开始排序：\n");
        for(int i = 0;i < brothers.size();i++){
            for (int j = 1;j < brothers.size()-i;j++){
                if(brothers.get(j).index  < brothers.get(j-1).index){
                    //swap
                    brothers.get(j).tellnum();
                    System.out.print("<——>" );
                    brothers.get(j-1).tellnum();
                    System.out.print('\n');
                    brothers.get(j).tellchange(j-1);
                    brothers.get(j-1).tellchange(j);
                    System.out.print('\n');
                    Collections.swap(brothers,j,j-1);
                }
            }
        }
    }

    //二分排序
    public void QuickSort(int left,int right){
        int start = left;
        int end = right;
        int ref = brothers.get(left).index;
        while(left != right){
            while((left < right)&& brothers.get(left).index < ref)
                left ++;
            while((left < right)&& brothers.get(right).index > ref)
                right --;
            if(left !=right){
                //swap
                brothers.get(right).tellnum();
                System.out.print("<——>" );
                brothers.get(left).tellnum();
                System.out.print("\n");
                brothers.get(right).tellchange(left);
                brothers.get(left).tellchange(right);
                System.out.print('\n');
                Collections.swap(brothers,right,left);
            }
        }
        //递归
        if (left-1 > start)
            QuickSort(start,left-1);
        if (left+1 < end)
            QuickSort(left+1,end);
        return;
    }

    //年龄报数
    public void AgeCountoff(){
        System.out.print("按排行报数：");
        for(int i = 0;i < brothers.size();i++)
            brothers.get(i).tellnum();
        System.out.print("\n\n");
    }

    //颜色报数
    public void ColorCountoff() {
        System.out.print("按颜色报数：");
        for (int i = 0; i < brothers.size(); i++)
            brothers.get(i).tellcolor();
        System.out.print("\n");
    }
}
