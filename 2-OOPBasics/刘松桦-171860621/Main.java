import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    
    public static void bubbleSort(Gourd a[],int n){
        int i,j;
        Gourd temp;
        for (j=0;j<n-1;j++){
            for (i=0;i<n-1-j;i++){
                if(a[i].id>a[i+1].id) {
                    a[i].reportName();
                    a[i].reportOrder(i+1,i+2);
                    a[i+1].reportName();
                    a[i+1].reportOrder(i+2,i+1);
                    temp=a[i];
                    a[i]=a[i+1];
                    a[i+1]=temp;
                }
            }
        }
    }

    public static void quickSort(Gourd a[],int l,int r){
        if(l>=r)
            return;
        int i = l;
        int j = r;
        Gourd key = a[l];
        while(i<j){
            while(i<j && a[j].id>=key.id)
                j--;
            if(i<j){
                a[j].reportName();
                a[j].reportOrder(j+1,i+1);
                a[i].reportName();
                a[i].reportOrder(i+1,j+1);
                a[i] = a[j];
                i++;
            }
            while(i<j && a[i].id<key.id)
                i++;
            if(i<j){
                a[i].reportName();
                a[i].reportOrder(i+1,j+1);
                a[j] = a[i];
                j--;
            }
        }
        a[i] = key;
        quickSort(a, l, i-1);
        quickSort(a, i+1, r);
    }

    public static void main(String[] args) {

        int []arr=new int[7];
        for(int i=0;i<7;i++){
            arr[i]=i;
        }
        List<Gourd> list=new ArrayList<Gourd>();
        Gourd []gourds=new Gourd[7];
        list.add(new RedGourd());
        list.add(new OrangeGourd());
        list.add(new YellowGourd());
        list.add(new GreenGourd());
        list.add(new NavyGourd());
        list.add(new BlueGourd());
        list.add(new PurpleGourd());
        Collections.shuffle(list);
        System.out.println("葫芦娃随机站队完成！准备冒泡排序！");
        bubbleSort(list.toArray(gourds),7);
        System.out.println("冒泡排序完成！报数：");
        for(int i=0;i<7;i++){
            gourds[i].reportName();
        }
        System.out.print("\n\n");
        Collections.shuffle(list);
        System.out.println("葫芦娃随机站队完成！准备快速排序！");
        quickSort(list.toArray(gourds),0,6);
        System.out.println("快速排序完成！报数：");
        for(int i=0;i<7;i++){
            gourds[i].reportColor();
        }
        System.out.print("\n\n");
    }
}
