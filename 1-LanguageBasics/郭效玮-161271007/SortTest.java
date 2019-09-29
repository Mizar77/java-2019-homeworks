import java.util.Arrays;
import java.util.Scanner;

class IntArray{
	int[] array;
	int arrayLength;
	public IntArray() {
		// TODO 自动生成的构造函数存根
	}
	public IntArray(String str) {
		// TODO 自动生成的构造函数存根
		String[] stringArray=str.split(" ");
		array=new int[stringArray.length];
		this.arrayLength=stringArray.length;
		for (int i = 0; i < arrayLength; i++) {
			array[i]=new Integer(stringArray[i]).intValue();
		}
	}
	@Override
	public String toString() {
		// TODO 自动生成的方法存根
		String str="";
		for (int i : array) {
			str+=i;
			str+=" ";
		}
		return str;
	}
	public void sort() {
		Arrays.sort(array);
	}
}
public class SortTest {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		System.out.println("input integers splited by blank");
		Scanner scanner=new Scanner(System.in);
		IntArray intArray=new IntArray(scanner.nextLine());
		intArray.sort();
		System.out.println(intArray);
	}

}
