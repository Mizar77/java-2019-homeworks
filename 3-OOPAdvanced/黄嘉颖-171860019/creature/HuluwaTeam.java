package creature;

import queuepattern.*;
import space.*;

public class HuluwaTeam {
    private Huluwa brothers[];
    private Grandpa cheerleader;
    public HuluwaTeam(){
        brothers=new Huluwa[7];
        cheerleader=new Grandpa();
        randomQueue();
    }

    public Grandpa getCheerleader() {
        return cheerleader;
    }
    public Huluwa getTheSpecificHuluwa(int i){
        return brothers[i];
    }
    public Huluwa[] getBrothers(){
        return brothers;
    }

    public void randomQueue(){
        //brothers=new Huluwa[7];
        boolean flag;
        for (int i=0;i<brothers.length;i++){
            flag=false;
            while(flag==false) {
                int rand = (int) Math.round(Math.random() * 6 + 1);
                for (int j = 0; j < i; j++) {
                    if (brothers[j].getRank() == rand) {
                        flag = true;
                        break;
                    }
                }
                if (flag==true)flag=false;
                else{
                    brothers[i]=new Huluwa(rand);
                    flag=true;
                }
            }
        }
    }
    public void bubbleSort(){
        //System.out.println();
        for (int i=0;i<brothers.length-1;i++) {
            for (int j = 0; j < brothers.length - i - 1; j++) {
                if (brothers[j].getRank() > brothers[j + 1].getRank()) {
                    //brothers[j].tellChange(j,j+1);
                    //queue[j + 1].tellChange(j+1,j);
                    Huluwa temp = brothers[j];
                    brothers[j] = brothers[j + 1];
                    brothers[j + 1] = temp;
                }
            }
        }
    }


    public void generateTheSpecificPattern(QueuePattern pattern, Space battleground, int x, int y){
        pattern.generateTheSpecificPattern(battleground,this,x,y);
    }

    public void generateTheCheerPattern(Space battleground, int x, int y){
        cheerleader.moveTo(battleground,x,y);
    }
}
