# Homework_2：面向葫芦娃编程
`calabashBros`数组存储七位葫芦娃，包含以下属性：
+ `static final int size`:表示葫芦娃的个数
+ `List<Calabash> calabashBros`：保存葫芦兄弟
+ `static final String[] color`:葫芦兄弟的颜色
+ `static final String[] name`：葫芦兄弟的辈分

并包含以下方法:  
+  `boolean cmp(String a, String b)`:比较两个葫芦娃的大小关系。
+  `void bubbleSort()`:对葫芦娃按辈分进行冒泡排序。
+  `void binarySort()`:对葫芦娃按颜色进行二分插入排序。
+  `void print(int tag)`:打印葫芦娃的信息，其中`tag`==`CMP_COLOR`时，打印颜色，`tag`==`CMP_NAME`时打印辈分。
+  `void confuseThem()`:打乱队伍
---
`Calabash`类则表示葫芦娃，包含了以下属性：  
+ `int seq`：表示辈分(`name`数组的下标)
+ `String  color`：表示颜色。
+ `int index`：表示他在队伍中的位置
+ 
并通过两个方法告诉我他们的信息：
+ `void sayMyName()`:告诉我他们的名字
+ `void sayMyColor()`:告诉我他们的颜色
+ `String tellYouMyName()`:返回他们的名字(字符串)
+ `String tellYouMyColor()`:返回他们的颜色(字符串)
+ `void whereAmI(int i)`:通知他们在队伍中的位置
+ `void tellYouWhereAmI()`:告诉我他们在队伍中的位置
---
首先创建葫芦兄弟对象  
```  java
CalabashBro calabashBro = new CalabashBro();
```
利用构造函数创造出7个葫芦娃。  
再利用
``` java
calabashBro.confuseThem();
```
打乱排队顺序。调用
``` java 
calabashBro.bubbleSort();
```
命令他们以冒泡排序的方式排好队，并报出位置的变化信息，最后报数。   

在比较过程中。
``` java
if (cmp(CMP_NAME,calabashBros.get(j+1),calabashBros.get(j))) {
    calabashBros.get(j+1).sayMyName();
    calabashBros.get(j+1).tellYouWhereAmI();
    //交换
    Collections.swap(calabashBros,j,j+1);

    calabashBros.get(j+1).whereAmI(j);
    calabashBros.get(j+1).tellYouWhereAmI();
}

```
先让葫芦娃报出自己的名字和所在位置，交换位置，然后再跟他说他在哪里，再让他告诉我他的位置。

二分插入排序同理。