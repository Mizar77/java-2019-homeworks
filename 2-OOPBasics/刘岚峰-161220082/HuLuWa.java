public class HuLuWa {
    public static final String[] HuLuWaSeniority = {
        "老大", "老二", "老三", "老四", "老五", "老六", "老七"
    };

    public static final String[] HuLuWaColor = {
        "赤", "橙", "黄", "绿", "青", "蓝", "紫"
    };

    /* The rank of the HuLuWa among his family , the value must be from 1 to 7*/
    private int seniority;
    /* The position of the HuLuWa in a container */
    private int position;
    /* may be need add other properties */

    HuLuWa(){
        this.seniority = 1;
        this.position = -1;
    }

    HuLuWa(int seniority){
        if(seniority < 1 || seniority > 7){
            System.err.println("葫芦娃的兄弟的辈分只能是1到7之间的某个数.");
            System.exit(-1);
        }
        this.seniority = seniority;
        this.position = -1;
    }

    public int getPosition(){
        return this.position;
    }

    public void setPosition(int newPos){
        this.position = newPos;
    }

    void setSeniority(int seniority){
        this.seniority = seniority;
    }

    public String getHuLuWaColor(){
        return HuLuWaColor[this.seniority - 1];
    }

    public String getHuLuWaSeniority(){
        return HuLuWaSeniority[this.seniority - 1];
    }

    /**
     * brief: compare two HuLuWas by their seniority number. If seniority of a is smaller than that of b, return true,
     * else return false.
     * param: a and b are HuLuWas who put into comparison
     */
    public static boolean compareBySeniority(HuLuWa a, HuLuWa b){
        return a.seniority < b.seniority;
    }

    public void printHuLuWaSeniority(){
        System.out.print(HuLuWaSeniority[this.seniority-1]);
    }

    public void printHuLuWaColor(){
        System.out.print(HuLuWaColor[this.seniority-1]);
    }
}
