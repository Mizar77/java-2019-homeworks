/*
    This Java Example shows how to sort HuLubro and let them numberoff.
 */
public class HuLuBro
{
    //Save every HuLuwas' index as an array
    private HuLuwa[] hulubro;

    //Default Constructor
    public HuLuBro()
    {

    }

    //Constructor using names,colors and numbers
    public HuLuBro(String[] namelist,String[] colorlist,int[] numberlist)
    {
        hulubro = new HuLuwa[7];
        for (int i =namelist.length -1,j = 0 ;i >= 0;i--,j++)
        {
            this.hulubro[j] = new HuLuwa(namelist[i],colorlist[i],numberlist[i]);
        }
    }

    //
    public static void main(String[] args)
    {
        String[] namelist = new String[]{"大娃","二娃","三娃","四娃","五娃","六娃","七娃"};
        String[] colorlist = new String[]{"红色","橙色","黄色","绿色","青色","蓝色","紫色"};
        int[] numberlist = new int[]{1,2,3,4,5,6,7};
        HuLuBro hulubro = new HuLuBro(namelist,colorlist,numberlist);
        hulubro.randomArray();
        hulubro.bubbleSort();
        System.out.println("-------------------------------------");
        hulubro.randomArray();
        hulubro.binarySort();

    }

    //Let HuLubro stand in a random list
    public void randomArray()
    {
        for (int i = 0; i < this.hulubro.length ; i++ )
        {
            for (int j = i + 1; j< this.hulubro.length; j++)
            {
                if(this.hulubro[i].compareTo(this.hulubro[j]) <= 0)
                {
                    this.swapPos(i,j);
                    this.hulubro[i].numberOffSwap(j+1,i+1);
                    this.hulubro[j].numberOffSwap(i+1,j+1);
                }
            }
        }
    }

    //sort HuLubro using BubbleSort by number and let them numberoff.
    public void bubbleSort()
    {
        for (int i = 0; i < this.hulubro.length ; i++ )
        {
            for (int j = i + 1; j< this.hulubro.length; j++)
            {
                if(this.hulubro[i].compareTo(this.hulubro[j]) > 0)
                {
                    this.swapPos(i,j);
                    this.hulubro[i].numberOffSwap(j,i);
                    this.hulubro[j].numberOffSwap(i,j);
                }
            }
        }
        for(int i = 0;i<this.hulubro.length;i++)
        {
            this.hulubro[i].numberOffName();
        }
    }

    //sort HuLubro using BinarySort by color and let them numberoff.
    public void binarySort()
    {
        int i,j;
        int high,low,mid;
        //temp HuLuwa when insert
        HuLuwa temp = new HuLuwa();
        for ( i = 1;i < this.hulubro.length;i++)
        {
            low = 0;
            high = i-1;
            temp.copyIndex(this.hulubro[i]);
            //find temp HuLuwa's insert position
            while(low <= high)
            {
                mid = (low+high)/2;
                if(temp.compareTo(this.hulubro[mid]) < 0)
                {
                    high = mid-1;
                }
                else
                {
                    low = mid + 1;
                }
            }
            //move another HuLuwa and insert temp HuLuwa
            for(j = i-1;j >= low;j--)
            {
                this.hulubro[j+1].copyIndex(this.hulubro[j]);
                this.hulubro[j+1].numberOffSwap(j,j+1);
            }

            this.hulubro[low].copyIndex(temp);
            this.hulubro[low].numberOffSwap(i,low);
        }


        for (i =  0;i<this.hulubro.length;i++)
        {
            this.hulubro[i].numberOffColor();
        }
    }

    //swap 2 HuLuwas' position in HuLubro's list
    private void swapPos(int pre,int bak)
    {
        HuLuwa temp = new HuLuwa(this.hulubro[pre]);
        this.hulubro[pre].copyIndex(this.hulubro[bak]);
        this.hulubro[bak].copyIndex(temp);
    }

}
