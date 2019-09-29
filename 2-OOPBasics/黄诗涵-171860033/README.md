### homework2 面向葫芦娃编程
#### 171860033 黄诗涵


# 数据结构
&emsp;&ensp; 需要将葫芦娃抽象成类来进行描述，但是七个葫芦娃各自有不同的本领，能完成不同的动作，用同一个类来表示会造成麻烦。于是先写一个通用的父类，葫芦娃们都具有的属性（都有颜色，有排行）作为父类的成员，<u>通过继承的方式去扩展葫芦娃各自本领。</u>
## Huluwa类（父类）
&emsp;&ensp; 在main()方法以外定义一个Huluwa类，对main将七个葫芦娃抽象成具有不同参数的对象。
* 成员变量
>
    private static Random rand = new Random();  
    private String rank;  
    private String color;  
    private int num;  
    private int mypos;//记录自己的位置

rank：葫芦娃的排行；  
colo：代表色；  
num：1~7的编号方便排序；  
mypos：葫芦娃记录自己在藤上第几个位置；  
rand：模拟葫芦娃自己挑选位置  

* 成员函数

>
    public void swap(int j,Huluwa[] vine);  
    public void exchangeSeat(Huluwa[] vine);
    ...
&emsp;&emsp;排序算法相当于**爷爷发出指令指挥葫芦娃移动,但移动是葫芦娃自己完成**，所以**swap**操作是调用葫芦娃的成员函数。  

&emsp;&emsp;**exchangeSeat**：打乱是让每个葫芦娃依次选择一个位置与之上的葫芦娃交换，也可以不换。
**例子：**  

>random:  
老大:exchange position with 老二.  
老二:exchange position with 老大.  
老三:exchange position with 老六.  
老四:exchange position with 老七.  
老五:exchange position with 老二.  
老六:exchange position with 老大.  
老七:I don't change position.  
最后得到的顺序：老六 老五 老大 老七 老二 老三 老四

## 派生类Red, Orange, Yellow, Green, Indigo, Blue, Purple  
>
        class Red extends Huluwa{
        public Red(int i){
            rank="老大";
            color="红";
            num=1;
            mypos=i-1;
        }
    }

&emsp;&emsp;以Red类举例，这个类代表红色的大娃，除了构造函数，继承了基类所以成员。他除了能完成交换位置和随机选位置等基类中已有的操作之外，可以增加与别的葫芦娃不同的本领，比如喷火。


## SortHuluwa类
&emsp;&emsp; 这是main()所在的类，一个项目中有且仅有一个。SortHuluwa只为葫芦娃提供排序算法

![葫芦娃](C:\Users\Administrator\Pictures\Saved Pictures\huluwa.png)

* 创建长度为7的葫芦娃对象数组：爷爷发现葫芦藤，藤上挂着7个葫芦。  
```
    Huluwa hulus[]=new Huluwa[7];
```
* 创建七个不同派生类的对象：爷爷依次看过去有红橙黄绿青蓝紫色7个不同的葫芦娃。
```
    vine[0]=new Red(1);
    vine[1]=new Orange(2);
    vine[2]=new Yellow(3);
    vine[3]=new Green(4);
    vine[4]=new Indigo(5);
    vine[5]=new Blue(6);
    vine[6]=new Purple(7);
```


# 算法

### 随机打乱数组
依次调用老大~老七的exchangeSeat函数  

选位置通过java.util.Random实现，创建一个Random对象rand，再调用rand.nextInt(int)来生成随机数。

### 冒泡排序
```
 public static void bubbleSort(Huluwa[] hulus)
```
采用了较优化的冒泡排序算法。

每次循环记录最后一次有元素交换的位置int last,则last之后位置上的元素都是有序的，下次循环就不需要再访问。

若某次循环没有发生元素交换，则表示整个数组已经有序，直接return。



### 二分法排序
```
public static void dichotomySort(Huluwa[] hulus)
```
&emsp;&emsp; 二分法排序是二分查找与插入排序的结合。

&emsp;&emsp; 一般的插入排序是从第i个元素依次向前查找，二分查找对前i个元素进行折半，每次比较缩小一半的查找量，能在log(i)的时间复杂度内找到第i个元素应该插入的位置，然后将之后的元素整体后移。

其中一次循环：

>老三:leave the vine from 5.  
老六:4->5  
老五:3->4  
老四:2->3  
老三:ground->2

&emsp;&emsp; 先让老三离开藤站到地上，其他葫芦娃依次后移给老三让出位置后，老三再挂到藤上。