package algorithm.java1109;


import java.util.Arrays;

public class SelectSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 4, 9, 10, 223, 111, 23, 3, 39};

        // i가 0일때 최소값 idx 찾기
        int minIdx = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[minIdx] > arr[j]) {
                minIdx = j;
            }
        }
        int temp = arr[0];
        arr[0] = arr[minIdx];
        arr[minIdx] = temp;

        System.out.println(minIdx);
        System.out.println(Arrays.toString(arr));

        // i가 1일때 최소값 idx 찾기
        minIdx = 1;
        for (int j = 2; j < arr.length; j++) {
            if (arr[minIdx] > arr[j]) {
                minIdx = j;
            }
        }
        temp = arr[1];
        arr[1] = arr[minIdx];
        arr[minIdx] = temp;

        System.out.println(minIdx);
        System.out.println(Arrays.toString(arr));


    }

}
