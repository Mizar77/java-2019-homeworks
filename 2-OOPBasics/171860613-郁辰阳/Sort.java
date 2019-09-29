
public class Sort {
	public HuLuWa[] bubbleSort(HuLuWa []a) {
		for(int cnt=0;cnt<7;cnt++) {
			for(int i=1;i<7;i++) {
				if(a[i].compareTo(a[i-1])<0) {
					a[i-1].outputSen(); a[i].outputSen(); System.out.print("交换位置"+'\n');
					a[i-1].swap(i+1);
					a[i].swap(i);
					HuLuWa temp=a[i];
					a[i]=a[i-1];
					a[i-1]=temp;
				}
			}
		}
		System.out.print("冒泡排序后: ");
		for(int j=0;j<7;j++) {
			a[j].outputSen();
		}
		System.out.print("\n");
		return a;
	}
	
	public HuLuWa[] binarySort(HuLuWa []a) {
		for(int i=0;i<7;i++) {
			a[i].outputSen(); System.out.print("出列"+'\n');
			
			HuLuWa temp=a[i];
			int left=0;
			int right=i-1;
			int middle=0;
			while(left<=right) {
				middle=(left+right)/2;
				if(temp.compareTo(a[middle])<0)
					right=middle-1;
				else
					left=middle+1;
			}
			for(int j=i-1;j>=left;j--) {
				a[j].swap(j+2);
				a[j+1]=a[j];
			}
			if(left!=i) {
				temp.outputSen(); System.out.print("入列:入列位置见下一行"+'\n');
				temp.swap(left+1);
				a[left]=temp;
			}else {
				temp.outputSen(); System.out.print("入列：保持原位置不变"+'\n');
			}
		}
		System.out.print("二分排序后:  ");
		for(int i=0;i<7;i++) {
			a[i].outputColor();
		}
		System.out.print("\n");
		return a;
	}
}
