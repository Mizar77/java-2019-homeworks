package com.work.person;

public class app {
    public static void main(String args[]){
        Process p=new Process();
        //p.report();
        p.queueRandom();
        p.queueBubble();
        p.queueRandom();
        //p.queueBISort();
        p.BianryInsertSort();
        //p.binarySort(0,7,0);
        //p.report();
        /*for(int i=0;i<5;i++)
        {
            String s=p.genSevenRandom();
            System.out.println(s);
        }*/
    }
}
