###姓名：吴鸿祜    学号：171860677

### 面向对象编程思路：

1.对于每一个葫芦娃，它有排行和颜色两个属性，因此创建一个类DollBrother对葫芦娃进行描述，每个葫芦娃看作是一个DollBrother对应的对象

2.类DollBrother包含两个private的整型数成员变量：rank和color; 表示葫芦娃的排行和颜色两个私有属性，并在对象初始化之后不可修改。
   同时，DollBrother类含有两个操作函数getRank()和getColor()，对葫芦娃这一对象仅能进行读取排行大小和颜色，无法进行修改

3.公共类GourdDoll模拟七个葫芦娃的“大家庭”，用来描述七个葫芦娃的集合及对其的排序操作

4.类GourdDoll中有成员DollBrother brothers[], 初始化该对象时表示拥有若干个DollBrother（葫芦娃对象）

5.类GourdDoll中有两个私有成员函数：sayRank(DollBrother brother)和sayColor(DollBrother brother)，表示获取某个葫芦娃的排行或者颜色，模拟排序
 过程中葫芦娃的报告输出

6..类GourdDoll中有两个公共成员函数：bubblesort()和dichotomysort()，前者用冒泡排序根据葫芦娃的排行大小进行排序，后者用二分法按照颜色进行排序，
 排序前由用户输入数字表示七兄弟的站队