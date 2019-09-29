public class CalabashBrother
{
    // coordinate in Virtual World of The CalabashBrother
    int x;
    int y;
    // some attributes of calabashBrother
    String name;
    String color;
    int order; // 0 refers to 1st child with red color, etc

    public CalabashBrother(String name, String color, int order)
    {
        this.name = name; this.color = color; this.order = order;
    }

    public String getName()
    {
        return name;
    }

    public String getColor()
    {
        return color;
    }

    public void sayName()
    {
        System.out.print(name);
    }

    public void sayColor()
    {
        System.out.print(color);
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void setCoordinante(int x, int y)
    {
        this.x = x; this.y = y;
    }

    public void report(int destX, int destY)
    {
        System.out.print(name + ": (" + x + ", " + y + ") --> ");
        System.out.println("(" + destX + ", " + destY + ")");
    }
}
