package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        GourdDoll[] gourds = new GourdDoll[7];

        System.out.println("Bubble sort:");
        Grandpa.plantGourds(gourds);
        System.out.println("Start:");
        Grandpa.reportGourdsIdentity(gourds);
        Grandpa.reportGourdsColor(gourds);
        System.out.println("Sorting:");
        Grandpa.sortBubble(gourds);
        System.out.println("End:");
        Grandpa.reportGourdsIdentity(gourds);

        System.out.println("Dichotomy sort:");
        Grandpa.plantGourds(gourds);
        System.out.println("Start:");
        Grandpa.reportGourdsIdentity(gourds);
        Grandpa.reportGourdsColor(gourds);
        System.out.println("Sorting:");
        Grandpa.sortDichotomy(gourds);
        System.out.println("End:");
        Grandpa.reportGourdsColor(gourds);
    }
}

class GourdDoll {
    String color;
    String identity;
    //used to sort
    int sign;
    int address;

    GourdDoll(String color, String identity, int sign, int address) {
        this.color = new String(color);
        this.identity = new String(identity);
        this.sign = sign;
        this.address = address;
    }
    GourdDoll(GourdDoll gourdDoll) {
        color = new String(gourdDoll.color);
        identity = new String(gourdDoll.identity);
        sign = gourdDoll.sign;
        address = gourdDoll.address;
    }

    //身份比较
    public int compareWithBrother(GourdDoll brother) {
        return sign - brother.sign;
    }
    //交换位置并报告
    public void swapWithBrother(GourdDoll brother) {
        if (brother == this) return;

        if (sign < brother.sign) {
            System.out.println(
                    identity + ": " + address + "->" + brother.address + "\t" +
                    brother.identity + ": " + brother.address + "- > " + address
            );
        }
        else {
            System.out.println(
                    brother.identity + ": " + brother.address + "- > " + address + "\t" +
                    identity + ": " + address + "->" + brother.address
            );
        }

        GourdDoll temp = new GourdDoll(this);
        color = new String(brother.color);
        identity = new String(brother.identity);
        sign = brother.sign;

        brother.color = new String(temp.color);
        brother.identity = new String(temp.identity);
        brother.sign = temp.sign;
    }
    public void reportColor() {System.out.print(color + " ");}
    public void reportIdentity() {System.out.print(identity + " ");}
}

class Grandpa {
    static public void plantGourds(GourdDoll[] gourds) {
        boolean[] allgourds = new boolean[7];
        for (int i = 0; i < allgourds.length; i++) {
            allgourds[i] = false;
        }
        Random rand = new Random();

        for (int i = 0; i < gourds.length; i++) {
            int gourd;
            do {
                gourd = rand.nextInt(7);
            } while (allgourds[gourd] == true);
            allgourds[gourd] = true;
            switch(gourd) {
                case 0 : gourds[i] = new GourdDoll("红色", "老大", 0, i); break;
                case 1 : gourds[i] = new GourdDoll("橙色", "老二", 1, i); break;
                case 2 : gourds[i] = new GourdDoll("黄色", "老三", 2, i); break;
                case 3 : gourds[i] = new GourdDoll("绿色", "老四", 3, i); break;
                case 4 : gourds[i] = new GourdDoll("青色", "老五", 4, i); break;
                case 5 : gourds[i] = new GourdDoll("蓝色", "老六", 5, i); break;
                case 6 : gourds[i] = new GourdDoll("紫色", "老七", 6, i); break;
            }
        }
    }

    static public void reportGourdsColor(GourdDoll[] gourds) {
        for (int i = 0; i < gourds.length; i++) {
            gourds[i].reportColor();
        }
        System.out.print("\n");
    }
    static public void reportGourdsIdentity(GourdDoll[] gourds) {
        for (int i = 0; i < gourds.length; i++) {
            gourds[i].reportIdentity();
        }
        System.out.print("\n");
    }

    static public void sortBubble(GourdDoll[] gourds) {
        for (int i = 0; i < gourds.length - 1; i++) {
            for (int j = 0; j < gourds.length - 1 - i; j++) {
                if (gourds[j].compareWithBrother(gourds[j+1]) > 0) {
                    gourds[j].swapWithBrother(gourds[j + 1]);
                }
            }
        }
    }
    static public void sortDichotomy(GourdDoll[] gourds) {
        for (int i = 1; i < gourds.length; i++) {
            int left = 0, right = i - 1, mid;
            while (left <= right) {
                mid = (left + right) / 2;
                if (gourds[i].compareWithBrother(gourds[mid]) < 0)
                    right = mid - 1;
                else left = mid + 1;
            }
            for (int j = i; j > left; j--) {
                gourds[j-1].swapWithBrother(gourds[j]);
            }
        }
    }
}