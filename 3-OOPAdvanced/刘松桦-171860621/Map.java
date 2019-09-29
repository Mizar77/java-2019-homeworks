class Map {

    private int n;
    char[][] table;

    Map(int n) {
        this.n = n;
        table = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                table[i][j] = ' ';
    }

    private void printLine() {
        for (int i = 0; i < n; i++) {
            System.out.print("+---");
        }
        System.out.print("+\n");
    }

    void printMap() {
        for (int i = 0; i < n; i++) {
            printLine();
            for (int j = 0; j < n; j++) {
                System.out.print("| " + table[i][j] + " ");
            }
            System.out.print("|\n");
        }
        printLine();
    }
}
