class Main{
    public static void main(String[] args){
        Map battlefield = new Map(40);
        //battlefield.printMap();
        HuluwaArmy huluwaArmy = new HuluwaArmy(new Position(battlefield.getSize()/2,0));
        DemonArmy demonArmy = new DemonArmy(new Position(battlefield.getSize()/2,battlefield.getSize()-1));
        huluwaArmy.joinMap(battlefield);
        demonArmy.joinMap(battlefield);
        battlefield.printMap();
        demonArmy.changeFormation(battlefield);
        battlefield.printMap();
    }
} 
