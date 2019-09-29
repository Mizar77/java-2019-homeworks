package creature;

import queuepattern.*;
import space.*;

public class SnakeTeam {
    private Demon demons[];
    private Snake cheerleader;
    public SnakeTeam(){
        demons=new Demon[19];
        demons[0]=new Scorpion();
        demons[1]=new Frog(1);
        demons[2]=new Frog(2);
        demons[3]=new Frog(3);
        demons[4]=new Bat();
        demons[5]=new Bee();
        demons[6]=new Centipede();
        demons[7]=new Frog(1);
        demons[8]=new Frog(2);
        demons[9]=new Frog(3);
        demons[10]=new Bat();
        demons[11]=new Bee();
        demons[12]=new Centipede();
        demons[13]=new Frog(1);
        demons[14]=new Frog(2);
        demons[15]=new Frog(3);
        demons[16]=new Bat();
        demons[17]=new Bee();
        demons[18]=new Centipede();
        cheerleader=new Snake();
    }

    public Snake getCheerleader() {
        return cheerleader;
    }
    public Demon[] getDemons(){return demons;}

    public void generateTheSpecificPattern(QueuePattern pattern, Space battleground, int x, int y){
        pattern.generateTheSpecificPattern(battleground,this,x,y);
    }

    public void generateTheCheerPattern(Space battleground, int x, int y){
        cheerleader.moveTo(battleground,x,y);
    }
}
