# 第三次作业 OOPAdvanced
本次作业要求使用面向对象方法，实现葫芦娃和妖怪在`NXN`空间上排兵布阵的功能。
## 一、项目设计思路
本次作业中，我共设计了位置(Position),地图(Map)、阵型(Formation)、生物(Creature)、军队(Army)五个基本类。并从生物和军队两个基本类派生出了葫芦娃(Huluwa)、老爷爷(Grandpa)、蝎子精(Scorpion)、小喽啰(Follower)等具体生物类，以及对峙双方的葫芦娃兄弟(HuluwaArmy)和妖怪军团(DemonArmy)两支军队。  

  ![类图](http://www.plantuml.com/plantuml/png/NO_12i8m38RlUugS1tk1uM6YJ2-2u1F4BU2qRKRQEWGVtZfBDtlB_oK_-V_6EXJdjIewXTR2LlGhZaUl_8Ghi2VDPgLtGkYyK9Gd7EFKicXq0vkepso7MNxDK5PLia8DclILn49QBlQmlU6Je5YYmEOTBkOGASx2uk4Ff7W7GTEFERrqB6Duak6MbUA99Bys-A2CXS9Gniyrt7amHOe-BrBlLFUFDcHwhzK7) 

### 1.位置(Position)类
维护简单的位置信息，存放在二维空间的x坐标，和y坐标。供生物和阵型使用。
### 2.地图(Map)类
维护二维地图空间，由`Creature`的二维数组实现，对外提供增加、移除和判断位置是否有生物存在的接口
### 3.阵型(Formation)类
根据提供的军队人数`int num`、基坐标位置`Position base`和面朝方向`int direction`，提供计算不同阵型所需坐标位置的方法。每个阵型方法返回一个`List<Position>`的 位置列表。
### 4.生物(Creature)类
维护生物的名字、图标和在地图上的位置信息。提供加入地图、离开地图、移动等方法。
### 5.军队(Army)类
包含由`Creature`组成的指挥官、拉拉队长、士兵等成员。并包含军队所拥有的阵型知识`Formation`。通过调用成员士兵的加入地图方法，结合阵型提供的位置信息，实现所需的排兵布阵功能。
## 二、所用到的面向对象设计理念
#### 1.继承
>葫芦娃、老爷爷蝎子精等生物都继承自`Creature`类，以及两只不同的军队都继承自`Army`类。不同的派生类之间都具有不同的构造方法，并且HuluwaArmy和DemonArmy拥有不同的排兵布阵方法。
#### 2.多态
在`Army`类和`Map`类中，对于任何不同的生物，都将其当做基类`Creature`来处理，实现向上转型。Army类的士兵成员定义如下： 
>`protected List<Creature> soldiers;`  

而初始化时：
>`this.soldiers.add(new Huluwa("二娃","橙色"));`  
#### 3.组合
>在`Army`类中，使用组合的方式，包含了`Creature`和`Formation`类的成员对象。 

```
class Army{
  protected Creature commander;
  protected Creature cheerleader;
  protected List<Creature> soldiers;
  protected Formation formation;
  }
```