import java.util.*;
public class Creature{
    private String race;//用于记录该生物的种族，默认为无，每个继承的子类具有不同的种族
    private String symbol;//考虑控制台输出地图，每个生物用一个中文字符来表示，该属性用于存储生物的代号，在后续可能变为图片
    Creature(){
        race="无";
        symbol="  ";
    }
    Creature(String r,String s){
        race=r;
        symbol=s;
    }
    public String getRace(){return race;}
    public String getSymbol(){return symbol;}
    public void  setRace(String r){race=r;}
    public void setSymbol(String s){symbol=s;}
}