public class Position {
    private int x;
    private int y;
    private boolean isEmpty;
    private Creature creature;

    public Position(){
        isEmpty=true;
    }

    public Position(int x,int y){
        this.x=x;   this.y=y;
        isEmpty=true;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public boolean isEmpty(){
        return isEmpty;
    }

    public void setEmpty(){
        isEmpty=true;
    }

    public void setPosition(int x,int y){
        this.x=x;   this.y=y;
    }

    public Creature getCreature(){
        return creature;
    }

    public void setCreature(Creature c){
        this.creature=c;
        this.isEmpty=false;
    }

}
