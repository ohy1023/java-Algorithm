package book.thisiscodingtest.sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        quickSort(arr, 0, arr.length - 1);

        printArray(arr);
    }

    private static void quickSort(int[] arr, int lt, int rt) {
        int part2 = partition(arr, lt, rt);
        if (lt < part2 - 1) {
            quickSort(arr, lt, part2 - 1);
        }
        if (rt > part2) {
            quickSort(arr, part2, rt);
        }

    }


    private static int partition(int[] arr, int lt, int rt) {
        int pivot = arr[(lt + rt) / 2];
        while (lt <= rt) {
            while (arr[lt] < pivot) lt++;
            while (arr[rt] > pivot) rt--;
            if (lt <= rt) {
                swap(arr, lt, rt);
                lt++;
                rt--;
            }
        }
        return lt;
    }

    private static void swap(int[] arr, int lt, int rt) {
        int tmp = arr[lt];
        arr[lt] = arr[rt];
        arr[rt] = tmp;
    }

    private static void printArray(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }
}
