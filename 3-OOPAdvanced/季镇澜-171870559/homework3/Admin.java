package homework3;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Scanner;

import static java.lang.System.out;

public class Admin {
    private static Checkerboard theboard;
    private static Elder theElder;
    private static Snake theSnake;

    public static void main(String args[]) throws IOException, InterruptedException {
        theboard = new Checkerboard();
        while (true) {
            theElder = new Elder(theboard);
            theSnake = new Snake(theboard);
            theElder.arrange();
            theSnake.arrange();
            theboard.print();
            System.out.print("输入[Y/n]继续……");
            char input=(char)System.in.read();
            if (input == 'n')
                break;
            else {
                theboard.clear();
            }
        }
    }
}

