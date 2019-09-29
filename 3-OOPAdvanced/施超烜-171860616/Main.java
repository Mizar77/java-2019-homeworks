import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args){
        Map m=new Map();
        String cmd=" ";
        while(!cmd.equals("exit")){
            m.clean();
            m.arrange();
            m.show();
            System.out.println("输入exit以退出，否则进行下一次排阵");
            Scanner in=new Scanner(System.in);
            cmd=in.nextLine();
        }
    }
}