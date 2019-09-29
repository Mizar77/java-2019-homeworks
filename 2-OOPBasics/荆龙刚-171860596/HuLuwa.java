/*
    Save one HuLuwa's index in HuLubro.
    This Java Example shows one HuLuwa's index in HuLubro.
 */

public class HuLuwa
{
    //HuLuwa's No.
    private int number;
    //HuLuwa's color
    private String color;
    //HuLuwa's name
    private String name;

    //Constructor using name,color and number
    public HuLuwa(String name,String color,int number)
    {
        this.number = number;
        this.name = name;
        this.color = color;
    }

    //Default Constructor
    public HuLuwa()
    {

    }

    //Copy Constructor
    public HuLuwa(HuLuwa h)
    {
        this.color = h.color;
        this.name = h.name;
        this.number = h.number;
    }


    //Compare 2 HuLuwas' number
    public int compareTo(HuLuwa h)
    {
        if(this.number < h.number)
        {
            return -1;
        }
        else if(this.number > h.number)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

    //Copy index from another HuLuwa
    public void copyIndex(HuLuwa h)
    {
        this.color = h.color;
        this.number = h.number;
        this.name=  h.name;
    }

    //NumberOff using name
    public void numberOffName()
    {
        System.out.println(this.name);
    }

    //Numberoff using color
    public void numberOffColor()
    {
        System.out.println(this.color);
    }

    //Numberoff when Swap
    public void numberOffSwap(int ori, int cur)
    {
        System.out.print(this.name+"：");
        System.out.print(ori);
        System.out.print("->");
        System.out.print(cur);
        System.out.print("\n");
    }


    public static void  main(String[] args)
    {
        //dawa is the biggest one in HuLubro.
        HuLuwa dawa = new HuLuwa("大娃","红色",1);
        dawa.numberOffColor();
        dawa.numberOffName();
        dawa.numberOffSwap(3,4);
    }



}
