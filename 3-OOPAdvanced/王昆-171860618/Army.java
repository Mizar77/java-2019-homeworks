import java.util.*;
import javafx.util.*; 
class Army{
    protected Creature commander;
    protected Creature cheerleader;
    protected List<Creature> soldiers;
    protected Formation formation;
    Army(){
        this.soldiers = new ArrayList<>();
    }
    public void setCommander(Creature c){
        this.commander = c;
    }
    public void setCheerleader(Creature c){
        this.cheerleader = c;
    }
    public void addSoldiers(Creature c){
        this.soldiers.add(c);
    }
}
class HuluwaArmy extends Army{
    private Position basePosition;
    HuluwaArmy(Position base){
        basePosition = base;
        this.commander = new Huluwa("大娃","红色");
        this.cheerleader = new Grandpa();
        this.soldiers.add(new Huluwa("二娃","橙色"));
        this.soldiers.add(new Huluwa("三娃","黄色"));
        this.soldiers.add(new Huluwa("四娃","绿色"));
        this.soldiers.add(new Huluwa("五娃","青色"));
        this.soldiers.add(new Huluwa("六娃","蓝色"));
        this.soldiers.add(new Huluwa("七娃","紫色"));
        this.formation = new Formation(basePosition,this.soldiers.size()+1,1);
    }
    public void joinMap(Map map){
        int number = this.soldiers.size();
        List<Position> formationsite = formation.changShe();
        this.cheerleader.joinMap(map,new Position(0,0));
        this.commander.joinMap(map,formationsite.get(0));
        for(int i=0;i<number;i++){
            Position p = formationsite.get(i+1);
            this.soldiers.get(i).joinMap(map,p);
        }
    }
}
class DemonArmy extends Army{
    private Position basePosition;
    DemonArmy(Position base){
        basePosition = base;
        this.commander = new Scorpion();
        this.cheerleader = new Snake();
        for(int i=0;i<6;i++){
            this.soldiers.add(new Follower());
        }
        this.formation = new Formation(basePosition,this.soldiers.size()+1,-1);
    }
    public void joinMap(Map map){
        int number = this.soldiers.size();
        List<Position> formationsite = formation.heYi();
        this.commander.joinMap(map,formationsite.get(0));
        for(int i=0;i<number;i++){
            Position p = formationsite.get(i+1);
            this.soldiers.get(i).joinMap(map,p);
        }
        this.cheerleader.joinMap(map,new Position(0,map.getSize()-1));
    }
    public void changeFormation(Map map){
        int number = this.soldiers.size();
        for(int i=0;i<number;i++){
                this.soldiers.get(i).leaveMap(map);
         }
        List<Position> formationsite = formation.chongE();
        this.commander.joinMap(map,formationsite.get(0));
        for(int i=0;i<number;i++){
            Position t = formationsite.get(i+1);
            if(map.isFree(t)){
                this.soldiers.get(i).joinMap(map,t);
            }
        }
    }
}