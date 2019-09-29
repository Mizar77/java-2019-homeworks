import java.util.ArrayList;
import java.util.Random;

public class Calabashfield {
    public Creature[][] creatures1 = new Creature[11][10];
    private    Calabash calabash[] = new Calabash[7];
    public Calabashfield() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 10; j++) {
                creatures1[i][j]=new Creature();
            }
        }
    }
    public void RandomCalabash(){
        ArrayList<Integer> arrayList = new ArrayList<>();
        Random random = new Random();
        while (arrayList.size() < 7) {
            int rand = random.nextInt(7) % 7;
            if (!arrayList.contains(rand))
                arrayList.add(rand);
        }
        int t = 1;
        for (int j : arrayList) {
            calabash[j] = new Calabash(t);
            Integer index = j + 1;
            t++;
        }
    }
    public void SortCalabash() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6 - i; j++) {
                if (calabash[j].getRank() > calabash[j + 1].getRank()) {
                    Calabash t = calabash[j];
                    calabash[j] = calabash[j + 1];
                    calabash[j + 1] = t;
                }
            }
        }
    }

    public boolean isEmpty(int i, int j) {
        return creatures1[i][j].getType() == null;
    }

    public void SetGoodToField(Creature creature, int i, int j) {
        if (isEmpty(i, j)) {
            creatures1[i][j] = creature;
        } else
            return;
    }
    public void SetStyle(){
        SetGoodToField(new Grandfa(),0,0);
        for(int i=0;i<7;i++)
        {
            SetGoodToField(calabash[i],(i+2),6);
        }
    }

    public void PrintCalabash(){
        for(int i=0;i<7;i++){
            System.out.println(calabash[i].getName()+"\t");
        }
    }
    public void PrintCalabashfield(){
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(creatures1[i][j].getName() + "\t");
            }
            System.out.println();
        }
    }

}
