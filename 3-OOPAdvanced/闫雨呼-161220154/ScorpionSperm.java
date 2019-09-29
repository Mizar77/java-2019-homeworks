import java.util.Random;

class BadFollower extends Creature{
    BadFollower(String name){
        super(name,true);
    }
}
class ScorpionSperm extends Creature{
    private final static int FOLLOWERS_NUM=7;
    private BadFollower[] badFollowers;
    ScorpionSperm(String name){
        super(name,true);
        badFollowers=new BadFollower[FOLLOWERS_NUM];
        for(int i=0;i<FOLLOWERS_NUM;i++)
            badFollowers[i]=new BadFollower("F"+(i+1));
    }
    void setBadGuys(){
        Random rand=new Random();
        changeFormation(rand.nextInt(Formation.FORMATION_NUM-1));
    }
    void changeFormation(int formation){
        Formation.changeFormation(GameMap.battleField,badFollowers,formation);
    }
}
