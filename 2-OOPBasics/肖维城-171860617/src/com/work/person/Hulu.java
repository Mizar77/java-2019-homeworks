package com.work.person;

public class Hulu {
    int val;
    //int pos;

    public Hulu(int v){
        val=v;
    }

    public void reportNum(){
        switch (val){
            case 1:System.out.print("老大");break;
            case 2:System.out.print("老二");break;
            case 3:System.out.print("老三");break;
            case 4:System.out.print("老四");break;
            case 5:System.out.print("老五");break;
            case 6:System.out.print("老六");break;
            case 7:System.out.print("老七");break;
            default :System.out.print("error");break;
        }
    }

    public void reportColor(){
        switch (val){
            case 1:System.out.print("红");break;
            case 2:System.out.print("橙");break;
            case 3:System.out.print("黄");break;
            case 4:System.out.print("绿");break;
            case 5:System.out.print("青");break;
            case 6:System.out.print("蓝");break;
            case 7:System.out.print("紫");break;
            default :System.out.print("error");break;
        }
    }
}
