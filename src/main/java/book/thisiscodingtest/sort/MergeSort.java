package book.thisiscodingtest.sort;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
        int[] tmp = new int[arr.length];

        mergeSort(arr, tmp, 0, arr.length - 1);

        printArray(arr);
    }

    private static void mergeSort(int[] arr, int[] tmp, int lt, int rt) {
        if (lt < rt) {
            int mid = (lt + rt) / 2;
            mergeSort(arr, tmp, lt, mid);
            mergeSort(arr, tmp, mid + 1, rt);
            merge(arr, tmp, lt, mid, rt);
        }
    }


    private static void merge(int[] arr, int[] tmp, int lt, int mid, int rt) {
        for (int i = lt; i <= rt; i++) {
            tmp[i] = arr[i];
        }

        int part1 = lt;
        int part2 = mid + 1;
        int index = lt;
        while (part1 <= mid && part2 <= rt) {
            if (tmp[part1] <= tmp[part2]) {
                arr[index] = tmp[part1];
                part1++;
            } else {
                arr[index] = tmp[part2];
                part2++;
            }
            index++;
        }

        for (int i = 0; i <= mid - part1; i++) {
            arr[index + i] = tmp[part1 + i];
        }

    }

    private static void printArray(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }
}
