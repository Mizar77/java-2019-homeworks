import java.util.*;
import javafx.util.*; 
class Position{
    private int x;
    private int y;
    Position(int a,int b) {
        this.x = a;
        this.y = b;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
class Map{
    private int size;
    Creature[][] map;
    Map(int n){ 
        size =n;
        map = new Creature[size][size];
        for(int i=0;i<size;i++)
            for(int j=0;j<size;j++)
            map[i][j] = null;
    }
    public int getSize(){
        return size;
    }
    public boolean isFree(Position p){
        if(map[p.getX()][p.getY()]==null){
            return true;
        }else{
            return false;
        }
    }
    public void addCreatrue(Creature c,Position p){
        map[p.getX()][p.getY()] = c;
    }
    public void removeCreatrue(Position p){
        map[p.getX()][p.getY()] = null;
    }
    public void printMap(){
        for(int i=0;i<size;i++)
        {
            for(int j = 0;j<size;j++)
            {
                if(map[i][j]!=null){
                    System.out.print(map[i][j].getIcon());
                }        
                else{
                    System.out.print(' ');
                }               
                System.out.print(' ');
            }
            System.out.print('\n');
        }
    }
}