class CalabashName{
    static String []name = {"老大","老二","老三","老四","老五","老六","老七"};
}
class CalabashColor{
    static String []color = {"红色","橙色","黄色","绿色","青色","蓝色","紫色"};
}
//葫芦娃
public class Calabash extends Being{
    String color;
    public Calabash(){}
    public Calabash(String name, String color){
        this.name = name;
        this.color = color;
    }
}