public class Main {
    private static final int N = 7; /* There are seven calabash brothers */

    /* Main class */
    public static void main(String[] args) {
        /* Initialize the world map */
        World world = new World();

        CalabashBrotherSorter sorter = new CalabashBrotherSorter(world);
        System.out.println("Bubble Sort Begin");
        /* Bubble Sort */
        sorter.bubbleSort();
        System.out.println("Bubble Sort End");
        System.out.println("Binary Sort Begin");
        /* Binary Sort */
        sorter.binarySort();
        System.out.println("Binary Sort End");
    }
}
