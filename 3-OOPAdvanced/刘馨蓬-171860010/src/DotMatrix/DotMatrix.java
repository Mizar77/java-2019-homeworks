package DotMatrix;

import Position.*;


public class DotMatrix{
    private DotMatrixName name;
    private Position[] logiclife;
    private Position logiccommander;
    private int count;
    public DotMatrix(DotMatrixName choose){
        name=choose;
        switch (choose){
            case HEYI:
                count=7;
                logiclife=new Position[7];
                logiclife[0]=new Position(1,4);
                logiclife[1]=new Position(2,3);
                logiclife[2]=new Position(3,2);
                logiclife[3]=new Position(4,1);
                logiclife[4]=new Position(5,2);
                logiclife[5]=new Position(6,3);
                logiclife[6]=new Position(7,4);
                logiccommander=new Position(4,3);
                break;
            case YANXING:
                count=5;
                logiclife=new Position[5];
                logiclife[0]=new Position(1,5);
                logiclife[1]=new Position(2,4);
                logiclife[2]=new Position(3,3);
                logiclife[3]=new Position(4,2);
                logiclife[4]=new Position(5,1);
                logiccommander=new Position(5,5);
                break;
            case HENGE:
                count=6;
                logiclife=new Position[6];
                logiclife[0]=new Position(1,2);
                logiclife[1]=new Position(2,1);
                logiclife[2]=new Position(3,2);
                logiclife[3]=new Position(4,1);
                logiclife[4]=new Position(5,2);
                logiclife[5]=new Position(6,1);
                logiccommander=new Position(3,4);
                break;
            case CHANGSHE:
                count=6;
                logiclife=new Position[6];
                logiclife[0]=new Position(1,1);
                logiclife[1]=new Position(2,1);
                logiclife[2]=new Position(3,1);
                logiclife[3]=new Position(4,1);
                logiclife[4]=new Position(5,1);
                logiclife[5]=new Position(6,1);
                logiccommander=new Position(3,3);
                break;
            case YULIN:
                count=10;
                logiclife=new Position[10];
                logiclife[0]=new Position(1,1);
                logiclife[1]=new Position(2,2);
                logiclife[2]=new Position(3,1);
                logiclife[3]=new Position(3,2);
                logiclife[4]=new Position(3,3);
                logiclife[5]=new Position(4,1);
                logiclife[6]=new Position(4,2);
                logiclife[7]=new Position(4,3);
                logiclife[8]=new Position(4,4);
                logiclife[9]=new Position(5,2);
                logiccommander=new Position(3,5);
                break;
            case FANGMEN:
                count=8;
                logiclife=new Position[8];
                logiclife[0]=new Position(1,3);
                logiclife[1]=new Position(2,2);
                logiclife[2]=new Position(2,4);
                logiclife[3]=new Position(3,1);
                logiclife[4]=new Position(3,5);
                logiclife[5]=new Position(4,2);
                logiclife[6]=new Position(4,4);
                logiclife[7]=new Position(5,3);
                logiccommander=new Position(3,7);
                break;
            case YANYUE:
                count=19;
                logiclife=new Position[19];
                logiclife[0]=new Position(1,6);
                logiclife[1]=new Position(2,4);
                logiclife[2]=new Position(2,5);
                logiclife[3]=new Position(3,3);
                logiclife[4]=new Position(3,4);
                logiclife[5]=new Position(4,1);
                logiclife[6]=new Position(4,2);
                logiclife[7]=new Position(4,3);
                logiclife[8]=new Position(5,1);
                logiclife[9]=new Position(5,2);
                logiclife[10]=new Position(5,3);
                logiclife[11]=new Position(6,1);
                logiclife[12]=new Position(6,2);
                logiclife[13]=new Position(6,3);
                logiclife[14]=new Position(7,3);
                logiclife[15]=new Position(7,4);
                logiclife[16]=new Position(8,4);
                logiclife[17]=new Position(8,5);
                logiclife[18]=new Position(9,6);
                logiccommander=new Position(5,8);
                break;
            case FENGSHI:
                count=12;
                logiclife=new Position[12];
                logiclife[0]=new Position(1,4);
                logiclife[1]=new Position(2,3);
                logiclife[2]=new Position(3,2);
                logiclife[3]=new Position(4,1);
                logiclife[4]=new Position(4,2);
                logiclife[5]=new Position(4,3);
                logiclife[6]=new Position(4,4);
                logiclife[7]=new Position(4,5);
                logiclife[8]=new Position(4,6);
                logiclife[9]=new Position(5,2);
                logiclife[10]=new Position(6,3);
                logiclife[11]=new Position(7,4);
                logiccommander=new Position(3,8);
                break;
            case HULUWA:
                count=7;
                logiclife=new Position[7];
                logiclife[0]=new Position(1,3);
                logiclife[1]=new Position(2,3);
                logiclife[2]=new Position(3,3);
                logiclife[3]=new Position(4,3);
                logiclife[4]=new Position(5,3);
                logiclife[5]=new Position(6,3);
                logiclife[6]=new Position(7,3);
                logiccommander=new Position(4,1);
                break;
            default:
                System.out.println("DotMatrixName don't exist!");
        }
    }
    public Position commanderPosition(){
        return logiccommander;
    }
    public Position lifePosition(int i){
        return logiclife[i];
    }
    public int DotLength(){
        return count;
    }
}
