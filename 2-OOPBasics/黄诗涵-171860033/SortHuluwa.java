import java.util.Random;
import java.util.Vector;
class Huluwa {
    protected static Random rand = new Random();
    protected String rank;
    protected String color;
    protected int num;
    protected int mypos;//记录自己的位置
    public Huluwa() { }
    public void swap(int j,Huluwa[] vine)
    {
        int i=mypos;
        if(i==j)
            return;
        Huluwa temp = vine[i];
        vine[i]=vine[j];
        vine[j] = temp;
        int tmp2=vine[i].mypos;
        vine[i].mypos=vine[j].mypos;
        vine[j].mypos=tmp2;
    }

    public void exchangeSeat(Huluwa[] vine)
    {
        int num=rand.nextInt(7);
        if(num!=mypos)
            System.out.printf("%s:exchange position with %s.\n",this.rank,vine[num].rank);
        else
            System.out.printf("%s:I don't change position.\n",rank);
        swap(num,vine);
    }
    public int getnum()
    {
        return num;
    }
    public String getRank()
    {
        return rank;
    }
    public String getColor()
    {
        return color;
    }
}
class Red extends Huluwa{
    public Red(int i){
        rank="老大";
        color="红";
        num=1;
        mypos=i-1;
    }
}
class Orange extends Huluwa{
    public Orange(int i){
        rank="老二";
        color="橙";
        num=2;
        mypos=i-1;
    }
}
class Yellow extends Huluwa{
    public Yellow(int i){
        rank="老三";
        color="黄";
        num=3;
        mypos=i-1;
    }
}
class Green extends Huluwa{
    public Green(int i){
        rank="老四";
        color="绿";
        num=4;
        mypos=i-1;
    }
}
class Indigo extends Huluwa{
    public Indigo(int i){
        rank="老五";
        color="青";
        num=5;
        mypos=i-1;
    }
}
class Blue extends Huluwa{
    public Blue(int i){
        rank="老六";
        color="蓝";
        num=6;
        mypos=i-1;
    }
}
class Purple extends Huluwa{
    public Purple(int i){
        rank="老七";
        color="紫";
        num=7;
        mypos=i-1;
    }
}
public class SortHuluwa{
    // private static Random rand = new Random();
    public static void random(Huluwa [] vine)
    {
        for (int i=1;i<=7;i++)
        {
            for (int j = 0; j < 7; j++)
            {
                if(vine[j].getnum()==i)
                {
                    vine[j].exchangeSeat(vine);//each huluwa chooses a pos
                    break;
                }
            }
        }
    }
    public static void swap(Huluwa[] vine, int i, int j) {
        vine[i].swap(j,vine);
    }
    public static void reportRank(Huluwa []vine)
    {
        int i=0;
        for(;i<vine.length-1;i++)
            System.out.printf("%s ",vine[i].getRank());
        System.out.printf("%s\n",vine[i].getRank());
    }
    public static void reportColor(Huluwa []vine)
    {
        int i=0;
        for(;i<vine.length-1;i++)
            System.out.printf("%s ",vine[i].getColor());
        System.out.printf("%s\n",vine[i].getColor());
    }
    public static void bubbleSort(Huluwa[] vine) {
        int last=vine.length-1;

        for(int i=0;i<vine.length-1;i++)
        {
            boolean ifex=false;
            int tmp=0;
            for(int j=0;j<last;j++)
            {
                if(vine[j].getnum()>vine[j+1].getnum()) {
                    System.out.printf("%s:%d->%d\n",vine[j].getRank(),j,j+1);
                    System.out.printf("%s:%d->%d\n\n",vine[j+1].getRank(),j+1,j);
                    swap(vine,j,j+1);
                    tmp=j;
                    ifex=true;
                }
            }

            if(!ifex)
                return;
            last=tmp;
        }
    }
    public static void dichotomySort(Huluwa[] vine) {
        for(int i=0;i<vine.length;i++)
        {
            int left=0,right=i-1;
            Huluwa tmp=vine[i];
            while(left<=right)
            {
                int mid=(left+right)/2;
                if(vine[mid].getnum()>tmp.getnum())
                    right=mid-1;
                else
                    left=mid+1;
            }
            System.out.printf("\n");
            System.out.printf("%s:leave the vine from %d.\n",tmp.getRank(),i);
            for(int j=i;j>left;j--)
            {
                System.out.printf("%s:%d->%d\n",vine[j-1].getRank(),j-1,j);
                vine[j].swap(j-1,vine);
            }
            System.out.printf("%s:ground->%d\n",tmp.getRank(),left);
            if(left!=i)
                vine[left]=tmp;

        }
    }

    public static void main(String[] args) {
        Huluwa vine[]=new Huluwa[7];
        vine[0]=new Red(1);
        vine[1]=new Orange(2);
        vine[2]=new Yellow(3);
        vine[3]=new Green(4);
        vine[4]=new Indigo(5);
        vine[5]=new Blue(6);
        vine[6]=new Purple(7);
        System.out.printf("random: \n");
        random(vine);
        reportRank(vine);
        System.out.printf("bubbleSort: \n");
        bubbleSort(vine);
        System.out.printf("报数： ");
        reportRank(vine);

        System.out.printf("\nrandom: \n");
        random(vine);
        reportColor(vine);
        System.out.printf("dichotomySort: ");
        dichotomySort(vine);
        System.out.printf("报颜色： ");
        reportColor(vine);

    }

}
