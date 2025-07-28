package book.thisiscodingtest.sort;

public class SelectSort {

    public static void main(String[] args) {
        Integer[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
        int size = arr.length;

        for (int i = 0; i < size - 1; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;

        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
