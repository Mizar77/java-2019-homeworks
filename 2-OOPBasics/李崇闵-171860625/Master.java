public class Master {
    Hulu []members;
    int []Pos;
    void initialize(){
        members=new Hulu[7];
        Pos=new int[7];
        members[0]=new Hulu();
        members[0].name="老大";
        members[0].age=0;
        members[0].color="红色";
        members[0].Color=0;
        members[1]=new Hulu();
        members[1].name="老二";
        members[1].age=1;
        members[1].color="橙色";
        members[1].Color=1;
        members[2]=new Hulu();
        members[2].name="老三";
        members[2].age=2;
        members[2].color="黄色";
        members[2].Color=2;
        members[3]=new Hulu();
        members[3].name="老四";
        members[3].age=3;
        members[3].color="绿色";
        members[3].Color=3;
        members[4]=new Hulu();
        members[4].name="老五";
        members[4].age=4;
        members[4].color="青色";
        members[4].Color=4;
        members[5]=new Hulu();
        members[5].name="老六";
        members[5].age=5;
        members[5].color="蓝色";
        members[5].Color=5;
        members[6]=new Hulu();
        members[6].name="老七";
        members[6].age=6;
        members[6].color="紫色";
        members[6].Color=6;
    }
    void random_queue()
    {
        members[0].pos=3;
        Pos[3]=0;
        members[1].pos=5;
        Pos[5]=1;
        members[2].pos=2;
        Pos[2]=2;
        members[3].pos=6;
        Pos[6]=3;
        members[4].pos=1;
        Pos[1]=4;
        members[5].pos=0;
        Pos[0]=5;
        members[6].pos=4;
        Pos[4]=6;
    }
    void Bubble_Sort()
    {

        for(int i=0;i<7;i++)
        {

        }
        for(int i=7;i>1;i--)
        {
            for(int j=0;j<i-1;j++)
            {
                if(members[Pos[j]].age>members[Pos[j+1]].age)
                {

                    members[Pos[j]].report1(members[Pos[j+1]].pos);
                    members[Pos[j+1]].report1(members[Pos[j]].pos);
                    int temp=members[Pos[j]].pos;
                    members[Pos[j]].pos=members[Pos[j+1]].pos;
                    members[Pos[j+1]].pos=temp;
                    temp=Pos[j];
                    Pos[j]=Pos[j+1];
                    Pos[j+1]=temp;
                }
            }
        }
        for(int i=0;i<7;i++)
            System.out.println(members[Pos[i]].name);
    }
    void Binary_sort()
    {
        int left;
        int right;
        int mid;
        int num;
       for(int i=0;i<7;i++)
       {
            left=0;
            right=i-1;
            num=members[Pos[i]].Color;
            while(right>=left)
            {
                mid=(left+right)/2;
                if(num>members[Pos[mid]].Color)
                    left=mid+1;
                else
                    right=mid-1;
            }
            for(int j=i-1;j>=left;j--)
            {
                members[Pos[j]].report2(j+1);
                members[Pos[j]].pos=j+1;

                Pos[j+1]=Pos[j];

            }

            Pos[left]=num;
            members[Pos[left]].report2(left);
            members[Pos[left]].pos=left;
       }
        for(int i=0;i<7;i++)
            System.out.println(members[Pos[i]].color);
    }

    public static void main(String args[]){
        Master master=new Master();
        master.initialize();

        master.random_queue();
        master.Bubble_Sort();

        master.random_queue();
        master.Binary_sort();

    }

}
