import java.util.Random;

/**
 * @author: 李睿钦 电子科学与工程学院 161180068
 * @className: cocktail_sort
 * @description: 双向冒泡排序，就是从左往右冒泡和从右往左冒泡交替进行。条件凑巧的话可以快一点。当然，这也是Java的使用练习。
 * @data: 2019-9-9 22:14
 **/

class HuLuBrothers{
	private String name;
	private String color;
	private String nameList[] = new String[]{"大娃","二娃","三娃","四娃","五娃","六娃","七娃"};
	private String colorList[] = new String[]{"红色","橙色","黄色","绿色","青色","蓝色","紫色"};
	private int location;				
	public int order;					
	
	// the constructor.
	HuLuBrothers(int order, int location){
		this.order = order;
		this.location = location;
		this.name = this.nameList[order];
		this.color = this.colorList[order];
	}
	HuLuBrothers(){
		this.order = -1;
		this.location = -1;
		this.name = "Initialize";
		this.color = "Initialize";
	}
	
	public void broadcast(int loc_before, int loc_after){
		System.out.println(this.name + "：" + loc_before + "->" + loc_after);
	}
	
	public int getLocation(){
		return this.location;
	}
	
	public void setLocation(int location){
		this.location = location;
	}
	
	public String getColor(){
		return this.color;
	}
	
	public String getName(){
		return this.name;
	}
	
}

public class homework2 {
	public static void main(String args[]){
		HuLuBrothers Brothers[] = new HuLuBrothers[7];	// initialize HuLu Brother
		for (int i=0; i<7; i++){
			Brothers[i] = new HuLuBrothers(i,i);
		}
		System.out.print(">>Begin the HuLu-Brother sort game :-)\n>>===============>>\n");
		System.out.print(">>shuffle. Printed by rank: ");
		shuffle(Brothers);
		print(Brothers, true);				// boolean ifRank = true: rank; false: color.
		System.out.print("\n>>Bubble sort: \n");
		sort(Brothers);
		System.out.print("\n>>After sort. Printed by rank: ");
		print(Brothers, true);
		System.out.print("\n>>Shuffle again. Printed by color: ");
		shuffle(Brothers);
		print(Brothers, false);
		System.out.print("\n>>Binary sort: \n");
		binary(Brothers);
		System.out.print("\n>>After sort. Printed by rank: ");
		print(Brothers, true);
		System.out.print("\n>>===============>>\n>>Finish! Congratulated! :-D");
	}
	
	private static void sort(HuLuBrothers[] array) {
		HuLuBrothers tmp = new HuLuBrothers();
		for(int i=0; i<array.length; i++) {
			boolean isSorted = true;
			// 如果排序下来元素没有调换，就提前结束。
			for(int j=0; j<array.length-i-1; j++) {
				if(array[j].getLocation() > array[j+1].getLocation()) {
					//进行调换操作
					tmp.setLocation(array[j].getLocation());
					array[j].setLocation(array[j+1].getLocation());
					array[j+1].setLocation(tmp.getLocation());
					array[j].broadcast(j, j+1);
					isSorted = false;
				}
			}	
			if(isSorted) { break; }
			isSorted = true;
		}
	}
	
	/**	
	private static void initialize(){
		HuLuBrothers[] Brothers = null;	// initialize HuLu Brother
		for (int i=0; i<7; i++){
			Brothers[i] = new HuLuBrothers(i,i+1);
		}
	}**/
	
	private static void shuffle(HuLuBrothers[] Brothers1){
		Random rand=new Random();
		for (int i=0; i<7; i++){
			one_num:
			while(true){
				Brothers1[i].setLocation(rand.nextInt(7));
				for (int j=0; j<i; j++){
					if (Brothers1[i].getLocation()==Brothers1[j].getLocation()) continue one_num;
				}
				//System.out.print((Brothers1[i].location+1) + " ");
				break;
			}
		}//System.out.println();
	}
	
	private static void print(HuLuBrothers[] a, boolean ifRank){
		if (ifRank){
			for(int i=0; i<a.length; i++){
				for(int j=0;j<a.length; j++)
					if(i==a[j].getLocation()){
						System.out.print(a[j].getName() + " ");
						break;
				}
			}
			System.out.println();
		}
		else{
			for(int i=0; i<a.length; i++){
				for(int j=0;j<a.length; j++)
					if(i==a[j].getLocation()){
						System.out.print(a[j].getColor() + " ");
						break;
				}
			}
			System.out.println();
		}
	}
	
	private static void binary(HuLuBrothers[] array){
        int low;
        int high;
        int mid;
        int value;
        for (int i=1; i<7; i++){
        	low = 0;
        	high = i - 1;
        	mid = (low + high)/2;
        	value = array[mid].getLocation();
        	value = array[i].getLocation();
        	while(low <= high)
            {
                mid = (low + high) / 2;
                if(value == array[mid].getLocation())
                {
                	// This is impossible but I want to preserve this structure. Beautiful, isn't it? :-D
                }
                if(value > array[mid].getLocation())
                {
                    low = mid + 1;
                }
                if(value < array[mid].getLocation())
                {
                    high = mid - 1;
                }
            }
        	for (int j=i-1; j>=low; j--){
        		array[j+1].setLocation(array[j].getLocation());
        		array[j].broadcast(j,j+1);
        	}
        	if (low != i){
        		array[low].setLocation(value);
        		array[i].broadcast(i, low);
        	}
        }
    }
}
