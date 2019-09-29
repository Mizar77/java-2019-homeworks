import java.util.Arrays;

public class HuLuGrandpa {
	public static void main(String[] args) {
		HuLuWa []sequence = new HuLuWa[7];
		MyRandom random = new MyRandom();
		sequence = random.randomGenerator();
		
		System.out.print("冒泡排序前: ");
		for(int i=0;i<7;i++) {
			sequence[i].outputSen(); 
		}
		System.out.print('\n');
		
		Sort MySort = new Sort();
		MySort.bubbleSort(sequence);
		
		MyRandom random2 = new MyRandom();
		sequence = random2.randomGenerator();
		
		System.out.println("-------------------------");
		System.out.print("二分排序前: ");
		for(int i=0;i<7;i++) {
			sequence[i].outputSen();
		}
		System.out.print('\n');

		MySort.binarySort(sequence);
		return;
	}
}
