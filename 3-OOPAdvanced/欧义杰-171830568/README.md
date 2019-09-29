# hw3：面向葫芦娃编程

![UML图](https://github.com/shi1ro/java-2019-homeworks/blob/master/3-OOPAdvanced/%E6%AC%A7%E4%B9%89%E6%9D%B0-171830568/image/UML.png)

## 面向对象思路

1.由于蛇精、葫芦娃等个体都具有位置，姓名等属性，将这些属性聚合起来作为一个虚基类Creature，葫芦娃，爷爷，蝎子精，蛇精，小喽啰都从该虚基类中继承，都使用相同的对外get,set虚方法，方便之后增加这些生物的共性、特性，同时可以用Creature的上溯造型将这些生物都包括进去。一些某一类所有对象公用的变量，如该类对象在map中的表示形式，该类一共new了几个对象等信息使用static变量修饰</br>
2.由于各阵营人数不固定，为了之后方便添加、删除各阵营中个体数量，使用Vector<Creature>(类CreatureVec)对对象进行管理。同时暂时有5种Creature，使用一个Vector<Creature>数组(CreatureControl中的creavecs数组)对五种Creature进行管理，数组初始大小设为5，同时数组下标0-4使用enum，化为HULUWA,XIEZI等enum对象，方便编程时使用</br>
3.每个Creature对象都有place变量，同时在最下层控制类设有char二维数组map,始终保持map中位置与对象中存储位置一致，才能在频繁的清理，随机，排序过程中保持统一、正确。在打印时按照map进行打印。</br>
  
## 一些过程中踩的小坑
1.new完任意数组后记得对数组成员也要进行初始化，否则会弹NullPointer</br>
2.在继承类中使用super来调用父类的构造器</br>
3.与书上版本不同，声明Vector,或是Enumeration时，都需要再之后加上<>来确定一个类，若类未知也可以使用<?></br>
4.java中简化了析构器，方法调用也多是传址调用，中间几乎没有临时对象产生。在构造器中令static变量num++即可达到“记录该类变量共创建了多少个”的目的</br>
5.当需要将一个char变量H和一个int变量1组合成H1输出，不能只char+int,需要在前面加上一个""+char+int,才能达到目标要求，否则会输出一个(char+int)的数
