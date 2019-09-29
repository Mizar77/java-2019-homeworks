class Huluwa{
    int rank;
    String name;
    String color;
    Huluwa(int rank,String name,String color){
        this.name=name;
        this.rank=rank;
        this.color=color;
    }
    public void tellChange(int place,int changeplace){
        System.out.println(name+':'+(place+1)+"->"+(changeplace+1));
    }
}

public class HuluwaSort {
    static Huluwa[] queue;
    static Huluwa red,orange,yellow,green,cyan,blue,purple;
    public static void giveBirth(){
        queue=new Huluwa[7];
        red=new Huluwa(1,"老大","红色");
        orange=new Huluwa(2,"老二","橙色");
        yellow=new Huluwa(3,"老三","黄色");
        green=new Huluwa(4,"老四","绿色");
        cyan=new Huluwa(5,"老五","青色");
        blue=new Huluwa(6,"老六","蓝色");
        purple=new Huluwa(7,"老七","紫色");
    }
    public static void randomQueue(){
        boolean flag;
        for (int i=0;i<queue.length;i++){
            flag=false;
            while(flag==false) {
                int rand = (int) Math.round(Math.random() * 6 + 1);
                for (int j = 0; j < i; j++) {
                    if (queue[j].rank == rand) {
                        flag = true;
                        break;
                    }
                }
                if (flag==true)flag=false;
                else{
                    switch(rand) {
                        case 1:
                            queue[i]=red;break;
                        case 2:
                            queue[i]=orange;break;
                        case 3:
                            queue[i]=yellow;break;
                        case 4:
                            queue[i]=green;break;
                        case 5:
                            queue[i]=cyan;break;
                        case 6:
                            queue[i]=blue;break;
                        case 7:
                            queue[i]=purple;break;
                    }
                    flag=true;
                }
            }
        }
    }
    public static void bubbleSort(){
        System.out.println();
        for (int i=0;i<queue.length-1;i++) {
            for (int j = 0; j < queue.length - i - 1; j++) {
                if (queue[j].rank > queue[j + 1].rank) {
                    queue[j].tellChange(j,j+1);
                    queue[j + 1].tellChange(j+1,j);
                    Huluwa temp = queue[j];
                    queue[j] = queue[j + 1];
                    queue[j + 1] = temp;
                }
            }
        }
        for (int i=0;i<queue.length;i++)
            System.out.print(queue[i].name+' ');
        System.out.println();
    }
    public static int binarySearch(int start,int end,int val){
        int mid=-1;
        while(start<=end){
            mid=(start+end)/2;
            if (queue[mid].rank<val)
                start=mid+1;
            else if(queue[mid].rank>val)
                end=mid-1;
            else break;
        }
        if (queue[mid].rank<val)return mid+1;
        else if (queue[mid].rank>val) return mid;
        return mid+1;
    }
    public static void binarySort(int start, int end){
        System.out.println();
        for (int i=start+1;i<=end;i++) {
            int val = queue[i].rank;
            Huluwa temp=queue[i];
            int location=binarySearch(start,i-1,val);
            for (int j=i;j>location;j--){
                queue[j-1].tellChange(j-1,j);
                queue[j]=queue[j-1];
            }
            temp.tellChange(i,location);
            queue[location]=temp;
        }
        for (int i=0;i<queue.length;i++)
            System.out.print(queue[i].color+' ');
        System.out.println();
    }
    public static void main(String args[]){
        giveBirth();
        randomQueue();
        bubbleSort();
        randomQueue();
        binarySort(0,queue.length-1);
    }
}
