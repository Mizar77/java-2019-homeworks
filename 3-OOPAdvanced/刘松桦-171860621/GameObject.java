class GameObject {

    static private void pause(int time){
        try{
            Thread.sleep(time);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    private String name;
    char symbol;
    int x, y;
    private Map map;

    GameObject(String name, Character symbol,Map map) {
        this.name = name;
        this.symbol = symbol;
        this.map=map;
    }

    GameObject(String name, Character symbol, int x, int y,Map map) {
        this.name = name;
        this.symbol = symbol;
        this.x = x;
        this.y = y;
        this.map=map;
        map.table[x][y]=symbol;
    }

    void setPosition(int x,int y){
        map.table[x][y]=symbol;
        this.x=x;
        this.y=y;
    }

    void changePosition(int x,int y){
        char temp;
        temp=' ';
        if(this.x<x){
            for(int i=this.x+1;i<=x;i++){
                map.table[i-1][this.y]=temp;
                temp=map.table[i][this.y];
                map.table[i][this.y]=symbol;
                map.printMap();
                pause(1000);
            }
        }
        else if(this.x>x){
            for(int i=this.x-1;i>=x;i--){
                map.table[i+1][this.y]=temp;
                temp=map.table[i][this.y];
                map.table[i][this.y]=symbol;
                map.printMap();
                pause(1000);
            }
        }
        if(this.y<y){
            for(int i=this.y+1;i<=y;i++){
                map.table[x][i-1]=temp;
                temp=map.table[x][i];
                map.table[x][i]=symbol;
                map.printMap();
                pause(1000);
            }
        }
        else if(this.y>y){
            for(int i=this.y-1;i>=y;i--){
                map.table[x][i+1]=temp;
                temp=map.table[x][i];
                map.table[x][i]=symbol;
                map.printMap();
                pause(1000);
            }
        }
        this.x=x;
        this.y=y;
    }

}
