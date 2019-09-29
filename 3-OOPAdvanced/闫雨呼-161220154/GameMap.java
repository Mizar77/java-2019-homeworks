import java.util.Random;

class GameMap {
    final static int N=15;
    static Object[][] battleField=new Object[N][N];
    private Grandpa grandpa;
    private ScorpionSperm scorpionSperm;
    private Random rand=new Random();
    void initMap(){
        for(int i=0;i<N;i++)
            for(int j=0;j<N;j++)
                battleField[i][j]=null;
        setGrandpaAndScorpionSperm();
        print();
    }
    private void setGrandpaAndScorpionSperm(){
        grandpa=new Grandpa("GP");
        grandpa.runTo(battleField,(N-1)/2,0);
        scorpionSperm=new ScorpionSperm("SS");
        scorpionSperm.runTo(battleField,(N-1)/2,N-1);

        grandpa.setCalabashBrothers();
        scorpionSperm.setBadGuys();
    }
    void changeFormation(){
        scorpionSperm.changeFormation(rand.nextInt(Formation.FORMATION_NUM-1));
        print();
    }
    private void print(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(battleField[i][j] != null){
                    //Creature here
                    ((Creature)battleField[i][j]).solute();
                }
                else{
                    //Nothing here
                    System.out.print("**");
                }
                System.out.print(" ");
            }
            System.out.print("\n");
        }
        for(int i=0;i<45;i++)
            System.out.print('-');
        System.out.print("\n");
    }
}
