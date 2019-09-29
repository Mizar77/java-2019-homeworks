# 3-OOPAdvance说明

![类图](class.png)

程序源码共分为7个类  
OOPAdvanced是主类  
Map类中主要维护整张地图的尺寸和地图中生物的位置  
Creature类的对象代表各种地图中的生物，维护了生物的名称坐标阵营等信息，Creature类中也维护了一个Map的副本  
Member类和Capatin对象都继承自Creature，分别代表一个战队的成员和队长，
成员类中聚集了队长的信息，队长类中维护了包含它所有成员的数组，
队长类中还聚集了Formation类的一个对象，用于指导阵型的组成  
Formation是阵型类  
Location是位置类，主要用于一些函数的输出  

在程序执行过程中，main函数创建了三张地图hulumap yaojmap totamap和三种阵型lfor vfor ofor
并创建葫芦兄弟生物和各种妖精生物,然后main向葫芦娃生物队长wa1和妖精生物队长xizi发送信息，命令他们分别按lfor和vfor在hulumap和yaojmap中站队，
再将他们移动到totamap中，同时向生物yeye和shejing发送信息让他们移动到合适的位置，将当下情景输出,
然后使妖精生物按ofor再进行一次站队，重新输出地图
