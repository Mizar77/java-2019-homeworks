import java.util.*;

public class CalabashBrotherSorter {
    private static final int X = 0;
    private static final int NUM = 7; /* Seven Calabash Brothers */
    private World world;

    private void shuffle() {
        CalabashBrother[] brothers = new CalabashBrother[NUM];
        for (int i = 0; i < NUM; i++) {
            brothers[i] = world.get(X, i);
        }
        ArrayList<CalabashBrother> list = new ArrayList<>(Arrays.asList(brothers));
        Collections.shuffle(list);
        brothers = list.toArray(new CalabashBrother[NUM]);
        for (int i = 0; i < NUM; i++) {
            world.place(brothers[i], X, i);
        }
    }

    public CalabashBrotherSorter(World world) {
        this.world = world;
        /* In this sorter, we will just place all Calabash Brothers on the same line in the world map
         * We will just place all on the line where the x-axis is zero for simplicity
         * */
        for (int i = 0; i < NUM; i++) {
            CalabashBrother brother = new CalabashBrother(i);
            world.place(brother, X, i);
        }
    }

    private int partition(int start, int end) {
        CalabashColorComparator comparator = new CalabashColorComparator();
        CalabashBrother pivot = world.get(X, start);
        int firstLess = start;
        for (int i = start + 1; i <= end; i++) {
            if (comparator.compare(world.get(X, i), pivot) < 0) {
                firstLess++;
                CalabashBrother brotherOne = world.get(X, firstLess);
                CalabashBrother brotherTwo = world.get(X, i);
                world.exchange(brotherOne, brotherTwo);
            }
        }
        CalabashBrother brother = world.get(X, firstLess);
        world.exchange(pivot, brother);
        return firstLess;
    }

    private void quickSort(int start, int end) {
        if (start > end)
            return;
        int pivotIndex = partition(start, end);
        quickSort(start, pivotIndex - 1);
        quickSort(pivotIndex + 1, end);
    }

    public void bubbleSort() {
        shuffle();
        /* Sort according to their order */
        CalabashRankComparator comparator = new CalabashRankComparator();
        for (int i = 0; i < NUM; i++) {
            for (int j = 0; j < NUM - i - 1; j++) {
                if (comparator.compare(world.get(X, j), world.get(X, j + 1)) >= 0) {
                    CalabashBrother brotherOne = world.get(X, j);
                    CalabashBrother brotherTwo = world.get(X, j + 1);
                    world.exchange(brotherOne, brotherTwo);
                }
            }
        }

        /* Sort finish */
        for (int i = 0; i < NUM; i++) {
            System.out.print(world.get(X, i).getName() + " ");
        }
        System.out.println();
    }

    public void binarySort() {
        shuffle();
        /* Use binary QuickSort */
        /* Sort according to their color */
        quickSort(0, NUM - 1);
        for (int i = 0; i < NUM; i++) {
            System.out.print(world.get(X, i).getName() + " ");
        }
        System.out.println();
    }
}
