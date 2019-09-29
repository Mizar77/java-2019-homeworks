package War;

import DotMatrix.*;
import Life.*;
import Position.*;

public class War {
    public static void main(String[] args){
        TwoDimensionsSpace map=new TwoDimensionsSpace();
        Cammander yeye=new Cammander("爷爷");
        Cammander xiezi=new Cammander("蝎子精");
        yeye.chooseDotMatrix(DotMatrixName.HULUWA,map);
        yeye.changeLifePosition(map);
        xiezi.chooseDotMatrix(DotMatrixName.HEYI,map);
        xiezi.changeLifePosition(map);
        yeye.changeSelfPosition(map);
        xiezi.changeSelfPosition(map);
        map.printMap();
        System.out.println("======================================================");
        xiezi.clear(map);
        xiezi.chooseDotMatrix(DotMatrixName.YANYUE,map);
        xiezi.changeLifePosition(map);
        xiezi.changeSelfPosition(map);
        map.printMap();
    }
}

