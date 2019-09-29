public class CalabashBrother extends GoodOnes implements Comparable{
    private Color   color;
    private Seniority seniority;

    public  CalabashBrother(Color c, Seniority s){
        this.color=c;this.seniority =s;
    }

    public Color getColor(){
        return this.color;
    }

    public Seniority getSeniority(){
        return this.seniority;
    }

    @Override
    public String toString(){
        return this.seniority.toString().substring(0,1);
    }

    @Override
    public boolean compare(Comparable another){
        if(another instanceof CalabashBrother)
            return (this.seniority.ordinal()>((CalabashBrother) another).seniority.ordinal());
        else
            return false;
    }
}

enum Color{
    红,橙,黄,绿,青,蓝,紫
}

enum Seniority {
    大娃,二娃,三娃,四娃,五娃,六娃,七娃
}
