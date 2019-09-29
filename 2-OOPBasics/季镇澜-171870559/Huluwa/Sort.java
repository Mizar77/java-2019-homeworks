package Huluwa;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

class Hulu {
    public int rank;
    private String name;
    private String color;
    private int location = 0;

    Hulu(String n, String c, int r) {
        name = n;
        color = c;
        rank = r;
    }

    public void reportName() {
        System.out.println("Name:" + name);
    }

    public void reportColor() {
        System.out.println("Color:" + color);
    }

    public void changeLocation(int dst, boolean ifReport) {
        int src = location;
        location = dst;
        if (ifReport)
            System.out.println(name + ": " + src + "->" + dst);
    }
}

class HuluArray {
    static Hulu[] theArray = new Hulu[]{
            new Hulu("老大", "红", 1),
            new Hulu("老二", "橙", 2),
            new Hulu("老三", "黄", 3),
            new Hulu("老四", "绿", 4),
            new Hulu("老五", "青", 5),
            new Hulu("老六", "蓝", 6),
            new Hulu("老七", "紫", 7)
    };

    void swap(int locA, int locB, boolean ifReport) {
        Hulu temp = theArray[locA];
        theArray[locA] = theArray[locB];
        theArray[locB] = temp;
        theArray[locA].changeLocation(locA, ifReport);
        theArray[locB].changeLocation(locB, ifReport);
    }

    void shuffle() {
        Random rand = new Random();
        for (int i = theArray.length; i > 0; i--) {
            int randId = rand.nextInt(i);
            swap(randId, i - 1, false);
        }
    }

    void bubbleSort() {
        for (int i = 0; i < theArray.length; i++) {
            for (int j = 0; j < theArray.length-i-1; j++) {
                if (theArray[j].rank > theArray[j + 1].rank)
                    swap(j, j + 1, true);
            }
        }
        System.out.println("BubbleSort is done");
        for (Hulu h : theArray)
            h.reportName();
    }

    int binaryFind(int low, int high, int objRank) {
        if (high <= low)
            return objRank < theArray[low].rank ? low : (low + 1);
        int mid = (low + high) / 2;
        if (objRank < theArray[mid].rank)
            return binaryFind(low, mid - 1, objRank);
        else
            return binaryFind(mid + 1, high, objRank);
    }

    void binarySort() {
        for (int i = 1; i < theArray.length; i++) {
            int dst=binaryFind(0,i-1,theArray[i].rank);
            for(int j=i;j>dst;j--){
                swap(j,j-1,true);
            }
        }
        System.out.println("BinarySort is done");
        for (Hulu h : theArray)
            h.reportColor();
    }
}

public class Sort {
    public static void main(String args[]){
        HuluArray obj=new HuluArray();
        obj.shuffle();
        obj.bubbleSort();
        obj.shuffle();
        obj.binarySort();
    }
}
