package org.nju.edu.Test;

import java.util.Random;

public class GourdManQueue {
    GourdMan[] GourdMans;
    GourdManQueue() throws Exception{
        GourdMans = new GourdMan[7];
        String[] names = new String[]{"大娃","二娃","三娃","四娃","五娃","六娃","七娃"};
        for(int i = 0;i < 7; i++){
            GourdMans[i] = new GourdMan(names[i]);
        }
    }

    private void ExchangeTwoGourdMans(int i,int j){
        GourdMan temp = GourdMans[i];
        GourdMans[i] = GourdMans[j];
        GourdMans[j] = temp;
    }

    private void ExchangeTwoGourdMansWithReport(int i,int j){
        GourdMan temp = GourdMans[i];
        GourdMans[i] = GourdMans[j];
        GourdMans[j] = temp;
        System.out.println(GourdMans[i].getName()+":"+String.valueOf(i)+"->"+String.valueOf(j));
        System.out.println(GourdMans[j].getName()+":"+String.valueOf(j)+"->"+String.valueOf(i));
    }

    public void RandomLineUP(){
        Random rand = new Random();
        for(int i = 0; i < 7; i ++){
            int a = rand.nextInt(7);
            ExchangeTwoGourdMans(i,a);
        }
    }

    public void AllSayName(){
        for(int i = 0; i < 7; i ++){
            GourdMans[i].SayName();
        }
    }

    public void AllSayColor(){
        for(int i = 0; i < 7; i ++){
            GourdMans[i].SayColor();
        }
    }

    public void SortByName(){
        for(int i = 0; i < 7; i ++){
            for(int j = 0; j < 7-i-1; j ++){
                if(GourdMans[j].CompareRankWith(GourdMans[j+1])){
                    ExchangeTwoGourdMansWithReport(j,j+1);
                }
            }
        }
    }

    public void SortByColor(){
        for(int i = 0; i < 7 ; i ++){
            int left = 0;
            int right = i-1;
            int middle = 0;
            GourdMan temp = GourdMans[i];
            while(left<=right){
                middle = (left+right)/2;
                if(GourdMans[middle].CompareColorWith(temp)){
                    right = middle - 1;
                }else {
                    left = middle + 1;
                }
            }
            for(int j = i - 1;j>=left;j--){
                ExchangeTwoGourdMansWithReport(j+1,j);
            }
        }
    }
}
