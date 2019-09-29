public class Main {

    static private void pause(int time){
        try{
            Thread.sleep(time);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Map map=new Map(11);
        System.out.println("地图生成：");
        map.printMap();
        pause(1000);
        System.out.println("葫芦娃随机站成了长蛇型：");
        Team gourdTeam=new GourdTeam(5,3,map);
        pause(1000);
        System.out.println("妖精战队排成了鹤翼型：");
        Team monsterTeam=new MonsterTeam(8,5,6,map);
        pause(1000);
        gourdTeam.changeFormation();
        System.out.println("葫芦娃按序排好了队");
        pause(1000);
        monsterTeam.changeFormation();
        System.out.println("妖精战队变成了衡轭型");
        pause(1000);
    }

}
