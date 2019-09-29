public class Arena {

    public static final int BROTHER =8;
    public static final int N = 16;

    private Position [][] room;

    public Arena(){
        room=new Position[N][N];
        for(int i=0;i<N;i++)
            for(int j=0;j<N;j++)
                room[i][j]=new Position(i,j);
    }

    public void printArena(){
        roundChange();
        for(int i=0;i<N;i++) {
            for (int j = 0; j < N; j++) {
                if (room[i][j].isEmpty())
                    System.out.print(" ");
                else
                    room[i][j].getCreature().reportIdentification();
            }
            System.out.print("\n");
        }
    }

    public void clearArena(){
        for(int i=0;i<N;i++)
            for(int j=0;j<N;j++){
                if(!room[i][j].isEmpty())
                    room[i][j].setEmpty();
            }
    }

    public void setAlliance(Position []selection,Creature []alliance,int size){
        for(int i=0;i<size;i++)
            selection[i].setCreature(alliance[i]);
    }

    public void setArena(Position []selection,int size){
        int x=0,y=0;
        for(int i=0;i<size;i++){
            x=selection[i].getX();  y=selection[i].getY();
            room[x][y].setCreature(selection[i].getCreature());
        }

    }

    public void roundChange(){
        for(int i=0;i<N;i++)
            System.out.print("=");
        System.out.print("\n");
    }

    public static void main(String []args){

        Arena arena = new Arena();
        Layout layout = new Layout();
        Sorter rdSorter = new RandomSorter();
        Sorter nmSorter = new NormalSorter();

        GoodOnes []brothers=new GoodOnes[BROTHER];
        for(int i=0;i<BROTHER-1;i++) brothers[i]=new CalabashBrother(Color.values()[i],Seniority.values()[i]);
        brothers[BROTHER-1]=new Grandfather();

        Position []alliance=layout.setChangShe(brothers.length);
        arena.setAlliance(alliance,brothers,BROTHER);
        rdSorter.sort(alliance,BROTHER-1);
        arena.setArena(alliance,BROTHER-1);
        arena.printArena();
        arena.clearArena();

        nmSorter.sort(alliance,BROTHER-1);
        arena.setArena(alliance,BROTHER);
        Genie []Genies1=new Genie[8];
        Position []horde1=layout.setHeYi(Genies1);
        arena.setAlliance(horde1,Genies1,Genies1.length);
        arena.setArena(horde1,Genies1.length);
        arena.printArena();
        arena.clearArena();

        arena.setArena(alliance,BROTHER);
        Genie []genies2=new Genie[7];
        Position []horde2=layout.setYanXing(genies2);
        arena.setAlliance(horde2,genies2,genies2.length);
        arena.setArena(horde2,genies2.length);
        arena.printArena();
        arena.clearArena();

        arena.setArena(alliance,BROTHER);
        Genie []genies3=new Genie[8];
        Position []horde3=layout.setChongE(genies3);
        arena.setAlliance(horde3,genies3,genies3.length);
        arena.setArena(horde3,genies3.length);
        arena.printArena();
        arena.clearArena();

    }
}
