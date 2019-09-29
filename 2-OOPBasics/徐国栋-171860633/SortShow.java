import java.awt.Color;
import java.util.*;

public class SortShow {// 排序表演类，完成作业二的调度任务
    CalabashBrother[] players;// 七个葫芦娃

    public SortShow() {
        players = new CalabashBrother[7];
        players[0] = new CalabashBrother(0, new Color(255, 0, 0));
        players[1] = new CalabashBrother(1, new Color(255, 128, 0));
        players[2] = new CalabashBrother(2, new Color(255, 255, 0));
        players[3] = new CalabashBrother(3, new Color(0, 255, 0));
        players[4] = new CalabashBrother(4, new Color(0, 255, 255));
        players[5] = new CalabashBrother(5, new Color(0, 0, 255));
        players[6] = new CalabashBrother(6, new Color(128, 0, 255));
    }

    public void randomShuffle() {
        ArrayList<CalabashBrother> randList = new ArrayList<>(Arrays.asList(players));
        Collections.shuffle(randList);
        players = randList.toArray(players);
    }

    private class RankComparator implements Comparator<CalabashBrother> {
        @Override
        public int compare(CalabashBrother a, CalabashBrother b) {
            return a.rank - b.rank;
        }
    }

    private class ColorComparator implements Comparator<CalabashBrother> {
        @Override
        public int compare(CalabashBrother a, CalabashBrother b) {
            return a.apperrance.color2intForSort() - b.apperrance.color2intForSort();
        }
    }

    public void playRankBubbleSort() {
        System.out.println("开始按排行的冒泡排序，注意到冒泡排序是原位排序，元素原地交换：");
        RankComparator rc = new RankComparator();
        int n = players.length - 1;
        CalabashBrother tmp;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (rc.compare(players[j], players[j + 1]) > 0) {
                    reportExchange(j, j + 1);
                    tmp = players[j];
                    players[j] = players[j + 1];
                    players[j + 1] = tmp;
                }
            }
        }
        System.out.println();
    }

    private void reportExchange(int a, int b) {// 冒泡排序是原位排序，元素两两交换
        System.out.print(players[a].name + ":\"" + (a) + "->" + (b) + "\";\t");
        System.out.print(players[b].name + ":\"" + (b) + "->" + (a) + "\";\n");
    }

    private void reportMoveTo(int a, int b) {// 归并排序会另外开辟空间，直接移动即可
        System.out.print(players[a].name + ":\"" + (a) + "->" + (b) + "\";\n");
    }

    private void merge(int left, int mid, int right) {
        CalabashBrother[] tmp = new CalabashBrother[players.length];
        int p1 = left, p2 = mid + 1, k = left;
        ColorComparator cc = new ColorComparator();
        while (p1 <= mid && p2 <= right) {
            if (cc.compare(players[p1], players[p2]) <= 0) {
                reportMoveTo(p1, k);
                tmp[k++] = players[p1++];
            } else {
                reportMoveTo(p2, k);
                tmp[k++] = players[p2++];
            }
        }
        while (p1 <= mid) {
            reportMoveTo(p1, k);
            tmp[k++] = players[p1++];
        }
        while (p2 <= right) {
            reportMoveTo(p2, k);
            tmp[k++] = players[p2++];
        }
        for (int i = left; i <= right; i++)
            players[i] = tmp[i];
    }

    private void mergeSort(int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(start, mid);
            mergeSort(mid + 1, end);
            merge(start, mid, end);
        }
    }

    public void playColorMergeSort() {
        System.out.println("开始按颜色的二分排序，注意到归并排序会另外开辟空间，直接移动即可：");//
        mergeSort(0, players.length - 1);
        System.out.println();
    }

    public void everyoneReport(String way) {
        if (way == "颜色") {
            for (int i = 0; i < players.length; i++) {
                System.out.print(players[i].name + ":\"");
                // players[i].printColor();
                // System.out.print("\";\t");
                System.out.print(players[i].apperrance.color2String() + "\";\t");
            }
            System.out.println("");
        } else if (way == "排行") {
            for (int i = 0; i < players.length; i++) {
                System.out.print(players[i].name + ":\"" + players[i].name + "\";\t");
            }
            System.out.println("");
        }
        System.out.println("");
    }

}