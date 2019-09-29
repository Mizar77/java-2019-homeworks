package navigation;

import creature.*;
import space.*;

import java.util.*;

public class Navigation {
    private int sizeM;
    private int sizeN;
    Queue<Coordinate> queue;
    boolean visit[][];
    Coordinate pre[][];
    int distance[][];
    public Navigation(){
        sizeM=0;
        sizeN=0;
        visit=null;
    }
    public Navigation(Space battleField){
        sizeM=battleField.getSizeX();
        sizeN=battleField.getSizeY();
        queue=new LinkedList<Coordinate>();
        visit=new boolean[sizeM][sizeN];
        distance=new int[sizeM][sizeN];
        pre=new Coordinate[sizeM][sizeN];
        for (int i=0;i<sizeM;i++) {
            for (int j = 0; j < sizeN; j++) {
                visit[i][j]=false;
                distance[i][j]=0;
            }
        }
    }
    public Stack<Coordinate> useTheNavigation(Space battleField,Creature creatureCurrent,int destX,int destY) {
        int[] directionX = new int[4];
        int[] directionY = new int[4];
        directionX[0] = 0;
        directionY[0] = -1;
        directionX[1] = -1;
        directionY[1] = 0;
        directionX[2] = 1;
        directionY[2] = 0;
        directionX[3] = 0;
        directionY[3] = 1;
        int x = creatureCurrent.getCoordinateX();
        int y = creatureCurrent.getCoordinateY();
        queue.offer(new Coordinate(x,y));
        visit[x][y] = true;
        Stack<Coordinate> stack=new Stack<Coordinate>();
        while (!queue.isEmpty()){
            Coordinate coordinate=queue.poll();
            for (int i=0;i<4;i++){
                if (battleField.isTheCellEmpty(coordinate.getX()+directionX[i],coordinate.getY()+directionY[i])&&visit[coordinate.getX()+directionX[i]][coordinate.getY()+directionY[i]]==false){
                    queue.offer(new Coordinate(coordinate.getX()+directionX[i],coordinate.getY()+directionY[i]));
                    visit[coordinate.getX()+directionX[i]][coordinate.getY()+directionY[i]]=true;
                    distance[coordinate.getX()+directionX[i]][coordinate.getY()+directionY[i]]=1+distance[coordinate.getX()][coordinate.getY()];
                    pre[coordinate.getX()+directionX[i]][coordinate.getY()+directionY[i]]=coordinate;
                    if (coordinate.getX()+directionX[i]==destX&&coordinate.getY()+directionY[i]==destY){
                        while(true){
                            stack.push(new Coordinate(destX,destY));
                            if (destX==x&&destY==y) break;
                            int dx=destX;
                            int dy=destY;
                            destX=pre[dx][dy].getX();
                            destY=pre[dx][dy].getY();
                        }
                        return stack;
                    }
                }
            }
        }
        return stack;
    }
}
