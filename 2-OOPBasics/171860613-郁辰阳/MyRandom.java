import java.util.Random;

public class MyRandom {
	private HuLuWa []a;
	private int p;
	private String[] relativeColor;
	
	MyRandom(){
		a=new HuLuWa[7]; p=0;
		relativeColor = new String[] {"红色","橙色","黄色","绿色","青色","蓝色","紫色"};
	}
	public boolean check(int input) {
		for(int i=0;i<p;i++) {
			if(a[i].getNum()==input)
				return false;
		}
		return true;
	}
	public HuLuWa[] randomGenerator() {
		Random ran = new Random();
		for(int i=0;i<7;i++) {
			int temp=0;
			temp=ran.nextInt(7)+1;
			while(!check(temp)) {
				temp=ran.nextInt(7)+1;
			}
			a[i]=new HuLuWa(temp,i+1,relativeColor[temp-1]);
			p++;
		}
		return a;
	}
}
