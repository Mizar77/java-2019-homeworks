package Life;

import Position.*;
import java.util.Random;

public class Calabash extends Life{
    public Calabash(TwoDimensionsSpace map, String calabashname){
        name=calabashname;
        do {
            Random rand = new Random();
            int X = rand.nextInt(map.N)+1;
            int Y = rand.nextInt(map.N)+1;
            position = new Position(X, Y);
        }while(map.isSomeoneThere(position));
        map.stand(this);
    }
}
