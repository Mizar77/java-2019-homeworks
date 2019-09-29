import java.util.Arrays;

/**
 * @author: 李睿钦 电子科学与工程学院 161180068
 * @className: cocktail_sort
 * @description: Java的安装配置完成后，练习一个排序算法。使用了双向冒泡排序，条件凑巧的话可以快一点:-)
 * @data: 2019-9-9 22:14
 **/

public class cocktail_sort {
	public static void sort(int array[]) {
		int tmp = 0;
		for(int i=0; i<array.length/2; i++) {
			boolean isSorted = true;
			// 如果排序下来元素没有调换，就提前结束。
			for(int j=i; j<array.length-i-1; j++) {
				if(array[j] > array[j+1]) {
					tmp = array[j];
					array[j] = array[j+1];
					array[j+1] = tmp;
					isSorted = false;
				}
			}
			if(isSorted) {
				break;
			}
			isSorted = true;
			for(int j=array.length-i-1; j>i; j--) {
				if(array[j] < array[j-1]) {
					tmp = array[j];
					array[j] = array[j-1];
					array[j-1] = tmp;
					isSorted = false;
				}
			}
			if(isSorted) {
				break;
			}
		}
	}
	
  // main方法。
	public static void main(String[] args) {
		int[] array = new int[]{9,99,156,10,67,162,333,27};
		sort(array);
		System.out.println(Arrays.toString(array));

	}
}
