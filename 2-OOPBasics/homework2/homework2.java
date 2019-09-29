import java.util.Random;//生成随机数来产生一个随机0-6排列

class huluwa{
    public int rank;//排行:1-7
    private int place;//站位:0-6
    public Color color;//颜色
    enum Color{red,orange,yellow,green,cyan,blue,purple}
    public huluwa(int x){//创造一只葫芦娃
        rank = x;
        place = x-1;
        switch(rank){
            case 1:color = Color.red;break;
            case 2:color = Color.orange;break;
            case 3:color = Color.yellow;break;
            case 4:color = Color.green;break;
            case 5:color = Color.cyan;break;
            case 6:color = Color.blue;break;
            case 7:color = Color.purple;break;
            default:break;
        }
    }
    public void print_rank(){//报数
        switch(rank){
            case 1:System.out.print("老大");break;
            case 2:System.out.print("老二");break;
            case 3:System.out.print("老三");break;
            case 4:System.out.print("老四");break;
            case 5:System.out.print("老五");break;
            case 6:System.out.print("老六");break;
            case 7:System.out.print("老七");break;
            default:System.out.print("第八只葫芦娃？");break;
        }
    }
    public void print_color(){//报颜色
        switch(color){
            case red:System.out.print("红色");break;
            case orange:System.out.print("橙色");break;
            case yellow:System.out.print("黄色");break;
            case green:System.out.print("绿色");break;
            case cyan:System.out.print("青色");break;
            case blue:System.out.print("蓝色");break;
            case purple:System.out.print("紫色");break;
            default:System.out.print("这种颜色的葫芦娃是新品种吗？");break;
        }
    }
    public void change_to_new_place(int new_place){//交换到新的位置
        print_rank();
        System.out.print(":"+place+"->"+new_place+"\n");
        place = new_place;
    }
    public void random_change_place(int new_place){
        place = new_place;
    }
}
class huluwajiuyeye {
    private huluwa[] HuLuWas = new huluwa[7];
    public huluwajiuyeye(){
        for(int i = 0;i<7;i++){
            HuLuWas[i] =new huluwa(i+1);
        }
    }
    public void random_queue(){//随机站队
        for(int i =0;i<7;i++){
            Random r = new Random();
            int s = r.nextInt(7);//生成一个0-6的随机数，把第i位葫芦娃和这个位置的葫芦娃换位置
            huluwa temp = HuLuWas[i];
            HuLuWas[i] = HuLuWas[s];
            HuLuWas[s] = temp;
            HuLuWas[i].random_change_place(i);
            HuLuWas[s].random_change_place(s);
        }
    }
    public void bubble_sort(){//依据排行进行冒泡排序
        for(int i =6;i>=0;i--){
            for(int j = 0;j<=i-1;j++){
                if(j<6&&HuLuWas[j+1].rank<HuLuWas[j].rank){
                    huluwa temp = HuLuWas[j+1];
                    HuLuWas[j+1] = HuLuWas[j];
                    HuLuWas[j] = temp;
                    HuLuWas[j+1].change_to_new_place(j+1);
                    HuLuWas[j].change_to_new_place(j);
                }
            }
        }
    }
    public void sort_rank(){//调用冒泡排序然后报数
        bubble_sort();
        for(int i =0;i<7;i++)
            HuLuWas[i].print_rank();
        System.out.print("\n");
    }
    public void sort_color(){//调用归并排序然后报颜色
        quick_sort(0,6);
        for(int i =0;i<7;i++)
            HuLuWas[i].print_color();
    }
    public void quick_sort(int left,int right){//根据颜色进行归并排序
         if(left<right){
             int mid = (left+right)/2;
             quick_sort(left,mid);//划分为两个分支
             quick_sort(mid+1,right);
             int pi = left,pj = mid+1,i = left;

             huluwa[] temp = new huluwa[7];//创建一个原始队伍的镜像
             for(int k = 0;k<7;k++)
                 temp[k] = HuLuWas[k];
             //merge
             while(pi<=mid&&pj<=right){
                 if(temp[pi].color.ordinal()<temp[pj].color.ordinal()){
                     if(temp[pi].rank!=HuLuWas[i].rank) {
                         HuLuWas[i] = temp[pi];
                         HuLuWas[i].change_to_new_place(i);
                     }
                     i++;
                     pi++;
                 }
                 else{
                     if(temp[pj].rank!=HuLuWas[i].rank) {
                         HuLuWas[i] = temp[pj];
                         HuLuWas[i].change_to_new_place(i);
                     }
                     i++;
                     pj++;
                 }
             }
             if(pi>mid){
                 for(;pj<=right;pj++,i++)
                     if(temp[pj].rank!=HuLuWas[i].rank) {
                         HuLuWas[i] = temp[pj];
                         HuLuWas[i].change_to_new_place(i);
                     }
             }
             else {
                 for (; pi <= mid; pi++, i++) {
                     if (temp[pi].rank != HuLuWas[i].rank) {
                         HuLuWas[i] = temp[pi];
                         HuLuWas[i].change_to_new_place(i);
                     }
                 }
             }
         }
    }
}
public class homework2{
    public static void main(String[] args){
        huluwajiuyeye HULUWAJIUYY = new huluwajiuyeye();
        HULUWAJIUYY.random_queue();
        HULUWAJIUYY.sort_rank();
        HULUWAJIUYY.random_queue();
        HULUWAJIUYY.sort_color();
    }
}
