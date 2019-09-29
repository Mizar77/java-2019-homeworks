package homework3;

public class Checkerboard {
    private String[][] theBoard = new String[10][12];

    Checkerboard() {
        for (int i = 0; i < 10; i++) {
            theBoard[i][3] = "界";
        }
    }

    public void modify(int x, int y, String name) {
        theBoard[x][y] = name;
    }

    public void clear() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                theBoard[i][j] = null;
            }
        }
        for (int i = 0; i < 10; i++) {
            theBoard[i][3] = "界";
        }
    }

    public void print() {
        System.out.println("  为方便输出，所有人物均用一个汉字指代，另外，“界”表示界限，用以分开双方 ");
        System.out.println("  老人                 ======双方布阵=======               蛇精 ");
        System.out.println("  0    1    2    3    4    5    6    7    8    9    10    11    ");
        System.out.println("  -------------------------------------------------------------");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " |");
            for (int j = 0; j < 12; j++) {
                if (theBoard[i][j] == null)
                    System.out.print("    |");
                else
                    System.out.print(" " + theBoard[i][j].substring(0, 1) + " |");
            }
            System.out.println("");
            System.out.println("  -------------------------------------------------------------");
        }
    }
}
