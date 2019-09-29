# 作业2 面向对象思想介绍

​	针对葫芦娃配对这个问题，我想出的办法是创建两个类，分别是 GourdEva（葫芦娃）和PlayGround（用来排队的场地），如下图。



 ![srceenshot-1.png](https://i.loli.net/2019/09/14/vf3Ku2w7VFkPSaY.png)





## 【GourdEva 葫芦娃】

每个葫芦娃具有的**属性变量**为：

- 颜色：红橙黄绿青蓝紫
- 姓名：老大......老七
- 辈分排名：0123456
- 位置：将来站在操场上时的位置，可以理解为每位葫芦娃的“自我认知”（我站在这个地方）

 ![srceenshot-2.png](https://i.loli.net/2019/09/14/XdbRUqwnNjuQFTt.png)

而葫芦娃的**操作**有：

- saycolor：说出（print）自己的颜色
- saymyname：说出（print）自己的姓名
- getrank：返回（return）辈分排名
- setPositionWithOutTalk：设置在操场上的新位置，仅设置不说出来
- setPositionAndTalk：设置在操场上的新位置，也说（print）出改变，如："老大：5->1"





## 【PlayGround 操场】

操场具有的**属性变量**包括：

- 葫芦群：场上一共有七位葫芦娃，会在 main 函数中进行初始化
- 队列：用来随机放置葫芦娃，以及进行排序的场所

 ![srceenshot-3.png](https://i.loli.net/2019/09/14/zk6xpVmufKLESc5.png)

而操场的主要**操作**包括：

- getRandomNumList：用来随机生成一串表示随机位置的数列
- randomSetInLine：利用 getRandomNumList 返回的数列设置每位葫芦娃的新位置
- bubbleSort：对队伍中的葫芦娃进行“冒泡排序”
- binarySort：对队伍中的葫芦娃进行“归并排序”





## 【main 主体函数/主要过程】

 ![srceenshot-4.png](https://i.loli.net/2019/09/14/VeYgdC9wxNiAXBJ.png)

即程序开始运行后，将进行：

1. 初始化七位葫芦娃
2. 随机分配站位
3. 冒泡排队
4. 随机分配站位
5. 归并排队





## 【Result 运行结果】

运行结果的截图如下：

 ![srceenshot-5.png](https://i.loli.net/2019/09/14/gNqYfeBbDSP69MW.png)

 ![srceenshot-6.png](https://i.loli.net/2019/09/14/4lVSjyGUWRMuazZ.png)

