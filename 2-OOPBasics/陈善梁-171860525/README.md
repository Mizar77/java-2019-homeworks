### 第二次作业
1. 葫芦娃类  
   1. 三个成员变量:int id(序号1~7)，String name(名字),String color(颜色)
   2. 构造函数接受三个参数初始化三个成员变量
   3. 三个表示葫芦娃动作的函数:descName(报名字),descColor(报颜色),descMove(报移动)
   4. 实现Comparable接口，使得葫芦娃之间按id比较大小
2. GrandFather类
   1. 私有变量Huluwa数组，表示拥有的七个葫芦娃
   2. bubbleSort和binarySort:分别将Huluwa数组用冒泡、二分排序
   3. findPlace(ArrayList<Huluwa>list,int start,int end,Huluwa h)函数: list的[start,end]已经排序,寻找插入h的位置,辅助binarySort
   4. shuffle函数:将Huluwa数组打乱
   5. showAllName与showAllColor:打印葫芦娃数组的名字、颜色

面向对象思想体现在:
   1. 葫芦娃对象有表示自身信息的属性:名字、颜色等。有表示动作的方法:报名字、颜色、移动等，表示状态变化。
   2. 葫芦娃可以看作是属于老爷爷的，因此老爷爷类有葫芦娃数组作为私有变量，并且可以调用方法对葫芦娃进行打乱顺序、排序以及让他们报数。对葫芦娃的排序都通过GrandFather对象提供的方法进行操作。