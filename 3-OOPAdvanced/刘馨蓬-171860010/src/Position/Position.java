package Position;

import Driction.*;

public class Position{
    public int X,Y;
    public Position(){
        X=0;
        Y=0;
    }
    public Position(int x,int y){
        X=x;
        Y=y;
    }
    public void PositionAdd(Position a){
        X+=a.X;
        Y+=a.Y;
    }
    public boolean isequal(Position a){
        if(X==a.X&&Y==a.Y)
            return true;
        else
            return false;
    }
    public Position surrounding(TwoDimensionsSpace map){
        Position temp=new Position();
        Direction[] directions=new Direction[8];
        directions[0]=new Direction(Directionname.UP);
        directions[1]=new Direction(Directionname.DOWN);
        directions[2]=new Direction(Directionname.LIFT);
        directions[3]=new Direction(Directionname.RIGHT);
        directions[4]=new Direction(Directionname.UP_LEFT);
        directions[5]=new Direction(Directionname.UP_RIGHT);
        directions[6]=new Direction(Directionname.DOWN_LIFT);
        directions[7]=new Direction(Directionname.DOWN_RIGHT);
        for(int i=0;i<8;i++){
            Position offset=directions[0].offSet();
            temp=new Position(offset.X+X,offset.Y+Y);
            if(!map.isSomeoneThere(temp)){
                break;
            }
        }
        return temp;
    }
}