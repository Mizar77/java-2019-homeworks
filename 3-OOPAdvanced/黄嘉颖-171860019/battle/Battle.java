package battle;

import creature.HuluwaTeam;
import creature.SnakeTeam;
import space.*;

public class Battle {
    public Space battleField;
    public HuluwaTeam huluwaTeam;
    public SnakeTeam snakeTeam;
    public Battle(){
        snakeTeam=new SnakeTeam();
        huluwaTeam=new HuluwaTeam();
        battleField=new Space(15);
    }
}
