# README

根据题意，可将该葫芦娃程序分成几个步骤

1. 让葫芦兄弟打乱排列
2. 让葫芦兄弟按照排名冒泡排序，交换时报告，结束时报数
3. 让葫芦兄弟打乱排列
4. 让葫芦兄弟按照颜色（其实还是排名）二分排序，交换时报告，结束时报数

用面向对象的思想来看，则是这样的：

1. 葫芦兄弟：打乱排列
2. 葫芦兄弟：冒泡排序； 每个葫芦兄弟：交换时报告，结束时报数
3. 葫芦兄弟：打乱排列
4. 葫芦兄弟：二分排序； 每个葫芦兄弟：交换时报告，结束时报数

得出结论，总共有两个不同的对象，分别是**单个葫芦娃**和**葫芦兄弟们**，葫芦兄弟们由多个葫芦娃组合而成。

## 单个葫芦娃

具有葫芦娃的所有信息（名字、颜色和排名）

同时可以在交换时报告

在结束时可以报数（颜色或者名字）

类名称为`HuLuwa`

类内对象有

```java
//葫芦娃的排名
private int number;
//葫芦娃的颜色
private String color;
//葫芦娃的名字
private String name;
//比较两个葫芦娃的排名
public int compareTo(HuLuwa h);
//葫芦娃的复制
public void copyIndex(HuLuwa h);
//葫芦娃的两种报数
public void numberOffName();
public void colorOffName();
//葫芦娃的交换报告，ori和cur分别为交换前后的位置
public void numberOffSwap(int ori, int cur);
//还有葫芦娃的三种构造函数(默认，拷贝，直接赋值版本)
```



## 葫芦兄弟们

由多个 单个葫芦娃 的对象作为成员

葫芦兄弟可以打乱自己的战队方式

葫芦兄弟可以使用两种不同的方式（冒泡排序和二分排序）排序

类名称为`HuLubro`

类内成员有

```java
//多个葫芦兄弟组成的葫芦娃队列
private HuLuwa[] hulubro;
//让葫芦兄弟们随机排队
public void randomArray();
//让葫芦兄弟们按照名字冒泡排序并报数
public void bubbleSort();
//让葫芦兄弟们按照颜色二分排序并报数
public void binarySort();
//交换两个不同葫芦娃在葫芦兄弟队列中的位置并让两个葫芦娃分别报告
private void swapPos(int pre,int bak)
//还有 葫芦兄弟们 的两种构造函数（默认，直接赋值版本）
```



## 运行

将葫芦兄弟们的信息初始化，然后直接按照分析得出的四个步骤，调用对应类内方法即可。

```java
String[] namelist = new String[]{"大娃","二娃","三娃","四娃","五娃","六娃","七娃"};       String[] colorlist = new String[]{"红色","橙色","黄色","绿色","青色","蓝色","紫色"};
int[] numberlist = new int[]{1,2,3,4,5,6,7};       
HuLuBro hulubro = new HuLuBro(namelist,colorlist,numberlist);
hulubro.randomArray();
hulubro.bubbleSort();
System.out.println("-------------------------------------");
hulubro.randomArray();
hulubro.binarySort();
```



