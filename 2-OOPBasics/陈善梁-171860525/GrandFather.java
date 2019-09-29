import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class GrandFather {
    private Huluwa []huluwas;//huluwas are grandfather's field

    public GrandFather(Huluwa[]huluwas){
        this.huluwas=huluwas;
    }

    public void bubbleSort(){
        for(int i=huluwas.length-1;i>=1;--i){//put ith huluwa in the right place
            for(int j=0;j<i;++j){
                if(huluwas[j+1].compareTo(huluwas[j])<0){
                    //j+1 < j
                    Huluwa temp=huluwas[j];
                    huluwas[j+1].descMove(j+1,j);
                    huluwas[j]=huluwas[j+1];
                    temp.descMove(j,j+1);
                    huluwas[j+1]=temp;

                    System.out.print("当前结果:");
                    showAllName();//展示每一步的结果
//                    System.out.println("");
                }
            }
        }
        System.out.println("");
    }

    public int findPlace(ArrayList<Huluwa>list,int start,int end,Huluwa h){
        //[start,end] is sorted,insert h into it,find where it should be
        int left=start;
        int right=end;
        int mid=(left+right)/2;
        while(left<=right){
            mid=(left+right)/2;
            if(list.get(mid).compareTo(h)==0){
                //equals,insert h in mid position
                return mid+1;
            }
            else if(list.get(mid).compareTo(h)>0){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return left;
    }

    public  void binarySort(){
        ArrayList<Huluwa>list=new ArrayList<>(Arrays.asList(huluwas));
        for(int i=1;i<list.size();++i){
            //put the ith element in the right place
            //find right place in 0~i
            Huluwa h=list.get(i);
            int putIndex=findPlace(list,0,i-1,h);
            if(putIndex!=i){
                for(int j=putIndex;j<=i-1;++j){
                    list.get(j).descMove(j,j+1);//putindex后的葫芦娃每个都后退一步
                }
                h.descMove(i,putIndex);//腾出了位置

                list.remove(i);
                list.add(putIndex,h);

                System.out.print("当前结果:");
                for(Huluwa huluwa:list){
                    huluwa.descName();
                }
                System.out.println("");
            }
        }
        System.arraycopy(list.toArray(),0,huluwas,0,huluwas.length);
        System.out.println("");
    }

    public void shuffle(){
        ArrayList<Huluwa>list=new ArrayList<>(Arrays.asList(huluwas));
        Collections.shuffle(list);//打乱
        int i=0;
        for(Huluwa h:list){
            huluwas[i]=h;
            ++i;
        }
    }

    public void showAllName(){
//        System.out.println("");
        for(int i=0;i<huluwas.length;++i){
            huluwas[i].descName();
        }
        System.out.println("");
    }

    public void showAllColor(){
//        System.out.println("");
        for(int i=0;i<huluwas.length;++i){
            huluwas[i].descColor();
        }
        System.out.println("");
    }

    public static  void main(String[]args){
        String[]names={"老大","老二","老三","老四","老五","老六","老七"};
        String[]colors={"红","橙","黄","绿","青","蓝","紫"};
        Huluwa[]huluwas=new Huluwa[7];//create huluwas
        for(int i=0;i<7;++i){
            huluwas[i]=new Huluwa(i,names[i],colors[i]);
        }

        GrandFather grandFather=new GrandFather(huluwas);
        grandFather.shuffle();
        System.out.println("before bubble sort:");
        grandFather.showAllName();
        grandFather.bubbleSort();
        System.out.println("after bubble sort:");
        grandFather.showAllName();

        grandFather.shuffle();
        System.out.println("\nbefore binary sort:");
        grandFather.showAllName();
        grandFather.binarySort();
        System.out.println("after binary sort:");
        grandFather.showAllColor();
    }
}
