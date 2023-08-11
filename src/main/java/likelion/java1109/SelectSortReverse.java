package likelion.java1109;

import java.util.Arrays;

public class SelectSortReverse {
    int[] solution(int[] arr, SortStrategy sortStrategy) {
        for (int i = 0; i < arr.length - 1; i++) {
            int idx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (sortStrategy.sortHow(arr[idx], arr[j])) {
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
        SelectSortReverse ss = new SelectSortReverse();
        SortStrategy sortHow = (a, b) -> (a < b);
        System.out.println(Arrays.toString(ss.solution(arr, sortHow)));


    }
}
