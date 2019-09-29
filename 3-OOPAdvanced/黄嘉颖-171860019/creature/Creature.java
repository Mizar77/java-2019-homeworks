package creature;

import javafx.scene.image.*;
import space.*;
import java.util.*;
import navigation.*;

public class Creature  {
    protected String name;
    protected Image picture;
    protected String picturePath;
    protected int coordinateX;
    protected int coordinateY;

    public Creature(){
        coordinateX=-1;
        coordinateY=-1;
        name=" ";
    }
    public Creature(String name){
        coordinateX=-1;
        coordinateY=-1;
        this.name=name;
    }

    public int getCoordinateX(){
        return coordinateX;
    }
    public int getCoordinateY(){
        return coordinateY;
    }
    public String getName(){
        return name;
    }
    public String getPicturePath(){
        return picturePath;
    }
    public Image getPicture(){
        return picture;
    }
    public void setCoordinateX(int x){
        coordinateX=x;
    }
    public void setCoordinateY(int y){
        coordinateY=y;
    }

    public void moveFrom(Space battleground){
        if (!battleground.isExceedTheBattleField(coordinateX,coordinateY)){
            battleground.removeTheCreature(coordinateX,coordinateY);
        }
        coordinateX=-1;
        coordinateY=-1;
    }
    public void moveTo(Space battleground, int x, int y){
        if (battleground.isTheCellEmpty(x,y)){
            coordinateX=x;
            coordinateY=y;
            battleground.setTheCreatureOnTheCell(x,y,this);
        }
        else{
            if (!battleground.isExceedTheBattleField(x,y)){
                if (battleground.getTheCreatureOnTheCell(x,y)!=this){
                    //System.out.println("Someone is still on the cell!");
                }
            }
        }
    }

    public Stack<Coordinate> moveFromTo(Space battleground,int destX,int destY)
    {
        Navigation navigation=new Navigation(battleground);
        return navigation.useTheNavigation(battleground,this,destX,destY);
    }
}
