
public class HuLuWa implements Comparable<HuLuWa>{
	//三个必要属性
	private int num; //排行
	private int place; //队列位置
	private String color; //颜色
	
	//构造函数
	HuLuWa(int inputnum, int inputplace,String inputcolor){ 
		num=inputnum; place=inputplace;
		color=inputcolor;
	}
	HuLuWa(){
		num=0; place=0;
		color = " ";
	}
	
	int getNum() {
		return num;
	}
	
	//换位置
	public void swap(int dst) {
		String seniority = " ";
		switch(num) {
		case 1:seniority="老大"; break;
		case 2:seniority="老二"; break;
		case 3:seniority="老三"; break;
		case 4:seniority="老四"; break;
		case 5:seniority="老五"; break;
		case 6:seniority="老六"; break;
		case 7:seniority="老七"; break;
		default:seniority="error"; break;
		}
		
		System.out.println(seniority+": "+ place +"->"+dst);
		place=dst;
	}
	
	
	@Override
	public int compareTo(HuLuWa b) {
		return num-b.getNum();
	}
	
	public void outputColor() {
		System.out.print(color+" ");
		return;
	}
	
	public void outputSen() {
		String seniority = " ";
		switch(num) {
		case 1:seniority="老大"; break;
		case 2:seniority="老二"; break;
		case 3:seniority="老三"; break;
		case 4:seniority="老四"; break;
		case 5:seniority="老五"; break;
		case 6:seniority="老六"; break;
		case 7:seniority="老七"; break;
		default:seniority="error"; break;
		}
		System.out.print(seniority+" ");
	}
}



