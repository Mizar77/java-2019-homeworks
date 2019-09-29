import java.util.*;

public class HuluwaBros {
    private ArrayList<Huluwa> bros;
    public HuluwaBros() {
        bros = new ArrayList<Huluwa>();
        for(int i = 1; i <= 7; i++) {
            bros.add(new Huluwa(i));
        }
    }
    // invoke the static method of class Collections to break the orders of HuluwaBros
    public void shuffle() {
        Collections.shuffle(bros);
    }
    public void bubbleSortByRank() {
        for(int i = 0; i < bros.size() -1; i++) {
            for(int j = 0; j < bros.size() - 1 - i; j++) {
                if(Huluwa.cmpByRank(bros.get(j+1), bros.get(j))) {
                    swap(j, j+1);
                }
            }
        }
    }
    public void printColor() {
        for(Huluwa h : bros) {
            System.out.println(h.color2String());
        }
    }
    public void printRank() {
        for(Huluwa h : bros) {
            System.out.println(h.rank2String());
        }
    }
    // this method will potentially invoke toString method of class Huluwa
    public void printAll() {
        System.out.println(bros);
    }
    public void qsortByColor() {
        qsortByColor(0, bros.size()-1);
    }
    // swap and print the action of exchange
    private void swap(int i, int j) {
        if(i == j) return;
        System.out.printf("%s: %d->%d, %s: %d->%d\n",
            bros.get(i).rank2String(),
            i, j,
            bros.get(j).rank2String(),
            j, i);
        Huluwa tmp = bros.get(i);
        bros.set(i, bros.get(j));
        bros.set(j, tmp);
    }
    // recursive method should be defined as private method
    private void qsortByColor(int begin, int end) {
        if(begin >= end) return;
        Huluwa pivot = bros.get(begin);
        int i = begin;
        for(int j = i+1; j <= end; j++) {
            if(Huluwa.cmpByColor(bros.get(j), pivot)) {
                swap(++i, j);
            }
        }
        swap(begin, i);
        qsortByColor(begin, i-1);
        qsortByColor(i+1, end);
    }
}