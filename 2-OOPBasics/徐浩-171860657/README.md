## 作业2:面向葫芦娃编程
***
##### 主要的类：
主要包含两个类，分别用于完成**对葫芦兄弟的描述**，以及**对葫芦兄弟完成的操作**。
`class CalabashBrother`用于描述单个葫芦兄弟，其中包含葫芦兄弟对应的颜色以及称呼。
`class Sorting`用于完成对葫芦兄弟们的排序操作。

+ 对于`class CalabashBrother`，成员变量如下：
    ```
    class CalabashBrother
    {
        private Color color;
        private String rank;
        private String colorName;
        Position pos;
        ...
    }
    ```
  + 其中`Color`为枚举类型，用于描述葫芦兄弟各自对应的颜色。
    `enum Color{RED,ORANGE,YELLOW,GREEN,CYAN,BLUE,PURPLE};`
  + `String rank`表示葫芦兄弟的兄辈关系，如“老大”，“老二”等。
  + `String colorName`表示葫芦兄弟各自对应颜色的字符串形式，便于输出使用。
  + `Position pos`表示葫芦兄弟当前在3*7的二维地图中的坐标。
  + **说明：**
    1.  葫芦兄弟的队伍设置在一个3*7的二维空间中，第一行以及第三行用于葫芦兄弟位置变换，第二行用于葫芦兄弟的站位，并默认**以左为前方，以右为后方**。
    2.  葫芦兄弟位置交换时将打印他们的二维坐标交换的过程。


+ 对于`class Sorting`,包含对葫芦兄弟们的排序操作：
  ```
  //用于随机初始化葫芦兄弟的站队顺序
  public static int[] randomArray();  

  //冒泡排序    
  public static void bubbleSort(CalabashBrother[] bros);

  //二分排序
  public static int partition(CalabashBrother[] bros,int begin,int end);
  public static void binarySort(CalabashBrother[] bros,int begin,int end);

  //main方法
  public static void main(String[] args);

  //打印葫芦兄弟交换位置的过程
  public static void moveTo(int x,int xPosition)
   ```
  + `int[] randomArray(int min, int max, int n)`    用于返回范围在[min,max]，含n个数的整型数组
  + `void bubbleSort(CalabashBrother[] bros)`   用于对数组bros进行冒泡排序
  + `void binarySort(CalabashBrother[] bros,int begin,int end)`</br>`int partition(CalabashBrother[] bros,int begin,int end);`  用于对数组bros进行二分排序
  + `void moveTo(int x,int xPosition)` 用于展示葫芦兄弟们交换位置时的具体过程。表示从位置`x`移动到`xPosition`的具体过程。
