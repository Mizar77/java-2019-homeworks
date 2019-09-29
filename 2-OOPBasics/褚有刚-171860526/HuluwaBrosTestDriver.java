public class HuluwaBrosTestDriver {
    public static void main(String[] args) {
        // execute in the block of try, catch exceptions potentially risen
        try {
            HuluwaBros hb = new HuluwaBros();
            hb.shuffle();
            System.out.println("====== before bubble sort ======");
            hb.printAll();
            System.out.println("====== position exchange ======");
            hb.bubbleSortByRank();
            System.out.println("====== after bubble sort ======");
            hb.printRank();

            hb.shuffle();
            System.out.println("====== before quick sort ======");
            hb.printAll();
            System.out.println("====== position exchange ======");
            hb.qsortByColor();
            System.out.println("====== after quick sort ======");
            hb.printColor();
        } catch(Exception e) {
            System.err.println("something unexpected happened, please check and run it again");
            e.printStackTrace();
        }
    }
}