# 第二次作业
### 作者：李睿钦
### 院系学号：电子科学与工程学院 161180068

## 【题目要求】

1. 先让七个兄弟随意站队，然后让他们按冒泡法依照各自排行（从老大到老七）进行排序，排序结束从第一个到最后一个报数（如老大报“老大”，以此类推）；
2. 然后让七兄弟再次随意站队，然后用让他们按二分法依照各自颜色（赤橙黄绿青蓝紫）进行排序，排序结束从第一个到最后一个报颜色（如老大报“红色”，以此类推）；
3. 排序过程中，每个葫芦娃在每次交换位置的时候报告交换动作（例如老大从位置5换至位置6，报告“老大：5->6“）

## 【本程序所使用的类】

HuLuBrothers类	--这个是模拟的葫芦兄弟
homework2类	--main()方法在这里

## 【HuLuBrothers类的详细信息】

### 实例变量

	name		--(private)葫芦娃的姓名。是字符串。
	color		--(private)葫芦娃的颜色。是字符串。
	location	--(private)葫芦娃当前的位置。为简单起见是一维的。是整型变量。
	order		--(public)葫芦娃的地位。由order通过nameList和colorList可以得到葫芦娃的name和color，故而是有序的代号。是整型变量(1-7)。
	nameList	--(private)葫芦娃名字的范围。是包含七个名字的字符串数组。顺序与order同步。
	colorList	--(private)葫芦娃颜色的范围。是包含七种颜色的字符串数组。顺序与order同步。

### 方法

1. HuLuBrothers

	--是构造函数。具有两种签名：

	--(int order, int location)如果初始化对象实例时传入了order（地位）和location（位置）参数，则相应的初始化实例变量，并进一步由order通过nameList和colorList可以得到葫芦娃的name和color。

	--()如果初始化时未传入任何参数，则将order和location设为-1，并将该对象实例变量name和color设置为"Initialize"。

2. broadcast(int loc_before, int loc_after)

	--功能是在对象的位置发生更改的时候，向外界输出一条信息，报告发生更改的葫芦娃的地位、原先的位置和更改后的位置。

3. 为private成员变量提供的接口

	--除了order之外，我禁止外界直接获取和修改上述实例变量；取而代之的方案是，我为一些必要的实例变量提供了读或者写的接口。

	--其中，location是可读可写的；name，color是只能读出的；nameList和colorList是不向外界开放的，也就是不能读，不能写。
	
	--我觉得这一块比较简单，所以就不再逐一地详细描述了。

### 补充

关于题目要求的排序算法，我觉得像是过程而不是事物本身，所以不在类中作相应的设计。	

## 【homework2类的简要信息】

因为这个类中的方法主要就是为了实现排序的具体流程，感觉是更倾向于过程的，所以在这里，我简要的列出了我所编写的几个方法所具有的功能，并且给出了相应的形式参数，具体的代码实现，我就不再赘述了。:-D

简要的信息包括：

public	main(String args[])		--实现题目要求的所有事情其实都发生在这里。

private	sort(HuLuBrothers[])		--使用冒泡排序对葫芦娃的location进行修改。

private	binary(HuLuBrothers[])		--使用结合二分查找的插入排序对葫芦娃的location进行修改。

private shuffle(HuLuBrothers[])		--让葫芦娃随机站队。

private	print(HuLuBrothers[], boolean)	--输出当前葫芦娃们站队的顺序。boolean所在的位置如果为true则输出名字，如果为false则输出颜色。

## 【程序的输出】

Begin the HuLu-Brother sort game :-)

shuffle. Printed by rank: 二娃 七娃 大娃 四娃 六娃 三娃 五娃 

Bubble sort: 
大娃：0->1
三娃：2->3
五娃：4->5
六娃：5->6
四娃：3->4
五娃：4->5
四娃：3->4
三娃：2->3
二娃：1->2

After sort. Printed by rank: 大娃 二娃 三娃 四娃 五娃 六娃 七娃 

Shuffle again. Printed by color: 橙色 青色 蓝色 红色 黄色 绿色 紫色 

Binary sort: 
大娃：0->1
二娃：1->0
四娃：3->4
三娃：2->3
二娃：1->2
五娃：4->1
五娃：4->5
四娃：3->4
三娃：2->3
六娃：5->2

After sort. Printed by rank: 大娃 二娃 三娃 四娃 五娃 六娃 七娃 

Finish! Congratulated! :-D