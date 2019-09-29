# 第二次作业：面向葫芦娃编程
## 设计思路
利用面向对象的程序设计思路，我们实际上就是在使用代码模拟世界。  
### 葫芦娃世界的模拟（World.java）
分析问题可知，首先需要创建一个葫芦娃的世界。在本次作业中，我使用一个二维数组来模拟这个葫芦娃的世界。对于后续的实验，在学习了接口、继承等特性后，可以对这个类进行重构后复用，使其可以支持葫芦娃中出现的各种妖精怪物（初步设想可以利用接口的方式实现）。在目前版本的World类中，其拥有一个二维数组作为成员变量，用于抽象葫芦娃世界：
```java
private CalabashBrother[][] worldMap;
```
除了基本的构造器之外，同时拥有几个方法，其分别用于获取指定位置的葫芦娃信息、将葫芦娃放置在某个位置、操作这个世界中的葫芦娃进行移动等：
```java
public CalabashBrother get(int x, int y) {
    return worldMap[x][y];
}

public void place(CalabashBrother brother, int x, int y) {
    /* Place this Calabash Brother on the world map */
    brother.setX(x);
    brother.setY(y);
    worldMap[x][y] = brother;
}

public void exchange(CalabashBrother brotherOne, CalabashBrother brotherTwo) {
    int oneX = brotherOne.getX(), oneY = brotherOne.getY();
    int twoX = brotherTwo.getX(), twoY = brotherTwo.getY();
    ...
}
```
### 葫芦娃的模拟（CalabashBrother.java）
在模拟完葫芦娃兄弟生活的世界后，我们接下来需要模拟葫芦娃。葫芦娃本身有所在位置的坐标、葫芦娃的姓名、葫芦娃的排行和葫芦娃的颜色这几个成员变量（后期还可以加入所拥有的能力等，不过本次实验不需要）：
```java
private int x;
private int y;
private int rank; /* Ranging from 0 to 6 */
private String color;
private String name;
```
我们在初始化时通过提供该葫芦娃的排名（rank）即可完成初始化，不过需要注意的是，我们并不会初始化葫芦娃的位置，这一信息需要由具体实施不同操作行为的类完成（例如本次实验的Sorter类），因此，我们需要为x和y这两个成员变量创建setter方法。  
#### 葫芦娃的移动
除了上述的两个setter方法和一些必要的getter方法外，在本次实验中葫芦娃有**移动**这一动作，我们同样使用一个方法来对其模拟：
```java
public void to(int newX, int newY) {
    /* Calabash brother goto (newX, newY) */
    System.out.println(name + ": " + "(" + x + "," + y + ")" + "->" + "(" + newX + "," + newY + ")");
    x = newX;
    y = newY;
}
```
### 排序行为的模拟（CalabashBrotherSorter.java）
由于葫芦娃本身不存在排序的说法，因此我们可以把排序这一行为看作是上帝（或者是动画片导演）来完成的。在本次实验中，我们将上帝（导演）抽象为Sorter。在完成排序任务时，我们将初始化的世界作为参数传入，排序器会将葫芦娃七兄弟放在对应的位置，接下来会分别利用冒泡排序和二分排序进行排序，具体由以下两个函数完成：
```java
public void bubbleSort() {
    shuffle();
    /* Sort according to their order */
    CalabashRankComparator comparator = new CalabashRankComparator();
    ...
}

public void binarySort() {
    shuffle();
    /* Use binary QuickSort */
    /* Sort according to their color */
    quickSort(0, NUM - 1);
    ...
}
```
其中的shuffle和quicksort两个方法分别是我们定义的辅助方法，具体实现在文件中可见。
#### 排序器（Comparator）
在本次实验中，我们需要两次利用不同的偏序关系对葫芦娃进行排序。我选择使用Comparator实现这一点，这一做法可以简化排序的过程（更重要的是可以使用库函数中自带的排序方法，虽然本次实验要求自己实现排序），具体排序器的定义在文件CalabashBrother.java中：
```java
class CalabashColorComparator implements Comparator<CalabashBrother> {
    @Override
    public int compare(CalabashBrother brotherOne, CalabashBrother brotherTwo) {
        return brotherOne.getRank() - brotherTwo.getRank();
    }
}

class CalabashRankComparator implements Comparator<CalabashBrother> {
    @Override
    public int compare(CalabashBrother brotherOne, CalabashBrother brotherTwo) {
        return brotherOne.getRank() - brotherTwo.getRank();
    }
}
```
