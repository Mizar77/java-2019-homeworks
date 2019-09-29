# 第二次作业

题目要求排序过程中葫芦娃需要报数和报颜色，所以定义一个葫芦娃类，并且给该类定义报数和报颜色的方法：  
void reportNum();//报数  
void reportColor();//报颜色

为了区分葫芦娃，用一个整型变量value表示葫芦娃身份，取值1-7

对七个葫芦娃整体有随机排队和按序排队的操作，模拟这些过程用另一个类Process类；

该类有一个Hulu类型数组，大小为7，模拟7个葫芦娃；

Process类的所有方法用于模拟作业要求的整个过程：

void queueRandom()//让葫芦娃随机站队；  
void queueBubble()//冒泡法让葫芦娃站队；  
void BinaryInsertSort()//二分法让葫芦娃站队；
void reportNum()//排序后让葫芦娃们报数
void reportColor()//排序后让葫芦娃们报颜色

最后一个app类是main函数所在的类，通过main调用Process所提供的方法对葫芦兄弟进行一系列排序操作。
