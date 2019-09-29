package com.work.person;
import java.util.Random;

public class Process {
    //private Hulu []arr={new Hulu(),new Hulu(),new Hulu()};
    private Hulu []arr=new Hulu[7];

    /*public void Process(){
        String rstr=genSevenRandom();
        for(int i=0;i<7;i++){

            Hulu h=new Hulu(rstr.charAt(i)-'0');
            arr[i]=h;
        }
    }*/

    public String genSevenRandom(){
        Random r=new Random();
        String ret="";
        while(ret.length()<7){
            //
            int v=r.nextInt(7)+1;
            char ch=(char)(v+'0');
            if(ret.indexOf(ch)==-1){
                ret=ret+ch;
            }
        }
        return ret;
    }

    public void queueRandom(){
        //Random r=new Random();
        String rstr=genSevenRandom();
        for(int i=0;i<7;i++){

            Hulu h=new Hulu(rstr.charAt(i)-'0');
            arr[i]=h;
        }
        System.out.println("随机站队：");
        reportNum();
    }

    public void reportNum(){
        for(int i=0;i<7;i++){
            arr[i].reportNum();
        }
        System.out.print('\n');
    }

    public void reportColor(){
        for(int i=0;i<7;i++){
            arr[i].reportColor();
        }
        System.out.print('\n');
    }

    void swap(int i, int j){
        System.out.print("SWAP: ");
        arr[i].reportNum();
        System.out.print(": "+i+"->"+j+"    ");
        arr[j].reportNum();
        System.out.print(": "+j+"->"+i+'\n');
        int temp=arr[i].val;
        arr[i].val=arr[j].val;
        arr[j].val=temp;
         //arr[i].reportNum()
    }

    public void queueBubble(){
        System.out.println("冒泡排序：");
        int i=0,j=0;
        for(i=0;i<7-1;i++){
            for(j=0;j<7-i-1;j++){
                if(arr[j].val>arr[j+1].val){
                    swap(j,j+1);
                }
            }
        }
        reportNum();
    }

    public void BianryInsertSort(){
        System.out.println("二分法：");
        for(int i=1;i<7;i++){
            Hulu temp=arr[i];
            int left=0,right=i;
            while(left<right){
                int mid=(left+right)/2;
                if(temp.val>=arr[mid].val){
                    left=mid+1;
                }
                else{
                    right=mid;
                }
            }
            for(int j=i;j>left;--j){
                swap(j-1,j);
            }
        }
        reportColor();
    }

    

}
