public class Huluwa implements Comparable<Huluwa> {
    private int id;
    private String name;
    private String color;

    public Huluwa(int id,String name,String color){
        this.id=id;
        this.name=name;
        this.color=color;
    }

    public void descName(){
        System.out.print(name+" ");
    }

    public void descColor(){
        System.out.print(color+" ");
    }

    public void descMove(int from,int to){
          if(from!=to) {
              System.out.print(name+": "+from+"->"+to+"; ");
          }
    }

    @Override
    public int compareTo(Huluwa o) {
        return this.id - o.id;
    }
}
