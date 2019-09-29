package Life;

import DotMatrix.*;
import Position.*;

public class Cammander extends Life{
    private Life[] minions;
    private DotMatrix dot;
    private Position standard;
    public Cammander(String choosename){
        name=choosename;
        if(name=="爷爷"){
            standard=new Position(4,0);
        }
        else{
            standard=new Position(4,5);
        }
    }
    public void chooseDotMatrix(DotMatrixName matrixname,TwoDimensionsSpace map){
        dot = new DotMatrix(matrixname);
        if(name=="爷爷"){
            minions=new Calabash[7];
            minions[0]=new Calabash(map,"老大");
            minions[1]=new Calabash(map,"老二");
            minions[2]=new Calabash(map,"老三");
            minions[3]=new Calabash(map,"老四");
            minions[4]=new Calabash(map,"老五");
            minions[5]=new Calabash(map,"老六");
            minions[6]=new Calabash(map,"老七");
        }
        else {
            minions = new Life[dot.DotLength()];
            for(int i=0;i<dot.DotLength();i++){
                minions[i]=new Life();
            }
        }
    }
    public void changeLifePosition(TwoDimensionsSpace map){
        if(name=="爷爷") {
            for (int i = 0; i < dot.DotLength(); i++) {
                Position temp = new Position(dot.lifePosition(i).X, dot.lifePosition(i).Y);
                temp.PositionAdd(standard);
                minions[i].move(temp,map);
            }
        }
        else{
            for (int i = 0; i < dot.DotLength(); i++) {
                Position temp = new Position(dot.lifePosition(i).X, dot.lifePosition(i).Y);
                temp.PositionAdd(standard);
                minions[i].changePosition(temp,map);
            }
        }
    }
    public void changeSelfPosition(TwoDimensionsSpace map){
        Position temp=dot.commanderPosition();
        temp.PositionAdd(standard);
        this.changePosition(temp,map);
    }
    public void clear(TwoDimensionsSpace map){
        for(int i=0;i<dot.DotLength();i++){
            minions[i].leaveThere(map);
        }
        this.leaveThere(map);
    }
}
