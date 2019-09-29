package CalabashBrothers;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Boy b1=new Boy("老大","红色",1,1);
        Boy b2=new Boy("老二","橙色",2,2);
        Boy b3=new Boy("老三","黄色",3,3);
        Boy b4=new Boy("老四","绿色",4,4);
        Boy b5=new Boy("老五","青色",5,5);
        Boy b6=new Boy("老六","蓝色",6,6);
        Boy b7=new Boy("老七","紫色",7,7);

        Boy[] boys=new Boy[7];
        int[] order=new int[7];
        System.out.println("Please enter a sequence of numbers 1-7, separated by spaces:");
        Scanner keyboard=new Scanner(System.in);
        for(int i=0;i<7;i++)
        {
            order[i]=(keyboard.nextInt()-1);
        }

        Sort sorter=new Sort();

        System.out.println("--------------------------------------------");
        boys[order[0]]=b1;
        boys[order[1]]=b2;
        boys[order[2]]=b3;
        boys[order[3]]=b4;
        boys[order[4]]=b5;
        boys[order[5]]=b6;
        boys[order[6]]=b7;
        System.out.print("Before bubble sort:");
        BoysReportName(boys);
        sorter.BubbleSort(boys);
        System.out.print("After bubble sort:");
        BoysReportName(boys);

        System.out.println("--------------------------------------------");
        boys[order[0]]=b1;
        boys[order[1]]=b2;
        boys[order[2]]=b3;
        boys[order[3]]=b4;
        boys[order[4]]=b5;
        boys[order[5]]=b6;
        boys[order[6]]=b7;
        System.out.print("Before dichotomy sort:");
        BoysReportColor(boys);
        sorter.DichotomySort(boys);
        System.out.print("After dichotomy sort:");
        BoysReportColor(boys);

        System.out.println("----------------------------------");
        System.out.println("Program ends.");
        return;
    }
    private static void BoysReportName(Boy[]boys)
    {
        for(int i=0;i<7;i++)
        {
            boys[i].ReportNumber();
        }
        System.out.println();
    }

    private static void BoysReportColor(Boy[]boys)
    {
        for(int i=0;i<7;i++)
        {
            boys[i].ReportColor();
        }
        System.out.println();
    }
}
