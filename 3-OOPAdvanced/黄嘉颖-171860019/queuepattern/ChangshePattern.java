package queuepattern;
import creature.*;
import space.*;

public class ChangshePattern implements QueuePattern {
    public void generateTheSpecificPattern(Space battleground, SnakeTeam snakeTeam, int x, int y){
        Demon[] group=snakeTeam.getDemons();
        for (int i=0;i<group.length;i++){
            group[i].moveFrom(battleground);
        }
        if (!battleground.isExceedTheBattleField(x,y)&&!battleground.isExceedTheBattleField(x,y+5)){
            group[0].moveTo(battleground, x, y);
            for (int i=1;i<6;i++){
                y += 1;
                group[i].moveTo(battleground, x, y);
            }
        }
        else
        {
            System.out.println("changshe pattern move wrong!!!");
        }
    }
    public void generateTheSpecificPattern(Space battleground, HuluwaTeam huluwaTeam, int x, int y){
        Huluwa[] group=huluwaTeam.getBrothers();
        for (int i=0;i<group.length;i++){
            group[i].moveFrom(battleground);
        }
        huluwaTeam.randomQueue();
        if (x==0){
            huluwaTeam.bubbleSort();
        }
        if (!battleground.isExceedTheBattleField(x,y)&&!battleground.isExceedTheBattleField(x,y+5)){
            group[0].moveTo(battleground, x, y);
            for (int i=1;i<group.length;i++){
                y += 1;
                group[i].moveTo(battleground, x, y);
            }
        }
        else
        {
            System.out.println("changshe pattern move wrong!!!");
        }
    }
}
