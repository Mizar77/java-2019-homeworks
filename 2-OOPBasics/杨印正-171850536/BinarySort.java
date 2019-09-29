public class BinarySort {
    public static void binarysort(CalabashBrother[] array) {
        for (int i = 2; i < array.length + 1; i++) {//i为葫芦娃location1-7
            for (int j = 0; j < array.length; j++) {//j为葫芦娃数组huluwa[7]下标
                if (array[j].location == i) {//寻找location为2的葫芦娃
                    int temp = array[j].location;//记录待排序葫芦娃位置
                    int low = 1, high = i - 1;//二分法排序
                    int mid = 0;
                    while (low <= high) {
                        mid = low + (high - low) / 2;
                        for (int k = 0; k < array.length; k++) {
                            if (array[k].location == mid) {//寻找此时位置为已排好序中间location
                                if (array[k].number > array[j].number) {//比较number
                                    high = mid - 1;
                                } else {
                                    low = mid + 1;
                                }
                            }
                        }
                    }
                    for (int h = i - 1; h >= low; h--) {//后挪
                        for (int m = 0; m < array.length; m++) {
                            if (array[m].location == h) {
                                array[m].report("seniority");
                                System.out.print(":");
                                array[m].report("location");
                                System.out.print("->");
                                array[m].location = h + 1;
                                array[m].report("location");
                            }
                        }
                    }
                    array[j].location = low;
                }

            }
        }
    }
}