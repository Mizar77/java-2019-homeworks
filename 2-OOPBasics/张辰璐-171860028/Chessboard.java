import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Chessboard {
    final static int numOfBros = 7;
    final String name[] = {"老大", "老二", "老三", "老四", "老五", "老六", "老七"};
    final String color[] = {"红色", "橙色", "黄色", "绿色", "青色", "蓝色", "紫色"};

    List<Chessman>being;
    List<Integer>map;

    /*Constructors*/
    public Chessboard(){
        being=new ArrayList<Chessman>();
        map=new ArrayList<Integer>();
    }

    public static Chessboard newRandom() {
        Chessboard res = new Chessboard();
        for (int i = 0; i < numOfBros; i++){
            res.being.add(new Chessman(res.name[i],res.color[i],new Position(i),i));
            res.map.add(i);
        }
        //make id of chessmen in random order
        Collections.shuffle(res.map);
        //modify the position info in chessmen
        for(int tsite=0;tsite<res.map.size();tsite++){
            int tindex=res.map.get(tsite);
            Chessman tempC=res.being.get(tindex);
            Position tempS=tempC.getSite();
            tempS.changeX(tsite);
            res.being.set(tindex,tempC);
        }
        return res;
    }

    /*Methods*/
    public void standRandom() {
        //make id of chessmen in random order
        Collections.shuffle(map);
        //modify the position info in chessmen
        for(int tsite=0;tsite<map.size();tsite++){
            int tindex=map.get(tsite);
            Chessman tempC=being.get(tindex);
            Position tempS=tempC.getSite();
            tempS.changeX(tsite);
            being.set(tindex,tempC);
        }
    }

    public void showNameQueue() {
        for(int tsite=0;tsite<map.size();tsite++){
            int tindex=map.get(tsite);
            Chessman tempC=being.get(tindex);
            System.out.printf("%s ",tempC.getName());
        }
        System.out.printf("\n");
    }

    public void showColorQueue() {
        for(int tsite=0;tsite<map.size();tsite++){
            int tindex=map.get(tsite);
            Chessman tempC=being.get(tindex);
            System.out.printf("%s ",tempC.getColor());
        }
        System.out.printf("\n");
    }

    private int getSiteBeingId(int tsite){
        int tindex=map.get(tsite);
        Chessman tempC=being.get(tindex);
        return tempC.getId();
    }

    private String getSiteBeingName(int tsite){
        int tindex=map.get(tsite);
        Chessman tempC=being.get(tindex);
        return tempC.getName();
    }

    private void swapSiteBeing(int tsite0,int tsite1){
        int tindex0=map.get(tsite0);
        int tindex1=map.get(tsite1);
        map.set(tsite0,tindex1);
        map.set(tsite1,tindex0);
        //update chessman site info
        Chessman tempC0=being.get(tindex0);
        tempC0.changeSite(new Position(tsite1));
        Chessman tempC1=being.get(tindex1);
        tempC1.changeSite(new Position(tsite0));
        being.set(tindex0,tempC1);
        being.set(tindex1,tempC0);
    }

    public void bubbleSorting() {
        for (int i = 0; i < numOfBros - 1; i++) {
            int min = i;
            for (int j = i + 1; j < numOfBros; j++) {
                //basic data type & composite date type: == vs equal:https://www.cnblogs.com/zhxhdean/archive/2011/03/25/1995431.html
                if (getSiteBeingId(min) > getSiteBeingId(j))
                    min = j;
            }
            if (min != i) {
                System.out.println(getSiteBeingName(i) + ":" + i + "->" + min);
                System.out.println(getSiteBeingName(min) + ":" + min + "->" + i);
                swapSiteBeing(min,i);
            }
        }
    }

    private void partSorting(int begin, int end) {
        if (begin >= end) return;
        int mid = (begin + end) / 2;
        partSorting(begin, mid);
        partSorting(mid + 1, end);
        int[] temp = new int[end - begin + 1];
        int lp = begin, rp = mid + 1, tp = 0;
        while (lp <= mid && rp <= end) {
            if (getSiteBeingId(lp) > getSiteBeingId(rp)) {
                System.out.println(getSiteBeingName(rp) + ":" + rp + "->" + (begin+tp));
                temp[tp++] = map.get(rp++);
            } else {
                System.out.println(getSiteBeingName(lp) + ":" + lp + "->" + (begin+lp));
                temp[tp++] = map.get(lp++);
            }
        }
        while (lp <= mid) {
            System.out.println(getSiteBeingName(lp) + ":" + lp + "->" + (begin+lp));
            temp[tp++] = map.get(lp++);
        }
        while (rp <= end) {
            System.out.println(getSiteBeingName(rp) + ":" + rp + "->" + (begin+tp));
            temp[tp++] = map.get(rp++);
        }
        for (int i = 0; i < end - begin + 1; i++)
            map.set(i + begin, temp[i]);
    }

    public void binarySorting() {
        partSorting(0, numOfBros - 1);
    }





    public static void main(String[] args) {
        //Phase 1
        System.out.println("=================Phase 1==================");
        Chessboard cb = Chessboard.newRandom();
        System.out.println("CalabashBrothers stand in random order!");
        cb.showNameQueue();
        cb.bubbleSorting();
        System.out.println("After bubble-sorting!");
        cb.showNameQueue();
        //Phase 2
        System.out.println("=================Phase 2==================");
        cb.standRandom();
        System.out.println("CalabashBrothers stand in random order!");
        cb.showColorQueue();
        cb.binarySorting();
        System.out.println("After binary-sorting!");
        cb.showColorQueue();
    }
}
