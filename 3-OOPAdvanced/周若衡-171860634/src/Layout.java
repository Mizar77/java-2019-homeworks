public class Layout {

    private static final Position GRANDPA=new Position(14,0);
    private static final Position SNAKE=new Position(14,8);

    public Position[] setChangShe(int size){

        Position []layout=new Position[size];
        for(int i=0;i<size;i++) layout[i]=new Position();

        layout[0].setPosition(2,0);
        for(int i=1;i<size-1;i++)
            layout[i].setPosition(layout[i-1].getX()+1, layout[i-1].getY());
        layout[size-1]=GRANDPA;
        return layout;
    }

    public Position[] setHeYi(Creature []genies){
        int size=genies.length;
        genies[0]=new Scorpion();
        for(int i=1;i<size-1;i++) genies[i]=new Goblin();
        genies[size-1]=new Snake();
        Position []layout=new Position[size];
        for(int i=0;i<size;i++) layout[i]=new Position();

        layout[0].setPosition(4,8);
        for(int i=1;i<size/2;i++)
            layout[i].setPosition(layout[i-1].getX()+1,layout[i-1].getY()+1);
        for(int i=size/2;i<size-1;i++)
            layout[i].setPosition(layout[i-1].getX()-1,layout[i-1].getY()+1);

        layout[size-1]=SNAKE;
        return layout;
    }

    public Position[] setYanXing(Creature []genies){
        int size=genies.length;
        genies[0]=new Scorpion();
        for(int i=1;i<size-1;i++) genies[i]=new Goblin();
        genies[size-1]=new Snake();
        Position []layout=new Position[size];
        for(int i=0;i<size;i++) layout[i]=new Position();

        layout[0].setPosition(7,10);
        for(int i=1;i<size-1;i++)
            layout[i].setPosition(layout[i-1].getX()-1,layout[i-1].getY()+1);

        layout[size-1]=SNAKE;
        return layout;
    }

    public Position[] setChongE(Creature []genies){
        int size=genies.length;
        genies[0]=new Scorpion();
        for(int i=1;i<size-1;i++) genies[i]=new Goblin();
        genies[size-1]=new Snake();
        Position []layout=new Position[size];
        for(int i=0;i<size;i++) layout[i]=new Position();

        layout[0].setPosition(2,8);
        for(int i=1;i<size-1;i++){
            if(i%2==0){
                layout[i].setPosition(layout[i-1].getX()+1,layout[i-1].getY()-3);
            }
            else{
                layout[i].setPosition(layout[i-1].getX()+1,layout[i-1].getY()+3);
            }
        }

        layout[size-1]=SNAKE;
        return layout;
    }

}
