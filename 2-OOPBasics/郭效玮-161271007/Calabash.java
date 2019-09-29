package calabash;

abstract class SortBase {
	int value;

	public SortBase() {
	}

	public SortBase(int value) {
		this.value = value;
	}

	boolean smallerThan(SortBase base) {
		return value < base.value;
	}

	boolean largerThan(SortBase base) {
		return value > base.value;
	}

	@Override
	public String toString() {
		// TODO 自动生成的方法存根
		return value + "";
	}
}

class Order extends SortBase {
	public Order() {
	}

	public Order(int orderValue) {
		super(orderValue);
	}

	@Override
	public String toString() {
		switch (value) {
		case 0:
			return "老大";
		case 1:
			return "老二";
		case 2:
			return "老三";
		case 3:
			return "老四";
		case 4:
			return "老五";
		case 5:
			return "老六";
		case 6:
			return "老七";
		default:
			return "你就是葫芦小金刚?";
		}
	}
}

class Color extends SortBase {

	public Color() {
	}

	public Color(int colorValue) {
		super(colorValue);
	}

	@Override
	public String toString() {
		switch (value) {
		case 0:
			return "红色";
		case 1:
			return "橙色";
		case 2:
			return "黄色";
		case 3:
			return "绿色";
		case 4:
			return "青色";
		case 5:
			return "蓝色";
		case 6:
			return "紫色";
		default:
			return "你就是七彩葫芦娃?";
		}
	}
}

public class Calabash {

	private Order order;
	private Color color;

	public Calabash() {
	}

	public Calabash(int num) {
		order = new Order(num);
		color = new Color(num);
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	public String exPosInfo(int posEx,int pos) {
		return order+":"+posEx+"--->"+pos;
	}
}
