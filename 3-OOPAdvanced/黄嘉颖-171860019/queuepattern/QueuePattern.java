package queuepattern;
import space.*;
import  creature.*;


public interface QueuePattern {
    void generateTheSpecificPattern(Space battleground, SnakeTeam snakeTeam, int x, int y);
    void generateTheSpecificPattern(Space battleground, HuluwaTeam huluwaTeam, int x, int y);
}
