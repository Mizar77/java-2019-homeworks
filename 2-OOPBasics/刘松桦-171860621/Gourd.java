abstract class Gourd {
    public int id;
    public String color;
    public void reportOrder(int a, int b){

        System.out.print("：从像素("+a*100+"，300)");
        if(b-a==1||b-a==-1){
            System.out.print("挪动");
        }else{
            System.out.print("飞跃");
        }
        System.out.println("到了像素("+b*100+",300)");
    }
    public void reportColor(){
        System.out.print(color+" ");
    }
    public abstract void reportName();
}

class RedGourd extends Gourd{
    public void reportName(){
        System.out.print("老大 ");
    }
    public RedGourd(){
        id=1;
        color="红色";
    }
}

class OrangeGourd extends Gourd{
    public void reportName(){
        System.out.print("老二 ");
    }
    public OrangeGourd(){
        id=2;
        color="橙色";
    }
}

class YellowGourd extends Gourd{
    public void reportName(){
        System.out.print("老三 ");
    }
    public YellowGourd(){
        id=3;
        color="黄色";
    }
}

class GreenGourd extends Gourd{
    public void reportName(){
        System.out.print("老四 ");
    }
    public GreenGourd(){
        id=4;
        color="绿色";
    }
}

class NavyGourd extends Gourd{
    public void reportName(){
        System.out.print("老五 ");
    }
    public NavyGourd(){
        id=5;
        color="青色";
    }
}

class BlueGourd extends Gourd{
    public void reportName(){
        System.out.print("老六 ");
    }
    public BlueGourd(){
        id=6;
        color="蓝色";
    }
}

class PurpleGourd extends Gourd{
    public void reportName(){
        System.out.print("老七 ");
    }
    public PurpleGourd(){
        id=7;
        color="紫色";
    }
}