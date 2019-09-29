import java.util.Random;

class World{
    static final int WORLD_SIZE = 16;
    public enum Topography{GROUND}
    //public enum Something{NOTHING,CALABASHBROTHER}
    public enum Direction{STILL,LEFT,RIGHT,UP,DOWN}
    static Topography[][] map = new Topography[WORLD_SIZE][WORLD_SIZE];//地图,map[i][j]为一格
    static CalabashBrother[] calabashBrothers = new CalabashBrother[7];//葫芦娃
    static int[] calabashList = new int[7];//葫芦娃队列，按位置站好，数组内容为id号
    void initWorld(){
        //init map
        for(int i = 0;i < WORLD_SIZE;++i){
            for(int j = 0;j < WORLD_SIZE;++j){
                map[i][j] = Topography.GROUND;
            }
        }

        //init calabash brother
        for(int i = 0;i < 7;++i){
            calabashBrothers[i] = new CalabashBrother();
            calabashBrothers[i].setId(i);
            calabashBrothers[i].setPosition(50,50+100*i);
            calabashList[i] = i;
        }
    }

    World(){
        initWorld();
    }

    World(int[] place){
        initWorld();
        for(int i = 0;i < 7;++i){//给每个葫芦娃设定初始位置
            calabashBrothers[i].setPosition(50, 100*place[i]+50);
            calabashList[place[i]] = i;//place中的随机化的位置，list中按位置排
        }
    }

    void randomOrder(int[] place){
        for(int i = 0;i < 7;++i){//给每个葫芦娃设定初始位置
            calabashBrothers[i].setPosition(50, 100*place[i]+50);
            calabashList[place[i]] = i;//place中的随机化的位置，list中按位置排
        }

    }

    void showList(){
        System.out.println("队伍排列如下：");
        for(int i = 0;i < 7;++i){
            System.out.printf("%s ",calabashBrothers[calabashList[i]].getStatusName());
        }
        System.out.printf("%n");
    }

    void showColor(){
        System.out.println("队伍排列如下：");
        for(int i = 0;i < 7;++i){
            System.out.printf("%s ",calabashBrothers[calabashList[i]].getColor());
        }
        System.out.printf("%n");
    }

    static CalabashBrother brotherAround(int id,Direction direction){
        //在某个葫芦娃的某个方向上是否有别的葫芦娃
        assert(id >= 0 && id < 7);
        CalabashBrother obj = calabashBrothers[id];
        boolean find = false;
        int i;
        for(i = 0;i < 7;++i){
            if(i != id){
                //switch(direction){
                    if(direction == World.Direction.LEFT){
                            if(obj.getPosition()[0] - obj.getTouchSize()/2 <= 
                              calabashBrothers[i].getPosition()[0] + calabashBrothers[i].getTouchSize()/2 &&
                               obj.getPosition()[0] > calabashBrothers[i].getPosition()[0]){
                                find = true;
                            }
                    }
                    else if(direction == World.Direction.RIGHT){
                            if(obj.getPosition()[0] + obj.getTouchSize()/2 >= 
                              calabashBrothers[i].getPosition()[0] - calabashBrothers[i].getTouchSize()/2 &&
                              obj.getPosition()[0] < calabashBrothers[i].getPosition()[0]){
                                find = true;
                            }
                    }
                    else if(direction == World.Direction.UP){
                            if(obj.getPosition()[1] + obj.getTouchSize()/2 >= 
                               calabashBrothers[i].getPosition()[1] - calabashBrothers[i].getTouchSize()/2 &&
                               obj.getPosition()[1] < calabashBrothers[i].getPosition()[1]){
                                find = true;
                            }
                    }
                    else if(direction == World.Direction.DOWN){
                            if(obj.getPosition()[1] - obj.getTouchSize()/2 <= 
                               calabashBrothers[i].getPosition()[1] + calabashBrothers[i].getTouchSize()/2 && 
                               obj.getPosition()[1] > calabashBrothers[i].getPosition()[1]){
                                   find = true;
                            }
                    }
                //}
            }
            if(find)
                break;
        }
        if(find)
            return calabashBrothers[i];
        else
            return null;
    }

}


class CalabashBrother{
    static String[] statusName = {"老大","老二","老三","老四","老五","老六","老七"};
    static String[] ownColor = {"赤","橙","黄","绿","青","蓝","紫"};
    private int id = -1;//身份,下标索引
    private int touchSize = 100;//一个葫芦娃的接触范围占一格,1*1
    private int realSize = 50;//0.5*o.5格，一个葫芦娃实际占的位置
    private int[] position = new int[2];//位置
    private int speedX = 5;
    private int speedY = 5;
    private World.Direction moveDirection = World.Direction.STILL;

    void swapPlace(CalabashBrother another){
        //要换位时，相互接触，即在一格范围内接触
        //只能横竖移动，所以此时横坐标或纵坐标相等
        if(position[0] == another.position[0]){//横坐标相等
            //交错
            //多线程可以考虑两者协商，一个往左（下），一个往右（上）来交错
            //walkTO(position[0]-25,position[1]);
            //another.walkTO(another.position[0]+25,another.position[1]);
            int destinationX = position[0]-realSize/2;
            int ownDestinationY = another.position[1];
            int anotherDestnationY = position[1];

            assert(destinationX >= realSize/2);//一个葫芦娃实际占0.5*0.5格的正方形，中心位置在正方形中心
            while(position[0] != destinationX){
                position[0] -= speedX;
                another.position[0] += another.speedX;
                System.out.println(statusName[id]+":("+(position[0]+speedX)+","+position[1]+")->("
                                   +position[0]+","+position[1]+")");
                System.out.println(another.getStatusName()+":("+(another.position[0]-another.speedX)+","+another.position[1]+")->("
                                   +another.position[0]+","+another.position[1]+")");
                try{
                    Thread.sleep(10);
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
            }

            //到目的地
            while(!(ownDestinationY == position[1] && anotherDestnationY == another.position[1])){
                if(ownDestinationY > position[1]){
                    position[1] += speedY;
                    System.out.println(statusName[id]+":("+position[0]+","+(position[1]-speedY)+")->("
                                   +position[0]+","+position[1]+")");
                }
                else if(ownDestinationY < position[1]){
                    position[1] -= speedY;
                    System.out.println(statusName[id]+":("+position[0]+","+(position[1]+speedY)+")->("
                                   +position[0]+","+position[1]+")");
                }

                if(anotherDestnationY > another.position[1]){
                    another.position[1] += another.speedY;
                    System.out.println(another.getStatusName()+":("+another.position[0]+","+(another.position[1]-another.speedY)+")->("
                                   +another.position[0]+","+another.position[1]+")");
                }
                else if(anotherDestnationY < another.position[1]){
                    another.position[1] -= another.speedY;
                    System.out.println(another.getStatusName()+":("+another.position[0]+","+(another.position[1]+another.speedY)+")->("
                                   +another.position[0]+","+another.position[1]+")");
                }
                try{
                    Thread.sleep(10);
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
            }            
            //回到方块中心
            destinationX = position[0]+realSize/2;
            while(position[0] != destinationX){
                position[0] += speedX;
                another.position[0] -= another.speedX;
                System.out.println(statusName[id]+":("+(position[0]-speedX)+","+position[1]+")->("
                                   +position[0]+","+position[1]+")");
                System.out.println(another.getStatusName()+":("+(another.position[0]+another.speedX)+","+another.position[1]+")->("
                                   +another.position[0]+","+another.position[1]+")");
                try{
                    Thread.sleep(10);
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
            }
            
        }
        else{//纵坐标相等
            //交错
            int destinationY = position[1]-realSize/2;
            int ownDestinationX = another.position[0];
            int anotherDestnationX = position[0];

            assert(destinationY >= realSize/2);//一个葫芦娃实际占0.5*0.5格的正方形，中心位置在正方形中心
            while(position[1] != destinationY){
                position[1] -= speedY;
                another.position[1] += another.speedY;
                System.out.println(statusName[id]+":("+position[0]+","+(position[1]+speedY)+")->("
                                   +position[0]+","+position[1]+")");
                System.out.println(another.getStatusName()+":("+another.position[0]+","+(another.position[1]-another.speedY)+")->("
                                   +another.position[0]+","+another.position[1]+")");
                try{
                    Thread.sleep(10);
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
            }

            //到目的地
            while(!(ownDestinationX == position[0] && anotherDestnationX == another.position[0])){
                if(ownDestinationX > position[0]){
                    position[0] += speedX;
                    System.out.println(statusName[id]+":("+(position[0]-speedX)+","+position[1]+")->("
                                   +position[0]+","+position[1]+")");
                }
                else if(ownDestinationX < position[0]){
                    position[0] -= speedX;
                    System.out.println(statusName[id]+":("+(position[0]+speedX)+","+position[1]+")->("
                                   +position[0]+","+position[1]+")");
                }

                if(anotherDestnationX > another.position[0]){
                    another.position[0] += another.speedX;
                    System.out.println(another.getStatusName()+":("+(another.position[0]-another.speedX)+","+another.position[1]+")->("
                                   +another.position[0]+","+another.position[1]+")");
                }
                else if(anotherDestnationX < another.position[0]){
                    another.position[0] -= another.speedX;
                    System.out.println(another.getStatusName()+":("+(another.position[0]+another.speedX)+","+another.position[1]+")->("
                                   +another.position[0]+","+another.position[1]+")");
                }

                try{
                    Thread.sleep(10);
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
            }            
            //回到方块中心
            destinationY = position[1]+realSize/2;
            while(position[1] != destinationY){
                position[1] += speedY;
                another.position[1] -= another.speedY;
                System.out.println(statusName[id]+":("+position[0]+","+(position[1]-speedY)+")->("
                                   +position[0]+","+position[1]+")");
                System.out.println(another.getStatusName()+":("+another.position[0]+","+(another.position[1]+another.speedY)+")->("
                                   +another.position[0]+","+another.position[1]+")");
                try{
                    Thread.sleep(10);
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
            }


        }
    }

    int walkTO(int pos_first,int pos_second){//
        //int destinationX = 50 + pos_first*100;
        //int destinationY = 50 + pos_second*100;
        int destinationX = pos_first;
        int destinationY = pos_second;
        CalabashBrother another = null;
        //先左右后上下
        if(destinationX > position[0]){
            moveDirection = World.Direction.RIGHT;//向右移动
            while(destinationX != position[0]){
                if((another = World.brotherAround(id, moveDirection)) == null){
                    position[0] += speedX;
                    System.out.println(statusName[id]+":("+(position[0]-speedX)+","+position[1]+")->("
                                   +position[0]+","+position[1]+")");
                    try{
                        Thread.sleep(10);
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
                else if(destinationX != position[0]){
                    swapPlace(another);
                }
            }
            moveDirection = World.Direction.STILL;
        }
        else if(destinationX < position[0]){
            moveDirection = World.Direction.LEFT;//向左移动
            while(destinationX != position[0]){
                if((another = World.brotherAround(id, moveDirection)) == null){
                    position[0] -= speedX;
                    System.out.println(statusName[id]+":("+(position[0]+speedX)+","+position[1]+")->("
                                   +position[0]+","+position[1]+")");
                    try{
                        Thread.sleep(10);
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
                else if(destinationX != position[0]){
                    swapPlace(another);
                }
            }
            moveDirection = World.Direction.STILL;
        }

        if(destinationY > position[1]){
            moveDirection = World.Direction.UP;//向上移动
            while(destinationY != position[1]){
                if((another = World.brotherAround(id, moveDirection)) == null){
                    position[1] += speedY;
                    System.out.println(statusName[id]+":("+position[0]+","+(position[1]-speedY)+")->("
                                   +position[0]+","+position[1]+")");
                    try{
                        Thread.sleep(10);
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
                else if(destinationY != position[1]){
                    swapPlace(another);
                }
            }
            moveDirection = World.Direction.STILL;
        }
        else if(destinationY < position[1]){
            moveDirection = World.Direction.DOWN;
            while(destinationY != position[1]){
                if((another = World.brotherAround(id, moveDirection)) == null){
                    position[1] -= speedY;
                    System.out.println(statusName[id]+":("+position[0]+","+(position[1]+speedY)+")->("
                                   +position[0]+","+position[1]+")");
                    try{
                        Thread.sleep(10);
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
                else if(destinationY != position[1]){
                    swapPlace(another);
                }
            }
            moveDirection = World.Direction.STILL;
        }

        return 0;//succeed
    }
    
    String getStatusName(){
        if(id == -1 || id >= 7){
            System.out.println("wrong id" + id);
            return "";
        }
        else
            return statusName[id];
    }

    String getColor(){
        if(id == -1 || id >= 7){
            System.out.println("wrong id" + id);
            return "";
        }
        else
            return ownColor[id];
    }

    int[] getPosition(){
        return position; 
    }

    int getTouchSize(){
        return touchSize;
    }

    int getId(){
        return id;
    }

    boolean setId(int id){
        if(id >= 0 && id < 7){
            this.id = id;
            return true;
        }
        else{
            System.out.println("wrong id");
            return false;
        }
    }

    boolean setPosition(int first,int second){
        if(first >= touchSize/2 && first <= World.WORLD_SIZE*100 - touchSize/2 &&
           second >= touchSize/2 && second <= World.WORLD_SIZE*100 - touchSize/2){
            position[0] = first;
            position[1] = second;
            return true;
        }
        else
            return false;
    }
}


public class CalabashBrothersSort{
    static int[] randomPlace = {0,1,2,3,4,5,6};
    static void ownRandomizePlace(int[] place){
        int length = place.length;
        Random random = new Random();
        for(int i = 0;i < length;++i){
            int ran = random.nextInt(7);
            int temp = randomPlace[i];
            randomPlace[i] = randomPlace[ran];//交换
            randomPlace[ran] = temp;
        }
    }
    public static void main(String[] args){
        //随机初始化位置
        ownRandomizePlace(randomPlace);
        World oneWorld = new World(randomPlace);
        System.out.println("冒泡:");
        oneWorld.showList();
        //冒泡
        int[] onePlace;
        int[] list = World.calabashList;
        boolean swapped = false;
        for(int i = 0; i < 6 ; ++i){
            swapped = false;
            for(int j = 0 ; j < 6 - i; ++j){//calabashBrothers的列表是按位置顺序排好的
                if(World.calabashBrothers[list[j]].getId() > World.calabashBrothers[list[j+1]].getId()){
                    onePlace = World.calabashBrothers[list[j+1]].getPosition();
                    World.calabashBrothers[list[j]].walkTO(onePlace[0],onePlace[1]);
                    int temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                    swapped = true;
                }
            }
            if(swapped == false){
                break;
            }
        }
        System.out.println("冒泡之后");
        oneWorld.showList();

        ownRandomizePlace(randomPlace);
        oneWorld.randomOrder(randomPlace);
        System.out.println("二分:");
        oneWorld.showColor();
        //二分插入排序
        for(int i = 1;i < 7;++i){
            int first = 0;
            int last = i-1;
            int mid = (first+last)/2;
            while(last > first){
                if(World.calabashBrothers[list[i]].getId() < World.calabashBrothers[list[mid]].getId()){
                    last = mid-1;
                    mid = (first+last)/2;
                }
                else if(World.calabashBrothers[list[i]].getId() > World.calabashBrothers[list[mid]].getId()){
                    first = mid+1;
                    mid = (first+last)/2;
                }
            }
            int temp = list[i];
            if(list[i] < list[mid]){
                onePlace = World.calabashBrothers[list[mid]].getPosition();
                World.calabashBrothers[list[i]].walkTO(onePlace[0],onePlace[1]);
                for(int k = i;k >= mid+1;--k){
                    list[k] = list[k-1];
                }
                list[mid] = temp;
            }
            else{
                onePlace = World.calabashBrothers[list[mid+1]].getPosition();
                World.calabashBrothers[list[i]].walkTO(onePlace[0],onePlace[1]);
                for(int k = i;k >= mid+2;--k){
                    list[k] = list[k-1];   
                }
                list[mid+1] = temp;
            }
        }
        System.out.println("二分之后:");
        oneWorld.showColor();

    }

}