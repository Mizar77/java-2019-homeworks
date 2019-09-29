public class God {
    private final static int changeTimes=6;
    public static void main(String[] args){
        GameMap battleField=new GameMap();
        Formation.initFormation();
        battleField.initMap();
        for(int i=0;i<changeTimes;i++) {
            try {
                Thread.sleep(1000);
                battleField.changeFormation();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
