package queuepattern;
import creature.*;
import space.*;

public class FengshiPattern implements QueuePattern {
    public void generateTheSpecificPattern(Space battleground, SnakeTeam snakeTeam, int x, int y){
        Demon[] group=snakeTeam.getDemons();
        for (int i=0;i<group.length;i++){
            group[i].moveFrom(battleground);
        }
        if (!battleground.isExceedTheBattleField(x-3,y)&&!battleground.isExceedTheBattleField(x+3,y+8)){
            group[0].moveTo(battleground, x, y);
            //second layer
            group[1].moveTo(battleground, x-1, y+1);
            group[2].moveTo(battleground, x+1, y+1);
            //third layer
            group[3].moveTo(battleground, x, y+1);
            //forth layer
            group[4].moveTo(battleground, x-2, y+2);
            group[5].moveTo(battleground, x+2, y+2);
            //fifth layer
            group[6].moveTo(battleground, x, y+2);
            //sixth layer
            group[7].moveTo(battleground, x-3, y+3);
            group[8].moveTo(battleground, x+3, y+3);
            //seventh-ninth layer
            group[9].moveTo(battleground, x, y+3);
            group[10].moveTo(battleground, x, y+4);
            group[11].moveTo(battleground, x, y+5);
        }
        else
        {
            System.out.println("fengshi pattern move wrong!!!");
        }
    }
    public void generateTheSpecificPattern(Space battleground, HuluwaTeam huluwaTeam, int x, int y){
        //if had more huluwas
    }
}
