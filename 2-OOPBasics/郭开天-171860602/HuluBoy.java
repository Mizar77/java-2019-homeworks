public class HuluBoy{
    private int order;
    private int color;
    public HuluBoy(int order,int color){
        this.color=color;
        this.order=order;
    }
    public void printOrder(){
        switch(order){
            case 0:System.out.print("老大");break;
            case 1:System.out.print("老二");break;
            case 2:System.out.print("老三");break;
            case 3:System.out.print("老四");break;
            case 4:System.out.print("老五");break;
            case 5:System.out.print("老六");break;
            case 6:System.out.print("老七");break;
        }
    }
    public void printColor(){
        switch(color){
            case 0:System.out.print("红色");break;
            case 1:System.out.print("橙色");break;
            case 2:System.out.print("黄色");break;
            case 3:System.out.print("绿色");break;
            case 4:System.out.print("青色");break;
            case 5:System.out.print("蓝色");break;
            case 6:System.out.print("紫色");break;
        }
    }
    public int getOrder(){
        return order;
    }
    public int getColor(){
        return color;
    }
}