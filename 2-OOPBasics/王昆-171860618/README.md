# 王昆-171860618 第二次作业说明

本次作业，我的代码中总共包含三个类：
* main入口方法的OOPBasics类
* 完成题目要求动作的HuluwaSolution类
* 定义葫芦娃对象的Huluwa类  

其中HuluWa类定义了葫芦娃的名字、颜色等属性，以及葫芦娃的报数、报告交换位置等动作：
```Java
class HuluWa{
    //葫芦娃的名字:
    private String name; 
    //葫芦娃的颜色:
    private String color;
    //葫芦娃的序号，用来排序: 
    private int number;
    //按照名字报数：
    public void printName();
    //按照颜色报数：
    public void printColor();
    //交换位置时报告交换动作"name:b->e":
    public void printMovement(int b,int e);
    //返回该葫芦娃的序号:
    public int key();
}
```
HuluWaSolution类中维护了葫芦娃排队的位置数组，并且实现了随机排队、冒泡排序、二分排序 等功能：
```Java
class HuluWaSolution{
    //位置数组：
    private HuluWa []_brothers;
    //二分排序划分队伍：
    private void _pivot(int begin,int end);
    //随意站队，打乱葫芦兄弟数组顺序：
    private void shuffle()；
    //冒泡排序   
    public void bubbleSort()；
    //二分法快速排序
    public void quickSort()；
}
```
最后在main函数中通过HuluWaSolution类的接口实现题目要求的操作：
```Java
    public static void main(String[] args){
        HuluWaSolution solution = new HuluWaSolution();
        solution.bubbleSort();
        solution.quickSort();
    }
```