import java.util.Random;
public class MySort {
    //CalabashBrothers[] Boys;
    static int [] GetRandomArray(int len){
        int RandomArray[]=new int[len];
        Random random=new Random();
        int j;
        RandomArray[0]=random.nextInt(len);
        for(int i=1;i<len;i++){
            j=0;
            while(j!=i){
                j=0;
                RandomArray[i]=random.nextInt(len);
                while(j<i&&RandomArray[j]!=RandomArray[i])
                    j++;
            }
        }
        return RandomArray;
    }

    static void ExchangeTwoBoys(CalabashBrothers boy1,CalabashBrothers boy2){
        int rank_temp=boy1.rank;
        String color_temp=boy1.color;
        String name_temp=boy1.name;

        boy1.rank=boy2.rank;
        boy1.color=boy2.color;
        boy1.name=boy2.name;

        boy2.rank=rank_temp;
        boy2.color=color_temp;
        boy2.name=name_temp;
    }

    static void BubbleSortBoys(int array[],int len){
        CalabashBrothers[] QueueBoys=new CalabashBrothers[len];
        for(int i=0;i<len;i++){
            QueueBoys[i]=new CalabashBrothers(array[i]);
        }
        for(int i=0;i<len-1;i++){
            for(int j=0;j<len-1-i;j++){
                if(QueueBoys[j].rank>QueueBoys[j+1].rank){

                    QueueBoys[j].TellExchangeLocation(j+1,j+2);
                    QueueBoys[j+1].TellExchangeLocation(j+2,j+1);

                    ExchangeTwoBoys(QueueBoys[j],QueueBoys[j+1]);

                }
            }
        }
        for(int i=0;i<len;i++){
            QueueBoys[i].TellName();
        }
    }


    static void BinarySortBoys(int array[],int len){
        CalabashBrothers[] QueueBoys=new CalabashBrothers[len];
        for(int i=0;i<len;i++){
            QueueBoys[i]=new CalabashBrothers(array[i]);
        }
        for(int i=1;i<len;i++) {
            CalabashBrothers cala_temp = new CalabashBrothers(0);
            ExchangeTwoBoys(cala_temp, QueueBoys[i]);
            int low = 0, high = i - 1, mid = -1;
            while (low <= high) {
                mid = low + (high - low) / 2;
                if (QueueBoys[mid].rank > cala_temp.rank) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            for (int j = i - 1; j >= low; j--) {
                QueueBoys[j].TellExchangeLocation(j + 1, j + 2);
                ExchangeTwoBoys(QueueBoys[j], QueueBoys[j + 1]);
            }
            if (low != i)
                cala_temp.TellExchangeLocation(i + 1, low + 1);
            ExchangeTwoBoys(QueueBoys[low], cala_temp);
        }
        for(int i=0;i<len;i++){
            QueueBoys[i].TellColor();
        }
    }

    public static void main(String args[]){
        BubbleSortBoys(GetRandomArray(7),7);
        BinarySortBoys(GetRandomArray(7),7);
       // int array[]={3,2,5,1,6,4,0};
       // BinarySortBoys(array,7);
        //BubbleSortBoys(array,7);
       /*int []array=GetRandomArray(7);
         for(int i=0;i<7;i++){
            System.out.println(array[i]);
        }*/
    }
}

