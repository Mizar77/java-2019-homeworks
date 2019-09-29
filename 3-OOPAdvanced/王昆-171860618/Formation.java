import java.util.*;
import javafx.util.*; 
class Formation{
    Position base;
    int num;
    int direction;
    Formation(Position p,int n,int d){
        base = p;
        num = n;
        direction = d;
    }
    public List<Position> heYi(){
    List<Position> heYisites =  new ArrayList<>();
    heYisites.add(base);
    int x = base.getX();
    int y = base.getY();
    for(int i=1;i<num;i++){
        int t = (i%2 == 1)?1:-1;
        int p = (i-1)/2+1;
        heYisites.add(new Position(x+p*t,y+p*direction));
    }
    return heYisites;
   }
    public List<Position> yanXing(){
    List<Position> yanXingsites =  new ArrayList<>();
    yanXingsites.add(base);
    int x = base.getX();
    int y = base.getY();
    for(int i=1;i<num;i++){
        yanXingsites.add(new Position(x+i,y+i*direction));
    }
    return yanXingsites;
   }
   public List<Position> chongE(){
    List<Position> chongEsites =  new ArrayList<>();
    chongEsites.add(base);
    int x = base.getX();
    int y = base.getY();
    for(int i=1;i<num;i++){
        chongEsites.add(new Position(x+i%2,y+i*direction));
    }
    return chongEsites;
   }
   public List<Position> changShe(){
    List<Position> changShesites =  new ArrayList<>();
    changShesites.add(base);
    int x = base.getX();
    int y = base.getY();
    for(int i=1;i<num;i++){
        changShesites.add(new Position(x,y+i*direction));
    }
    return changShesites;
   }
   static public List<Position> yanYue(){
    List<Position> yanYuesites =  Arrays.asList(new Position(0,0), new Position(0,1), new Position(1,0),
    new Position(-1,0),new Position(0,-1),new Position(1,1),new Position(-1,1),new Position(1,-1),new Position(-1,-1),
    new Position(0,2),new Position(1,2),new Position(1,3),new Position(2,3),new Position(3,4),
    new Position(0,-2),new Position(1,-2),new Position(1,-3),new Position(2,-3),new Position(3,-4));
    return yanYuesites;
   }
}
