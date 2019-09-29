package queuepattern;
import creature.*;
import space.*;

public class YulinPattern implements QueuePattern {
    public void generateTheSpecificPattern(Space battleground, SnakeTeam snakeTeam, int x, int y){
        Demon[] group=snakeTeam.getDemons();
        for (int i=0;i<group.length;i++){
            group[i].moveFrom(battleground);
        }
        if (!battleground.isExceedTheBattleField(x-3,y)&&!battleground.isExceedTheBattleField(x+3,y+4)){
            group[0].moveTo(battleground, x, y);
            //second layer
            group[1].moveTo(battleground, x+1, y+1);
            //third layer
            int start=x-2;
            for(int i=0;i<3;i++) {
                group[i+2].moveTo(battleground,start+2*i,y+2);
            }
            //forth layer
            start=x-3;
            for(int i=0;i<4;i++) {
                group[i+5].moveTo(battleground,start+2*i,y+3);
            }
            //fifth layer
            group[9].moveTo(battleground,x,y+4);
        }
        else
        {
            System.out.println("yulin pattern move wrong!!!");
        }
    }
    public void generateTheSpecificPattern(Space battleground, HuluwaTeam huluwaTeam, int x, int y){
        //if had more huluwas
    }
}
