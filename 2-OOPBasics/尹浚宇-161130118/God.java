public class God
{
    public World createWorld()
    {
        World world = new World();
        return world;
    }

    public CalabashBrother createCalabashBrother(String name, String color, int order)
    {
        CalabashBrother CalaBro = new CalabashBrother(name, color, order);
        return CalaBro;
    }

    public CalabashBrother[] createCalaBros()
    {
        CalabashBrother[] CalaArr = new CalabashBrother[7];
        CalaArr[0] = createCalabashBrother("大娃", "红色", 0);
        CalaArr[1] = createCalabashBrother("二娃", "橙色", 1);
        CalaArr[2] = createCalabashBrother("三娃", "黄色", 2);
        CalaArr[3] = createCalabashBrother("四娃", "绿色", 3);
        CalaArr[4] = createCalabashBrother("五娃", "青色", 4);
        CalaArr[5] = createCalabashBrother("六娃", "蓝色", 5);
        CalaArr[6] = createCalabashBrother("七娃", "紫色", 6);
        return CalaArr;
    }

    public void putCalaBros(World world, CalabashBrother[] CalaArr, int row)
    {
        for (int i = 0; i < CalaArr.length; i++)
        {
            world.map[row][i] = CalaArr[i];
            CalaArr[i].setCoordinante(row, i);
        }
    }

    private void swag(World world, int row, int index, int i)
    {
        if (index == i)
            return;
        int tempX = 6, tempY = 6;

        world.map[tempX][tempY] = world.map[row][index];
        world.map[row][index].report(tempX, tempY);
        world.map[row][index].setCoordinante(tempX, tempY);
        world.map[row][index] = null;


        world.map[row][index] = world.map[row][i];
        world.map[row][i].report(row, index);
        world.map[row][i].setCoordinante(row, index);
        world.map[row][i] = null;

        world.map[row][i] = world.map[tempX][tempY];
        world.map[tempX][tempY].report(row, i);
        world.map[tempX][tempY].setCoordinante(row, i);
        world.map[tempX][tempY] = null;
    }

    public void randPermutation(World world, int row)
    {
        java.util.Random r = new java.util.Random();
        for (int i = 6; i >= 0 ; i--)
        {
            int index = r.nextInt(7);
            swag(world, row, index, i);
        }
    }

    public void makeReported(World world, int row, int mode)
    {
        for (int i = 0; i < 7; i++)
        {
            if (mode == 0)
                world.map[row][i].sayName();
            else if (mode == 1)
                world.map[row][i].sayColor();
            System.out.print(" ");
        }
        System.out.println();
    }

    public void sortByName(World world, int row)
    {
        for (int i = 0; i < 7; i++)
            for (int j = i + 1; j < 7; j++)
                if (world.map[row][i].order > world.map[row][j].order)
                    swag(world, row, i, j);
    }

    private void Qsort(World world, int row, CalabashBrother[] arr, int left, int right)
    {
        if(left >= right)
            return;

        int pivot = arr[left].order;
        int i = left;
        int j = right;

        while (i < j)
        {
            while(arr[j].order >= pivot && i < j)
                j--;

            while(arr[i].order <= pivot && i < j)
                i++;

            swag(world, row, i, j);
        }
        swag(world, row, left, i);

        Qsort(world, row, arr, left, i - 1);
        Qsort(world, row, arr, i + 1, right);
    }

    public void sortByColor(World world, int row)
    {
        Qsort(world, row, world.map[row], 0, 6);
    }
}