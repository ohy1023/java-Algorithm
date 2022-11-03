package algorithm.java1103;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RemoveMultipleOf3 {
    public static void main(String[] args) {
        int N = 50;
        int[] arr = new int[N-1];
        boolean[] checks = new boolean[arr.length];
        Arrays.fill(checks,true);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i +2;
        }
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {


        }

    }
}
