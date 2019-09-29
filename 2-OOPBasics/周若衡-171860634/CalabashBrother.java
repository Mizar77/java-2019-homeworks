import java.util.Random;

public enum CalabashBrother{
    
    RED("老大","赤色",1),ORANGE("老二","橙色",2),YELLOW("老三","黄色",3),GREEN("老四","绿色",4),CYANBLUE("老五","青色",5),BLUE("老六","蓝色",6),PURPLE("老七","紫色",7);
    private final String name;
    private final String color;
    private final int level;
    private CalabashBrother(String name,String color,int level){
        this.name = name;
        this.color = color;
        this.level = level;
    }
    public static void bubbleSort(CalabashBrother []brothers){
        System.out.println("Bubble Sort by seniority in family:");
        for(int i=0;i<brothers.length-1;i++){
            for(int j=0;j<brothers.length-1;j++){
                if(brothers[j].level > brothers[j+1].level){
                    System.out.println(brothers[j].name+":"+j+"->"+(j+1)+" "+brothers[j+1].name+":"+(j+1)+"->"+j);
                    CalabashBrother temp = brothers[j];
                    brothers[j]=brothers[j+1];
                    brothers[j+1]=temp;
                }
            }
        }

        System.out.println("Report Number:");
        for(int i=0;i<brothers.length;i++){
            System.out.println(brothers[i].name+" ");
        }

    }

    public static void binarySort(CalabashBrother []brothers){
        System.out.println("\n"+"Binary Sort by color:");

        for(int i=0;i<brothers.length;i++){
            CalabashBrother broTemp = brothers[i];
            int left=0; int right=i-1; int mid;

            while(left<=right){
                mid = (left+right)/2;
                if(broTemp.level < brothers[mid].level){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }

            for(int j=i-1;j>=left;j--){
                System.out.println(brothers[j].name+":"+j+"->"+(j+1));
                brothers[j+1] = brothers[j];
            }
            if(left != i){
                System.out.println(broTemp.name+":"+i+"->"+left);
                brothers[left] = broTemp;
            }
        }

        System.out.println("Report Color:");
        for(int i=0;i<brothers.length;i++){
            System.out.println(brothers[i].color);
        }
    }

    public static CalabashBrother[] disrupt(CalabashBrother []brothers){
        CalabashBrother []broTemp = new CalabashBrother[brothers.length];
        int size = brothers.length-1;
        Random rd = new Random();
        for(int i=0;i<brothers.length;i++){
            int rand = rd.nextInt(size+1);
            broTemp[i]=brothers[rand];
            brothers[rand]=brothers[size];
            size--;
        }
        return broTemp;
    }

    public static void main(String[] args){
        CalabashBrother[] brothers = {GREEN,RED,CYANBLUE,YELLOW,ORANGE,PURPLE,BLUE};
        bubbleSort(brothers);
        brothers = disrupt(brothers);
        binarySort(brothers);
    }

}