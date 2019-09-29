package location;

public class Direction {
    public final double degree;

    public final double radian;

    public final double xDir;

    public final double yDir;

    public Direction(double degree){
        this.degree  = degree;
        this.radian = Math.toRadians(degree);
        this.xDir = Math.cos(radian);
        this.yDir = Math.sin(radian);
    }
}
