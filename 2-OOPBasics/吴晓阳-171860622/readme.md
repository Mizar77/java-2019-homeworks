### 171860622_吴晓阳_葫芦娃
1. 本次程序所涉及到的部分主要分为了三个模块：主模块、葫芦娃模块和排序模块。

2. 葫芦娃模块（Calabash）采取enum方式，具有名称（name）、辈分（seniority）、颜色（color）三个属性。
  a.  辈分和颜色采用enum方式，重置了toString方法
  b、 模块中同时添加了FROM_OLD_TO_YOUNG和FROM_RED_TO_PURPLE两个比较器（Comparator），目前的功能相同，但排序标准不同，使得其未来可以进行重载扩展。
  c.  葫芦娃继承自Figure模块
  
3. Figure模块是人物模块，还具有drawable，emittable（可以发射子弹），lifable（存在生命值）等接口。
   其中的drawable接口又和figure接口合并成了drawableFigure接口。这一接口是用于显示的，在控制台中会自动装载。

4. 排序模块采用了策略模式（Strategy Model）。
  a.  每个排序类型（排序器）都继承自SortStrategy接口，实现对List进行排序的sort方法。
  b.  目前实现了系统默认排序器、快排排序器、归并排序器、冒泡排序器和二分排序器（后两者被放在本次代码中）。

5. 控制模块（console）中放置了格子式界面GridFrame，同时有GridMap来将显示界面和存储相联系。控制界面允许进行人物的生成和插入。
  a.  添加了人物创造器（Creator),向控制界面加入人物时，只允许传入创造器，由控制台生成人物
  b.  控制台会自动给人物加上显示装饰类
  c.  加入人物后，控制台返回一个句柄figure handler，里面包括了人物的引用，人物在界面中的相对位置，人物的图像等信息，
      外界只能获取信息，不能更改句柄中信息（只能通过控制台的move，remove等操作来进行）。
	  
6.	排序时，当有一方要进入另一方的位置时，后者会先移动到周边的空地，待该次移动结束后，再移动回相应的空位中。

7.	最后输出时，调用葫芦娃
8. 输出结果：
Sanwa: 1 -> air
Erwa: 3 -> 1
Sanwa: air -> 3
Siwa: 2 -> air
Sanwa: 3 -> 2
Siwa: air -> 3
Qiwa: 5 -> air
Liuwa: 6 -> 5
Qiwa: air -> 6
老大老二老三老四老五老六老七
Sanwa: 1 -> air
Siwa: 0 -> 1
Sanwa: air -> 0
Dawa: 4 -> air
Qiwa: 3 -> 4
Liuwa: 2 -> 3
Siwa: 1 -> 2
Sanwa: 0 -> 1
Dawa: air -> 0
Erwa: 5 -> air
Qiwa: 4 -> 5
Liuwa: 3 -> 4
Siwa: 2 -> 3
Sanwa: 1 -> 2
Erwa: air -> 1
Wuwa: 6 -> air
Qiwa: 5 -> 6
Liuwa: 4 -> 5
Wuwa: air -> 4
红橙黄绿青蓝紫

9. 显示界面中，葫芦娃会分成两排来分别排序，葫芦娃在格子中的位置就是它们在存储中实际的位置。
