package calabash;

import java.util.Random;

public class CalabashTest {

	public static int[] calabashRandom(int arrayLength) {
		int[] randomArray=new int[arrayLength];
		boolean[] boolArray=new boolean[arrayLength];
		Random random=new Random();
		int randomNum=0;
		for (int i = 0; i < randomArray.length; i++) {
			do{
			randomNum=random.nextInt(arrayLength);
			}while(boolArray[randomNum]);
			boolArray[randomNum]=true;
			randomArray[i]=randomNum;
		}
		return randomArray;
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		System.out.println("BubbleSort:");
		CalabashArray calabashArray=new CalabashArray(calabashRandom(7));
		System.out.println(calabashArray.getOrders());
		calabashArray.bubbleSort();
		System.out.println(calabashArray.getOrders());
		
		System.out.println("-----------------------------------------");
		
		System.out.println("BinarySort:");
		calabashArray.setRandom(calabashRandom(7));
		System.out.println(calabashArray.getColors());
		calabashArray.binarySort();
		System.out.println(calabashArray.getColors());
		
	}

}
