import java.util.*;
import javafx.util.*; 
class Creature{
    protected char icon;
    protected Position position;
    public char getIcon(){
        return this.icon;
    }
    public void setIcon(char c){
         this.icon = c;
    }
    public boolean Move(Map map,Position p){
         if(this.position == null)
             return false;
         int x = p.getX();
         int y = p.getY();
         int size = map.getSize();
         if(x >size|| y > size || x<0 || y<0 || map.isFree(p)){
              return false;
         }else{
             map.removeCreatrue(this.position);
             this.position = new Position(x, y);
             map.addCreatrue(this,this.position);
             return true;
         }
     }
     public boolean leaveMap(Map map){
         if(this.position == null)
             return false;
         int x = this.position.getX();
         int y = this.position.getY();
         int size = map.getSize();
         if(x >size|| y > size || x<0 || y<0){
              return false;
         }else{
            map.removeCreatrue(this.position);
            this.position = null;
            return true;
         }
 
     }
    public boolean joinMap(Map map,Position p){
        int x = p.getX();
        int y = p.getY();
        int size = map.getSize();
        if(x >size|| y > size || x<0 || y<0 || !map.isFree(p)){
             return false;
        }else{
            this.position = new Position(x, y);
            map.addCreatrue(this,this.position);
            return true;
        }
    }
 } 
 class Huluwa extends Creature{
     private String name;
     private String color;
     Huluwa(String n,String c){
         this.name = n;
         this.color = c;
         //this.icon = name.charAt(0);
         this.icon = 'h';
     }
 }
 class Grandpa extends Creature{
     private String name;
     Grandpa(){
         this.name = "ÀÏÒ¯Ò¯";
         //this.icon = 'Ò¯';
         this.icon = 'g';
     }
 }
 class Scorpion extends Creature{
     private String name;
     Scorpion(){
         this.name = "Ð«×Ó¾«";
         this.icon = 'Ð«';
         this.icon = 'x';
     }
 }
 class Snake extends Creature{
     private String name;
     Snake(){
         this.name = "Éß¾«";
         this.icon = 's';
     }
 }
 class Follower extends Creature{
     private String name;
     Follower(){
         this.name = "Ð¡à¶†ª";
         //this.icon = 'à¶';
         this.icon = 'f';
     }
 }
 