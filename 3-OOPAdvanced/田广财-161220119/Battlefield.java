public class Battlefield {
    private static int rows = 11, cols = 20;
    private Creature[][] creatures = new Creature[rows][cols];

    public Battlefield() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                creatures[i][j] = new Creature();
            }
        }
    }

    public void CopyGoodToBattlefield() {
        Calabashfield calabashfield = new Calabashfield();
        calabashfield.RandomCalabash();
        calabashfield.SortCalabash();
        calabashfield.SetStyle();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < 10; j++) {
                creatures[i][j] = calabashfield.creatures1[i][j];
            }
        }
    }

    public void CopyBadToBattlefield(int index) {
        Scorpionfield scorpionfield = new Scorpionfield();
        if (index == 1) {
            scorpionfield.SetStyle1();
        } else if (index == 2) {
            scorpionfield.SetStyle2();
        } else if (index == 3) {
            scorpionfield.SetStyle3();
        } else if (index == 4) {
            scorpionfield.SetStyle4();
        } else if (index == 5) {
            scorpionfield.SetStyle5();
        } else if (index == 6) {
            scorpionfield.SetStyle6();
        } else {
            scorpionfield.SetStyle7();
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 10; j < cols; j++) {
                creatures[i][j] = scorpionfield.creatures2[i][j - 10];
            }
        }
    }

    public void PrintBattlefield() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (creatures[i][j].getType() == null) {
                    System.out.print("    " + "\t");
                } else {
                    System.out.print(creatures[i][j].getName() + "\t");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("good");
        Battlefield battlefield = new Battlefield();
        battlefield.CopyGoodToBattlefield();
        battlefield.PrintBattlefield();
    }
}
