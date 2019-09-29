class Position{
    int x;
    int y;
    Position(int x,int y){
        this.x=x;
        this.y=y;
    }
}
class Formation {
    static int FORMATION_NUM=8;
    private static int NUM=7;
    private static Position[][] preparedFormations=new Position[FORMATION_NUM][NUM];
    static void initFormation(){
        preparedFormations[0]=new Position[]{new Position(0,0),new Position(1,1),new Position(2,2),new Position(3,3),new Position(-1,1),new Position(-2,2),new Position(-3,3)};//鹤翼
        preparedFormations[1]=new Position[]{new Position(0,0),new Position(1,-1),new Position(2,-2),new Position(3,-3),new Position(-1,1),new Position(-2,2),new Position(-3,3)};//雁行
        preparedFormations[2]=new Position[]{new Position(0,0),new Position(-1,1),new Position(-2,0),new Position(-3,1),new Position(1,1),new Position(2,0),new Position(3,1)};//衡轭
        preparedFormations[3]=new Position[]{new Position(0,0),new Position(-1,1),new Position(-2,2),new Position(-3,3),new Position(0,2),new Position(-1,3),new Position(1,3)};//鱼鳞
        preparedFormations[4]=new Position[]{new Position(0,0),new Position(1,1),new Position(-1,1),new Position(2,2),new Position(-2,2),new Position(1,3),new Position(-1,3)};//方*
        preparedFormations[5]=new Position[]{new Position(0,0),new Position(-1,1),new Position(-2,2),new Position(-3,3),new Position(0,1),new Position(1,2),new Position(2,3)};//偃月
        preparedFormations[6]=new Position[]{new Position(0,0),new Position(-1,1),new Position(1,1),new Position(0,1),new Position(0,2),new Position(0,3),new Position(0,4)};//锋矢
        preparedFormations[7]=new Position[]{new Position(0,0),new Position(-1,0),new Position(-2,0),new Position(-3,0),new Position(1,0),new Position(2,0),new Position(3,0)};//长蛇
    }
    static void changeFormation(Object[][] battleField,Creature[] creatures,int formation){
        Position center;
        if(creatures[0].badGuy)
            center=new Position((GameMap.N-1)/2,GameMap.N-6);
        else
            center=new Position((GameMap.N-1)/2,2);
        int dstX,dstY;
        for(int i=0;i<NUM;i++){
            dstX=preparedFormations[formation][i].x+center.x;
            dstY=preparedFormations[formation][i].y+center.y;
            if(battleField[dstX][dstY]==null || creatures[0].x==-1) {
                if(creatures[i].x!=-1)
                    battleField[creatures[i].x][creatures[i].y]=null;
                creatures[i].runTo(battleField, dstX, dstY);
            }
            else
                swap(battleField,creatures[i].x,creatures[i].y,dstX,dstY);
        }
    }
    private static void swap(Object[][] battleField,int x1,int y1,int x2,int y2){
        Object temp=battleField[x1][y1];
        ((Creature)battleField[x2][y2]).runTo(battleField,x1,y1);
        ((Creature)temp).runTo(battleField,x2,y2);
    }
}
