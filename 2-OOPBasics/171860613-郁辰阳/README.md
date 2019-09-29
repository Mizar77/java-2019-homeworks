1. HuLuWa类
	1. 3个成员变量num, place, color，用于表示葫芦娃的排行，队列位置和颜色
	2. 方法swap用于表示该葫芦娃与另一葫芦娃交换位置的动作
	3. 实现Comparable接口， 使得两个葫芦娃可以通过排行进行直接比较
2. Sort类
	1.两个接口函数用于对葫芦娃数组进行排序
	bubbleSort(...)根据排行进行冒泡排序
	binarySort(...)根据颜色进行二分排序
3. MyRandom类
	1. 接口函数randomGenerator()用于生成一个由七个葫芦娃组成的HuLuWa类数组，葫芦娃顺序随机
4. HuLuGrandpa类
	1.在该类中创建main函数，创建乱序葫芦娃数组并进行排序

OOP思想：
	1.在HuLuWa类中创建葫芦娃的相关属性以及动作，体现出HuLuWa在队列中的真实移动过程
	2.HuLuGrandpa类中创建葫芦娃乱序数组进行排序，表明老爷爷是葫芦娃的拥有者
