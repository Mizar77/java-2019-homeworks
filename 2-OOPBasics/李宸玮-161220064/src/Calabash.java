enum Color{red,orange,yellow,green,ching,blue,purple}
enum Order{老大,老二,老三,老四,老五,老六,老七}
public class Calabash {
    private int pos;//站队位置
    private int num;//序列号
    private Color color;
    private Order order;
    public Color getColor() {
        return color;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public int getPos() {
        return pos;
    }

    public Order getOrder() {
        return order;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public void moveto(int curPos  ){
        System.out.println(this.order+":"+this.pos+"->"+curPos);
        this.pos=curPos;
    }
    public void shoutName(){
        System.out.print(this.getOrder()+"! ");
    }
    public  void shoutColor(){
        System.out.print(this.getColor()+"! ");
    }

}
