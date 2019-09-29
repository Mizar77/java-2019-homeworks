package space;
import creature.*;

public class Space{
    private int sizeX;
    private int sizeY;
    private Cell battleField[][];

    public Space(int N){
        sizeX=N;
        sizeY=N;
        battleField=new Cell[N][N];
        for (int i=0;i<N;i++)
            for (int j=0;j<N;j++)
                battleField[i][j]=new Cell(i,j);
    }
    public Space(int M, int N){
        sizeX=M;
        sizeY=N;
        battleField=new Cell[M][N];
        for (int i=0;i<M;i++)
            for (int j=0;j<N;j++)
                battleField[i][j]=new Cell(i,j);
    }

    public int getSizeX(){
        return sizeX;
    }
    public int getSizeY(){
        return sizeY;
    }
    public Creature getTheCreatureOnTheCell(int x, int y){
        return battleField[x][y].getCreatureOnTheCell();
    }
    public void setTheCreatureOnTheCell(int x,int y,Creature newCreature){
        if (isTheCellEmpty(x,y)){
            battleField[x][y].setCreatureOnTheCell(newCreature);
        }
    }


    public boolean isExceedTheBattleField(int x,int y){
        if (x<sizeX&&y<sizeY&&x>=0&&y>=0) return false;
        else return true;
    }
    public boolean isTheCellEmpty(int x,int y){
        if (!isExceedTheBattleField(x,y)){
            return battleField[x][y].isCellEmpty();
        }
        return false;
    }
    public void removeTheCreature(int x,int y){
        if (!isExceedTheBattleField(x,y)){
            battleField[x][y].removeCreatureOnTheCell();
        }
    }
}
