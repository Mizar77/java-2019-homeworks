public class HuluBrothers{
    private HuluBoy[] huluset = new HuluBoy[7];
    public HuluBrothers(){
        for(int i=0;i<7;i++)
            huluset[i]=new HuluBoy(i,i);
    }
    public void printColor(){
        for(int i=0;i<7;i++){
            huluset[i].printColor();
        }
        System.out.println("");
    }
    public void printOrder(){
        for(int i=0;i<7;i++){
            huluset[i].printOrder();
        }
        System.out.println("");
    }
    public void disOrganize(){
        for(int i=0;i<7;i++){
            HuluBoy temp;
            int rn=(int)(Math.random()*7);
            temp=huluset[rn];
            huluset[rn]=huluset[i];
            huluset[i]=temp;
        }
    }
    public void BubbleSort(){
        for(int i=0;i<6;i++){
            for(int j=0;j<6-i;j++){
                if(huluset[j].getOrder()>huluset[j+1].getOrder()){
                    HuluBoy temp;
                    huluset[j].printOrder();
                    System.out.println("："+j+"->"+(j+1));
                    huluset[j+1].printOrder();
                    System.out.println("："+(j+1)+"->"+j);
                    temp=huluset[j];
                    huluset[j]=huluset[j+1];
                    huluset[j+1]=temp;
                }
            }
        }
    }
    public void BinarySort(){
        for(int i=1;i<7;i++){
            int local=BinarySearch(0, i-1, huluset[i]);
            HuluBoy temp=huluset[i];
            for(int j=i;j>local;j--){
                huluset[j]=huluset[j-1];
                huluset[j-1].printOrder();
                System.out.println("："+(j-1)+"->"+j);
            }
            huluset[local]=temp;
            if(i!=local){
                temp.printOrder();
                System.out.println("："+i+"->"+local);
            }
        }
    }
    public int BinarySearch(int begin,int end,HuluBoy target){
        int middle=(begin+end)/2;
        while(begin<end){
            if(huluset[middle].getColor()<target.getColor()){
                begin=middle+1;
            }
            else{
                end=middle-1;
            }
            middle=(begin+end)/2;
        }
        if(huluset[begin].getColor()<target.getColor()){
            return begin+1;
        }
        else{
            return begin;
        }
    }
}