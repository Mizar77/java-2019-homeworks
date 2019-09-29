package Driction;

import Position.*;

public class Direction{
    private Directionname name;
    private Position offset;
    public Direction(Directionname directionname){
        name=directionname;
        switch (directionname){
            case UP:
                offset=new Position(-1,0);
                break;
            case DOWN:
                offset=new Position(1,0);
                break;
            case LIFT:
                offset=new Position(0,-1);
                break;
            case RIGHT:
                offset=new Position(0,1);
                break;
            case UP_LEFT:
                offset=new Position(-1,-1);
                break;
            case UP_RIGHT:
                offset=new Position(-1,1);
                break;
            case DOWN_LIFT:
                offset=new Position(1,-1);
                break;
            case DOWN_RIGHT:
                offset=new Position(1,1);
                break;
            default:
                System.out.println("Directionname don't exist!");
        }
    }
    public Position offSet(){
        return offset;
    }
    public Directionname putName(){
        return name;
    }
}