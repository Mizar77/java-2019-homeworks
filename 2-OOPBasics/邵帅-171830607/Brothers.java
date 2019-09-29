import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

//import com.sun.tools.javac.util.List;

class Brothers {
    int number; // 自己应该的位置
    int pos; // 当前位置
    String color;
    String rank;

    public Brothers(int mynumber, String mycolor, String myrank) {
        number = mynumber;
        color = mycolor;
        rank = myrank;
    }

    public void printcolor() {
        System.out.println(color + " ");
    }

    public void printrank() {
        System.out.println(rank + " ");
    }

    public void change(int thatpos) {
        System.out.println(rank + ": " + pos + "->" + thatpos);
        pos = thatpos;
    }

    public static void main(String[] args) {
        // 创建对象
        Brothers brother1 = new Brothers(1, "红色", "老大");
        // Brothers brother1 = new Brothers(1, "red", "big");
        // brother1.printcolor();
        Brothers brother2 = new Brothers(2, "橙色", "老二");
        Brothers brother3 = new Brothers(3, "黄色", "老三");
        Brothers brother4 = new Brothers(4, "绿色", "老四");
        Brothers brother5 = new Brothers(5, "青色", "老五");
        Brothers brother6 = new Brothers(6, "蓝色", "老六");
        Brothers brother7 = new Brothers(7, "紫色", "老七");

        ArrayList<Brothers> bros = new ArrayList<>();
        bros.add(brother1);
        bros.add(brother2);
        bros.add(brother3);
        bros.add(brother4);
        bros.add(brother5);
        bros.add(brother6);
        bros.add(brother7);
        // 随意站队
        // 没有对随机战队
        Random r = new Random();
        ArrayList<Brothers> a = new ArrayList<>(); // 存储现实中的兄弟萌
        ArrayList<Integer> indexlist = new ArrayList<>();

        // 后来发现有随机生成函数

        for (int i = 0; i < bros.size(); i++) {
            // 获取在1-7内的随机数
            int j = r.nextInt(7) + 1;
            // 判断是否重复
            if (!indexlist.contains(j)) {
                // 获取元素并记录当前位置
                indexlist.add(j);
                a.add(bros.get(j - 1));
                a.get(i).pos = i + 1;
            } else {
                i--;
            }
        }
        // Collections.shuffle(bros);
        // System.out.println("排序前:"+bros);
        // 报数
        // 排序前
        System.out.println("冒泡法");

        System.out.println("排序前：");
        for (int i = 0; i < a.size(); i++) {
            a.get(i).printrank();
        }

        // 冒泡法按照排行排序
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.size() - i - 1; j++) {
                {
                    int i1, i2;
                    // 一开始找pos为0和pos为1的比较,想法是不用交换本来数组内的顺序。直接排(因为这样更加模拟现实的动作)（没有用数组附带的信息，所有信息都是自己创造的
                    for (i1 = 0; i1 < a.size(); i1++) {
                        if (a.get(i1).pos - 1 == j)
                            break;
                    }
                    for (i2 = 0; i2 < a.size(); i2++) {
                        if (a.get(i2).pos - 1 == j + 1)
                            break;
                    }
                    if (a.get(i1).number > a.get(i2).number) {
                        int temp1 = a.get(i1).pos; // 记录前者的位置
                        a.get(i1).change(a.get(i2).pos);
                        a.get(i2).change(temp1);
                    }
                }
                /*
                 * if(a.get(j).number > a.get(j+1).number) { int temp = a.get(j).pos; //记录前者的位置
                 * et(j).change(a.get(j+1).pos); //change数组 a.get(j+1).change(temp);
                 * 
                 * }
                 */
            }
        }
        // 按位置报数
        System.out.println("排序后：");
        for (int i = 1; i < a.size() + 1; i++) {
            for (int j = 0; j < a.size(); j++) {
                if (a.get(j).pos == i)
                    a.get(j).printrank();
            }
        }

        // a.clear();
        // 按位置报数
        // System.out.println("排序前:"+a ) ;
        // 二分法排序
        //但是如果用随机排序Brothers数组，不会改变pos的值,需要手动改变
        System.out.println("二分法");
        Collections.shuffle(bros);
        for(int i=0;i<bros.size();i++)
        {
            bros.get(i).pos = i+1;
        }
        System.out.println("排序前：");
        for (int i = 0; i < bros.size(); i++) {
            bros.get(i).printrank();
        }
        for (int i = 1; i < a.size(); i++) {
            // int temp = arr[i];
            int temp0 = bros.get(i).number;    //应该在的位置number
            // Brothers temp = a.get(i);
            int low = 0, high = i - 1;
            int mid = -1;
            while (low <= high) {
                mid = low + (high - low) / 2;
                if (bros.get(mid).number > temp0) {// if (arr[mid] > temp) { number
                    high = mid - 1;
                } else { // 元素相同时，也插入在后面的位置
                    low = mid + 1;
                }
            }

            // low与temp0所在位置交换即可,或者说low与i交换(pos为low的葫芦娃和pos为i的葫芦娃交换)
            //要一直交换过去
            //一般情况下low<i
            int j=i;
            while(low <j){
                int temp = bros.get(j).pos;
                bros.get(j).change(bros.get(j-1).pos);//get(i)
                bros.get(j-1).change(temp);
                Collections.swap(bros, j-1, j);
                j--;
            }

            // for(int j = i - 1; j >= low; j--) { arr[j + 1] = arr[j]; } arr[low] = temp;
        }
        System.out.println("排序后：");
        
        for(int i=0;i<bros.size();i++){
            bros.get(i).printcolor();
        }

    }

}