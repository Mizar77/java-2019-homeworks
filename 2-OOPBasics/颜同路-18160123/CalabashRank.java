import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;

public class CalabashRank {
    public static void main(String[] args) {
        Map thismap = new Map();//只是另外一张葫芦娃的地图
        thismap.map[0][0] = -1;//地图的原点是老爷爷和葫芦兄弟们的家，这是一个清贫但是舒适的小屋，所以不要问我为什么葫芦娃在这里可以重叠（○｀ 3′○）

        System.out.println("传说有一座葫芦山，山里关着蝎子精和蛇精……\n有一个勤劳的老爷爷，种出了七个神奇的葫芦……");

        Calabash.calabashbrothers = new ArrayList<Calabash>();//创建葫芦兄弟的ArrayList
        Calabash.calabashbrothers.add(new Calabash("红娃", "老大", "红色", 1));
        Calabash.calabashbrothers.add(new Calabash("橙娃", "老二", "橙色", 2));
        Calabash.calabashbrothers.add(new Calabash("黄娃", "老三", "黄色", 3));
        Calabash.calabashbrothers.add(new Calabash("绿娃", "老四", "绿色", 4));
        Calabash.calabashbrothers.add(new Calabash("青娃", "老五", "青色", 5));
        Calabash.calabashbrothers.add(new Calabash("蓝娃", "老六", "蓝色", 6));
        Calabash.calabashbrothers.add(new Calabash("紫娃", "老七", "紫色", 7));//创建7个葫芦娃对象

        System.out.println("有一天，爷爷突然让葫芦娃随机站成一排……");

        System.out.println("爷爷：爷爷前几天看到NJU的同学们热火朝天地军训，突然心血来潮想让葫芦娃们也来列列队呢(๑•̀ㅂ•́)و✧");
        System.out.println("爷爷：孩子们，出来吧！");

        Collections.shuffle(Calabash.calabashbrothers);//利用Collection根体系的shuffle方法打乱顺序

        Random r = new Random();
        int line = r.nextInt(100);//老汉灵机一动，随机报了一个0到99的随机数作为葫芦娃排队的行

        for (int i = 0; i < 7; i++) {
            thismap.map[line][i] = Calabash.calabashbrothers.get(i).id;
        }
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if(Calabash.calabashbrothers.get(j).id == i)
                    Calabash.calabashbrothers.get(j).run(j, line);
            }
        }

        System.out.println("爷爷：孩子们，虽然不知道为什么要那样做，但是请你们用冒泡排序排成从老大到老七的队形呢，么么哒！");
        Calabash.bubbleSort(Calabash.calabashbrothers);
        for (int i = 0; i < 7; i++) {
            thismap.map[line][i] = Calabash.calabashbrothers.get(i).id;
            Calabash.calabashbrothers.get(i).run(i, line);//跑到指定的位置
        }
        System.out.println("爷爷：爷爷眼睛看不清了，请你们按照队形从前到后挨个报一下自个的排行！");
        for (Calabash c: Calabash.calabashbrothers
             ) {
            System.out.println(c.name + "：" + c.rank + "！");
        }

        System.out.println("爷爷：虽然让你们跑来跑去很麻烦，但是不知道为什么，这次就想再让你们把队形打乱呢(ˉ▽￣～)");

        Collections.shuffle(Calabash.calabashbrothers);//再次打乱顺序
        for (int i = 0; i < 7; i++) {
            thismap.map[line][i] = Calabash.calabashbrothers.get(i).id;
        }
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if(Calabash.calabashbrothers.get(j).id == i)
                    Calabash.calabashbrothers.get(j).run(j, line);
            }
        }
        System.out.println("爷爷：孩子们，再用二分法排序试试按照颜色排成彩虹的队形呢，么么哒！");
        Calabash.bubbleSort(Calabash.calabashbrothers);
        for (int i = 0; i < 7; i++) {
            thismap.map[line][i] = Calabash.calabashbrothers.get(i).id;
            Calabash.calabashbrothers.get(i).run(i, line);//跑到指定的位置
        }
        System.out.println("爷爷：爷爷眼睛看不清了，请你们按照队形从前到后挨个报一下自个的颜色！");
        for (Calabash c: Calabash.calabashbrothers
        ) {
            System.out.println(c.name + "：" + c.color + "！");
        }
        System.out.println("爷爷：你们太棒了！今天的训练就到这里！");
    }
}

class Calabash {    //葫芦娃类
    public String name;
    public String rank;//长幼
    public String color;
    public int id;
    public int x;
    public int y;//x和y表示这个葫芦娃在地图上的位置
    Calabash(String name, String rank, String color, int id){             //构造器
        this.name = name;
        this.rank = rank;
        this.color = color;
        this.id = id;
        this.x = 0;
        this.y = 0;
        System.out.println(rank + "：爷爷，我是" + name + "！");
    }

    static public ArrayList<Calabash> calabashbrothers;//葫芦娃类型的容器ArrayList，用于在后台维护葫芦娃排队顺序的队列

    public void skill(){}//虚方法：“独特的本领”

    public void run(int x, int y){  //跑步前进到地图的目标地点，并进行报告
        System.out.println(rank + ": 爷爷，我从(" + this.x + ", " + this.y + ")跑到了(" + x + ", " + y + ")！");
        this.x = x;
        this.y = y;
    }

    public static void bubbleSort(ArrayList<Calabash> calabashList){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6 - i; j++) {
                if(calabashList.get(j).id > calabashList.get(j + 1).id) {
                    Collections.swap(calabashList, j, j + 1);//交换两个元素
                }
            }
        }
    }//冒泡排序

    public static void binaryInsertSort(ArrayList<Calabash> calabashList){
        for (int i = 1; i < 7; i++) {   //默认第一个为已经排好的序列，对1到6个元素进行二分法插入
            int low = 0, high = i - 1;
            int mid = -1;
            while (low <= high) {
                mid = (high + low) / 2;
                if (calabashList.get(mid).id > calabashList.get(i).id) {
                    high = mid - 1;
                } else { // 元素相同时，也插入在后面的位置
                    low = mid + 1;
                }
            }
            System.out.println(calabashList.get(i).rank + "：" + i + "→" + low);
            calabashList.add(low, calabashList.get(i));
            calabashList.remove(i + 1);
        }
    }//二分法排序
}

class Map{  //地图类
    int map[][];//坐标
    Map(){
        map = new int[100][100];//初始化为一个100 * 100的地图
    }
}