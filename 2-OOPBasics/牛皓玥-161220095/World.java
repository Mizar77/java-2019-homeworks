public class World {
    public static void main(String[] args ) {

        Queue calabashbrothers = new Queue();
        calabashbrothers.Shuffle();
        calabashbrothers.Show();
        calabashbrothers.BubbleSort();
        calabashbrothers.AgeCountoff();

        System.out.print("重新排队中······\n");
        calabashbrothers.Shuffle();
        calabashbrothers.Show();
        System.out.print("开始排序：\n");
        calabashbrothers.QuickSort(0, calabashbrothers.brothers.size()-1);
        calabashbrothers.ColorCountoff();
    }
}
