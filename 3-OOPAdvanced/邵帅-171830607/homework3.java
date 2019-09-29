import java.util.ArrayList;
import java.util.Collections;
// 生物类
class Organism {

    // Point position; //位置
    int flag; // 0表示没有生物，1表示有生物
    String name;

    public Organism() {
        flag = 0;
        name = "";
    }

    public Organism(String myname) {
        //this.position = mypos;
        this.name = myname;
        flag = 1;
    }
}
public class homework3 {

    /*
     * class Point{ private int x; private int y;
     * 
     * public Point(int x1,int y1){ this.x = x1; this.y = y1; } public int getX(){
     * return x; } public int getY(){ return y; }
     * 
     * public void setX(int x1){ this.x = x1; } public void setY(int y1){ this.y =
     * y1; } }
     */
    

    /*
     * class Organism extends Organism {
     * 
     * String color; String rank; public Organism(int mynumber, String mycolor,
     * String myrank) { number = mynumber; color = mycolor; rank = myrank; } public
     * void init(ArrayList <Organism> bros) { // 创建葫芦娃并打乱 Organism brother1 = new
     * Organism(1, "红色", "老大"); // Organism brother1 = new Organism(1, "red",
     * "big"); // brother1.printcolor(); Organism brother2 = new Organism(2, "橙色",
     * "老二"); Organism brother3 = new Organism(3, "黄色", "老三"); Organism brother4 =
     * new Organism(4, "绿色", "老四"); Organism brother5 = new Organism(5, "青色", "老五");
     * Organism brother6 = new Organism(6, "蓝色", "老六"); Organism brother7 = new
     * Organism(7, "紫色", "老七");
     * 
     * //ArrayList<Organism> bros = new ArrayList<>(); bros.add(brother1);
     * bros.add(brother2); bros.add(brother3); bros.add(brother4);
     * bros.add(brother5); bros.add(brother6); bros.add(brother7);
     * Collections.shuffle(bros); } }
     */
    public static void main(String[] args) {
        int N = 20;
        Organism[][] map = new Organism[20][20];
        // Organism []map = new Organism[10];
        for (int i = 0; i < N; i++) {
            for(int j=0;j<N;j++){
                map[i][j] = new Organism();		// 创建对象
            }
		}
        //for (int i = 0; i < 10; i++) {
           // map[i] = new Organism();
        //}

        // 初始乱序的七兄弟长蛇阵
        Organism brother1 = new Organism("老大");
        Organism brother2 = new Organism("老二");
        Organism brother3 = new Organism("老三");
        Organism brother4 = new Organism("老四");
        Organism brother5 = new Organism("老五");
        Organism brother6 = new Organism("老六");
        Organism brother7 = new Organism("老七");
        ArrayList<Organism> bros = new ArrayList<>();
        bros.add(brother1);
        bros.add(brother2);
        bros.add(brother3);
        bros.add(brother4);
        bros.add(brother5);
        bros.add(brother6);
        bros.add(brother7);
        Collections.shuffle(bros);

        for(int i=1;i<=7;i++)
        {
            map[i][0] = bros.get(i-1);
        }
        // 雁行阵,七个小喽啰
        
        /*Organism badass1 = new Organism("小喽啰");
        Organism badass2 = new Organism("小喽啰");
        Organism badass3 = new Organism("小喽啰");
        Organism badass4 = new Organism("小喽啰");
        Organism badass5 = new Organism("小喽啰");
        Organism badass6 = new Organism("小喽啰");
        Organism badass7 = new Organism("小喽啰");
        */


        //这里可以根据N的大小变换，但便于设计用了具体数值
        for(int i = 10;i<16;i++)
        {
            map[17-i][i] = new Organism("小喽啰");
        }
        Organism scorpion = new Organism("蝎子精");

        map[1][16] = scorpion;
        Organism snake = new Organism("蛇精");
        //放入蛇精
        map[0][17] = snake;
        //放入老爷爷
        Organism grandpa = new Organism("老爷爷");
        map[0][0] = grandpa;


        //打印
        for(int i=0;i<19;i++)
        {
            for(int j=0;j<19;j++){
                    System.out.print(map[i][j].name + "\t");
            }
            System.out.print("\n");
        }


        for(int i = 10;i<16;i++)
        {
            map[17-i][i] = new Organism();      //清空之前的
        }
        
        map[1][16] = new Organism();
        map[0][17] = new Organism();
        //换成鹤翼阵
        for(int i=1;i<4;i++)
        {
            map[i][i+10] = new Organism("小喽啰");
        }
        map[4][14] = scorpion;
        map[5][14] = snake;
        for(int i=1;i<4;i++)
        {
            map[4-i][i+14] = new Organism("小喽啰");
        }

        for(int i=0;i<19;i++)
        {
            for(int j=0;j<19;j++){
                    System.out.print(map[i][j].name + "\t");
            }
            System.out.print("\n");
        }

    }
}