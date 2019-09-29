#一、编写目的
&emsp;1. 追求高可扩展性，为葫芦娃系列代码迭代打下基础；<br>
&emsp;2. 探索面向对象的思想，设计低耦合的类与方法；<br>

#二、设计思路
###简介：
&emsp;葫芦娃与后期的敌对阵营皆为棋子，活动地图为棋盘，因此设计`Chessman类`与`Chessboard类`抽象棋子与棋盘；<br>
&emsp;在第二周作业中活动地图为一维线性结构，但是考虑到实验后期将会扩展二维地图，故另设`Position类`抽象坐标，便于后期扩展；
>Position类<br>
>* 构造器: `Position(int i);`<br>
>* 私有实例字段：`int index;`<br>
>* 公有字段访问方法：`int getX();`<br>
>* 公有字段更改方法：`changeX(int i);`<br>

>Chessman类<br>
>* 构造器：`Chessman(String n, String c, Position s, int i);`<br>
>* 私有实例字段：`String name;` `String color;`<br> 
           &emsp;`Position site`: 棋子在棋盘上的实时位置；<br> 
           &emsp;`int id`: 棋子的逻辑编号，在第二周作业中葫芦娃将从大娃到七娃被编为0~6号；<br>
>* 公有字段访问方法：`String getName();` `String getColor();` `Position getSite();` `String getId();` <br>
>* 公有字段更改方法：`int changeSite(Position nextSite);`<br>


>Chessboard类<br>
>* 常量字段：`int numOfBros;` `String name[];` `String color[];`<br>
>* 私有实例字段：<br>
>&emsp;`List<Chessman>being`: 存储棋盘上现有棋子信息，棋子在这里的index将作为棋子的线性编号；<br>
>&emsp;`List<Integer>map`: 记录棋盘上现有棋子分布的线性编号，需要区分逻辑编号与线性编号；<br>
>* 构造器：<br>
>&emsp;`默认构造器 Chessboard()`：为being与map创建对象，避免"Exception in thread "main" java.lang.NullPointerException"错误；<br>
>&emsp;`静态工厂构造方法 static Chessboard newRandom()`: 创建随机打乱棋盘上棋子顺序的构造方法，为了方便从命名区分功能不适用重载构造的方法；<br>
>* 公有字段访问方法：<br>
>&emsp;`void showNameQueue()/void showColorQueue()`:按照棋盘上棋子顺序报棋子名/颜色；<br>
>&emsp;`int getSiteBeingId(int tsite)/String getSiteBeingName(int tsite)`:由棋盘上棋子的线性编号获取棋子的逻辑编号；<br>
>* 公有字段更改方法：<br>
>&emsp;`void swapSiteBeing(int tsite0,int tsite1)`:交换棋盘上棋子的线性顺序，过程中不改变棋子的逻辑顺序，并更新棋子自身存储的位置信息；<br>
>&emsp;`void bubbleSorting();` `void binarySorting();` `void standRandom();`<br>

#三、注意事项
1. 命名规范；<br>
2. 非常量字段禁止公有；<br>
3. 对外提供的接口功能限定；<br>
4. main方法与所在类毫无关系，可以放在任何类中；<br>

#四、参考资料
[markdown](https://blog.csdn.net/ljc_563812704/article/details/53464039"悬停显示"")<br>
[equal vs '=='](https://www.cnblogs.com/zhxhdean/archive/2011/03/25/1995431.html"悬停显示"")
