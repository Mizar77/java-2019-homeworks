# 作业：面向葫芦娃编程

本次作业的任务如下：

1. 先让七个兄弟随意站队，然后让他们按冒泡法依照各自排行（从老大到老七）进行排序，排序结束从第一个到最后一个报数（如老大报“老大”，以此类推）；
2. 然后让七兄弟再次随意站队，然后用让他们按二分法依照各自颜色（赤橙黄绿青蓝紫）进行排序，排序结束从第一个到最后一个报颜色（如老大报“红色”，以此类推）；
3. 排序过程中，每个葫芦娃在每次交换位置的时候报告交换动作（例如老大从位置5换至位置6，报告“老大：5->6“）

涉及到的类有：**葫芦娃**（7个，每个具有次序，颜色，名字等信息以及会执行与任务有关的动作）、**葫芦娃队列**（对位置信息的封装，使得上帝不能直接操纵葫芦娃，必须经过队列来进行操作，是上帝与葫芦娃之间的媒介，用来初始化葫芦娃、让其随机排序、冒泡排序、二分法排序以及报数）、**上帝**（创建出一个葫芦娃队列，并且控制事件的执行流程）。接下来依次对这3种类进行说明：

------

## 葫芦娃（HuLuWa）

### 数据成员（Field）

1. rank：指定不同葫芦娃的次序，这个次序是排序的依据。大娃为0，二娃为1，以此类推。

2. names：葫芦娃名字集合，为**static**成员变量，每个对象均可访问。
   
   `private static String[] names={"老大","老二","老三","老四","老五","老六","老七"};`

3. colors：葫芦娃颜色集合，为**static**成员变量，每个对象均可访问。
   
   `private static String[] colors={"红色","橙色","黄色","绿色","青色","蓝色","紫色"};`

### 成员函数（Method）

1. count( countKind kind )：报数是葫芦娃的行为，因此将其作为HuLuWa类中的方法。两次报数需要根据不同的类型，因此需要传入参数加以区分，countKind为枚举类型，声明如下：
   
   `enum countKind {NAME, COLOR}`

2. getRank( )：获取葫芦娃次序，用作排序依据

3. runTo( HuLuWa[ ] huLuWaBrothers, int src, int dst )：此处的参数src以及dst代表的含义不是数组的下标，葫芦娃从第**[src+1]**个葫芦娃的位置移动到第**[end+1]**个葫芦娃的位置。同时在屏幕上输出移动信息。

4. runToTempPosition( )：假设**HuluwaQueue**所维持的队列中存在一个**空闲的中间位置**，葫芦娃移动到这个空闲的中间位置以便进行位置交换。

5. returnFromTemp( HuLuWa[ ] huLuWaBrothers, int dst )：葫芦娃从**空闲的中间位置**移动到**dst**位置，最终完成位置交换。 

---

## 葫芦娃队列（HuluwaQueue）

### 数据成员 (Field)

1. huLuWaBrothers：使用数组存放葫芦娃对象
2. numberOfHuLuWa：葫芦娃数量
3. tempPosition：空闲的中间位置，以便葫芦娃之间进行位置交换

### 成员函数 (Method)

1. HuluwaQueue( int number )：构造函数，用来初始化葫芦娃队列以及葫芦娃

2. swap( )：交换两个葫芦娃的位置，并且在屏幕上进行相应输出
   
   ```java
   private void swap(int p1,int p2){
           huLuWaBrothers[p2].runToTempPosition();
           huLuWaBrothers[p1].runTo(huLuWaBrothers,p1,p2);
           HuLuWa.returnFromTemp(huLuWaBrothers,p1);
       }
   ```

3. shuffle( )：葫芦娃随机排序，并且输出位置交换信息

4. bubbleSort( )：冒泡排序

5. binarySort( )：二分法排序

6. count( countKind kind )：两次报数需要根据不同的类型，因此需要传入参数加以区分

------

## 上帝（God）

### 数据成员（Field）

1. HULUWA_NUM：葫芦娃个数，static类型，值为7
2. huLuWaQueue：葫芦娃队列

### 成员函数（Method）

1. God( )：构造函数，初始化葫芦娃队列

2. run( )：执行排序，报数等命令
