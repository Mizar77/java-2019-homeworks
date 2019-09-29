import java.util.*;

public class Map{
    int col,row;
    Location[][] map;
    Map(){
        col=15;
        row=15;
        map=new Location[15][15];
        for(int i=0;i<15;i++){
            for(int j=0;j<15;j++)
                map[i][j]=new Location(i,j);
        }
    }
    private int[] randomArrayGenerator(int n){//生成1-n的的随机排列
        Random rand=new Random();
        int temp=0;
        int[] arrange=new int[n];
        int index=0;
        while(true){
            if(index==n){
                break;
            }
            temp=rand.nextInt(n)+1;
            boolean ifcontain=false;
            for(int i=0;i<arrange.length;i++){
                if(arrange[i]==temp){
                    ifcontain=true;
                }
            }
            if(ifcontain){
                continue;
            }else{
                arrange[index]=temp;
                index++;
            }
        }
        return arrange;
     }
     private void arrangeGrandfather(){
         Grandfather yeye=new Grandfather();
         map[0][0].setCreature(yeye);
     }
     private void arrangeCalabashBrother(){
         CalabashBrother dawa=new CalabashBrother("大");
         CalabashBrother erwa=new CalabashBrother("二");
         CalabashBrother sanwa=new CalabashBrother("三");
         CalabashBrother siwa=new CalabashBrother("四");
         CalabashBrother wuwa=new CalabashBrother("五");
         CalabashBrother liuwa=new CalabashBrother("六");
         CalabashBrother qiwa=new CalabashBrother("七");
         int[] arrange=randomArrayGenerator(7);
         for(int i=0;i<7;i++){
             switch(arrange[i]){
                 case 1:map[i+1][1].setCreature(dawa);break;
                 case 2:map[i+1][1].setCreature(erwa);break;
                 case 3:map[i+1][1].setCreature(sanwa);break;
                 case 4:map[i+1][1].setCreature(siwa);break;
                 case 5:map[i+1][1].setCreature(wuwa);break;
                 case 6:map[i+1][1].setCreature(liuwa);break;
                 case 7:map[i+1][1].setCreature(qiwa);break;
             }
         }
     }
     private void arrangeSnakeEssence(){
        SnakeEssence shejing=new SnakeEssence();
        map[0][14].setCreature(shejing);
     }
     private void arrangeWannabeAndScorpionEssence(){
         Random rand=new Random();
         int index=rand.nextInt(7)+1;
         switch(index){
             case 1:{
                ScorpionEssence xiezijing=new ScorpionEssence();
                map[1][7].setCreature(xiezijing);
                Wannabe[] list=new Wannabe[6];
                for(int i=0;i<6;i++)
                    list[i]=new Wannabe();
                map[2][8].setCreature(list[0]);
                map[3][9].setCreature(list[1]);
                map[4][10].setCreature(list[2]);
                map[3][11].setCreature(list[3]);
                map[2][12].setCreature(list[4]);
                map[1][13].setCreature(list[5]);
             }break;
             case 2:{
                ScorpionEssence xiezijing=new ScorpionEssence();
                map[5][9].setCreature(xiezijing);
                Wannabe[] list=new Wannabe[4];
                for(int i=0;i<4;i++)
                    list[i]=new Wannabe();
                map[4][10].setCreature(list[0]);
                map[3][11].setCreature(list[1]);
                map[2][12].setCreature(list[2]);
                map[1][13].setCreature(list[3]);
             }break;
             case 3:{
                ScorpionEssence xiezijing=new ScorpionEssence();
                map[2][10].setCreature(xiezijing);
                Wannabe[] list=new Wannabe[5];
                for(int i=0;i<5;i++)
                    list[i]=new Wannabe();
                map[1][11].setCreature(list[0]);
                map[3][11].setCreature(list[1]);
                map[4][10].setCreature(list[2]);
                map[5][11].setCreature(list[3]);
                map[6][10].setCreature(list[4]);
             }break;
             case 4:{
                ScorpionEssence xiezijing=new ScorpionEssence();
                map[4][7].setCreature(xiezijing);
                Wannabe[] list=new Wannabe[9];
                for(int i=0;i<9;i++)
                    list[i]=new Wannabe();
                map[3][8].setCreature(list[0]);
                map[4][9].setCreature(list[1]);
                map[1][10].setCreature(list[2]);
                map[3][10].setCreature(list[3]);
                map[5][10].setCreature(list[4]);
                map[2][11].setCreature(list[5]);
                map[4][11].setCreature(list[6]);
                map[3][12].setCreature(list[7]);
                map[4][13].setCreature(list[8]);
             }break;
             case 5:{
                ScorpionEssence xiezijing=new ScorpionEssence();
                map[3][8].setCreature(xiezijing);
                Wannabe[] list=new Wannabe[7];
                for(int i=0;i<7;i++)
                    list[i]=new Wannabe();
                map[2][9].setCreature(list[0]);
                map[4][9].setCreature(list[1]);
                map[1][10].setCreature(list[2]);
                map[5][10].setCreature(list[3]);
                map[2][11].setCreature(list[4]);
                map[4][11].setCreature(list[5]);
                map[3][12].setCreature(list[6]);
             }break;
             case 6:{
                ScorpionEssence xiezijing=new ScorpionEssence();
                map[4][7].setCreature(xiezijing); 
                Wannabe[] list=new Wannabe[18];
                for(int i=0;i<18;i++)
                    list[i]=new Wannabe();
                map[5][7].setCreature(list[0]);
                map[6][7].setCreature(list[1]);
                map[4][8].setCreature(list[2]);
                map[5][8].setCreature(list[3]);
                map[6][8].setCreature(list[4]);
                map[3][9].setCreature(list[5]);
                map[7][9].setCreature(list[6]);
                map[2][10].setCreature(list[7]);
                map[4][10].setCreature(list[8]);
                map[5][10].setCreature(list[9]);
                map[6][10].setCreature(list[10]);
                map[8][10].setCreature(list[11]);
                map[3][11].setCreature(list[12]);
                map[7][11].setCreature(list[13]);
                map[2][12].setCreature(list[14]);
                map[8][12].setCreature(list[15]);
                map[1][13].setCreature(list[16]);
                map[9][13].setCreature(list[17]);
             }break;
             case 7:{
                ScorpionEssence xiezijing=new ScorpionEssence();
                map[4][7].setCreature(xiezijing);
                Wannabe[] list=new Wannabe[11];
                for(int i=0;i<11;i++)
                    list[i]=new Wannabe();
                map[3][8].setCreature(list[0]); 
                map[2][9].setCreature(list[1]);
                map[1][10].setCreature(list[2]);
                map[2][10].setCreature(list[3]);
                map[3][10].setCreature(list[4]);
                map[4][10].setCreature(list[5]);
                map[5][10].setCreature(list[6]);
                map[6][10].setCreature(list[7]);
                map[2][11].setCreature(list[8]);
                map[3][12].setCreature(list[9]);
                map[4][13].setCreature(list[10]);
             }break;
         }
     }
     public void arrange(){
         arrangeGrandfather();
         arrangeCalabashBrother();
         arrangeSnakeEssence();
         arrangeWannabeAndScorpionEssence();
     }
     public void show(){
         for(int i=0;i<15;i++){
             for(int j=0;j<15;j++)
                System.out.print(map[i][j].getCreature().getSymbol());
             System.out.println("");
         }
     }
     public void clean(){
         for(int i=0;i<15;i++){
             for(int j=0;j<15;j++)
                map[i][j]=new Location(i, j);
         }
     }
}