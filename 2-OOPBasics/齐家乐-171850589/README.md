## 作业2代码说明

##### 齐家乐 171850589

代码文件为**CalabashBroQueue.java**，共实现3个类，分别为**CalabashBroQueue**，**CalabashBro**，**CalabshBroMap**.

**CalabashBroQueue**中只有main方法，实例化了**7个葫芦娃对象**并实例化了一个**地图对象**

**CalabashBro**类只包含葫芦娃最基础的姓名，排行属性，获取他们的函数以及报自己颜色，排行的方法.

**CalabashBroMap**中实现了主要功能，包括冒泡排序，插入排序，随机站队，报颜色，报排行等.

排序算法中的比较目前是在**CalabashBroMap**中通过获取葫芦娃的颜色或排行后进行比较实现的.

有一个想法是对**CalabashBro**类实现Comparable接口来直接比较葫芦娃，由于时间关系未能完成.



*Ref:* 插入排序部分参考了百度百科词条