import java.util.Random;

public class HuLuWaArray {
    /* length of HuLuWa array*/
    private int length;
    private HuLuWa[] array;

    HuLuWaArray(){
        this.length = 7;
        this.array = new HuLuWa[this.length];
        for(int i = 0; i < this.length; i++){
            this.array[i] = new HuLuWa();
            this.array[i].setPosition(i);
            this.array[i].setSeniority(i + 1);
        }
    }

    private void swapHuLuWa(int pos1, int pos2){
        HuLuWa tmp = array[pos1];
        array[pos1] = array[pos2];
        array[pos1].setPosition(pos1);
        array[pos2] = tmp;
        array[pos2].setPosition(pos2);
    }

    public void distributeRandomly(){
        System.out.println("打乱葫芦兄弟的顺序，让他们任意站队。");
        Random r = new Random();
        int pos1, pos2;

        for(int time = this.length; time > 0; time--){
            pos1 = r.nextInt(this.length);
            pos2 = r.nextInt(this.length);
            swapHuLuWa(pos1, pos2);
        }
    }

    private void printMovement(String ele, int src, int dst){
        System.out.println(ele + ": " + src + "->" + dst);
    }

    /* bubble sort */
    public void bubbleSortBySeniority(){
        for(int i = 0; i < length - 1; i++){
            for(int j = 0; j <length - 1 - i; j++){
                if(HuLuWa.compareBySeniority(array[j+1], array[j])){
                    printMovement(array[j+1].getHuLuWaSeniority(), j+1, j);
                    printMovement(array[j].getHuLuWaSeniority(), j, j+1);
                    swapHuLuWa(j, j+1);
                }
            }
        }
    }

    /**
     * brief: put a HuLuWa into assigned position, and return the original HuLuWa in the destination
     * param: movingEle is the HuLuWa put into the dst of array
     * dst is the destination position to put this HuLuWa
     * */
    private HuLuWa moveHuLuWa(HuLuWa movingEle, int dst){
        HuLuWa ret = array[dst];

        array[dst] = movingEle;
        movingEle.setPosition(dst);
        return ret;
    }

    /* binary sort */
    public void binarySortByColor(){
        HuLuWa insertEle = null;
        int low, high, mid;

        for(int i = 1; i < length ; i++){
            insertEle = array[i];
            low = 0;
            high = i - 1;
            while(low <= high){
                mid = low + (high - low) / 2;
                if(HuLuWa.compareBySeniority(insertEle, array[mid])){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
            for(int j = i-1; j >= low; j--){
                printMovement(array[j].getHuLuWaColor(), j, j+1);
                moveHuLuWa(array[j], j+1);
            }
            printMovement(insertEle.getHuLuWaColor(), insertEle.getPosition(), low);
            moveHuLuWa(insertEle, low);
        }
    }

    /* report by HuLuWa seniority */
    public void reportHuLuWaBySeniority(){
        System.out.print("葫芦兄弟用辈分来从头到尾报数：");
        array[0].printHuLuWaSeniority();
        for(int i = 1; i < length; i++){
            System.out.print(", ");
            array[i].printHuLuWaSeniority();
        }
        System.out.print("\n");
    }

    /* report by HuLuWa color */
    public void reportHuLuWaByColor(){
        System.out.print("葫芦兄弟用代表色来从头到尾报数：");
        array[0].printHuLuWaColor();
        for(int i = 1; i < length; i++){
            System.out.print(", ");
            array[i].printHuLuWaColor();
        }
        System.out.print("\n");
    }
}
