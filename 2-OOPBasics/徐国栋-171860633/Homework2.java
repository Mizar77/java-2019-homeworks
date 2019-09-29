
public class Homework2 {
    public static void main(String[] args) {
        SortShow sortshow = new SortShow();

        sortshow.randomShuffle();
        System.out.println("第一项任务已开始,随机打乱后，葫芦娃报数：");
        sortshow.everyoneReport("排行");

        sortshow.playRankBubbleSort();
        System.out.println("按照排行冒泡排序，完成后，所有葫芦娃报数：");
        sortshow.everyoneReport("排行");
        System.out.println("第一项任务结束。\n");

        sortshow.randomShuffle();
        System.out.println("第二项任务已开始，随机打乱后，葫芦娃报数：");
        sortshow.everyoneReport("颜色");

        sortshow.playColorMergeSort();
        System.out.println("按照颜色二分排序，完成后，所有葫芦娃报数：");
        sortshow.everyoneReport("颜色");
        System.out.println("第二项任务结束。所有任务结束。\n");
    }
}