class Position {
    int index;
    public Position(int i){
        index=i;
    }

    public int getX(){
        return index;
    }

    public int changeX(int i){
        index=i;
        return 0;
    }
}

public class Chessman {
    String name;
    String color;
    Position site;
    int id;

    public Chessman(String n, String c, Position s, int i) {
        name = n;
        color = c;
        site = s;
        id = i;
    }

    public int changeSite(Position nextSite) {
        //TODO:study the change in address!
        site = nextSite;
        return 0;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public Position getSite() {
        return site;
    }

    public int getId(){
        return id;
    }
}
