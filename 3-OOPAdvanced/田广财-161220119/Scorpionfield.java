public class Scorpionfield {
    public Creature[][] creatures2 = new Creature[11][10];

    public Scorpionfield() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 10; j++) {
                creatures2[i][j] = new Creature();
            }
        }
    }

    public boolean isEmpty(int i, int j) {
        return creatures2[i][j].getType() == null;
    }

    public void SetBadToField(Creature creature, int i, int j) {
        if (isEmpty(i, j)) {
            creatures2[i][j] = creature;
        } else
            return;
    }

    public void SetStyle1() {
        SetBadToField(new Snake(), 0, 9);
        SetBadToField(new Scorpion(), 1, 1);
        SetBadToField(new Minion(), 3, 2);
        SetBadToField(new Minion(), 5, 3);
        SetBadToField(new Minion(), 7, 4);
        SetBadToField(new Minion(), 5, 5);
        SetBadToField(new Minion(), 3, 6);
        SetBadToField(new Minion(), 1, 7);
    }

    public void SetStyle2() {
        SetBadToField(new Snake(), 0, 9);
        SetBadToField(new Minion(), 1, 8);
        SetBadToField(new Minion(), 2, 7);
        SetBadToField(new Minion(), 3, 6);
        SetBadToField(new Minion(), 4, 5);
        SetBadToField(new Minion(), 5, 4);
        SetBadToField(new Minion(), 6, 3);
        SetBadToField(new Minion(), 7, 2);
        SetBadToField(new Scorpion(), 8, 1);
    }

    public void SetStyle3() {
        SetBadToField(new Snake(), 0, 9);
        SetBadToField(new Minion(), 0, 5);
        SetBadToField(new Minion(), 1, 4);
        SetBadToField(new Minion(), 2, 5);
        SetBadToField(new Minion(), 3, 4);
        SetBadToField(new Minion(), 4, 5);
        SetBadToField(new Scorpion(), 5, 4);
        SetBadToField(new Minion(), 6, 5);
        SetBadToField(new Minion(), 7, 4);
        SetBadToField(new Minion(), 8, 5);
        SetBadToField(new Minion(), 9, 4);
//        SetBadToField(new Minion(), 10, 5);

    }

    public void SetStyle4() {
        SetBadToField(new Snake(), 0, 9);
        SetBadToField(new Minion(), 2, 5);
        SetBadToField(new Minion(), 4, 5);
        SetBadToField(new Minion(), 6, 5);
        SetBadToField(new Minion(), 3, 6);
        SetBadToField(new Minion(), 5, 6);
        SetBadToField(new Minion(), 5, 7);
        SetBadToField(new Minion(), 3, 4);
        SetBadToField(new Minion(), 5, 4);
        SetBadToField(new Scorpion(), 5, 3);
    }

    public void SetStyle5() {
        SetBadToField(new Snake(), 0, 9);
        SetBadToField(new Minion(), 1, 4);
        SetBadToField(new Minion(), 3, 3);
        SetBadToField(new Scorpion(), 5, 2);
        SetBadToField(new Minion(), 7, 3);
        SetBadToField(new Minion(), 9, 4);
        SetBadToField(new Minion(), 3, 5);
        SetBadToField(new Minion(), 7, 5);
        SetBadToField(new Minion(), 5, 6);

    }

    public void SetStyle6() {
        SetBadToField(new Snake(), 0, 9);
        SetBadToField(new Minion(), 4, 2);
        SetBadToField(new Scorpion(), 5, 2);
        SetBadToField(new Minion(), 6, 2);
        SetBadToField(new Minion(), 4, 3);
        SetBadToField(new Minion(), 5, 3);
        SetBadToField(new Minion(), 6, 3);
        SetBadToField(new Minion(), 4, 4);
        SetBadToField(new Minion(), 5, 4);
        SetBadToField(new Minion(), 6, 4);
        SetBadToField(new Minion(), 3, 3);
        SetBadToField(new Minion(), 7, 3);
        SetBadToField(new Minion(), 2, 4);
        SetBadToField(new Minion(), 3, 4);
        SetBadToField(new Minion(),7,4);
        SetBadToField(new Minion(),8,4);
        SetBadToField(new Minion(),1,5);
        SetBadToField(new Minion(),2,5);
        SetBadToField(new Minion(),0,6);
        SetBadToField(new Minion(),1,6);
        SetBadToField(new Minion(),8,5);
        SetBadToField(new Minion(),9,5);
        SetBadToField(new Minion(),9,6);
        SetBadToField(new Minion(),10,6);
    }
    public void SetStyle7(){
        SetBadToField(new Snake(),0,9);
        SetBadToField(new Minion(),2,4);
        SetBadToField(new Minion(),3,4);
        SetBadToField(new Minion(),4,4);
        SetBadToField(new Minion(),5,4);
        SetBadToField(new Minion(),6,4);
        SetBadToField(new Minion(),7,4);
        SetBadToField(new Minion(),3,3);
        SetBadToField(new Scorpion(),4,2);
        SetBadToField(new Minion(),3,5);
        SetBadToField(new Minion(),4,6);

    }

    public void PrintScopionfield() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(creatures2[i][j].getName() + "\t");
            }
            System.out.println();
        }
    }




}
