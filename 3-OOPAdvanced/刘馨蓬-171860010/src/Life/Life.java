package Life;

import Position.*;
import Driction.*;
import java.util.Random;
public class Life {
    protected Position position;
    protected String name;
    public Life(){
        name="小喽啰";
        position=new Position();
    }
    public void changePosition(Position destination,TwoDimensionsSpace map){
        Position temp=new Position();
        if(position.isequal(temp)){
            position=destination;
            standThere(map);
        }
        else {
            leaveThere(map);
            position = destination;
            standThere(map);
        }
    }
    public Position getPosition(){
        return position;
    }
    public Direction[] choosedirection(Position now,Position destination){
        Direction[] directions=new Direction[8];
        boolean equal=false;
        if(now.X>destination.X){
            if(now.Y>destination.Y){
                directions[0]=new Direction(Directionname.UP);
                directions[1]=new Direction(Directionname.LIFT);
                directions[2]=new Direction(Directionname.UP_LEFT);
                directions[3]=new Direction(Directionname.RIGHT);
                directions[4]=new Direction(Directionname.DOWN);
                directions[5]=new Direction(Directionname.UP_RIGHT);
                directions[6]=new Direction(Directionname.DOWN_LIFT);
                directions[7]=new Direction(Directionname.DOWN_RIGHT);
            }
            else {
                if(now.Y==destination.Y){
                    equal=true;
                }
                directions[0]=new Direction(Directionname.UP);
                directions[1]=new Direction(Directionname.RIGHT);
                directions[2]=new Direction(Directionname.UP_RIGHT);
                directions[3]=new Direction(Directionname.LIFT);
                directions[4]=new Direction(Directionname.UP_LEFT);
                directions[5]=new Direction(Directionname.DOWN_RIGHT);
                directions[6]=new Direction(Directionname.DOWN_LIFT);
                directions[7]=new Direction(Directionname.DOWN);
            }
        }
        else if(now.X<destination.X){
            if (now.Y > destination.Y) {
                directions[0] = new Direction(Directionname.DOWN);
                directions[1] = new Direction(Directionname.LIFT);
                directions[2] = new Direction(Directionname.DOWN_LIFT);
                directions[3] = new Direction(Directionname.RIGHT);
                directions[4] = new Direction(Directionname.UP);
                directions[5] = new Direction(Directionname.UP_RIGHT);
                directions[6] = new Direction(Directionname.UP_LEFT);
                directions[7] = new Direction(Directionname.DOWN_RIGHT);
            } else {
                if(now.Y==destination.Y){
                    equal=true;
                }
                directions[0] = new Direction(Directionname.DOWN);
                directions[1] = new Direction(Directionname.RIGHT);
                directions[2] = new Direction(Directionname.DOWN_RIGHT);
                directions[3] = new Direction(Directionname.LIFT);
                directions[4] = new Direction(Directionname.UP_LEFT);
                directions[5] = new Direction(Directionname.UP_RIGHT);
                directions[6] = new Direction(Directionname.DOWN_LIFT);
                directions[7] = new Direction(Directionname.UP);
            }
        }
        else{
            equal=true;
            if (now.Y > destination.Y) {
                directions[0] = new Direction(Directionname.LIFT);
                directions[1] = new Direction(Directionname.DOWN);
                directions[2] = new Direction(Directionname.DOWN_LIFT);
                directions[3] = new Direction(Directionname.RIGHT);
                directions[4] = new Direction(Directionname.UP);
                directions[5] = new Direction(Directionname.UP_RIGHT);
                directions[6] = new Direction(Directionname.UP_LEFT);
                directions[7] = new Direction(Directionname.DOWN_RIGHT);
            } else {
                directions[0] = new Direction(Directionname.RIGHT);
                directions[1] = new Direction(Directionname.DOWN);
                directions[2] = new Direction(Directionname.DOWN_RIGHT);
                directions[3] = new Direction(Directionname.LIFT);
                directions[4] = new Direction(Directionname.UP_LEFT);
                directions[5] = new Direction(Directionname.UP_RIGHT);
                directions[6] = new Direction(Directionname.DOWN_LIFT);
                directions[7] = new Direction(Directionname.UP);
            }
        }
        Direction[] randdirections = new Direction[8];
        if(!equal) {
            Random rand = new Random();
            boolean[] isempty = new boolean[8];
            for (int i = 0; i < 8; i++) {
                isempty[i] = true;
            }
            for (int i = 0; i < 3; i++) {
                int x = rand.nextInt(3);
                while (!isempty[x]) {
                    x = rand.nextInt(3);
                }
                randdirections[i] = directions[x];
                isempty[x] = false;
            }
            for (int i = 3; i < 8; i++) {
                int x = rand.nextInt(5);
                while (!isempty[x + 3]) {
                    x = rand.nextInt(5);
                }
                randdirections[i] = directions[x + 3];
                isempty[x + 3] = false;
            }
        }
        else{
            Random rand = new Random();
            boolean[] isempty = new boolean[8];
            for (int i = 0; i < 8; i++) {
                isempty[i] = true;
            }
            for (int i = 0; i < 1; i++) {
                int x = rand.nextInt(1);
                while (!isempty[x]) {
                    x = rand.nextInt(1);
                }
                randdirections[i] = directions[x];
                isempty[x] = false;
            }
            for (int i = 1; i < 8; i++) {
                int x = rand.nextInt(7);
                while (!isempty[x + 1]) {
                    x = rand.nextInt(7);
                }
                randdirections[i] = directions[x + 1];
                isempty[x + 1] = false;
            }
        }
        return randdirections;
    }
    public void leaveThere(TwoDimensionsSpace map){
        map.leave(position);
        position.X=0;
        position.Y=0;
    }
    private void standThere(TwoDimensionsSpace map){
        map.stand(this);
    }
    public String putname(){
        return name;
    }
    public void move(Position temp,TwoDimensionsSpace map){
        if (map.isSomeoneThere(temp)) {
            Position next = temp.surrounding(map);
            Life life = map.getlife(temp);
            life.changePosition(next,map);
        }
        while (!position.isequal(temp)) {
            Direction[] directionstack = choosedirection(position, temp);
            for (int j = 0; j < 8; j++) {
                Position offset = directionstack[j].offSet();
                Position next = new Position(offset.X + position.X, offset.Y + position.Y);
                if (!map.isSomeoneThere(next)) {
                    changePosition(next,map);
                    break;
                }
            }
        }
    }
}

