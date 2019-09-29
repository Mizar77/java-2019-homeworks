public class Main
{
    public static void main(String[] args)
    {
        System.out.println("天地鸿蒙之初, 多元宇宙中诞生了一位创世神.");
        God god = new God();

        System.out.println("某一天, 神突发奇想, 在茫茫宇宙中创造了一个葫芦娃世界.");
        World world = god.createWorld();

        System.out.println("之后, 神在葫芦娃世界里创造了七个迥然不同的葫芦娃, 给世界带去了欢声笑语.");
        CalabashBrother[] CalaArr = god.createCalaBros();

        System.out.println("平日里, 神有许多兴趣爱好, 其中一项就是学习算法设计与分析.");
        System.out.println("在参悟了冒泡排序和快速排序之后, 神决定利用自己创造的葫芦娃世界实际演练一下.");

        System.out.println("首先, 神让葫芦兄弟顺序站在第一行.");
        god.putCalaBros(world, CalaArr, 0);

        System.out.println("然后, 神随机打乱了葫芦兄弟的列顺序.");
        god.randPermutation(world, 0);

        System.out.println("接着, 神以名字作为键值对葫芦兄弟进行冒泡排序.");
        god.sortByName(world, 0);

        System.out.println("排序后, 神让葫芦兄弟从前向后报上名来.");
        god.makeReported(world, 0, 0);

        System.out.println("然后, 神又随机打乱了葫芦兄弟的列顺序.");
        god.randPermutation(world, 0);

        System.out.println("接着, 神以颜色作为键值对葫芦兄弟进行快速排序.");
        god.sortByColor(world, 0);

        System.out.println("排序后, 神让葫芦兄弟从前向后报上颜色来.");
        god.makeReported(world, 0, 1);

        System.out.println("经过实际演练后, 神很满意自己的学习效果, 于是去休息了.");
    }
}