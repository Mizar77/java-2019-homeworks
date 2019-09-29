#CalabashSort
###共三个文件

Calabash.java

	//共实现3个类
	abstract class SortBase			//排序依据的抽象类
	class Order extends SortBase	//名称
	class Color extends SortBase	//颜色
	public class Calabash			//葫芦娃类
	/***
			注意到葫芦娃的颜色和名称是绝对绑定的，故写一个SortBase抽象类作为唯一的排序
		所用逻辑，内部有int型成员value作为排序依据，并且有以SortBase类作为形参的大小比
		较方法；而Order和Color两个子类只是重写了不同的toString方法用作不同的表现形式，
		而无需对大小比较方法重写（因为Order和Color在逻辑上所用是唯一的value用于排序依
		据）Calabash类为Order和Color的组合，包含了getter和setter
	***/

CalabashArray.java

	//实现一个类
	public class CalabashArray		//葫芦娃队列类
	/***
			CalabashArray封装了一个Calabash类的数组，并且有两种数组排序方法；可以接受
		一个随机数组的参数将数组初始化或者再次打乱顺序，同时实现了所有数组成员的Order和
		Color的getter
	***/

CalabaTest.java

	//实现一个类
	public class CalabashTest
	/***
			测试类包含了程序的main入口，并且写了一个用于生成指定长度不重复随机数组的
		static方法
	***/