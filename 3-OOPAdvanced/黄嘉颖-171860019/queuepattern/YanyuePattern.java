package queuepattern;
import creature.*;
import space.*;

public class YanyuePattern implements QueuePattern {
    public void generateTheSpecificPattern(Space battleground, SnakeTeam snakeTeam, int x, int y){
        Demon[] group=snakeTeam.getDemons();
        for (int i=0;i<group.length;i++){
            group[i].moveFrom(battleground);
        }
        if (!battleground.isExceedTheBattleField(x,y)&&!battleground.isExceedTheBattleField(x-5,y+8)){
            group[0].moveTo(battleground, x, y);
            //second layer
            group[1].moveTo(battleground, x-2, y+1);
            group[2].moveTo(battleground, x-1, y+1);
            //third layer
            group[3].moveTo(battleground, x-3, y+2);
            group[4].moveTo(battleground, x-2, y+2);
            //forth-sixth layer
            for(int i=0;i<3;i++) {
                group[3*i+5].moveTo(battleground,x-5,y+3+i);
                group[3*i+6].moveTo(battleground,x-4,y+3+i);
                group[3*i+7].moveTo(battleground,x-3,y+3+i);
            }
            //seventh layer
            group[14].moveTo(battleground, x-3, y+6);
            group[15].moveTo(battleground, x-2, y+6);
            //eighth layer
            group[16].moveTo(battleground, x-2, y+7);
            group[17].moveTo(battleground, x-1, y+7);
            //ninth layer
            group[18].moveTo(battleground,x,y+8);
        }
        else
        {
            System.out.println("yanyue pattern move wrong!!!");
        }
    }
    public void generateTheSpecificPattern(Space battleground, HuluwaTeam huluwaTeam, int x, int y){
        //if had more huluwas
    }
}
