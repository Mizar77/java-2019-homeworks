enum Color{
    赤, 橙, 黄, 绿, 青, 蓝, 紫
}
enum Rank{
    老大, 老二, 老三, 老四, 老五, 老六, 老七
}

/**
 * 葫芦娃类
 */
public class Calabash {
    private int id;
    private Color color;
    private Rank rank;
    private int position;

    public Calabash(){}
    public Calabash(int id){
        this.id = id;
        this.color = Color.values()[id];
        this.rank = Rank.values()[id];
        this.position = -1; //初始时顺序不知
    }
    public int getId(){
        return this.id;
    }
    public Color getColor(){
        return this.color;
    }
    public Rank getRank(){
        return this.rank;
    }
    public int getPosition(){
        return this.position;
    }
    public void setPosition(int position){
        this.position = position;
    }

    /**
     * 报数
     * @param isColor   true时按颜色报数，否则按排行报数
     */
    public void shout(boolean isColor){
        if(isColor){
            System.out.print(this.color + " ");
        }else{
            System.out.print(this.rank + " ");
        }
    }

    /**
     * 葫芦娃移动
     * @param movePos   移动到的位置
     */
    public void move(int movePos){
        if(this.position != -1){
            System.out.println(this.rank + ": " + this.position + "->" + movePos);
        }
        this.position = movePos;
    }
}
