import java.util.*;
class calabash{
    int id;
    String rank;
    String color;
    calabash(int i,String r,String c){
        id=i;
        rank=r;
        color=c;
    } 
    public int getId(){
        return id;
    } 
    public String getRank(){
        return rank;
    }
    public String getColor(){
        return color;
    }
}
class calabashBrother{
    calabash dawa,erwa,sanwa,siwa,wuwa,liuwa,qiwa;
    int[] arrange;
    calabashBrother(){
        calabash dawa=new calabash(1,"老大","红");
        calabash erwa=new calabash(2,"老二","橙");
        calabash sanwa=new calabash(3,"老三","黄");
        calabash siwa=new calabash(4,"老四","绿");
        calabash wuwa=new calabash(5,"老五","青");
        calabash liuwa=new calabash(6,"老六","蓝");
        calabash qiwa=new calabash(7,"老七","紫");
        randomArrayGenerator(7);
    }
    public void randomArrayGenerator(int n){//生成1-n的的随机排列
        Random rand=new Random();
        int temp=0;
        arrange=new int[n];
        int index=0;
        while(true){
            if(index==n){
                break;
            }
            temp=rand.nextInt(n)+1;
            boolean ifcontain=false;
            for(int i=0;i<arrange.length;i++){
                if(arrange[i]==temp){
                    ifcontain=true;
                }
            }
            if(ifcontain){
                continue;
            }else{
                arrange[index]=temp;
                index++;
            }
        }
        System.out.println("葫芦兄弟随机排列如下：");
        for(int i=0;i<n;i++){
            switch(arrange[i]){
                case 1:System.out.println("老大 ");break;
                case 2:System.out.println("老二 ");break;
                case 3:System.out.println("老三 ");break;
                case 4:System.out.println("老四 ");break;
                case 5:System.out.println("老五 ");break;
                case 6:System.out.println("老六 ");break;
                case 7:System.out.println("老七 ");break;
                }
        }
     }
    public void soundOff(String property){//根据排名或颜色报数
        System.out.println("葫芦兄弟报数如下：");
        if(property=="rank"){
            for(int i=0;i<7;i++){
                switch(arrange[i]){
                case 1:System.out.println("老大 ");break;
                case 2:System.out.println("老二 ");break;
                case 3:System.out.println("老三 ");break;
                case 4:System.out.println("老四 ");break;
                case 5:System.out.println("老五 ");break;
                case 6:System.out.println("老六 ");break;
                case 7:System.out.println("老七 ");break;
                }
            }
        }else{
            for(int i=0;i<7;i++){
                switch(arrange[i]){
                case 1:System.out.println("红色 ");break;
                case 2:System.out.println("橙色 ");break;
                case 3:System.out.println("黄色 ");break;
                case 4:System.out.println("绿色 ");break;
                case 5:System.out.println("青色 ");break;
                case 6:System.out.println("蓝色 ");break;
                case 7:System.out.println("紫色 ");break;
                }
            }
        }
    }
    public void bubbleSort(){
        int temp=0;
        for(int i=0;i<arrange.length-1;i++){
            for(int j=0;j<arrange.length-1;j++){
                if(arrange[j]>arrange[j+1]){
                    switch(arrange[j]){
                        case 1:System.out.println("老大: "+Integer.toString(j)+"->"+Integer.toString(j+1));break;
                        case 2:System.out.println("老二: "+Integer.toString(j)+"->"+Integer.toString(j+1));break;
                        case 3:System.out.println("老三: "+Integer.toString(j)+"->"+Integer.toString(j+1));break;
                        case 4:System.out.println("老四: "+Integer.toString(j)+"->"+Integer.toString(j+1));break;
                        case 5:System.out.println("老五: "+Integer.toString(j)+"->"+Integer.toString(j+1));break;
                        case 6:System.out.println("老六: "+Integer.toString(j)+"->"+Integer.toString(j+1));break;
                        case 7:System.out.println("老七: "+Integer.toString(j)+"->"+Integer.toString(j+1));break;
                    }
                    switch(arrange[j+1]){
                        case 1:System.out.println("老大: "+Integer.toString(j+1)+"->"+Integer.toString(j));break;
                        case 2:System.out.println("老二: "+Integer.toString(j+1)+"->"+Integer.toString(j));break;
                        case 3:System.out.println("老三: "+Integer.toString(j+1)+"->"+Integer.toString(j));break;
                        case 4:System.out.println("老四: "+Integer.toString(j+1)+"->"+Integer.toString(j));break;
                        case 5:System.out.println("老五: "+Integer.toString(j+1)+"->"+Integer.toString(j));break;
                        case 6:System.out.println("老六: "+Integer.toString(j+1)+"->"+Integer.toString(j));break;
                        case 7:System.out.println("老七: "+Integer.toString(j+1)+"->"+Integer.toString(j));break;
                    }
                    temp=arrange[j];
                    arrange[j]=arrange[j+1];
                    arrange[j+1]=temp;
                }
            }
        }
    }
    public void binarySort(){
        int temp=0;
        int i=0,j=0;
        int high=0,low=0,mid=0;
        for(i=1;i<arrange.length;i++){
            low=0;//上界
            high=i-1;//下界
            temp=arrange[i];
            while(low<=high){
                mid=(low+high)/2;
                if(temp<arrange[mid]){
                    high=mid-1;
                }
                else{
                    low=mid+1;     
                }
            }
            if(low!=i){
                for(j=i-1;j>=low;j--){
                    switch(arrange[j]){
                        case 1:System.out.println("老大: "+Integer.toString(j)+"->"+Integer.toString(j+1));break;
                        case 2:System.out.println("老二: "+Integer.toString(j)+"->"+Integer.toString(j+1));break;
                        case 3:System.out.println("老三: "+Integer.toString(j)+"->"+Integer.toString(j+1));break;
                        case 4:System.out.println("老四: "+Integer.toString(j)+"->"+Integer.toString(j+1));break;
                        case 5:System.out.println("老五: "+Integer.toString(j)+"->"+Integer.toString(j+1));break;
                        case 6:System.out.println("老六: "+Integer.toString(j)+"->"+Integer.toString(j+1));break;
                        case 7:System.out.println("老七: "+Integer.toString(j)+"->"+Integer.toString(j+1));break;
                    }
                    arrange[j+1]=arrange[j];
                }
                switch(arrange[i]){
                    case 1:System.out.println("老大: "+Integer.toString(i)+"->"+Integer.toString(low));break;
                    case 2:System.out.println("老二: "+Integer.toString(i)+"->"+Integer.toString(low));break;
                    case 3:System.out.println("老三: "+Integer.toString(i)+"->"+Integer.toString(low));break;
                    case 4:System.out.println("老四: "+Integer.toString(i)+"->"+Integer.toString(low));break;
                    case 5:System.out.println("老五: "+Integer.toString(i)+"->"+Integer.toString(low));break;
                    case 6:System.out.println("老六: "+Integer.toString(i)+"->"+Integer.toString(low));break;
                    case 7:System.out.println("老七: "+Integer.toString(i)+"->"+Integer.toString(low));break;
                }
            }
            arrange[low]=temp;
        }
    }
}

public class calabash_1{
        public static void main(String[] args){
        calabashBrother brother=new calabashBrother();
        brother.bubbleSort();
        brother.soundOff("rank");
        brother.randomArrayGenerator(7);
        brother.binarySort();
        brother.soundOff("color");
    }
}