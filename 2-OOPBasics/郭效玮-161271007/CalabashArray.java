package calabash;

public class CalabashArray {
	Calabash[] calabashes;

	public CalabashArray() {
		// TODO 自动生成的构造函数存根
	}

	public CalabashArray(int[] randomArray) {
		calabashes = new Calabash[randomArray.length];
		for (int i = 0; i < calabashes.length; i++) {
			calabashes[i] = new Calabash(randomArray[i]);
		}
	}

	public void setRandom(int[] randomArray) {
		calabashes = new Calabash[randomArray.length];
		for (int i = 0; i < calabashes.length; i++) {
			calabashes[i] = new Calabash(randomArray[i]);
		}
	}

	public String getColors() {
		String colors = new String("");
		for (int i = 0; i < calabashes.length; i++) {
			colors += calabashes[i].getColor();
			colors += " ";
		}
		return colors;
	}

	public String getOrders() {
		String orders = new String("");
		for (int i = 0; i < calabashes.length; i++) {
			orders += calabashes[i].getOrder();
			orders += " ";
		}
		return orders;
	}

	public void bubbleSort() {
		for (int i = calabashes.length - 1; i > 0; i--)
			for (int j = 0; j < i; j++)
				if (calabashes[j].getOrder().largerThan(calabashes[j + 1].getOrder())) {
					System.out.println(calabashes[j].exPosInfo(j, j + 1));
					System.out.println(calabashes[j + 1].exPosInfo(j + 1, j));
					Calabash temp = calabashes[j];
					calabashes[j] = calabashes[j + 1];
					calabashes[j + 1] = temp;
				}
	}

	public void binarySort() {
		for (int i = 0; i < 7; i++) {
			Calabash tempBro = calabashes[i];
			int l = 0, r = i - 1;
			while (l <= r) {
				int m = (l + r) / 2;
				if (tempBro.getColor().smallerThan(calabashes[m].getColor()))
					r = m - 1;
				else
					l = m + 1;
			}
			for (int j = i - 1; j >= l; j--) {
				calabashes[j + 1] = calabashes[j];
				System.out.println(calabashes[j].exPosInfo(j, j + 1));
			}
			if (i != l)
				System.out.println(tempBro.exPosInfo(i, 1));
			calabashes[l] = tempBro;
		}
	}
}
