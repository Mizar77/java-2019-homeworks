# 第三次作业思路：（面向对象）

    正所谓万物皆对象！！！上完上一节Java课程之后，我在这方面的领悟又有了更进一层的认知，所以把之前稚嫩的代码做了“大刀阔斧”的改进（之前只是设计了一个类，实在太过于稚嫩）
记得老师曾经说过，所谓面向对象的编程就是要尽量地去模拟现实世界。基于这个观点，我觉得这个项目里面的内容无非可以分成环境和生物体这两个类型

于是我主要设计了*Creature*和*GMap*两个类，当然为了此次作业的“变阵”需求，我还设计了*Formation*类

----

***设计理念***：当然是更加真切地模拟现实世界啦~

所有的生物体都是继承自*Creature*，而又因为“老爷爷”和“蛇精”他们作为各自一方的领袖，肯定具有许多相似之处，
因此我设计了一个*Chief*类作为*Creature*的子类，而令*Snake*和*Grandpa*类再去继承自*Chief*。

*Creature*简介：*Creature*里有属性*x*，*y*,*num*,*image*,*name*,*running_speed*;

其中*x*代表了生物体所处的x坐标

*y*代表了生物体所处的y坐标

*num*就稍微特殊一点点，如果不是葫芦娃的话，*num*的取值都是-1，假如是葫芦娃的话，*num*的取值就是葫芦娃自己的兄弟排行
（好处：*这样处理便于我对葫芦娃进行排序，使得程序更加高效简介*）

*Creature*类的方法：*Creature*类的方法有构造方法,*get_x*,*get_y*,*get_speed*,*Move*,*_Show*

从名字可以很清晰明白地看出各个方法的作用，在此就不再一一赘述！

---

*Chief*简介:*Chief*在继承*Creature*的基础上多加了一个方法:*Cheers*，其功能也显而易见，就是在双方对峙时为各自一方加油，鼓劲！
*设计好处*:往后我肯定打算设计更多*Chief*类才有的方法，比如为场上己方成员补血，换位等等

*Grandpa*和*Snake*继承自*Chief*类，使得很多东西都变得方便起来了！

----

*huluBaby*简介：*huluBaby*在继承了*Creature*的基础上，目前就多了两个属性而已，分别是*color*和*rank*,分别代表葫芦娃的颜色和兄弟排行。

----

*Scorpion*和*badSoldier*简介:这两个类除了有自己独特的构造方法之外，和*Creature*没有任何差别，由此我们能够很好地发现设计成继承关系的好处，在我看来，继承关系可以这样理解：子类“是一种特殊的”父类，即“继承”表述的是“是一种特殊的”关系
通过继承使用，我们能够很有效地降低代码的冗余性

----

*Formation*简介：由于这次作业设计涉及各种各样的阵型，如果每次变阵都是再打一遍，就会十分复杂，因此我决定设计一个*Formation*类，使得变阵直接调用*Formation*的相关方法
便得以高效完成。

*Formation*里面有两个属性，分别是*name*和*index*，这两个属性分别表示该阵型的名称和序号（序号对应于*github*上面给出阵型的顺序）

同时*Formation*里面除了构造方法，还有三个方法，分别是*change_hulu_formation*,*change_mon_formation*
和*set_Chief*，分别用于帮助葫芦娃方变阵，帮助妖精方变阵和摆放老爷爷、蛇精的位置。

*Formation*还有八个子类，分别是1: 鹤翼 2: 雁行 3: 衡轭 4：非法 5：鱼鳞 6: 方门 7: 偃月 8：锋矢

----

这里要介绍的是*Grid*类，从名字可以看出来，这是一个“格子”类，当初设计这个类的初衷是为了配合*Gmap*类来使用，使得*Gmap*类里具有*Grid[][]*属性，
相当于是一个“棋盘”里面有很多“格子”，这个意思。

而*Grid*类又有属性*creature*,*x*,*y*,*isEmpty*;

其中有*creature*属性意味着*Grid*相当于一个“容器”，里面可以放置生物体；*x*表示该格子的具体位置的x坐标，同理*y*表示该格子的具体位置的y坐标，*isEmpty*
可以用于判断该格子里面是否有生物实体，这样我们对于环境的模拟就相当不错了！

而*Grid*里面除了构造方法之外，又有方法*Set*,*Empty_or_not*,*Swap*,*ret_num*,*Move_to*,*Show_me*,*return_crea*,他们的功能如下：

*Set*：在该格子生成一个生物体。

*Empty_or_not*：判断该格子是否为空。

*Swap*：交换两个格子的内容，当然都是交换生物体啦~

*ret_num*:返回生物体的"*num*"属性。

*Move_to*：在判断目标格子没有生物体后，采用该方法可以将生物体移动到目标格子。

*Show_me*：输出该格子的具体内容。

*return_crea*：返回该格子的生物体。

### 当然目前葫芦娃的排序是基于*Grid*的，正是因为*Grid*有*Swap*，*return_crea*这两个方法，使得“格子”可以比较自己上面的葫芦娃，然后和其他格子交互，进行葫芦娃的排序！！！

----

最后要介绍的，是我们的*Gmap*类，*Gmap*类可以说是相当关键的一个类，为什么这么说呢，因为它模拟了我们游戏的环境，所有的生物体都是生活在*Gmap*
当中的，为了更好地模拟环境，我设计了*x*,*y*,*grid*,*creatures*,*BabyList*,*soldiers*,*map*,*grandpa*,*snake*,*scorpion*,*form*这么些属性
这些属性从名字上和上下文可以很清晰地推断其意义，因此不再赘述！

下面来介绍以下*Gmap*类的方法，除了构造函数外，主要有*putCreature*,*movCreature*,*ShowTheMap*,*Hulu_Range*,分别用来放置生物体，移动生物体（和前者的区别在于使用前者时：
生物体之前是还没有位于棋盘上的）,打印输出地图，葫芦娃内部排序。


以上就是关于本次作业的设计思路！下面通过展示PlantUML来更加直观的展示！！！

## PlantUML展示部分




@startuml

Class Gmap{
	{static} int x;//地图的x维度方向上大小
	{static} int y;//地图的y维度方向上大小
	{static} Grid[][] grid;//地图上有n*n的格子，老师课堂上说到的莲花宝座
	Creature[] creatures
    	{static} huluBaby[] BabyList:  并不用于排序，只是方便索引葫芦娃的坐标信息
    	badSoldier[] soldiers
    	{static} Gmap map
   	Grandpa grandpa
   	Snake snake
    	Scorpion scorpion
    	{static} Formation form
	+ {static} void main()    
	+  void putCreature(Creature temp, int x, int y);//在地图的(x,y)处放置生物temp
	+  void movCreature(Creature temp,int x,int y);//将生物体temp移动到地图的(x,y)处
	+  int return_x()
	+  int return_y()
	+  {static} void ShowTheMap(int re_x,int re_y)
	+  {static} void Hulu_Range(huluBaby[] list)：传入葫芦娃数组只是方便索引葫芦娃下标，并不是通过数组来排序，算法中是格子去比较格子自己上面的葫芦娃，再进行格子间的交互，来排序
}

Class Formation{
    String name
    int index
    Formation()
    + void Change_mon_Formation(int index,Gmap map,Scorpion scor,badSoldier[] sol) :妖怪改变阵型
    + void Change_hulu_Formation(int index,Gmap map,huluBaby[] baby) :葫芦娃改变阵型
    + void Set_Chief(Gmap map,Grandpa pa,Snake snake)
}

class HEYI {
	HEYI()
}

class YANHANG {
	YANHANG()
}

class HENGE {
	HENGE()
}

class CHANGSHE {
	CHANGSHE()
}

class YULIN {
	YULIN()
}

class FANGMEN {
	FANGMEN()
}

class YANYUE{
	YANYUE()
}

class FENGSHI {
	FENGSHI()
}

class Grid{
    Creature creature
    int x
    int y
    boolean isEmpty
    Grid()
    Grid(int my_x,int my_y)
    Grid(Creature temp,int my_x,int my_y)
    + void Set(Creature a);//在该格子上创建一个生物
    + boolean Empty_or_not();//判断该格子上是否有生物体
    + void Swap(Grid dest);//交换两个格子上的生物体
    + int ret_num()
    + void Move_to(Grid dest);//将this.creature移动到格子dest去
    + void Show_me()
    + Creature return_crea();//返回当前格子上的生物
}

class Creature{
    int x;//生物体所处地图上的x坐标
    int y;//生物体所处地图上的y坐标
    int num
    BufferedImage image
	String name
	int running_speed;//设置的生物体移动速度
    Creature()
    Creature(int my_x,int my_y,String my_name,int my_speed)
    + int get_x()
    + int get_y()
    + int get_speed()
    + void Move(int i,int j);//生物体的移动功能，并且会改变其属性x,y
    + void _Show()
}

class Chief{
    + Chief()
    + void Cheers(Gmap map)//首领给自己一方加油助威
}

class huluBaby{
    String color;//葫芦娃的颜色
	String rank;//葫芦娃的排行
    huluBaby()
    huluBaby(int renum,String recol,String rerank,int my_x,int my_y,int speed,String my_name)
    +void _Show()
}

class Grandpa{
    Grandpa()
    Grandpa(int my_x,int my_y,BufferedImage my_image,String my_name,int my_speed)
}

class Snake{
    Snake()
    Snake(int my_x,int my_y,BufferedImage my_image,String my_name,int my_speed)
}

class Scorpion{
    Scorpion()
    Scorpion(int my_x,int my_y,BufferedImage my_image,String my_name,int my_speed)
}

class badSoldier{
    badSoldier()
    badSoldier(int my_x,int my_y,BufferedImage my_image,String my_name,int my_speed)
}


Formation <|-- HEYI
Formation <|-- YANHANG
Formation <|-- HENGE
Formation <|-- CHANGSHE
Formation <|-- YULIN
Formation <|-- FANGMEN
Formation <|-- YANYUE
Formation <|-- FENGSHI

Gmap "1"  *--  "many" Grid
Grid "1" o-- "1" Creature

Creature <|--  Chief
Chief <|-- Grandpa
Chief <|-- Snake
Creature <|-- huluBaby
Creature <|-- Scorpion
Creature <|-- badSoldier


@enduml

![](https://github.com/Goodday666/Pictures2/raw/master/myPlantuml.png)

![](https://github.com/Goodday666/Pictures2/raw/master/myPlantuml2.png)


