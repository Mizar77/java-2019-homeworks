package Position;

import Life.*;

public class TwoDimensionsSpace {
    private boolean[][] map;
    private Life[][] life;
    public static final int N=15;
    public TwoDimensionsSpace(){
        map=new boolean[N][N];
        life=new Life[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                map[i][j]=false;
            }
        }
    }
    public void leave(Position position){
        map[position.X-1][position.Y-1]=false;
    }
    public void stand(Life name){
        Position position=name.getPosition();
        map[position.X-1][position.Y-1]=true;
        life[position.X-1][position.Y-1]=name;
    }
    public boolean isSomeoneThere(Position place){
        if(map[place.X-1][place.Y-1])
            return true;
        else
            return false;
    }
    public Life getlife(Position place){
        return life[place.X][place.Y];
    }
    public void printMap(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]){
                    System.out.print(" "+life[i][j].putname().charAt(1)+" ");

                }
                else{
                    System.out.print("    ");
                }
            }
            System.out.println();
        }
    }
}