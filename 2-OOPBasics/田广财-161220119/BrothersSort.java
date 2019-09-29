package tgc;
import java.util.ArrayList;
import java.util.Random;
public class BrothersSort {
    private Huluwa getHuluwa(int index) {
        switch (index) {
            case 1:
                return Huluwa.hlw1;
            case 2:
                return Huluwa.hlw2;
            case 3:
                return Huluwa.hlw3;
            case 4:
                return Huluwa.hlw4;
            case 5:
                return Huluwa.hlw5;
            case 6:
                return Huluwa.hlw6;
            case 7:
                return Huluwa.hlw7;
            default:
                return Huluwa.hlw0;    //防止代码出错
        }
    }

    private Huluwa[] brothers = new Huluwa[7];

    public BrothersSort() {
        System.out.println("葫芦娃随机站队：");
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Random random = new Random();
        while (arrayList.size() < 7) {
            int rand = random.nextInt(7) % 7;
            if (!arrayList.contains(rand))
                arrayList.add(rand);
        }
        int i = 1;
        for (int j : arrayList) {
            brothers[j] = getHuluwa(i);
            Integer index = j + 1;
            i++;
        }
        for (int t = 0; t < 7; t++) {
            System.out.print(brothers[t].getRank() + brothers[t].getColor() + " ");
        }
        System.out.println();

    }

    public void bubbleSort() {
        System.out.println("冒泡排序：");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6 - i; j++) {
                if (brothers[j].compareTo(brothers[j + 1]) > 0) {
                    Huluwa t = brothers[j];
                    brothers[j] = brothers[j + 1];
                    brothers[j + 1] = t;
                    System.out.println(brothers[j + 1].getCompareRank(j, j + 1));

                }
            }
        }
        System.out.println("冒泡排序结果：");
        for (int i = 0; i < 7; i++) {
            System.out.print(brothers[i].getRank() + "  ");
        }
        System.out.println();

    }

    public void binarySort() {
        System.out.println("二分法排序：");
        for(int i=0;i<brothers.length;i++){
            Huluwa t=brothers[i];
            int left=0;
            int right=i-1;
            int mid=0;
            while   (left<=right){
                mid=(left+right)/2;
                if(t.compareTo(brothers[mid])<0){
                    right=mid-1;

                }else {
                    left=mid+1;
                }
            }
            for(int j=i-1;j>=left;j--){
                brothers[j+1]=brothers[j];
                System.out.println( brothers[j].getCompareRank(j,j+1));
            }
            if(left!=i){
                brothers[left]=t;

            }
        }

        System.out.println("二分法排序结果：");
        for (int l = 0; l < 7; l++) {
            System.out.print(brothers[l].getColor() + "  ");
        }
        System.out.println();

    }


}
