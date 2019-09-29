public class Gourd {
    //葫芦娃序号
    int index;
    //葫芦娃位置
    int position;

    //初始化
    Gourd(int i){
        index = i;
    }

    //获取位置
    public void setPosition(int i){
        position = i;
    }

    //报告排行
    public void tellnum(){
        switch (index){
            case 0:
                System.out.print("老大 ");
                break;
            case 1:
                System.out.print("老二 ");
                break;
            case 2:
                System.out.print("老三 ");
                break;
            case 3:
                System.out.print("老四 ");
                break;
            case 4:
                System.out.print("老五 ");
                break;
            case 5:
                System.out.print("老六 ");
                break;
            case 6:
                System.out.print("老七 ");
                break;
        }
    }

    //报告颜色
    public void tellcolor(){
        switch (index){
            case 0:
                System.out.print("红色 ");
                break;
            case 1:
                System.out.print("橙色 ");
                break;
            case 2:
                System.out.print("黄色 ");
                break;
            case 3:
                System.out.print("绿色 ");
                break;
            case 4:
                System.out.print("青色 ");
                break;
            case 5:
                System.out.print("蓝色 ");
                break;
            case 6:
                System.out.print("紫色 ");
                break;
        }
    }

    //报告位置
    public void tellpos(){
        System.out.print(" " + String.valueOf(position) + "\t");
    }

    //报告交换动作
    public void tellchange(int after){
        switch (index){
            case 0:
                System.out.print("【老大】");
                break;
            case 1:
                System.out.print("【老二】");
                break;
            case 2:
                System.out.print("【老三】");
                break;
            case 3:
                System.out.print("【老四】");
                break;
            case 4:
                System.out.print("【老五】");
                break;
            case 5:
                System.out.print("【老六】");
                break;
            case 6:
                System.out.print("【老七】");
                break;
        }
        System.out.print(":" + String.valueOf(position) + " ——> " + String.valueOf(after) + '\t');
        setPosition(after);
    }
}