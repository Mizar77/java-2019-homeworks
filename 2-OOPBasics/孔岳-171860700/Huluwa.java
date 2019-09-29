public class Huluwa
{
    
    public static void main(String[] args)
    {
        World w=new World();
        w.Init();
        w.StandRandly();
        w.BubbleSort();
        w.StandRandly();
        w.BinarySort();
    }
}
class Huluwas
{
    int ranking;
    int position;
    String color;
    String name;
    void Exchange(int i,int j)
    {
        position=j;
        System.out.println(name+":"+i+"->"+j);
    }
    void Baoshu()
    {
        System.out.println(name+":"+name);
    }
    void Baoyanse()
    {
        System.out.println(name+":"+color);
    }
}
class World
{
    Huluwas[] members=new Huluwas[7];
    //members = new Huluwa[7];
    //members[0]= new Huluwa();
    int map[]=new int[7];
    void Init()
    {
        //members=new Huluwas[7];
        for(int i=0;i<7;i++)
        {
            members[i]=new Huluwas();
        }
        for(int i=0;i<7;i++)
        {
            map[i]=0;
            members[i].ranking=i;
        }
        members[0].color="红色";members[0].name="老大";
        members[1].color="橙色";members[1].name="老二";
        members[2].color="黄色";members[2].name="老三";
        members[3].color="绿色";members[3].name="老四";
        members[4].color="青色";members[4].name="老五";
        members[5].color="蓝色";members[5].name="老六";
        members[6].color="紫色";members[6].name="老七";
    }
    void StandRandly()
    {
        int[] sequence=new int[7];
        for(int i=0;i<7;i++)
        {
            sequence[i]=i;
        }
        //Random r=new Random();
        for(int i=0;i<7;i++)
        {
            int p=(int)(Math.random()*7);
            //System.out.println(p);
            int tmp=sequence[i];
            sequence[i]=sequence[p];
            sequence[p]=tmp;
        }
        for(int i=0;i<7;i++)
        {
            members[i].position=sequence[i];
            map[sequence[i]]=i;
            
        }
        System.out.println("随机站队后排列顺序为:");
        for(int i=0;i<7;i++)
        {
            System.out.print(members[map[i]].ranking);
        }
        System.out.println();
    }
    void BubbleSort()
    {
        System.out.println("冒泡排序:");
        for(int i=0;i<7;i++)
        {
            for(int j=0;j<6;j++)
            {
                if(map[j]>map[j+1])
                {
                    members[map[j]].Exchange(j, j+1);
                    members[map[j+1]].Exchange(j+1, j);
                    int tp=map[j];
                    map[j]=map[j+1];
                    map[j+1]=tp;
                }
            }
    
        }
        for(int i=0;i<7;i++)
        {
            members[map[i]].Baoshu();
        }
    }
    void BinarySort()
    {
        System.out.println("二分排序:");
        int begin=0,end;
        for(int i=1;i<7;i++)
        {
            //0-i
            //int now=i;
            begin=0;
            end=i-1;
            int sig=0;
            int mid=0;
            while(begin<=end){
                mid=(begin+end)/2;
                if(map[mid]>map[i])
                {
                    end=mid-1;
                    sig=0;
                }
                else
                {
                    begin=mid+1;
                    sig=1;
                }
            }
            int insert=0;
            if(sig==0)
            {
                insert=mid;
            }
            else if(sig==1)
            {
                insert=mid+1;
            }
            if(insert!=i)
            {
                members[map[i]].Exchange(i, insert);
                for(int k=insert;k<i;k++)
                {
                    members[map[k]].Exchange(k, k+1);
                }
                int tp=map[i];
                for(int k=i-1;k>=insert;k--)
                {
                    map[k+1]=map[k];
                }
                map[insert]=tp;
            }
        }
        /*if(map[1]>map[0])
        {
            members[map[1]].Exchange(1, 0);
            members[map[0]].Exchange(0, 1);
            int tp=map[0];
            map[0]=map[1];
            map[1]=tp;
        }
        if(map[2]>map[0])
        {
            if(map[2]<map[1])
            {
                members[map[1]].Exchange(1, 2);
                members[map[2]].Exchange(2, 1);
                int tp=map[2];
                map[2]=map[1];
                map[1]=tp;
            }
        }
        else
        {
            members[map[2]].Exchange(2,0);
            members[map[1]].Exchange(1, 2);
            members[map[0]].Exchange(0, 1);
            int tp=map[2];
            map[2]=map[1];
            map[1]=map[0];
            map[0]=tp;
        }*/
        //System.out.println("");
        for(int i=0;i<7;i++)
        {
            members[map[i]].Baoyanse();
        }
    }
}
