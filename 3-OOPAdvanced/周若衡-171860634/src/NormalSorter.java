public class NormalSorter implements Sorter {
    @Override
    public void sort(Position []layout,int size){
        for(int i=0;i<size-1;i++)
            for(int j=0;j<size-i-1;j++){
                if(((Comparable)(layout[j].getCreature())).compare(((Comparable)(layout[j+1].getCreature())))) {
                    Creature tmp=layout[j].getCreature();
                    layout[j].setCreature(layout[j+1].getCreature());
                    layout[j+1].setCreature(tmp);
                }
            }
    }
}
