import java.util.*;

public class quicksort {

	public static void main(String[] args) {
		int[] array = {2,7,9,11,6};
		for(int i = 0;i<5;i++)
		{
			int j = i;
			for(int k = i+1;k<5;k++)
			{
				if(array[k]<array[j])
					j = k;
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
			}
		}
		for(int i = 0;i<5;i++)
			System.out.println(array[i]);
	}

}
