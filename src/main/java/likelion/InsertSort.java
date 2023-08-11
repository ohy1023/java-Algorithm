package likelion;

import java.util.Arrays;

public class InsertSort {
    int[] sort(int[] arr) {

        for (int i =1; i < arr.length; i++)
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8, 5, 6, 2, 4};
        InsertSort insertSort = new InsertSort();
        System.out.println(Arrays.toString(insertSort.sort(arr)));

    }
}
