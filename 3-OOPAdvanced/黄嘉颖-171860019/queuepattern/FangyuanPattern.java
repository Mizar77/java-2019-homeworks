package queuepattern;
import creature.*;
import space.*;

public class FangyuanPattern implements QueuePattern {
    public void generateTheSpecificPattern(Space battleground, SnakeTeam snakeTeam, int x, int y){
        Demon[] group=snakeTeam.getDemons();
        for (int i=0;i<group.length;i++){
            group[i].moveFrom(battleground);
        }
        if (!battleground.isExceedTheBattleField(x-2,y)&&!battleground.isExceedTheBattleField(x+2,y+4)){
            group[0].moveTo(battleground, x, y);
            //second layer
            group[1].moveTo(battleground,x-1,y+1);
            group[2].moveTo(battleground,x+1,y+1);
            //third layer
            group[3].moveTo(battleground,x-2,y+2);
            group[4].moveTo(battleground,x+2,y+2);
            //forth layer
            group[5].moveTo(battleground,x-1,y+3);
            group[6].moveTo(battleground,x+1,y+3);
            //fifth layer
            group[7].moveTo(battleground,x,y+4);
        }
        else
        {
            System.out.println("fangyuan pattern move wrong!!!");
        }
    }
    public void generateTheSpecificPattern(Space battleground, HuluwaTeam huluwaTeam, int x, int y){
        //if had more huluwas
    }
}
