package queuepattern;
import creature.*;
import space.*;

public class HeyiPattern implements QueuePattern {
    public void generateTheSpecificPattern(Space battleground, SnakeTeam snakeTeam, int x, int y){
        Demon[] group=snakeTeam.getDemons();
        for (int i=0;i<group.length;i++){
            group[i].moveFrom(battleground);
        }
        if (!battleground.isExceedTheBattleField(x,y)&&!battleground.isExceedTheBattleField(x+3,y+3)){
            group[0].moveTo(battleground,x,y);
            for (int i=1;i<4;i++){
                x += 1;
                y += 1;
                group[i].moveTo(battleground,x,y);
            }
            for (int i=4;i<7;i++){
                x += 1;
                y -= 1;
                group[i].moveTo(battleground,x,y);
            }
        }
        else
        {
            System.out.println("heyi pattern move wrong!!!");
        }
    }
    public void generateTheSpecificPattern(Space battleground, HuluwaTeam huluwaTeam, int x, int y){
        //if had more huluwas
    }
}
