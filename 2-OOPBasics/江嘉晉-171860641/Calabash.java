public class Calabash {
    public static void main(String[] args) {
        CalabashBros first = new CalabashBros("老大", "红色", 1);
        CalabashBros second = new CalabashBros("老二", "橙色", 2);
        CalabashBros third = new CalabashBros("老三", "黄色", 3);
        CalabashBros fourth = new CalabashBros("老四", "绿色", 4);
        CalabashBros fifth = new CalabashBros("老五", "青色", 5);
        CalabashBros sixth = new CalabashBros("老六", "蓝色", 6);
        CalabashBros seventh = new CalabashBros("老七", "紫色", 7);
        CalabashBros[] bros = {first, second, third, fourth, fifth, sixth, seventh};
        Manager manager = new Manager(bros);
        manager.randomPos();
        System.out.println("Original sequence:");
        manager.reportName();
        System.out.println("Bubble sorting:");
        manager.sortBubble();
        System.out.println("Sorted!");
        manager.reportName();
        manager.randomPos();
        System.out.println("Original sequence:");
        manager.reportColor();
        System.out.println("Merge sorting:");
        manager.sortMerge();
        System.out.println("sorted!");
        manager.reportColor();
    }
}

class Manager{
    private CalabashBros[] brosPos;
    private void merge(int s,int m,int e){
        int n1=m-s+1;
        int n2=e-m;
        CalabashBros[] L=new CalabashBros[n1];
        CalabashBros[] R=new CalabashBros[n2];

        for(int i=0;i<n1;i++)
            L[i]=brosPos[s+i];
        for(int i=0;i<n2;i++)
            R[i]=brosPos[m+1+i];

        int i=0;
        int j=0;
        int k=s;
        while(i<n1 && j<n2){
            if(L[i].getLevel()<=R[j].getLevel()){
                L[i].setAndReportColor(k);
                brosPos[k]=L[i];
                i++;
            }
            else{
                R[j].setAndReportColor(k);
                brosPos[k]=R[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            L[i].setAndReportColor(k);
            brosPos[k]=L[i];
            i++;
            k++;
        }
        while(j<n2){
            R[j].setAndReportColor(k);
            brosPos[k]=R[j];
            j++;
            k++;
        }
    }
    public Manager(CalabashBros[] bros){
        brosPos = new CalabashBros[7];
        for(int i=0;i<Constants.BROS_NUM;i++){
            brosPos[i]=bros[i];
        }
    }
    public void reportName(){
        for(CalabashBros bro:brosPos){
            System.out.println(bro.getName());
        }
    }
    public void reportColor(){
        for(CalabashBros bro:brosPos){
            System.out.println(bro.getColor());
        }
    }
    public void sortBubble(){
        for(int i=0;i<(brosPos.length-1);i++)
            for(int j=0;j<(brosPos.length-1-i);j++){
                if(brosPos[j].getLevel()>brosPos[j+1].getLevel()){
                    brosPos[j].setAndReportName(j+1);
                    brosPos[j+1].setAndReportName(j);
                    CalabashBros tempBro=brosPos[j];
                    brosPos[j]=brosPos[j+1];
                    brosPos[j+1]=tempBro;
                }
            }
    }
    public void sortMerge(){
        this.sortMerge(0,Constants.BROS_NUM-1);
    }
    public void sortMerge(int s,int e){
        if(s<e){
            int m=(s+e)/2;
            sortMerge(s,m);
            sortMerge(m+1,e);
            merge(s,m,e);
        }
    }
    public void randomPos(){
        for(int i=0,j;i<brosPos.length;i++){
            j=(int)(Math.random()*7);
            brosPos[i].setPos(j);
            brosPos[j].setPos(i);
            CalabashBros tempBro=brosPos[i];
            brosPos[i]=brosPos[j];
            brosPos[j]=tempBro;
        }
    }
    public void debug(){
        System.out.println(brosPos.length);
    }
}

class CalabashBros{
    private int pos;
    private final String name;
    private final String color;
    private final int level;
    public CalabashBros(String aName, String aColor, int aLevel){
        name=aName;
        color=aColor;
        level=aLevel;
        pos=aLevel-1;
    }
    public void setAndReportName(int newPos){
        if(pos==newPos)
            return;
        System.out.println(name+":"+(pos+1)+"->"+(newPos+1));
        pos=newPos;
    }
    public void setAndReportColor(int newPos){
        if(pos==newPos)
            return;
        System.out.println(color+":"+(pos+1)+"->"+(newPos+1));
        pos=newPos;
    }
    public void setPos(int newPos){
        pos=newPos;
    }
    public int getPos(){
        return pos;
    }
    public int getLevel(){
        return level;
    }
    public String getName(){
        return name;    //name.clone()?
    }
    public String getColor(){
        return color;   //color.clone()?
    }
}

class Constants{
    public static final int BROS_NUM=7;
}