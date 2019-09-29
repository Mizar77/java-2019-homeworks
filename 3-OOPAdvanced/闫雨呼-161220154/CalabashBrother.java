class Grandpa extends Creature{
    private static String[] brothersNames={"B1","B2","B3","B4","B5","B6","B7"};
    private static final int BROTHERS_NUM=7;
    private CalabashBrother[] calabashBrothers;
    Grandpa(String name) {
        super(name,false);
        calabashBrothers=new CalabashBrother[BROTHERS_NUM];
        for(int i=0;i<BROTHERS_NUM;i++)
            calabashBrothers[i]=new CalabashBrother(brothersNames[i]);
    }
    void setCalabashBrothers(){
        Formation.changeFormation(GameMap.battleField,calabashBrothers,Formation.FORMATION_NUM-1);
    }
}
class CalabashBrother extends Creature{
    CalabashBrother(String name){
        super(name,false);
    }
}
