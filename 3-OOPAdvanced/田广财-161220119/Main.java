public class Main {
    public static void main(String[] args) {
        Battlefield battlefield = new Battlefield();
        battlefield.CopyGoodToBattlefield();

        battlefield.CopyBadToBattlefield(1);
        battlefield.PrintBattlefield();
        battlefield.CopyBadToBattlefield(2);
        battlefield.PrintBattlefield();
        battlefield.CopyBadToBattlefield(3);
        battlefield.PrintBattlefield();
        battlefield.CopyBadToBattlefield(4);
        battlefield.PrintBattlefield();
        battlefield.CopyBadToBattlefield(5);
        battlefield.PrintBattlefield();
        battlefield.CopyBadToBattlefield(6);
        battlefield.PrintBattlefield();
        battlefield.CopyBadToBattlefield(7);
        battlefield.PrintBattlefield();
    }
}
