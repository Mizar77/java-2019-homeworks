import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * # 作业：面向葫芦娃编程
 * 
 * 葫芦娃有七兄弟（没看过的请参考[豆瓣](https://movie.douban.com/subject/1428576/)）。红娃排行老大、橙娃排行老二、黄娃排行老三、绿娃排行老四、青娃排行老五、蓝娃排行老六、紫娃排行老七，七兄弟各有一身独特的本领。
 * 
 * ![葫芦兄弟](http://english.cri.cn/mmsource/images/2009/06/24/4634carton1.jpg)
 * 
 * 请用**面向对象编程方法**，以Java语言编写程序，实现以下过程：
 * 
 * 1. 先让七个兄弟随意站队，然后让他们按冒泡法依照各自排行（从老大到老七）进行排序，排序结束从第一个到最后一个报数（如老大报“老大”，以此类推）； 2.
 * 然后让七兄弟再次随意站队，然后用让他们按二分法依照各自颜色（赤橙黄绿青蓝紫）进行排序，排序结束从第一个到最后一个报颜色（如老大报“红色”，以此类推）；
 * 3. 排序过程中，每个葫芦娃在每次交换位置的时候报告交换动作（例如老大从位置5换至位置6，报告“老大：5->6“） 4.
 * 请在个人作业提交目录下编写README.md文件，说明你是如何用面向对象编程思想来解决以上问题的。
 * 
 * 完成后按照作业提交要求和流程，完成作业提交。DDL:2019年9月15日23:00。
 * 
 * 第一眼上手阅读启发：
 * 第一环节： 随意站队： 就是 --> shuffle函数（） 冒泡排序就是 sort（） 从头到尾排序就是forEach（） + 一系列选择器 + 
 * lambda 
 * 第二环节： 再随意站队：就是再次调用 shuffle 函数（） 按照二分法 ：就是调用 Sort（） + binary方法 ， 从头到尾
 *  优势 forEach + lambda
 * 第三环节： 在交换位置的时候报告交换的动作 ： --> 这个行为可以嵌入到 sort（） 函数里面。
 * ⚠️但是很无奈没有冒泡排序的API，所以就只好自己写一个 static 的函数了。 所以就不能调用sorted了
 * 
 * @作者 ： 我喜欢你家孩子呀~ 
 * 联系方式： 1019070879@qq.com 
 * 创建日期: 2019年9月10日 
 * 时间: 上午12:35:26
 */

/**
 * 面向对象分析：葫芦娃因该是各种不同对象，因为每个葫芦都有自己不同的属性，所以不能把每个葫芦娃都设置成一个类，
 * 应该提取葫芦娃的共性，即是应该葫芦才是一个类，或者说是葫芦精是一个类，1-7娃是葫芦类的实例。
 *  
 *  为了后续的扩展，我们理应有一个棋盘类，不然怎么会有大作业的葫芦娃大战妖精！！ 
 *  简单来看，葫芦娃 和 妖精 都是棋盘上的棋子， 但是我们不能光有棋子，所以需要棋盘。
 *  按照Effective Java书籍上老爷子说的 列表要优于数组 ，所以如果要创建棋盘的话，我们使用ArrayList<ArrayList<int>> 就可以了，
 *  但是这次 实验，只是简单的冒泡和二分。本质上是在线性层面上实现的，多以还没必要用上二维 ArrayList 
 *  但是我们下次用到二维的时候直接上ArrayList<ArrayList<int>> 做棋盘就行了
 *  
 * @作者 ：  我喜欢你家孩子呀~
 * 联系方式： 1019070879@qq.com
 * 创建日期: 2019年9月15日   时间: 下午4:38:54
 */

/**
 * 用枚举类来实现颜色，更好地进行比较！！而且后续要添加颜色啥的也方便很多哇！！
 */
enum Color
{
	RED("红色", 1), ORANGE("橙色", 2), YELLOW("黄色", 3), GREEN("绿色", 4), CYAN("青色", 5), BLUE("蓝色", 6), PURPLE("紫色", 7);
	private final String color;
	private final int index; // 给颜色赋”下标"有利于比较！

	private Color(String color, int index)
	{
		this.color = color;
		this.index = index;
	}

	public String getColor()
	{
		return color;
	}

	public int getIndex()
	{
		return index;
	}
}

/**
 * 本来考虑把独立出棋盘的，但是这次实验室是线性操作，所以打算下次需要扩展棋盘至平面的时候再考虑吧
 */
//class QiPan
//{
//	
//	private ArrayList<ArrayList<int> > map;
//	private int row;
//	private int col;
//	public QiPan(ArrayList<ArrayList<int> > map, int row, int col)
//	{
//		super();
//		this.map = map;
//		this.row = row;
//		this.col = col;
//	}
//	
//}

// 葫芦娃的前身， 肯定就是葫芦！！只有葫芦才能生出葫芦娃！！
class HuLu
{
	private Color color; // 颜色
	private int priority; // 权值
	private String name;

	public HuLu(Color color, int priority, String name)
	{
		super();
		this.color = color;
		this.priority = priority;
		this.name = name;
	}

	public Color getColor()
	{
		return color;
	}

	public int getPriority()
	{
		return priority;
	}

	public void setPriority(int priority)
	{
		this.priority = priority;
	}

	public void setColor(Color color)
	{
		this.color = color;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return "HuLu [color=" + color + ", priority=" + priority + ", name=" + name + "]";
	}
}

public class Test
{
	public static void BubbleSort(List<HuLu> hlwArrayList)
	{
		String a = null;
		String b = null;
		for (int i = 0; i < hlwArrayList.size(); ++i)
		{
			for (int j = 0; j < hlwArrayList.size() - 1 - i; ++j)
			{
				if (hlwArrayList.get(j).getPriority() > hlwArrayList.get(j + 1).getPriority())
				{
					a = hlwArrayList.get(j).getName();
					b = hlwArrayList.get(j + 1).getName();
					System.out.print(a + " 和 " + b + " 交换位置！ " + a + " 从：" + "(" + j + ",0)" + " ---> " + "(" + (j + 1)
							+ ",0)  ");
					System.out.println(b + " 从：" + "(" + (j + 1) + ",0)" + " ---> " + "(" + j + ",0)");
					Collections.swap(hlwArrayList, j, j + 1); // 交换位置
				}
			}
		}

	}

	public static int Partion(List<HuLu> hlwArrayList, int left, int right)
	{
		int pivot = right; // 基准数的位置
		int i = left - 1;
		String a = null;
		String b = null;
		for (int j = left; j <= right - 1; ++j)
		{
			if (hlwArrayList.get(j).getColor().getIndex() < hlwArrayList.get(pivot).getColor().getIndex())
			{
				i++;
				a = hlwArrayList.get(i).getName();
				b = hlwArrayList.get(j).getName();

				System.out
						.print(a + " 和 " + b + " 交换位置！ " + a + " 从：" + "(" + i + ",0)" + " ---> " + "(" + j + ",0)  ");
				System.out.println(b + " 从：" + "(" + j + ",0)" + " ---> " + "(" + i + ",0)");
				Collections.swap(hlwArrayList, i, j); // 交换位置了。
			}
		}
		// 基准数归位
		a = hlwArrayList.get(i + 1).getName();
		b = hlwArrayList.get(pivot).getName();
		System.out.print(
				a + " 和 " + b + " 交换位置！ " + a + " 从：" + "(" + (i + 1) + ",0)" + " ---> " + "(" + pivot + ",0)  ");
		System.out.println(b + " 从：" + "(" + pivot + ",0)" + " ---> " + "(" + (i + 1) + ",0)");
		Collections.swap(hlwArrayList, i + 1, pivot); // 交换位置了。

		return i + 1;
	}

	// 快速排序 （二分法）
	public static void QuickSort(List<HuLu> hlwArrayList, int left, int right)
	{
		if (left < right)
		{
			int q = Partion(hlwArrayList, left, right);
			QuickSort(hlwArrayList, left, q - 1);
			QuickSort(hlwArrayList, q + 1, right);
		}
	}

	public static void main(String[] args)
	{
		ArrayList<HuLu> hlwArrayList = new ArrayList<>();
		HuLu NO_1 = new HuLu(Color.RED, 1, "大娃"); // 生出大娃
		HuLu NO_2 = new HuLu(Color.ORANGE, 2, "二娃"); // 生出二娃
		HuLu NO_3 = new HuLu(Color.YELLOW, 3, "三娃"); // 生出三娃
		HuLu NO_4 = new HuLu(Color.GREEN, 4, "四娃"); // 生出四娃
		HuLu NO_5 = new HuLu(Color.CYAN, 5, "五娃"); // 生出五娃
		HuLu NO_6 = new HuLu(Color.BLUE, 6, "六娃"); // 生出6娃
		HuLu NO_7 = new HuLu(Color.PURPLE, 7, "七娃"); // 生出七娃
		hlwArrayList.add(NO_7);
		hlwArrayList.add(NO_6);
		hlwArrayList.add(NO_5);
		hlwArrayList.add(NO_4);
		hlwArrayList.add(NO_3);
		hlwArrayList.add(NO_2);
		hlwArrayList.add(NO_1);

		/**
		 * 冒泡法
		 */
		// 先让七个兄弟随意站队
		Collections.shuffle(hlwArrayList);
		// 输出原来七兄弟的位置
		System.out.print("初始位置：");
		hlwArrayList.stream().map(HuLu::getName).forEach(a -> System.out.print(a + " "));
		System.out.println();
		// 然后让他们按冒泡法依照各自排行（从老大到老七）进行排序
		System.out.println("冒泡排序开始：");
		BubbleSort(hlwArrayList);
		// 排序结束：报位置
		System.out.println("冒泡排序结束！！");
		System.out.println("冒泡排序后的位置：");
		hlwArrayList.stream().map(HuLu::getName).forEach(a -> System.out.print(a + " "));
		System.out.println();

		/**
		 * 二分法
		 */
		System.out.println("--------------------------------------------------------------------");
		// 再让七兄弟随意站队
		Collections.shuffle(hlwArrayList);
		// 输出原来七兄弟的位置
		System.out.print("初始位置：");
		hlwArrayList.stream().map(HuLu::getName).forEach(a -> System.out.print(a + " "));
		System.out.println();
		System.out.println("快速排序（二分法）开始：");
		// 使用二分（快速排序）法进行排序
		QuickSort(hlwArrayList, 0, hlwArrayList.size() - 1);
		System.out.println("快速排序（二分法）结束！");
		System.out.println("快速排序（二分法）之后的位置：");
		// 排序结束，报告位置
		hlwArrayList.stream().map(HuLu::getName).forEach(a -> System.out.print(a + " "));
		System.out.println();

	}
}
