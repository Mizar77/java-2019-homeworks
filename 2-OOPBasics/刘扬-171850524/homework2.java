//2019-9-10 homework2
//written by 171850524

public class homework2 {
    public static void main(String[] args){
        System.out.println("冒泡排序:");
        //预设七个位置，分别是七个葫芦娃的坐标，葫芦娃初始顺序由数组给定
        double[][] site = {{1.0,0.0,0.0},{2.0,0.0,0.0},{3.0,0.0,0.0},{4.0,0.0,0.0},{5.0,0.0,0.0},{6.0,0.0,0.0},{7.0,0.0,0.0}};
        int[] nums1 = {1,3,6,2,7,5,4};//指定葫芦娃顺序
        Sorter sort1 = new Sorter(nums1, site);
        sort1.bubbleSort();

        System.out.println("二分排序:");
        int[] nums2 = {5,7,4,3,2,6,1};
        Sorter sort2 = new Sorter(nums2, site);
        sort2.insertionSort();
    }
}
class Sorter{//sorter用于调度葫芦娃:向葫芦娃发出指令，葫芦娃接受指令后移动
    Boy[] queue = new Boy[7];//queue是sorter记录的葫芦娃的排队情况
    Sorter(int[] nums, double[][] site){//根据参数进行初始化
        for(int i=0; i<7; i++){
            queue[i] = new Boy(nums[i], site[i]);
        }
    }
    void bubbleSort(){//冒泡排序
        for(int i=0; i<7; i++){
            for(int j= 0; j<6; j++){
                //如果前后排行逆序，则交换相邻对象
                if(queue[j].tellRank() > queue[j+1].tellRank()){
                    //排行靠前的葫芦娃在队伍中处于排行靠后的葫芦娃的后方
                    double[] site1 = queue[j].tellSite();
                    double[] site2 = queue[j+1].tellSite();
                    double[] midSite1 = {(site1[0]+site2[0])/2,(site1[1]+site2[1])/2 + 1.0,(site1[2]+site2[2])/2};
                    double[] midSite2 = {(site1[0]+site2[0])/2,(site1[1]+site2[1])/2 + 2.0,(site1[2]+site2[2])/2};
                    queue[j].walk(midSite1, false);//一方先移动至中间位置
                    queue[j+1].walk(midSite2, false);
                    queue[j].walk(site2, true);
                    queue[j+1].walk(site1, true);//另一方移动至目标位置
                    swapQueue(j, j+1);//sort更新葫芦娃排队情况
                }
            }
        }
        for(int i=0;i<7;i++)
            queue[i].tellName();//报数
    }
    void insertionSort(){//二分排序
        for(int i=1;i<7;i++){
            int low = 0, high = i - 1;
            int mid = 0;
            while(low <= high){//按照二分法寻找i应该插入的位置
                mid = low + (high-low) / 2;
                if(queue[i].tellRank() >= queue[mid].tellRank()){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
            //上述循环结束后，i应该插在high的后面
            if(high+1 == i)
                continue;
            Boy tmpBoy = queue[i];
            double[] site0 = queue[high+1].tellSite();
            double[] site1 = queue[i].tellSite();
            double[] site2 = {0.0, 0.0, 0.0};
            double[] tmpSite = {(site0[0]+site1[0])/2,(site0[1]+site1[1])/2+1.0,(site0[2]+site1[2])/2};
            queue[i].walk(tmpSite, false);//移动至中间位置，等待目标位置的葫芦娃移动才能继续移动

            for(int j = i - 1; j > high; j --){//high后面的对象依次向后移动一位
                site2 = queue[j].tellSite();
                //double[] midSite = {(site1[0]+site2[0])/2,(site1[1]+site2[1])/2,(site1[2]+site2[2])/2};
                //queue[j].walk(midSite);
                queue[j].walk(site1,true);//可直接移动至目标位置
                site1 = site2;
                queue[j+1] = queue[j];//更新排队情况
            }
            tmpBoy.walk(site0, true);
            queue[high+1] = tmpBoy;
        }
        for(int i=0;i<7;i++)
            queue[i].tellColor();//报颜色
    }
    void swapQueue(int x, int y){//在葫芦娃移动之后，sorter需要更新自己记录的葫芦娃的排队情况
        Boy tmp = queue[x];
        queue[x] = queue[y];
        queue[y] = tmp;
    }
}
class Boy {
    int rank = 0;//排行
    double x = 0.0;
    double y = 0.0;
    double z = 0.0;
    String name = "";//姓名
    String color = "";//颜色
    Boy(int num, double[] site){//构造函数，根据参数确定rank name color
        rank = num;
        this.x = site[0];
        this.y = site[1];
        this.z = site[2];
        switch(rank){
            case 1: name = "老大"; color = "红色"; break;
            case 2: name = "老二"; color = "橙色"; break;
            case 3: name = "老三"; color = "黄色"; break;
            case 4: name = "老四"; color = "绿色"; break;
            case 5: name = "老五"; color = "青色"; break;
            case 6: name = "老六"; color = "蓝色"; break;
            case 7: name = "老七"; color = "紫色"; break;
            default: System.out.println("创建葫芦娃失败");
        }
    }
    int tellRank(){//返回排行的数字，用于排序
        return rank;
    }
    void tellName(){//排序结束后报数
       System.out.println(name);
    }
    void tellColor(){//排序结束后报颜色
        System.out.println(color);
    }
    double[] tellSite(){
        double[] res = {x, y, z};
        return res;
    }
    void walk(double[] sites, boolean flag){//执行并报告交换动作
        System.out.print(name+':');
        System.out.print("("+x+","+y+","+z+")"+"->");
        System.out.print("("+sites[0]+","+sites[1]+","+sites[2]+")");
        if(flag == true)
            System.out.println();
        else
            System.out.println("(在中间位置等待)");
        x = sites[0];
        y = sites[1];
        z = sites[2];
    }
}
