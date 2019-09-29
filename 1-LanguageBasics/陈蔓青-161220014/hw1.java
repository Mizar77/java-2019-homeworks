public class hw1 {

    int[] array = {4,9,14,27,36,1,7,10,22};     //给定一个长度为9的数组进行排序

    public void mySort(){                       //由小至大进行排序
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++){
                if (array[j] < array[i]){
                    int swap = array[i];
                    array[i] = array[j];
                    array[j] = swap;
                }
            }
        }
    }

    public void myResult(){                     //输出排序后数组
        for (int i = 0; i < 9; i++)
            System.out.println(array[i] + " ");
    }

    public static void main(String args[]){
        hw1 sort = new hw1();
        sort.mySort();
        sort.myResult();
    }
}
