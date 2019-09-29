class Creature{
    private String name;
    int x;
    int y;
    boolean badGuy;
    Creature(String name,boolean badGuy){
        this.name=name;
        x=-1;
        y=-1;
        this.badGuy=badGuy;
    }
    void solute(){
        System.out.print(name);
    }
    void runTo(Object[][] battleField,int x,int y){
        battleField[x][y]=this;
        this.x=x;
        this.y=y;
    }
}