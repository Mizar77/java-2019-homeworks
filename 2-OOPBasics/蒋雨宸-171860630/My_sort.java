import java.util.*;

enum My_color{
    红色,橙色,黄色,绿色,青色,蓝色,紫色
};

enum Rank{
    老大,老二,老三,老四,老五,老六,老七
};

class Hulu_bro{
    int num;
    Hulu_bro(){
        num=0;
    }
    Hulu_bro(int n){
        num=n;
    }
    public void tell_self(){
        System.out.print(Rank.values()[num] + " ");
    }

    public void tell_col(){
        System.out.print(My_color.values()[num] + " ");
    }
}

class BroWrapper{
    Hulu_bro x;
    BroWrapper(Hulu_bro x){
        this.x=x;
    }
}


public class My_sort{

    public static void swap(BroWrapper x1,BroWrapper x2)
    {
        Hulu_bro temp=x1.x;
        x1.x=x2.x;
        x2.x=temp;
    }

    public static void bubble_sort(Hulu_bro [] array){
        for(int i = 1; i<array.length; i++){
            for(int j = 0; j<array.length-1;j++ ){
                if(array[j].num>array[j+1].num){
                    BroWrapper x1=new BroWrapper(array[j]);
                    BroWrapper x2=new BroWrapper(array[j+1]);
                    int temp = array[j+1].num;
                    System.out.println(Rank.values()[array[j].num]+":"+j+"->"+(j+1));
                    System.out.println(Rank.values()[temp]+":"+(j+1)+"->"+j);
                    swap(x1,x2);
                    array[j]=x1.x;
                    array[j+1]=x2.x;
                    
                }
            }
        }
    }

    public static void half(Hulu_bro[] array){
        for(int i=0; i<array.length; i++){
            Hulu_bro t=array[i];
            int low=0,high=i-1;
            int mid=-1;
            while(low<=high){
                mid=low+(high-low)/2;
                if(array[mid].num>t.num){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
            for(int j=i-1; j>=low;j--){
                array[j+1]=array[j];
                System.out.println(Rank.values()[array[j].num]+":"+j+"->"+(j+1));
            }
            array[low]=t;
            System.out.println(Rank.values()[t.num]+":"+i+"->"+low);
        }
    }
    public static void main(String[] args){
        Hulu_bro []bros;
        bros = new Hulu_bro[7];
        //随机分配值
        System.out.println("Random:");
        
        List list = new ArrayList();
        for(int i = 0; i < 7; i++){
            bros[i] = new Hulu_bro(i);
            list.add(bros[i]);
        }
        Collections.shuffle(list);

        Iterator it = list.iterator();
        int count=0;
        while(it.hasNext()){
            bros[count]=(Hulu_bro)it.next();
            bros[count++].tell_self();
        }
        System.out.println();
        bubble_sort(bros);
        System.out.println("bubble_sort:");
        for(int i = 0; i < 7; i++){
            bros[i].tell_self();
        }
        System.out.println();   


        System.out.println("Random:");
        it = list.iterator();
        count=0;
        while(it.hasNext()){
            bros[count]=(Hulu_bro)it.next();
            bros[count++].tell_self();
        }
        System.out.println();

        System.out.println("division:");
        half(bros);
        for(int i = 0; i < 7; i++){
            bros[i].tell_col();
        }
        System.out.println();
    }
}