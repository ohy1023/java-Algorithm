package likelion.java1102;

import java.util.Arrays;

public class RemoveMultipleOf2 {
    public static void main(String[] args) {
        int N = 50;
        int[] arr = new int[N-1];
        Boolean[] check = new Boolean[N-1];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i +2;
            check[i] = true;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0 && arr[i] > 2) {
                check[i] = false;
            }
        }

        System.out.println(Arrays.toString(arr));

        System.out.println(Arrays.toString(check));
    }
}
