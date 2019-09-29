import java.util.Arrays;


public class QuickSortNumbers {
    public static void main(String args[]){
        int[] numbers = new int[]{32,43,53,54,32,65,63,98,43,23};

        quickSort(numbers, true);
        System.out.println("Sorted number array is: " + Arrays.toString(numbers));
    }

    public static void quickSort(int[] numbers, boolean isAscend){
        if(numbers.length == 0){
            System.err.println("Input array is empty.");
            return;
        }

        int temp = 0;

        partition(numbers, 0, numbers.length - 1);
        if(!isAscend) {
            for (int i = 0, j = numbers.length - 1; i < j; i++, j--) {
                temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
            }
        }
    }

    private static void partition(int numbers[], int begin, int end){
        if(begin >= end){
            return;
        }

        int pivot = numbers[begin];
        int i = begin, j = end;

        while(i < j) {
            while(numbers[j] >= pivot && j > i){
                j--;
            }
            if(j == i){
                break;
            }
            mySwapNumbers(numbers, i, j);
            i++;
            while(numbers[i] <= pivot && i < j){
                i++;
            }
            if(i == j){
                break;
            }
            mySwapNumbers(numbers, i, j);
            j--;
        }

        partition(numbers, begin, i-1);
        partition(numbers, i+1, end);
    }

    private static void mySwapNumbers(int numbers[], int location1, int location2){
        int temp;

        temp = numbers[location1];
        numbers[location1] = numbers[location2];
        numbers[location2] = temp;
    }
}
