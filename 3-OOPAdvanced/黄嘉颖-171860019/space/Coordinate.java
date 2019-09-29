package space;

public class Coordinate {
    private int x;
    private int y;

    public Coordinate(){
        this.x=-1;
        this.y=-1;
    }
    public Coordinate(int x,int y){
        this.x=x;
        this.y=y;
    }

    public int getX(){return x;}
    public int getY(){return y;}
}
