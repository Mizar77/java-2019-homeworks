# 第二次作业实现方式
1. 对葫芦娃的模拟
将每个葫芦娃视作一个对象，设计为类`Hulu`，在该类中，有如下属性
```java
    public int rank;
    private String name;
    private String color;
    private int location = 0;
```
因为无论是颜色还是排行的顺序都是一致的，为了之后排序方便比较，设立public属性rank，其余属性设置为private。
2. 葫芦娃队列
采用数组的方式构成含有七个葫芦娃的队列，并确保每次数组中葫芦娃位置变更后其私有属性location和当前所在序号一致，即调用如下函数：
```java
public void changeLocation(int dst, boolean ifReport) {
    int src = location;
    location = dst;
    if (ifReport == true)
        System.out.println(name + ": " + src + "->" + dst);
    }
```
3. 排序
在排序中，出现通过比较数组中两元素的rank来确定下一步行动，进而进行位置的交换，交换时不只是单纯的改变数组中元素排列，同时被视为对象的葫芦娃也会更新位置并进行报告
```java
void swap(int locA, int locB, boolean ifReport) {
    Hulu temp = theArray[locA];
    theArray[locA] = theArray[locB];
    theArray[locB] = temp;
    theArray[locA].changeLocation(locA, ifReport);
    theArray[locB].changeLocation(locB, ifReport);
    }
```
排序完毕后每个葫芦娃一次进行报告的操作
```java
for (Hulu h : theArray)
    h.reportColor();
```