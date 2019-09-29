import java.util.Random;

public class Main {

    public static void main(String[] args) {
        CalabashBro[] calabashBros = new CalabashBro[7];
        calabashBros[0]=new CalabashBro("老大", "红色");
        calabashBros[1]=new CalabashBro("老二", "橙色");
        calabashBros[2]=new CalabashBro("老三", "黄色");
        calabashBros[3]=new CalabashBro("老四", "绿色");
        calabashBros[4]=new CalabashBro("老五", "青色");
        calabashBros[5]=new CalabashBro("老六", "蓝色");
        calabashBros[6]=new CalabashBro("老七", "紫色");

        /* Fisher-Yates Shuffle */
        Random random = new Random();
        for(int i = 6; i>0; --i){
            int indexForExchg = random.nextInt(i);
            CalabashBro temp1 = calabashBros[i];
            calabashBros[i]=calabashBros[indexForExchg];
            calabashBros[indexForExchg]=temp1;
        }

        /*Bubble Sort*/
        for(int j = 0; j < 6; ++j){
            for(int k = 0; k < (6-j); ++k){
                if(calabashBros[k].rankIsGreaterThan(calabashBros[k+1])){
                    calabashBros[k].displayRank(); System.out.println(":"+k+"->"+(k+1));
                    CalabashBro temp2 = calabashBros[k];
                    calabashBros[k] = calabashBros[k+1];
                    calabashBros[k+1] = temp2;
                }
            }
        }

        /*报数*/
        for(int i=0; i<7; ++i)
            calabashBros[i].displayRank();
        System.out.println();

        /* Fisher-Yates Shuffle */
        for(int i = 6; i>0; --i){
            int indexForExchg = random.nextInt(i);
            CalabashBro temp1 = calabashBros[i];
            calabashBros[i]=calabashBros[indexForExchg];
            calabashBros[indexForExchg]=temp1;
        }

        /*Binary Insert Sort*/
        for(int j = 1; j < 7; ++j) {
            int left = 0, right = j - 1;
            int mid = (left+right)/2;
            while(left <= right) {
                if(calabashBros[j].colorIsGreaterThan(calabashBros[mid])) {
                    left = mid+1;
                }
                else {
                    right = mid-1;
                }
                mid = (left+right)/2;
            }

            if(j!=left) {
                calabashBros[j].displayRank(); System.out.println(":" + j + "->" + left);
            }
            CalabashBro temp3 = calabashBros[j];
            for(int k = j; k>left; --k)
                calabashBros[k] = calabashBros[k-1];
            calabashBros[left] = temp3;

        }
        for(int i=0; i<7; ++i)
            calabashBros[i].displayColor();
        System.out.println();

    }
}
