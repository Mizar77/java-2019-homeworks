
public class Homework2
{
    public static void main(String[] args)//主函数
    {
        int[] rank = {1, 2, 3, 4, 5, 6, 7};
        String[] name = {"dawa", "erwa", "sanwa", "siwa", "wuwa", "liuwa", "qiwa"};
        Color[] color = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE, Color.PURPLE};
        Position[] position = {new Position(1), new Position(2), new Position(3), new Position(4), new Position(5), new Position(6), new Position(7)};
        Queue queue = new Queue(7);//创建一个队列
        for (int i : rank)
            queue.add(new CalabashBrothers(i, name[i - 1], position[i - 1], color[i - 1]));//用上述数据初始化一个葫芦娃队列

        queue.shuffle();//打乱队列
        bubbleSort(queue);//冒泡排序
        queue.shuffle();//打乱队列
        binaryInsertSort(queue);//二分排序
    }

    public static void bubbleSort(Queue queue)//冒泡排序函数
    {
        System.out.println("Bubble Sort:");
        for (int i = 0; i < queue.size; i++)
            for (int j = 0; j < queue.size - i - 1; j++)
            {
                if (queue.at(j).getRank() > queue.at(j + 1).getRank())//依照rank排序
                {
                   //队列中第j个葫芦娃与第j+1个葫芦娃交换位置
                    Position temp = queue.at(j).position;
                    queue.at(j).walkTo(queue.at(j+1).position);//葫芦娃j走到葫芦娃j+1的位置上,走的过程中会报告走向
                    queue.at(j + 1).walkTo(temp);//葫芦娃j + 1走到葫芦娃j的位置上,走的过程中会报告走向
                    queue.exchange(j, j + 1);
                }
            }
        for (int i = 0; i < queue.size; i++)//队列中每个娃报自己的名字
            queue.at(i).report(queue.at(i).getName());
        System.out.println("Bubble Sort Finished!\n");
    }

    public static void binaryInsertSort(Queue queue)//二分排序函数
    {
        System.out.println("Binary Insert Sort:");
        for (int i = 0; i < queue.size; i++)
        {
            int key = binarySearch(queue, i);
            for (int j = i; j > key; j--)
            {
                //队列中第j个葫芦娃与第j-1个葫芦娃交换位置
                Position temp = queue.at(j).position;
                queue.at(j).walkTo(queue.at(j-1).position);//葫芦娃j走到葫芦娃j-1的位置上,走的过程中会报告走向
                queue.at(j - 1).walkTo(temp);//葫芦娃j - 1走到葫芦娃j的位置上,走的过程中会报告走向
                queue.exchange(j, j - 1);
            }
        }
        for (int i = 0; i < queue.size; i++)//队列中每个娃报自己的颜色
            queue.at(i).report(queue.at(i).getColor().name());
        System.out.println("Binary Insert Sort Finished\n");
    }

    public static int binarySearch(Queue queue, int i)//二分查找
    {
        int start = 0, end = i, mid = -1;
        while (start < end)
        {
            mid = (start + end) / 2;
            if (queue.at(mid).getColor().getIndex() > queue.at(i).getColor().getIndex())
                end = mid;
            else if (queue.at(mid).getColor().getIndex() < queue.at(i).getColor().getIndex())
                start = mid + 1;
        }
        return start;
    }
}

enum Color//颜色的定义
{
    RED(1),
    ORANGE(2),
    YELLOW(3),
    GREEN(4),
    CYAN(5),
    BLUE(6),
    PURPLE(7);

    private int index;

    Color(int index)
    {
        this.index = index;
    }

    public int getIndex()
    {
        return index;
    }
}

class Position//位置的定义
{
    public int demision;
    public int x;
    public int y;
    public int z;

    public Position(int x)
    {
        this.demision = 1;
        this.x = x;
    }

    public Position(int x, int y)
    {
        this.demision = 2;
        this.x = x;
        this.y = y;
    }

    public Position(int x, int y, int z)
    {
        this.demision = 3;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

class CalabashBrothers//葫芦娃的定义
{
    private int rank;
    private String name;
    private Color color;
    public Position position;

    public CalabashBrothers(int rank, String name, Position position, Color color)
    {
        this.rank = rank;
        this.name = name;
        this.position = position;
        this.color = color;
    }

    public String getName()
    {
        return name;
    }

    public int getRank()
    {
        return rank;
    }

    public Color getColor()
    {
        return color;
    }

    public void report(String sentence)
    {
        System.out.println(this.name + ": " + sentence);
    }

    public void walkTo(Position position)
    {
        report(this.position.x + " -> " + position.x);
        this.position = position;
    }
}

class Queue//队列的定义
{
    public int size;
    CalabashBrothers[] queue;

    Queue(int size)
    {
        this.size = size;
        this.queue = new CalabashBrothers[size];
    }

    public boolean add(CalabashBrothers element)
    {
        for (int i = 0; i < size; i++)
        {
            if (queue[i] == null)
            {
                queue[i] = element;
                return true;
            }
        }
        return false;
    }

    public void clear()
    {
        for (int i = 0; i < size; i++)
            queue[i] = null;
    }

    public CalabashBrothers at(int i)
    {
        return queue[i];
    }

    public void exchange(int i, int j)
    {
        CalabashBrothers temp = queue[j];
        queue[j] = queue[i];
        queue[i] = temp;
    }

    public void shuffle()
    {
        for (int i = 0; i < size; i++)
        {
            int randIndex1 = (int) (Math.random() * size);
            int randIndex2 = (int) (Math.random() * size);
            CalabashBrothers temp = queue[randIndex1];
            queue[randIndex1] = queue[randIndex2];
            queue[randIndex2] = temp;
            queue[randIndex1].position = new Position(randIndex1 + 1);
            queue[randIndex2].position = new Position(randIndex2 + 1 );
        }
    }
}
