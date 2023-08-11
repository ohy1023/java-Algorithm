package likelion.java1109;

import java.util.Arrays;

public class SelectSortResult {
    int[] solution(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int idx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[idx] > arr[j]) {
                    idx = j;
                }
            }
            swap(arr, i, idx);
        }

        return arr;
    }

    private static void swap(int[] arr, int i, int idx) {
        int temp = arr[i];
        arr[i] = arr[idx];
        arr[idx] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 4, 9, 10, 223, 111, 23, 3, 39};
        SelectSortResult ss = new SelectSortResult();
        System.out.println(Arrays.toString(ss.solution(arr)));


    }
}
