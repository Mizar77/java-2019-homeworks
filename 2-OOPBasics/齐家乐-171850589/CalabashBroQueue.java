//Qi Jiale 2019.09.03
//Reference: Binary_sort https://baike.baidu.com/item/%E4%BA%8C%E5%88%86%E6%B3%95%E6%8F%92%E5%85%A5%E6%8E%92%E5%BA%8F
import java.util.ArrayList;
import java.util.Collections;

public class CalabashBroQueue{
    public static void main(String[] args){
        CalabashBro [] bros={
            new CalabashBro("红娃", "老大"),
            new CalabashBro("橙娃", "老二"),
            new CalabashBro("黄娃", "老三"),
            new CalabashBro("绿娃", "老四"),
            new CalabashBro("青娃", "老五"),
            new CalabashBro("蓝娃", "老六"),
            new CalabashBro("紫娃", "老七")
        };
        CalabshBroMap calabshBroMap=new CalabshBroMap(bros);
        
        calabshBroMap.rand_stand();
        calabshBroMap.report_rank();
        calabshBroMap.Bubble_sort();
        calabshBroMap.report_rank();
        System.out.println("");
        calabshBroMap.rand_stand();
        calabshBroMap.report_name();
        calabshBroMap.Binary_sort();
        calabshBroMap.report_name();
    }
}

class CalabashBro{
    private String name;
    private String rank;
    CalabashBro(String name,String rank){
        this.name=name;
        this.rank=rank;
    }
    public void report_rank(){
        System.out.print(rank+" ");
    }
    public void report_name(){
        System.out.print(name+" ");
    }
    public String name(){
        return name;
    }
    public String rank(){
        return rank;
    }
}

class CalabshBroMap{
    ArrayList<CalabashBro> bros=new ArrayList<CalabashBro>();
    ArrayList<String> name=new ArrayList<String>();
    ArrayList<String> rank=new ArrayList<String>();
    CalabshBroMap(CalabashBro bros []){
        for(int i=0;i<bros.length;i++){
            this.bros.add(bros[i]);
            this.name.add(bros[i].name());
            this.rank.add(bros[i].rank());
        }
    }
    public void rand_stand(){
        Collections.shuffle(bros);
    }
    public void Bubble_sort(){
        for(int i=0;i<bros.size()-1;i++){
            for(int j=0;j<bros.size()-1-i;j++){
                if(!comp_rank(bros.get(j).rank(), bros.get(j+1).rank())){
                    Collections.swap(bros,j,j+1);
                    Bubble_print_move(j);
                }
            }
        }
    }
    public void report_rank(){
        for(int i=0;i<bros.size();i++){
            bros.get(i).report_rank();
        }
        System.out.println("");
    }
    public void report_name(){
        for(int i=0;i<bros.size();i++){
            bros.get(i).report_name();
        }
        System.out.println("");
    }
    public void Binary_sort(){
        for (int i = 1; i < bros.size();i++){
            int start = 0,end = i - 1,mid = -1;
            CalabashBro temp = bros.get(i);
            while (start <= end){
                mid = (start + end) / 2;
                if (!comp_name(bros.get(mid).name(), temp.name())){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }
            bros.remove(i);
            bros.add(start, temp);
            Binary_print_move(start,i, temp);
        }
    }
    private void Bubble_print_move(int j){
        System.out.println(bros.get(j).rank()+j+"<-->"+(j+1)+bros.get(j+1).rank());
    }
    private void Binary_print_move(int start,int i,CalabashBro temp){
        System.out.println(temp.name()+"："+i+"->out");  
        for(int j = i - 1; j >= start; j--) {            
            System.out.println(bros.get(j).name()+"："+j+"->"+(j+1));    
        }        
        System.out.println(temp.name()+"：out->"+(start));   
    }
    private Boolean comp_rank(String a,String b){
        return comp(a, b, rank);
    }
    private boolean comp_name(String a,String b){
        return comp(a, b, name);
    }
    private boolean comp(String a,String b,ArrayList<String> standard){
        for(int i=0;i<standard.size();i++){
            if(a==standard.get(i)){
                return true;
            }
            else if(b==standard.get(i)){
                return false;
            }
        }
        System.err.println("Compare Error!");
        System.exit(-1);
        return false;
    }
}
