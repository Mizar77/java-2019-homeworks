import java.util.Random;
public class RandomSorter implements Sorter {
    @Override
    public void sort(Position []layout,int size){
        Random rd=new Random();
        for(int i=0;i<size;i++){
            int random=rd.nextInt(i+1);
            Creature tmp=layout[i].getCreature();
            layout[i].setCreature(layout[random].getCreature());
            layout[random].setCreature(tmp);
        }
    }
}
