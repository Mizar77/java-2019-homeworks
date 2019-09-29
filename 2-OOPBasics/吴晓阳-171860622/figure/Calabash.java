package figure;

import figure.feature.Emittable;
import item.BasicBullet;
import item.Bullet;

public class Calabash extends BasicFigure implements Comparable<Calabash>{
    private final Seniority seniority;

    private final Color color;

    public static final String typeName = "Calabash";

    private Boolean emittable = false;

    public Calabash(){
        super();
        this.seniority = null;
        this.color = null;
    }

    public Calabash(String name, Seniority seniority, Color color) {
        super(name);
        this.seniority = seniority;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public Seniority getSeniority() {
        return seniority;
    }

    public void speakOutSeniority(){
        System.out.print(seniority);
    }

    public void speakOutColor(){
        System.out.print(color);
    }

    @Override
    public String toString(){
        return getName();
    }

    @Override
    public int compareTo(Calabash calabash) {
        if(seniority.ordinal() < calabash.seniority.ordinal()){
            return -1;
        }
        else if(seniority.ordinal() > calabash.seniority.ordinal()){
            return 1;
        }
        else{
            return 0;
        }
    }

    public enum Color {
        RED, ORRANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE;

        @Override
        public String toString(){
            switch(this){
                case RED: return "红";
                case ORRANGE: return "橙";
                case YELLOW: return "黄";
                case GREEN: return "绿";
                case CYAN: return "青";
                case BLUE: return "蓝";
                case PURPLE: return "紫";
            }
            return "Error";
        }
    }

    public enum Seniority {
        ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN;

        @Override
        public String toString() {
            switch (this) {
                case ONE:
                    return "老大";
                case TWO:
                    return "老二";
                case THREE:
                    return "老三";
                case FOUR:
                    return "老四";
                case FIVE:
                    return "老五";
                case SIX:
                    return "老六";
                case SEVEN:
                    return "老七";
            }
            return "Error";
        }
    }


    public static class Dawa extends Calabash {
        public Dawa(){
            super("Dawa", Seniority.ONE, Color.RED);
        }

        public final static String typeName = "Dawa";
    }

    public static class Erwa extends Calabash{
        public Erwa(){
            super("Erwa",Seniority.TWO,Color.ORRANGE);
        }

        public final static String typeName = "Erwa";
    }

    public static class Sanwa extends Calabash{
        public Sanwa(){
            super("Sanwa", Seniority.THREE, Color.YELLOW);
        }

        public final static String typeName = "Sanwa";
    }

    public static class Siwa extends Calabash{
        public Siwa(){
            super("Siwa", Seniority.FOUR, Color.GREEN);
        }

        public final static String typeName = "Siwa";
    }

    public static class Wuwa extends Calabash{
        public Wuwa(){
            super("Wuwa", Seniority.FIVE, Color.CYAN);
        }

        public final static String typeName = "Wuwa";
    }

    public static class Liuwa extends Calabash{
        public Liuwa(){
            super("Liuwa", Seniority.SIX, Color.BLUE);
        }

        public final static String typeName = "Liuwa";
    }

    public static class Qiwa extends Calabash{
        public Qiwa(){
            super("Qiwa", Seniority.SEVEN, Color.PURPLE);
        }

        public final static String typeName = "Qiwa";
    }
}
