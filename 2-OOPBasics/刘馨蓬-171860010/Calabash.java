package Sort.demo;
import java.util.Random;

public class Calabash {
    Brother[] members;
    void initialize(){
        members=new Brother[7];
        for(int i=0;i<7;i++){
            members[i]=new Brother();
        }
        members[0].name="老大";
        members[0].color="红色";
        members[0].priority=0;
        members[1].name="老二";
        members[1].color="橙色";
        members[1].priority=1;
        members[2].name="老三";
        members[2].color="黄色";
        members[2].priority=2;
        members[3].name="老四";
        members[3].color="绿色";
        members[3].priority=3;
        members[4].name="老五";
        members[4].color="青色";
        members[4].priority=4;
        members[5].name="老六";
        members[5].color="蓝色";
        members[5].priority=5;
        members[6].name="老七";
        members[6].color="紫色";
        members[6].priority=6;
    }
    void disruptTheOrder(){
        Random rand=new Random();
        for(int i=7;i>0;i--){
            int temp=rand.nextInt(i);
            members[i-1].placeChange(temp+1);
            members[temp].placeChange(i);
            swap(temp,i-1);
        }
    }
    void swap(int i,int j){
        Brother temp=members[j];
        members[j]=members[i];
        members[i]=temp;
    }
    void bubbleSort(){
        for(int i=0;i<6;i++){
            for(int j=i+1;j<7;j++){
                if(members[i].compare(members[j])){
                    members[i].swapAction(j);
                    members[j].swapAction(i);
                   swap(i,j);
                }
            }
        }
        for(int i=0;i<7;i++){
           members[i].nameOff();
        }
    }
    void dichotomy(){
        for(int i=1;i<7;i++) {
            Brother temp = members[i];
            int low = 0;
            int high = i - 1;
            int mid = -1;
            while (low <= high) {
                mid = (high + low) / 2;
                if (members[mid].compare(temp)) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            for (int j = i - 1; j >= low; j--) {
                members[j].swapAction(j + 1);
                members[j + 1] = members[j];
            }
            temp.swapAction(low);
            members[low] = temp;
        }
        for(int i=0;i<7;i++){
            members[i].colorOff();
        }
    }
    public static void main(String[] args){
            Calabash calabash=new Calabash();
            calabash.initialize();
            calabash.disruptTheOrder();
            calabash.bubbleSort();
            calabash.disruptTheOrder();
            calabash.dichotomy();
    }

}

class Brother{
    String name;
    int place;
    String color;
    int priority;
    boolean compare(Brother x){
        if(x.priority<priority){
            return true;
        }
        else
            return false;
    }
    void placeChange(int x){
        place=x;
    }
    void nameOff(){
        System.out.println(name+" ");
    }
    void colorOff(){
        System.out.println(color);
    }
    void swapAction(int x){
        x=x+1;
        if(place!=x) {
            System.out.println(name + ":" + place + "->" + x);
            placeChange(x);
        }
    }
}

