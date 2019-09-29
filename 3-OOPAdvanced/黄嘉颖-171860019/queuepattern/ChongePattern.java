package queuepattern;

import creature.*;
import space.*;

public class ChongePattern implements QueuePattern {
    public void generateTheSpecificPattern(Space battleground, SnakeTeam snakeTeam, int x, int y){
        Demon[] group=snakeTeam.getDemons();
        for (int i=0;i<group.length;i++){
            group[i].moveFrom(battleground);
        }
        if (!battleground.isExceedTheBattleField(x,y)&&!battleground.isExceedTheBattleField(x-1,y-3)){
            group[0].moveTo(battleground, x, y);
            for (int i=1;i<6;i++){
                y += 1;
                if (i%2==1) group[i].moveTo(battleground, x-1, y);
                else group[i].moveTo(battleground, x, y);
            }
        }
        else
        {
            System.out.println("chonge pattern move wrong!!!");
        }
    }
    public void generateTheSpecificPattern(Space battleground, HuluwaTeam huluwaTeam, int x, int y){
        //if had more huluwas
    }
}
