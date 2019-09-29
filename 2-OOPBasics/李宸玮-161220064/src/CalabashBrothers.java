import java.util.*;
public class CalabashBrothers {
    Calabash []calabashes=new Calabash[7];//0-6代表老大到老七7个葫芦

    CalabashBrothers() {
        for (int i = 0; i < 7; i++) {
            this.calabashes[i] = new Calabash();
        }
    }
    //初始化葫芦娃兄弟组合
    public void shuffle(){
        Random rand=new Random();
        int num=0;
        boolean[] bool=new boolean[7];
        for(int i=0;i<7;i++){
            do{
                num=rand.nextInt(7);
            }while(bool[num]);
            bool[num]=true;//产生0-6的不同随机数{
            switch(i) {
                case 0:
                    calabashes[num].setColor(Color.red);
                    calabashes[num].setOrder(Order.老大);
                    calabashes[num].setNum(1);
                    calabashes[num].setPos(num);
                    break;
                case 1:
                    calabashes[num].setColor(Color.orange);
                    calabashes[num].setOrder(Order.老二);
                    calabashes[num].setNum(2);
                    calabashes[num].setPos(num);
                    break;
                case 2:
                    calabashes[num].setColor(Color.yellow);
                    calabashes[num].setOrder(Order.老三);
                    calabashes[num].setNum(3);
                    calabashes[num].setPos(num);
                    break;
                case 3:
                    calabashes[num].setColor(Color.green);
                    calabashes[num].setOrder(Order.老四);
                    calabashes[num].setPos(num);
                    calabashes[num].setNum(4);
                    break;
                case 4:
                    calabashes[num].setColor(Color.ching);
                    calabashes[num].setOrder(Order.老五);
                    calabashes[num].setPos(num);
                    calabashes[num].setNum(5);
                    break;
                case 5:
                    calabashes[num].setColor(Color.blue);
                    calabashes[num].setOrder(Order.老六);
                    calabashes[num].setPos(num);
                    calabashes[num].setNum(6);
                    break;
                case 6:
                    calabashes[num].setColor(Color.purple);
                    calabashes[num].setOrder(Order.老七);
                    calabashes[num].setNum(7);
                    calabashes[num].setPos(num);
                    break;
                default:
                    throw new RuntimeException("error");
            }
        }
    }//让七个兄弟随机站队
    public void swap(int i,int j){
        Calabash temp=new Calabash();
        temp=calabashes[i];
        calabashes[i]=calabashes[j];
        calabashes[j]=temp;
        calabashes[i].moveto(i);
        calabashes[j].moveto(j);
    }
    public void bubbleSort(){
        Calabash temp=new Calabash();
        for(int i=0;i<7;i++) {
            for(int j=i+1;j<7;j++) {
                if(calabashes[i].getNum()>calabashes[j].getNum()){
                    swap(i,j);
                }
            }
        }
    }//冒泡排序和二分法排序 无论是按照颜色还是按照排行都依照于num
    public void quickSort(){
        for (int i = 1; i < 7; i++) {
            Calabash temp = calabashes[i];
            int low = 0, high = i - 1;
            int mid = -1;
            while (low <= high) {
                mid = low + (high - low) / 2;
                if (calabashes[mid].getNum() > temp.getNum()) {
                    high = mid - 1;
                } else { // 元素相同时，也在后面的位置插入
                    low = mid + 1;
                }
            }
            for(int j = i - 1; j >= low; j--) {
                calabashes[j+1]=calabashes[j];
                calabashes[j+1].moveto(j+1);
            }
            if(calabashes[low]!=temp){
            calabashes[low]=temp;
            calabashes[low].moveto(low);}
        }
    }

/*
    */

}