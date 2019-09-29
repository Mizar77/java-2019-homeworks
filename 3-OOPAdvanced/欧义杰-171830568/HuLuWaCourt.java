import java.util.*;
public class HuLuWaCourt {
    
    public static void main(String[] args) throws Exception {
        System.out.println("H1-H7:大娃-七娃 Y:爷爷 X：蝎子精 L1-L8：小喽啰 S：蛇精，左半边为葫芦娃阵营，右半边为蝎子精蛇精阵营");
        CreatureControl creacon = new CreatureControl();
        creacon.initCreatures();
        for(int i = 0;i < CtName.getNameNum();i++)
            creacon.shufflePlace(i);
        System.out.println("初始两方乱序：");
        creacon.prin();
        creacon.sortHuPlace(0);
        creacon.sortOppoPlace(0);
        System.out.println("两方摆阵，爷爷、蝎子精随机分处于左、右边：");
        System.out.println("左方长蛇阵，右方冲轭阵：");
        creacon.prin();
        System.out.println("右方换鹤翼阵，蛇精位置再次随机：");
        creacon.sortOppoPlace(1);
        creacon.prin();
    }
}
enum CtName
{
    HULUWA,YEYE,XIEZI,SHEJING,LOULUO;
    static int namenum = 5;
    public static int getNameNum()
    {
        return namenum;
    }
}
class CreatureControl
{
    CreatureVec[] creavecs = new CreatureVec[CtName.namenum];
    static final int mapx = 10;
    static final int mapy = 10;
    static final int louluonum = 8;
    static Random rand = new Random();
    char[][]chmap = new char[mapx][mapy];
    int [][]idmap = new int[mapx][mapy];
    CreatureControl()
    {
        for(int i = 0;i < mapx;i++)
            for(int j = 0;j < mapy;j++)
            {
                chmap[i][j] = 'O';
                idmap[i][j] = -1;
            }
        for(int i = 0;i < CtName.getNameNum();i++)
            creavecs[i] = new CreatureVec();
    }
    public void addEle(CtName ctname,String name,int x,int y)
    {
        switch(ctname)
        {
            case HULUWA:
                creavecs[ctname.ordinal()].addEle(new HuLuWa(name,x,y));
                break;
            case YEYE:
                creavecs[ctname.ordinal()].addEle(new YeYe(name,x,y));
                break;
            case XIEZI:
                creavecs[ctname.ordinal()].addEle(new XieZi(name,x,y));
                break;
            case SHEJING:
                creavecs[ctname.ordinal()].addEle(new SheJing(name,x,y));
                break;
            case LOULUO:
                creavecs[ctname.ordinal()].addEle(new LouLuo(name,x,y));
                break;
        }
    }
    public void initCreatures()
    {
        addEle(CtName.HULUWA,"大娃",-1,-1);
        addEle(CtName.HULUWA,"二娃",-1,-1);
        addEle(CtName.HULUWA,"三娃",-1,-1);
        addEle(CtName.HULUWA,"四娃",-1,-1);
        addEle(CtName.HULUWA,"五娃",-1,-1);
        addEle(CtName.HULUWA,"六娃",-1,-1);
        addEle(CtName.HULUWA,"七娃",-1,-1);
        addEle(CtName.YEYE,"爷爷",-1,-1);
        addEle(CtName.XIEZI,"蝎子精",-1,-1);
        addEle(CtName.SHEJING,"蛇精",-1,-1);
        for(int i = 0;i < louluonum;i++)
            addEle(CtName.LOULUO,"喽啰",-1,-1);
    }
    public void shufflePlace(int nameord)
    {
        Enumeration<Creature>  e = creavecs[nameord].creavec.elements();
             while(e.hasMoreElements())
            {
                Creature temp = e.nextElement();
                int setx = 0;
                int sety = 0;
                int motox = temp.getx();
                int motoy = temp.gety();
                if(temp.getgrbool())
                {
                    do
                    {
                       setx = rand.nextInt(mapx);
                       sety = rand.nextInt(mapy/2);
                    }while(chmap[setx][sety] != 'O');
                    if(motox != -1 && motoy != -1)
                    {
                        chmap[motox][motoy] = 'O';
                        idmap[motox][motoy] = -1;
                    }
                    chmap[setx][sety] = temp.getsk();
                    idmap[setx][sety] = temp.getid();
                    temp.setPlace(setx, sety);
                }
                else 
                {
                    do
                    {
                       setx = rand.nextInt(mapx);
                       sety = rand.nextInt(mapy/2) + mapy/2;
                    }while(chmap[setx][sety] != 'O');
                    if(motox != -1 && motoy != -1)
                    {
                        chmap[motox][motoy] = 'O';
                        idmap[motox][motoy] = -1;
                    }
                    chmap[setx][sety] = temp.getsk();
                    idmap[setx][sety] = temp.getid();
                    temp.setPlace(setx, sety);
                }
            }
    }
    public void clearupPlace(int nameord)
    {
        Enumeration<Creature>  e = creavecs[nameord].creavec.elements();
        while(e.hasMoreElements())
       {
           Creature temp = e.nextElement();
           int motox = temp.getx();
           int motoy = temp.gety();
            if(motox != -1 && motoy != -1)
            {
                    chmap[motox][motoy] = 'O';
                    idmap[motox][motoy] = -1;
            }
            temp.setPlace(-1,1);
       }
    }
    public void sortHuPlace(int mode)
    {
        clearupPlace(CtName.HULUWA.ordinal());
        clearupPlace(CtName.YEYE.ordinal());
        Enumeration<Creature>  e = creavecs[CtName.HULUWA.ordinal()].creavec.elements();
        switch(mode)
        {
        case 0://snake
                int i = 0;
                while(e.hasMoreElements())
                {
                   Creature temp = e.nextElement();
                   if(i < mapx)
                   {
                        temp.setPlace(i,0);
                        chmap[i][0] = temp.getsk();
                        idmap[i][0] = temp.getid();
                        i++;
                   }
                   else
                        break;

                }
        break;

        default:break;
        }
          
         
    
          
        shufflePlace(CtName.YEYE.ordinal());
    }
    public void sortOppoPlace(int mode)
    {
        clearupPlace(CtName.SHEJING.ordinal());
        clearupPlace(CtName.XIEZI.ordinal());
        clearupPlace(CtName.LOULUO.ordinal());
        Enumeration<Creature>  e1 = creavecs[CtName.LOULUO.ordinal()].creavec.elements();
        Enumeration<Creature>  e2 = creavecs[CtName.XIEZI.ordinal()].creavec.elements();
        Creature Xie = e2.nextElement();
        switch(mode)
        {
        case 0://chong
            int i = 1;
            char flg = 'F';
            while(e1.hasMoreElements())
            {
                Creature temp = e1.nextElement();
                if(i < mapx && flg == 'F')
                {
                    temp.setPlace(i,mapy-2);
                    chmap[i][mapy-2] = temp.getsk();
                    idmap[i][mapy-2] = temp.getid();
                    flg = 'T';
                }
                else if(i < mapx && flg == 'T')
                {
                    temp.setPlace(i,mapy-1);
                    chmap[i][mapy-1] = temp.getsk();
                    idmap[i][mapy-1] = temp.getid();
                    flg = 'F';
                }
                else
                {
                    break;
                }
                i++;
            }
            Xie.setPlace(0, mapy-1);
            chmap[0][mapy-1] = Xie.getsk();
            idmap[0][mapy-1] = Xie.getid();
            break;
        case 1://heyi
            int cenx = mapx/2;
            int ceny = mapy/2;
            Xie.setPlace(cenx, ceny);
            chmap[cenx][ceny] = Xie.getsk();
            idmap[cenx][ceny] = Xie.getid();
            int ord = 0;
            while(ord < louluonum/2 && cenx > 0 && ceny < mapy)
            {
                Creature temp = e1.nextElement();
                cenx--;
                ceny++;
                temp.setPlace(cenx,ceny);
                chmap[cenx][ceny] = temp.getsk();
                idmap[cenx][ceny] = temp.getid();
                ord++;
            }
            cenx = mapx/2;
            ceny = mapy/2;
            while(ord < louluonum && cenx < mapx && ceny < mapy)
            {
                Creature temp = e1.nextElement();
                cenx++;
                ceny++;
                temp.setPlace(cenx,ceny);
                chmap[cenx][ceny] = temp.getsk();
                idmap[cenx][ceny] = temp.getid();
                ord++;
            }
        break;
        default:break;
        } 
        shufflePlace(CtName.SHEJING.ordinal());    
    }
    public void prin()
    {
        for(int i = 0;i < mapx;i++)
        {
            for(int j = 0;j < mapy;j++)
            {
                if(chmap[i][j] == 'H' || chmap[i][j] == 'L')
                    System.out.print("" + chmap[i][j] + idmap[i][j] + " ");
                else
                    System.out.print(chmap[i][j] + "  ");
                if(j == mapy/2 - 1)
                    System.out.print(" ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }
    
}
class CreatureVec
{
    Vector<Creature> creavec;
    CreatureVec()
    {
        creavec = new Vector<Creature>();
    }
    public void addEle(Creature x)
    {
        creavec.addElement(x);
    }
    public int leng()
    {
        return creavec.size();
    }

}
abstract class Creature //base individual
{
    Creature(String initname,int initx,int inity)
    {
        name = initname;
        placex = initx;
        placey = inity;
    }
    abstract public void setPlace(int x,int y);
    abstract public char getsk();
    abstract public int getnum();
    abstract public boolean getgrbool();
    abstract public int getid();
    abstract public int getx();
    abstract public int gety();
    String name;
    int id;
    int placex;
    int placey;
}
class HuLuWa extends Creature
{
    static char skin;
    static int num;
    static boolean groupbool;
    static
    {
        num = 0;
        skin = 'H';
        groupbool = true;
    }
    HuLuWa(String initname,int initx,int inity)
    {
        super(initname,initx,inity);
        num++;
        id = num;
    }
    public void setPlace(int x,int y)
    {
        placex = x;
        placey = y;
    }
    public char getsk() {return skin;}
    public int getnum()  {return num;}
    public boolean getgrbool()  {return groupbool;}
    public int getid(){return id;}
    public int getx(){return placex;}
    public int gety(){return placey;}
}
class YeYe extends Creature
{
    static char skin;
    static int num;
    static boolean groupbool;
    static
    {
        num = 0;
        skin = 'Y';
        groupbool = true;
    }
    YeYe(String initname,int initx,int inity)
    {
        super(initname,initx,inity);
        num++;
        id = num;
    }
    public void setPlace(int x,int y)
    {
        placex = x;
        placey = y;
    }
    public char getsk() {return skin;}
    public int getnum()  {return num;}
    public boolean getgrbool()  {return groupbool;}
    public int getid(){return id;}
    public int getx(){return placex;}
    public int gety(){return placey;}
}
class XieZi extends Creature
{
    static char skin;
    static int num;
    static boolean groupbool;
    static
    {
        num = 0;
        skin = 'X';
        groupbool = false;
    }
    XieZi(String initname,int initx,int inity)
    {
        super(initname,initx,inity);
        num++;
        id = num;
    }
    public void setPlace(int x,int y)
    {
        placex = x;
        placey = y;
    }
    public char getsk() {return skin;}
    public int getnum()  {return num;}
    public boolean getgrbool()  {return groupbool;}
    public int getid(){return id;}
    public int getx(){return placex;}
    public int gety(){return placey;}
}
class SheJing extends Creature
{
    static char skin;
    static int num;
    static boolean groupbool;
    static
    {
        num = 0;
        skin = 'S';
        groupbool = false;
    }
    SheJing(String initname,int initx,int inity)
    {
        super(initname,initx,inity);
        num++;
        id = num;
    }
    public void setPlace(int x,int y)
    {
        placex = x;
        placey = y;
    }
    public char getsk() {return skin;}
    public int getnum()  {return num;}
    public boolean getgrbool()  {return groupbool;}
    public int getid(){return id;}
    public int getx(){return placex;}
    public int gety(){return placey;}
}
class LouLuo extends Creature
{
    static char skin;
    static int num;
    static boolean groupbool;
    static
    {
        num = 0;
        skin = 'L';
        groupbool = false;
    }
    LouLuo(String initname,int initx,int inity)
    {
        super(initname,initx,inity);
        num++;
        id = num;
    }
    public void setPlace(int x,int y)
    {
        placex = x;
        placey = y;
    }
    public char getsk() {return skin;}
    public int getnum()  {return num;}
    public boolean getgrbool()  {return groupbool;}
    public int getid(){return id;}
    public int getx(){return placex;}
    public int gety(){return placey;}
}
