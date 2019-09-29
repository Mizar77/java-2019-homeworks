public class CalabashBrother {
    int number;//1-7,用来在颜色，排行时比较，大娃=1，二娃=2..
    int location;//坐标，用来排序，代替数组下标
    String seniority;//名称
    String color;//颜色
      void change(CalabashBrother a){//交换位置
        int temp=a.location;
        a.location=this.location;
        this.location=temp;
    }
    void report(String command) {//报告
        switch (command) {
            case "seniority":
                System.out.print(this.seniority);break;
            case "color":
                System.out.print(this.color);break;
            case "location":
                System.out.print(this.location);break;
                default:break;
        }
    }

    public CalabashBrother(int Number,int Location,String Seniority,String Color)
    {
        number=Number;
        location=Location;
        seniority=Seniority;
        color=Color;

    }
}






