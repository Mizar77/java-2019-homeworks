# 面向葫芦娃编程

## 葫芦娃对象

```
class Huluwa{
    int rank;
    String name;
    String color;
    Huluwa(int rank,String name,String color){
        this.name=name;
        this.rank=rank;
        this.color=color;
    }
    public void tellChange(int place,int changeplace){
        System.out.println(name+':'+(place+1)+"->"+(changeplace+1));
    }
}
```

​	根据题目可知，葫芦娃对象应有三个属性：

​		1.int类 排行（1-7)

​		2.String类 名字（老大老二老三...)

​		3.String类 颜色（红橙黄绿青蓝紫） 

​		有一个报告交换动作tellChange，格式为：“名字：原位置->现位置"

## 创建葫芦娃对象和排序的队列

```
    public static void giveBirth(){
        queue=new Huluwa[7];
        red=new Huluwa(1,"老大","红色");
        orange=new Huluwa(2,"老二","橙色");
        yellow=new Huluwa(3,"老三","黄色");
        green=new Huluwa(4,"老四","绿色");
        cyan=new Huluwa(5,"老五","青色");
        blue=new Huluwa(6,"老六","蓝色");
        purple=new Huluwa(7,"老七","紫色");
    }
```

​	创建七个葫芦娃对象和一个长度为7的排序队列，之后随意站队用。

## 葫芦娃随意站队

```
public static void randomQueue(){
        boolean flag;
        for (int i=0;i<queue.length;i++){
            flag=false;
            while(flag==false) {
                int rand = (int) Math.round(Math.random() * 6 + 1);
                for (int j = 0; j < i; j++) {
                    if (queue[j].rank == rand) {
                        flag = true;
                        break;
                    }
                }
                if (flag==true)flag=false;
                else{
                    switch(rand) {
                        case 1:
                            queue[i]=red;break;
                        case 2:
                            queue[i]=orange;break;
                        case 3:
                            queue[i]=yellow;break;
                        case 4:
                            queue[i]=green;break;
                        case 5:
                            queue[i]=cyan;break;
                        case 6:
                            queue[i]=blue;break;
                        case 7:
                            queue[i]=purple;break;
                    }
                    flag=true;
                }
            }
        }
    }
```

​	用Math.round()和Math.random()构成1-7随机数列，保证每个数不重复，并根据生成的随机数rand对应rank在队列里放入对应的葫芦娃。

## 冒泡排序

```
public static void bubbleSort(){
        System.out.println();
        for (int i=0;i<queue.length-1;i++) {
            for (int j = 0; j < queue.length - i - 1; j++) {
                if (queue[j].rank > queue[j + 1].rank) {
                    queue[j].tellChange(j,j+1);
                    queue[j + 1].tellChange(j+1,j);
                    Huluwa temp = queue[j];
                    queue[j] = queue[j + 1];
                    queue[j + 1] = temp;
                }
            }
        }
        for (int i=0;i<queue.length;i++)
            System.out.print(queue[i].name+' ');
        System.out.println();
    }
```

​	按照冒泡排序，比较的值根据rank排行进行排序，每次交换的时候对应的两个葫芦娃都要tellChange报告交换动作。排序完毕后从第一个到最后一个报数（汇报自己的名字）

## 二分法排序

```
 public static int binarySearch(int start,int end,int val){
        int mid=-1;
        while(start<=end){
            mid=(start+end)/2;
            if (queue[mid].rank<val)
                start=mid+1;
            else if(queue[mid].rank>val)
                end=mid-1;
            else break;
        }
        if (queue[mid].rank<val)return mid+1;
        else if (queue[mid].rank>val) return mid;
        return mid+1;
    }
    public static void binarySort(int start, int end){
        System.out.println();
        for (int i=start+1;i<=end;i++) {
            int val = queue[i].rank;
            Huluwa temp=queue[i];
            int location=binarySearch(start,i-1,val);
            for (int j=i;j>location;j--){
                queue[j-1].tellChange(j-1,j);
                queue[j]=queue[j-1];
            }
            temp.tellChange(i,location);
            queue[location]=temp;
        }
        for (int i=0;i<queue.length;i++)
            System.out.print(queue[i].color+' ');
        System.out.println();
    }
```

​	题目中要求按照各自颜色（赤橙黄绿青蓝紫）排序，其实颜色和rank对应顺序，为了方便比较就直接用了rank的数值。用二分法排序，每次通过二分查找找到对应的位置，再用插入排序。每次插入的时候对应的葫芦娃需要tellChange报告交换位置。排序结束后，按照顺序报告自己的颜色。

## 调用完成葫芦娃站队排序

```
    public static void main(String args[]){
        giveBirth();
        randomQueue();
        bubbleSort();
        randomQueue();
        binarySort(0,queue.length-1);
    }
```

