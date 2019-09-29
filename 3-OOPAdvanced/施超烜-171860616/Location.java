import java.util.*;
public class Location{
    private int x,y;//该位置在地图中的坐标
    private Creature creature;//该位置上的生物
    Location(int i,int j){
        x=i;y=j;
        creature= new Creature();
    }
    public int getx(){return x;}
    public int gety(){return y;}
    public Creature getCreature(){return creature;}
    public void setCreature(Creature newCreature){creature=newCreature;}
}