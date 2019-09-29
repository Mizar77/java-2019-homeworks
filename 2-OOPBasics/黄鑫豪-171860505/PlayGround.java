import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlayGround {
    static GourdEva[] theGroup = new GourdEva[7]; //red, orange, yellow, green, cyan, blue, purple;
    static GourdEva[] theLine = new GourdEva[7]; //模拟的队列

    public static void main(String[] args) {
        for (int i = 0; i < 7; i++)
            theGroup[i] = new GourdEva(i);

        randomSetInLine();
        bubbleSort();

        randomSetInLine();
        binarySort();
    }

    static List<Integer> getRandomNumList() { // 生成长度为7的随机数列
        List<Integer> list = new ArrayList<Integer>();

        Random r = new Random();
        while (list.size() != 7) {
            int num = r.nextInt(7);
            if (!list.contains(num)) {
                list.add(num);
            }
        }

        return list;
    }

    static void randomSetInLine() {
        List<Integer> tmpList = getRandomNumList();
        for (int i = 0; i < 7; i++) {
            theGroup[i].setPositionWithOutTalk(tmpList.get(i));
            theLine[tmpList.get(i)] = theGroup[i];
        }
        System.out.println("【随机站队】");
        whatInLine(true);
    }

    static void whatInLine(boolean name){
        for (int i = 0; i < 7; i++) {
            if (name)
                theLine[i].saymyname();
            else
                theLine[i].saycolor();
            if (i == 6)
                System.out.print('\n');
            else
                System.out.print('，');
        }
    }

    static void exchange(int a, int b) {
        theLine[a].setPositionAndTalk(b);
        theLine[b].setPositionAndTalk(a);
    }

    static void bubbleSort() {
        System.out.println("【开始冒泡排队】");
        int n = 7;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (theLine[j].getrank() > theLine[j + 1].getrank()) {
                    exchange(j, j + 1);
                    GourdEva tmp = theLine[j];
                    theLine[j] = theLine[j + 1];
                    theLine[j + 1] = tmp;
                }
            }
        }
        System.out.println("【冒泡排队后队中站位】");
        whatInLine(true);
    }

    static void binarySort() {
        System.out.println("【开始归并排队】");
        mergeSort(theLine, 0, 6);
        System.out.println("【归并排队后队中站位】");
        whatInLine(false);
    }

    static void mergeSort(GourdEva[] arr, int left, int right) {
        if (left == right)
            return;

        int mid = left + ((right - left) >> 1);

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        //MergePart
        GourdEva[] tmpLine = new GourdEva[right - left + 1];
        int k = 0;
        int i = left;
        int j = mid + 1;
        while (i <= mid && j <= right) {
            if (arr[i].getrank() < arr[j].getrank()) {
                tmpLine[k] = arr[i];
                arr[i++].setPositionAndTalk(k++);
            } else {
                tmpLine[k] = arr[j];
                arr[j++].setPositionAndTalk(k++);
            }
        }
        while (i <= mid) {
            tmpLine[k] = arr[i];
            arr[i++].setPositionAndTalk(k++);
        }
        while (j <= right) {
            tmpLine[k] = arr[j];
            arr[j++].setPositionAndTalk(k++);
        }

        if (tmpLine.length >= 0) System.arraycopy(tmpLine, 0, arr, left, tmpLine.length);
    }
}
