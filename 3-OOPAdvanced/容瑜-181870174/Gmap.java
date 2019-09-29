import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Scanner;
public class Gmap{//这是生物体生活的世界,一个二维空间
	static int x;//生活二维空间的横向大小
	static int y;//生活二维空间的纵向大小
    static Grid[][] grid;//里面蕴藏了一个二维的格子数组，格子里放生物体
	Creature[] creatures;
    static huluBaby[] BabyList;
    badSoldier[] soldiers;
    static Gmap map;
    Grandpa grandpa;
    Snake snake;
    Scorpion scorpion;
    static Formation form;
    
	
	public static void main(String[] args) throws IOException, InterruptedException{
		// TODO Auto-generated method stub
		Grandpa old_man = new Grandpa();
		huluBaby Baby1 = new huluBaby(1,"红色","老大",-1,-1,1,"葫芦娃");
		huluBaby Baby2 = new huluBaby(2,"橙色","老二",-1,-1,1,"葫芦娃");
		huluBaby Baby3 = new huluBaby(3,"黄色","老三",-1,-1,1,"葫芦娃");
		huluBaby Baby4 = new huluBaby(4,"绿色","老四",-1,-1,1,"葫芦娃");
		huluBaby Baby5 = new huluBaby(5,"青色","老五",-1,-1,1,"葫芦娃");
		huluBaby Baby6 = new huluBaby(6,"蓝色","老六",-1,-1,1,"葫芦娃");
		huluBaby Baby7 = new huluBaby(7,"紫色","老七",-1,-1,1,"葫芦娃");
		
		huluBaby[] BabyList = new huluBaby[7];
		BabyList[0] = Baby3;
		BabyList[1] = Baby7;
		BabyList[2] = Baby5;
		BabyList[3] = Baby6;
		BabyList[4] = Baby2;
		BabyList[5] = Baby1;
		BabyList[6] = Baby4;
		
		Snake snake = new Snake();
		Scorpion scorpion = new Scorpion();
		badSoldier bad1 = new badSoldier();
		badSoldier bad2 = new badSoldier();
		badSoldier bad3 = new badSoldier();
		badSoldier bad4 = new badSoldier();
		badSoldier bad5 = new badSoldier();
		badSoldier bad6 = new badSoldier();
		badSoldier bad7 = new badSoldier();
		badSoldier bad8 = new badSoldier();
		badSoldier[] bad_man = new badSoldier[8];
		bad_man[0] = bad1;
		bad_man[1] = bad2;
		bad_man[2] = bad3;
		bad_man[3] = bad4;
		bad_man[4] = bad5;
		bad_man[5] = bad6;
		bad_man[6] = bad7;
		bad_man[7] = bad8;
		
		Gmap map = new Gmap(25,25);
		Formation form = new Formation();
		form.Change_hulu_Formation(4,map,BabyList);
		form.Change_mon_Formation(7, map, scorpion, bad_man);
		System.out.println("葫芦娃乱序时输出阵型如下：");
		ShowTheMap(x, y);
		System.out.print("\n\n\n\n\n");
		Hulu_Range(BabyList);
		System.out.print("\n\n\n\n\n");
		System.out.println("葫芦娃有序列队后输出阵型如下：");
		ShowTheMap(x, y);
		form.Set_Chief(map, old_man,snake );
		System.out.print("\n\n\n\n\n");
		System.out.println("加入老爷爷和蛇精时输出阵型如下：");
		ShowTheMap(x, y);
		old_man.Cheers(map);
	    snake.Cheers(map);
	    System.out.print("\n\n\n\n\n");
		System.out.println("老爷爷和蛇精加油时输出阵型如下：");
		ShowTheMap(x, y);
		//变阵阶段
		Scanner input = new Scanner(System.in);
		int num=6;
		int type=0;
		while(num>0)
		{
			System.out.println("请让妖精按照以下阵型当中的其中一个进行变阵：\n1: 鹤翼\t2: 雁行\t3: 衡轭\t4：非法\t5：鱼鳞\t6: 方门\t7: 偃月\t8：锋矢");
			type = input.nextInt();
			while(type == 4)
			{
				System.out.println("input error\n请让妖精按照以下阵型当中的其中一个进行变阵：\n1: 鹤翼\t2: 雁行\t3: 衡轭\t4：非法\t5：鱼鳞\t6: 方门\t7: 偃月\t8：锋矢");
				type = input.nextInt();
			}
			form.Change_mon_Formation(type, map, scorpion, bad_man);
			System.out.print("\n\n\n\n\n");
			System.out.println("变阵后输出阵型如下：");
			ShowTheMap(x, y);
			num--;
		}
		
	}
	
	Gmap(int x,int y) {
		grid = new Grid[x][y];
	    this.x = x;
	    this.y = y;
	    for(int i =0;i<x;i++)
	    {
	        for(int j = 0; j < y;j++)
	        {
	            grid[i][j] = new Grid(i,j);
	        }
	    }
	}
	
	public void putCreature(Creature temp, int x, int y) {
        if(x < 0 || x > this.x-1 || y < 0 || y > this.y-1)
        {
        	System.out.println("x="+x+"y="+y);
            System.out.println("该位置不能放置生物体!");
            return;
        }
        grid[x][y].Set(temp);
        temp.Move(x, y);
    }
	
	public void movCreature(Creature temp,int x,int y) {
		int i=0;
		int j=0;
        if(x < 0 || x > this.x-1 || y < 0 || y > this.y-1)
        {
        	System.out.println("x="+x+"y="+y);
            System.out.println("该位置不能放置生物体!");
            return;
        }
        
        i = temp.get_x();
        j = temp.get_y();
        if(i == -1 && j == -1)
        {
            grid[x][y].Set(temp);
            temp.Move(x, y);
        }
        else if(i != x || j != y)
        {
            if(grid[x][y].Empty_or_not() == false)
            {
                grid[x][y].Swap(grid[i][j]); 
            }
            else
            {
                grid[i][j].Move_to(grid[x][y]);
            }
        }
    }
	
	public int return_x() {
		return this.x;
	}
	
	public int return_y() {
		return this.y;
	}
	
	public static void ShowTheMap(int re_x,int re_y) {
		int i = 0;
		int j = 0;
		for(i=0;i< x;i++) {
			for(j=0;j< y;j++) {
				if(grid[i][j].isEmpty == false) {
					//System.out.print(Gmap.grid[i][j].creature.name);
					Gmap.grid[i][j].Show_me();
				}
				else {
					System.out.print("---");
				}
			}
			System.out.print("\n");
		}
	}
	
	public static void Hulu_Range(huluBaby[] list) {
		int i=0;
		int j=0;
		for(i=0;i<6;i++) {
			for(j=0;j<6-i;j++) {
				if(list[j].num>list[j+1].num) {
					int m1=list[j].get_x();
					int n1=list[j].get_y();
					int m2=list[j+1].get_x();
					int n2=list[j+1].get_y();
					grid[m1][n1].Swap(grid[m2][n2]);
					int num1=0;
					int num2=0;
					while(list[num1].num !=grid[m1][n1].ret_num())
					{
						num1++;
					}
					while(list[num2].num !=grid[m2][n2].ret_num())
					{
						num2++;
					}
					huluBaby temp;
					temp = list[num1];
					list[num1] = list[num2];
					list[num2] = temp;
					System.out.print("\n\n\n\n\n");
					ShowTheMap(x, y);
				}
			}
		}
	}
	
}

class Formation{
	String name;//阵型名字
	int index;//阵型编码
	Formation(){
		name = "长蛇";
		index = 4;
	}
	
	Formation(String my_name,int my_index){
		this.name = my_name;
		this.index = my_index;
	}
	
	public void Change_mon_Formation(int index,Gmap map,Scorpion scor,badSoldier[] sol){//怪物变阵

		int base_x = map.x/2;
		int base_y = map.y - 6;
		if(index == 1)
		{
			map.movCreature(scor, base_x, base_y);
			map.movCreature(sol[0], base_x-1, base_y+1);
			map.movCreature(sol[1], base_x+1, base_y+1);
			map.movCreature(sol[2], base_x-2, base_y+2);
			map.movCreature(sol[3], base_x+2, base_y+2);
			map.movCreature(sol[4], base_x-3, base_y+3);
			map.movCreature(sol[5], base_x+3, base_y+3);
			map.movCreature(sol[6], base_x-4, base_y+4);
			map.movCreature(sol[7], base_x+4, base_y+4);
		}
		else if(index == 2) 
		{
			map.movCreature(scor, base_x+3, base_y-3);
			map.movCreature(sol[0], base_x+2, base_y-2);
			map.movCreature(sol[1], base_x+1, base_y-1);
			map.movCreature(sol[2], base_x, base_y);
			map.movCreature(sol[3], base_x-1, base_y+1);
			map.movCreature(sol[4], base_x-2, base_y+2);
			map.movCreature(sol[5], base_x-3, base_y+3);
			map.movCreature(sol[6], base_x-4, base_y+4);
			map.movCreature(sol[7], base_x-5, base_y+5);
		}
		else if(index == 3)
		{
			map.movCreature(scor, base_x, base_y);
			map.movCreature(sol[0], base_x-1, base_y+1);
			map.movCreature(sol[1], base_x+1, base_y+1);
			map.movCreature(sol[2], base_x-2, base_y);
			map.movCreature(sol[3], base_x+2, base_y);
			map.movCreature(sol[4], base_x-3, base_y+1);
			map.movCreature(sol[5], base_x+3, base_y+1);
			map.movCreature(sol[6], base_x-4, base_y);
			map.movCreature(sol[7], base_x+4, base_y);
		}
		else if(index == 4)
		{
			map.movCreature(scor, base_x, base_y);
			map.movCreature(sol[0], base_x-1, base_y);
			map.movCreature(sol[1], base_x+1, base_y);
			map.movCreature(sol[2], base_x-2, base_y);
			map.movCreature(sol[3], base_x+2, base_y);
			map.movCreature(sol[4], base_x-3, base_y);
			map.movCreature(sol[5], base_x+3, base_y);
			map.movCreature(sol[6], base_x-4, base_y);
			map.movCreature(sol[7], base_x+4, base_y);
		}
		else if(index == 5)
		{
			map.movCreature(scor, base_x, base_y);
			map.movCreature(sol[0], base_x, base_y+1);
			map.movCreature(sol[1], base_x-1, base_y+1);
			map.movCreature(sol[2], base_x-2, base_y+1);
			map.movCreature(sol[3], base_x+1, base_y+1);
			map.movCreature(sol[4], base_x, base_y+2);
			map.movCreature(sol[5], base_x-1, base_y+2);
			map.movCreature(sol[6], base_x, base_y+3);
			map.movCreature(sol[7], base_x-1, base_y+4);
		}
		else if(index == 6)
		{
			map.movCreature(scor, base_x, base_y);
			map.movCreature(sol[0], base_x-1, base_y+1);
			map.movCreature(sol[1], base_x+1, base_y+1);
			map.movCreature(sol[2], base_x-2, base_y+2);
			map.movCreature(sol[3], base_x+2, base_y+2);
			map.movCreature(sol[4], base_x-1, base_y+3);
			map.movCreature(sol[5], base_x+1, base_y+3);
			map.movCreature(sol[6], base_x, base_y+4);
			map.movCreature(sol[7], base_x, base_y+5);
		}
		else if(index == 7)
		{
			map.movCreature(scor, base_x, base_y);
			map.movCreature(sol[0], base_x-1, base_y+1);
			map.movCreature(sol[1], base_x, base_y+1);
			map.movCreature(sol[2], base_x+1, base_y+1);
			map.movCreature(sol[3], base_x-2, base_y+2);
			map.movCreature(sol[4], base_x-1, base_y+2);
			map.movCreature(sol[5], base_x+1, base_y+2);
			map.movCreature(sol[6], base_x+2, base_y+2);
			map.movCreature(sol[7], base_x-2, base_y+3);
		}
		else if(index == 8)
		{
			map.movCreature(scor, base_x, base_y);
			map.movCreature(sol[0], base_x-1, base_y+1);
			map.movCreature(sol[1], base_x-2, base_y+2);
			map.movCreature(sol[2], base_x-3, base_y+3);
			map.movCreature(sol[3], base_x+1, base_y+1);
			map.movCreature(sol[4], base_x+2, base_y+2);
			map.movCreature(sol[5], base_x+3, base_y+3);
			map.movCreature(sol[6], base_x, base_y+2);
			map.movCreature(sol[7], base_x, base_y+3);
		}
		else {
			System.out.println("阵型过于高端，无法按此列阵!");
		}
	}

	public void Change_hulu_Formation(int index,Gmap map,huluBaby[] baby){//葫芦娃变阵
		int base_x = map.x/2;
		int base_y = 6;
		if(index == 1)
		{
			map.movCreature(baby[0], base_x, base_y);
			map.movCreature(baby[1], base_x-1, base_y-1);
			map.movCreature(baby[2], base_x+1, base_y-1);
			map.movCreature(baby[3], base_x-2, base_y-2);
			map.movCreature(baby[4], base_x+2, base_y-2);
			map.movCreature(baby[5], base_x-3, base_y-3);
			map.movCreature(baby[6], base_x+3, base_y-3);
		}
		else if(index == 2) 
		{
			map.movCreature(baby[0], base_x+3, base_y+3);
			map.movCreature(baby[1], base_x+2, base_y+2);
			map.movCreature(baby[2], base_x+1, base_y+1);
			map.movCreature(baby[3], base_x, base_y);
			map.movCreature(baby[4], base_x-1, base_y-1);
			map.movCreature(baby[5], base_x-2, base_y-2);
			map.movCreature(baby[6], base_x-3, base_y-3);
		}
		else if(index == 3)
		{
			map.movCreature(baby[0], base_x, base_y);
			map.movCreature(baby[1], base_x-1, base_y-1);
			map.movCreature(baby[2], base_x+1, base_y-1);
			map.movCreature(baby[3], base_x-2, base_y);
			map.movCreature(baby[4], base_x+2, base_y);
			map.movCreature(baby[5], base_x-3, base_y-1);
			map.movCreature(baby[6], base_x+3, base_y-1);
		}
		else if(index == 4)
		{
			map.movCreature(baby[0], base_x-3, base_y);
			map.movCreature(baby[1], base_x-2, base_y);
			map.movCreature(baby[2], base_x-1, base_y);
			map.movCreature(baby[3], base_x, base_y);
			map.movCreature(baby[4], base_x+1, base_y);
			map.movCreature(baby[5], base_x+2, base_y);
			map.movCreature(baby[6], base_x+3, base_y);
		}
		else if(index == 5)
		{
			map.movCreature(baby[0], base_x, base_y);
			map.movCreature(baby[1], base_x, base_y-1);
			map.movCreature(baby[2], base_x-1, base_y-1);
			map.movCreature(baby[3], base_x-2, base_y-1);
			map.movCreature(baby[4], base_x+1, base_y-1);
			map.movCreature(baby[5], base_x, base_y-2);
			map.movCreature(baby[6], base_x-1, base_y-2);
		}
		else if(index == 6)
		{
			map.movCreature(baby[0], base_x, base_y);
			map.movCreature(baby[1], base_x-1, base_y-1);
			map.movCreature(baby[2], base_x+1, base_y-1);
			map.movCreature(baby[3], base_x-2, base_y-2);
			map.movCreature(baby[4], base_x+2, base_y-2);
			map.movCreature(baby[5], base_x-1, base_y-3);
			map.movCreature(baby[6], base_x+1, base_y-3);
		}
		else if(index == 7)
		{
			map.movCreature(baby[0], base_x, base_y);
			map.movCreature(baby[1], base_x-1, base_y-1);
			map.movCreature(baby[2], base_x, base_y-1);
			map.movCreature(baby[3], base_x+1, base_y-1);
			map.movCreature(baby[4], base_x-2, base_y-2);
			map.movCreature(baby[5], base_x-1, base_y-2);
			map.movCreature(baby[6], base_x+1, base_y-2);
		}
		else if(index == 8)
		{
			map.movCreature(baby[0], base_x, base_y);
			map.movCreature(baby[1], base_x-1, base_y-1);
			map.movCreature(baby[2], base_x-2, base_y-2);
			map.movCreature(baby[3], base_x+1, base_y-1);
			map.movCreature(baby[4], base_x+2, base_y-2);
			map.movCreature(baby[5], base_x, base_y-1);
			map.movCreature(baby[6], base_x, base_y-2);
		}
		else {
			System.out.println("阵型过于高端，无法按此列阵!");
		}
	}
	
	public void Set_Chief(Gmap map,Grandpa pa,Snake snake) {
		map.movCreature(pa, 23, 2);
		map.movCreature(snake, 23, 23);
	}
}


class HEYI extends Formation{
	HEYI(){
		this.name = "鹤翼";
		this.index = 1;
	}
}

class YANHANG extends Formation{
	YANHANG(){
		this.name = "雁行";
		this.index = 2;
	}
}

class HENGE extends Formation{
	HENGE(){
		this.name = "衡轭";
		this.index = 3;
	}
}

class CHANGSHE extends Formation{
	CHANGSHE(){
		this.name = "长蛇";
		this.index = 4;
	}
}

class YULIN extends Formation{
	YULIN(){
		this.name = "鱼鳞";
		this.index = 5;
	}
}

class FANGMEN extends Formation{
	FANGMEN(){
		this.name = "方门";
		this.index = 6;
	}
}

class YANYUE extends Formation{
	YANYUE(){
		this.name = "偃月";
		this.index = 7;
	}
}

class FENGSHI extends Formation{
	FENGSHI(){
		this.name = "锋矢";
		this.index = 8;
	}
}


class Grid{//作为二维世界里的一个格子
	Creature creature;//作为容器可以容纳的生物体
	int x;//在二维世界里的横坐标
	int y;//在二维世界里的纵坐标
	boolean isEmpty;//判断这个格子里是否有容纳生物体
	
	Grid(){
		creature = null;
		x = 0;
		y = 0;
		isEmpty = true;
	}
	
	Grid(int my_x,int my_y){
		creature = null;
		x = my_x;
		y = my_y;
		isEmpty = true;
	}
	
	Grid(Creature temp,int my_x,int my_y){
		creature = temp;
		x = my_x;
		y = my_y;
		isEmpty = false;
	}
	
	public void Set(Creature a) {
		this.creature = a;
		this.isEmpty = false;
	}
	
	public boolean Empty_or_not() {
		return this.isEmpty;
	}
	
	public void Swap(Grid dest) {//交换该格子和dest格子的生物
		Creature temp;
		temp = this.creature;
		this.creature = dest.creature;
		dest.creature.Move(x,y);
		dest.creature = temp;
		dest.creature.Move(dest.x, dest.y);
	}
	
	public int ret_num() {
		return creature.num;
	}
	
	public void Move_to(Grid dest) {//把该格子内的生物体移动到目的格子，目的格子原本为空
		dest.creature = creature;
		dest.isEmpty = false;
		dest.creature.Move(dest.x, dest.y);
		this.creature = null;
		this.isEmpty = true;
	}
	
	public void Show_me() {
		if(isEmpty != true) {
			creature._Show();
	    }
	}
	
	public Creature return_crea(){
	    return this.creature; //返回当前的creature
	}
}



class Creature{
	int x;//生物体有它自己对应的地图横坐标
	int y;//生物体有它自己对应的地图纵坐标
	int num;//如果是葫芦娃则是其兄弟排行，否则是-1
	BufferedImage image;//生物体有它自己的图像
	String name;//生物体自己的名字
	int running_speed;//生物体的移动速度,在横竖方向上均可以以这个速度移动
	
	Creature(){
		x = -1;
		y = -1;
		num = -1;
		running_speed = 1;
	}
	
	Creature(int my_x,int my_y,String my_name,int my_speed){
		x = my_x;
		y = my_y;
		running_speed = my_speed;
		name = my_name;
	}
	
	public int get_x() {
		return x;
	}
	
	public int get_y() {
		return y;
	}
	
	public int get_speed() {
		return running_speed;
	}
	
	public void Move(int i,int j) {
		this.x = i;
		this.y = j;
	}
	
	public void _Show(){
		System.out.print(name);
    }
}

class Chief extends Creature{
	public Chief(){
		super();
	}
	
	public void Cheers(Gmap map) throws InterruptedException {//使用技能加油助威
		int i = 10;
		while(i>0)
		{
			Thread.sleep(1500);
			if(i%2 == 0)
			{
				map.movCreature(this,x-1,y);
				int m = map.return_x();
				int n = map.return_y();
				Gmap.ShowTheMap(m,n);
				System.out.print("\n\n\n\n\n");
				i--;
			}
			else
			{
				map.movCreature(this,x+1,y);
				int m = map.return_x();
				int n = map.return_y();
				Gmap.ShowTheMap(m,n);
				System.out.print("\n\n\n\n\n");
				i--;
			}
		}
	}
}



class huluBaby extends Creature{
	String color;//葫芦娃的颜色
	String rank;//葫芦娃的排行
	
	huluBaby(){
		super();
		num = 1;
		color = "Red";
		rank = "老大";
		x = -1;
		y = -1;
		running_speed = 1;
		name = rank;
	}
	
	huluBaby(int renum,String recol,String rerank,int my_x,int my_y,int speed,String my_name) throws IOException{
		num = renum;
		color = recol;
		rank = rerank;
		x = my_x;
		y = my_y;
		running_speed = speed;
		name = rank;
	}
	
	public void _Show(){
		if(this.num == 1) {
			System.out.print("[01]");
		}
		else if(this.num == 2) {
			System.out.print("[02]");
		}
		else if(this.num == 3) {
			System.out.print("[03]");
		}
		else if(this.num == 4) {
			System.out.print("[04]");
		}
		else if(this.num == 5) {
			System.out.print("[05]");
		}
		else if(this.num == 6) {
			System.out.print("[06]");
		}
		else if(this.num == 7) {
			System.out.print("[07]");
		}
    }
	
}

class Grandpa extends Chief{
	Grandpa(){
		super();
		x = -1;
		y = -1;
		running_speed = 5;
		this.name = "👴";
	}
	
	Grandpa(int my_x,int my_y,BufferedImage my_image,String my_name,int my_speed){
		x = my_x;
		y = my_y;
		image = my_image;
		name = my_name;
		running_speed = my_speed;
		this.name = "👴";
	}
	
}

class Snake extends Chief{
	Snake(){
		super();
		x = -1;
		y = -1;
		running_speed = 5;
		this.name = "🐍";
	}
	
	Snake(int my_x,int my_y,BufferedImage my_image,String my_name,int my_speed){
		x = my_x;
		y = my_y;
		image = my_image;
		name = my_name;
		running_speed = my_speed;
		this.name = "🐍";
	}
}

class Scorpion extends Creature{
	Scorpion(){
		super();
		x = -1;
		y = -1;
		running_speed = 5;
		this.name = "🦂";
	}
	
	Scorpion(int my_x,int my_y,BufferedImage my_image,String my_name,int my_speed){
		x = my_x;
		y = my_y;
		image = my_image;
		running_speed = my_speed;
		this.name = "🦂";
	}
}

class badSoldier extends Creature{
	badSoldier(){
		super();
		x = -1;
		y = -1;
		running_speed = 5;
		this.name = "😈";
	}
	
	badSoldier(int my_x,int my_y,BufferedImage my_image,String my_name,int my_speed){
		x = my_x;
		y = my_y;
		image = my_image;
		name = my_name;
		running_speed = my_speed;
		this.name = "😈";
	}
}
