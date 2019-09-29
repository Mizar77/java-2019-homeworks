import javafx.geometry.Pos;

import java.util.*;

enum Color{RED,ORANGE,YELLOW,GREEN,CYAN,BLUE,PURPLE};

public class Sorting
{/*
    public static void moveTo(int x,int xPosition)
    {
        int y=1;                //表示葫芦兄弟y轴的位置
        int lastX=x,lastY=y;    //用于每次移动之前的位置
        boolean flag=false;

        if(xPosition<x)         //如果目标排位比当前排位考前，则从队伍上方换到目的位置
            y=2;
        else if(xPosition>x)    //否则从队伍的下方换到目的位置
        {
            y = 0;
            flag = true;
        }
        else
            return;
        System.out.print("Current position:("+lastX+","+lastY+")->("+x+","+y+")");
        if(flag)
            System.out.println("\t向下走");
        else
            System.out.println("\t向上走");
        lastY=y;
        while(x!=xPosition)
        {
            if(!flag)
                x--;
            else
                x++;
            System.out.print("Current position:("+lastX+","+lastY+")->("+x+","+y+")");
            if(!flag)
                System.out.println("\t向前走");
            else
                System.out.println("\t向后走");
            lastX=x;
            lastY=y;

        }
        y=1;        //回复y轴位置，
        System.out.print("Current position:("+lastX+","+lastY+")->("+x+","+y+")");
        if(flag)
            System.out.println("\t向上走，回到队伍");
        else
            System.out.println("\t向下走，回到队伍");
    }
*/
    //get a n-size random array (min~max)
    public static int[] randomArray(int min, int max, int n){
        if (n > (max - min + 1) || max < min) {
            return null;
        }
        int[] result = new int[n];
        int count = 0;
        while(count < n) {
            int num = (int) (Math.random() * (max - min+1)) + min;
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if(num == result[j]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                result[count] = num;
                count++;
            }
        }
        for(int i=0;i<n;i++)
            result[i]--;
        return result;
    }

    //BubbleSort
    public static void bubbleSort(CalabashBrother[] bros)
    {
        for(int i=0;i<bros.length-1;i++)
        {
            for (int j = i + 1; j < bros.length; j++)
            {
                if (bros[i].getColor().ordinal() > bros[j].getColor().ordinal() )
                //if (bros[i].getPosition() > bros[j].getPosition() )
                {
                    CalabashBrother tmp = bros[i];
                    bros[i] = bros[j];
                    bros[j] = tmp;
                    System.out.println();
                    System.out.println(bros[i].getRank()+" and "+bros[j].getRank()+" move at the same time.");
                    System.out.println(bros[i].getRank()+":"+j+"->"+i);
                    bros[i].getPos().moveTo(j,i,bros[i].getRank());
                    System.out.println(bros[j].getRank()+":"+i+"->"+j);
                    bros[j].getPos().moveTo(i,j,bros[i].getRank());
                }
            }
        }
        for(CalabashBrother tmp:bros)
        {
            System.out.print(tmp.getRank()+"\t");
        }
        System.out.println();
    }

    public static int partition(CalabashBrother[] bros,int begin,int end)
    {
        CalabashBrother tmp=bros[begin];
        int i=begin,j=end;
        while(i<j)
        {
            while((i<j)&&(bros[j].getColor().ordinal()>=tmp.getColor().ordinal()))   j--;
            if(i<j)
            {
                System.out.println();
                System.out.println(bros[i].getRank()+" and "+bros[j].getRank()+" move at the same time.");
                System.out.println(bros[i].getRank()+":"+i+"->"+j);
                bros[i].getPos().moveTo(i,j,bros[i].getRank());
                System.out.println(bros[j].getRank()+":"+j+"->"+i);
                bros[i].getPos().moveTo(j,i,bros[i].getRank());
                bros[i] = bros[j];
            }
            while((i<j)&&(bros[i].getColor().ordinal()<=tmp.getColor().ordinal()))   i++;
            if(i<j)
            {
                System.out.println();
                System.out.println(bros[i].getRank()+" and "+bros[j].getRank()+" move at the same time.");
                System.out.println(bros[i].getRank()+":"+i+"->"+j);
                bros[i].getPos().moveTo(i,j,bros[i].getRank());
                System.out.println(bros[j].getRank()+":"+j+"->"+i);
                bros[i].getPos().moveTo(j,i,bros[i].getRank());
                bros[j] = bros[i];
            }
        }
        bros[i]=tmp;
        return i;
    }

    public static void binarySort(CalabashBrother[] bros,int begin,int end)
    {
        if(bros==null||begin>=end||bros.length<1)
            return;
        if(begin<end)
        {
            int mid = partition(bros, begin, end);
            binarySort(bros, begin, mid - 1);
            binarySort(bros, mid + 1, end);
        }
    }

    public static void main(String[] args) {
        CalabashBrother[] bros = new CalabashBrother[7];
        int[] randomPos = randomArray(0, 7, 7);

/*print for testing
        for (int i : randomPos)
            System.out.print(i + "\t");
        System.out.println();
*/
        bros[randomPos[0]] = new CalabashBrother("RED","老大",new Position(randomPos[0],1));
        bros[randomPos[1]] = new CalabashBrother("ORANGE", "老二",new Position(randomPos[1],1));
        bros[randomPos[2]] = new CalabashBrother("YELLOW", "老三",new Position(randomPos[2],1));
        bros[randomPos[3]] = new CalabashBrother("GREEN", "老四",new Position(randomPos[3],1));
        bros[randomPos[4]] = new CalabashBrother("CYAN", "老五",new Position(randomPos[4],1));
        bros[randomPos[5]] = new CalabashBrother("BLUE", "老六",new Position(randomPos[5],1));
        bros[randomPos[6]] = new CalabashBrother("PURPLE", "老七",new Position(randomPos[6],1));

        System.out.println("Bubble sort:");
        bubbleSort(bros);
        System.out.println();

        bros[randomPos[0]] = new CalabashBrother("RED","老大","红色",new Position(randomPos[0],1));
        bros[randomPos[1]] = new CalabashBrother("ORANGE", "老二","橙色",new Position(randomPos[1],1));
        bros[randomPos[2]] = new CalabashBrother("YELLOW", "老三","黄色",new Position(randomPos[2],1));
        bros[randomPos[3]] = new CalabashBrother("GREEN", "老四","绿色",new Position(randomPos[3],1));
        bros[randomPos[4]] = new CalabashBrother("CYAN", "老五","青色",new Position(randomPos[4],1));
        bros[randomPos[5]] = new CalabashBrother("BLUE", "老六","蓝色",new Position(randomPos[5],1));
        bros[randomPos[6]] = new CalabashBrother("PURPLE", "老七","紫色",new Position(randomPos[6],1));

/*print for testing
        for (int i : randomPos)
            System.out.print(i + "\t");
        System.out.println();
*/

        System.out.println("Binary sort:");
        binarySort(bros,0,bros.length-1);
        for(CalabashBrother tmp:bros)
        {
            System.out.print(tmp.getColorName()+"\t");
        }
        System.out.println();
    }
}

class Position
{
    private int x;
    private int y=1;

    public Position(int xPosition,int yPosition)
    {
        x=xPosition;
        y=yPosition;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void moveTo(int x, int xPosition,String name)
    {
        int lastX=x,lastY=y;    //用于每次移动之前的位置
        boolean flag=false;

        if(xPosition<x)         //如果目标排位比当前排位考前，则从队伍上方换到目的位置
            y=2;
        else if(xPosition>x)    //否则从队伍的下方换到目的位置
        {
            y = 0;
            flag = true;
        }
        else
            return;

        System.out.print(name+"'s current position:("+lastX+","+lastY+")->("+x+","+y+")");
        if(flag)
            System.out.println("\t向下走");
        else
            System.out.println("\t向上走");
        lastY=y;

        while(x!=xPosition)
        {
            if(!flag)
                x--;
            else
                x++;
            System.out.print(name+"'s current position:("+lastX+","+lastY+")->("+x+","+y+")");
            if(!flag)
                System.out.println("\t向前走");
            else
                System.out.println("\t向后走");
            lastX=x;
            lastY=y;
        }
        y=1;        //回复y轴位置，葫芦兄弟回到队伍
        System.out.print(name+"'s current position:("+lastX+","+lastY+")->("+x+","+y+")");
        if(flag)
            System.out.println("\t向上走，回到队伍");
        else
            System.out.println("\t向下走，回到队伍");
    }
}


class CalabashBrother
{
    private Color color;
    private String rank;
    private String colorName;
    Position pos;

    public CalabashBrother(String col,String name)
    {
        color=Enum.valueOf(Color.class,col);
        rank=name;
    }
    public CalabashBrother(String col,String name,Position pos)
    {
        color=Enum.valueOf(Color.class,col);
        rank=name;
        this.pos=pos;
    }
    public CalabashBrother(String col,String name,String colorname)
    {
        color=Enum.valueOf(Color.class,col);
        rank=name;
        colorName=colorname;
    }
    public CalabashBrother(String col, String name, String colorname, Position pos)
    {
        color=Enum.valueOf(Color.class,col);
        rank=name;
        colorName=colorname;
        this.pos=pos;
    }
    String getRank()
    {
        return rank;
    }
    Color getColor()
    {
        return color;
    }
    String getColorName()
    {
        return colorName;
    }

    public Position getPos() {
        return pos;
    }
}