package likelion.java1103;

import java.util.Arrays;

public class RemoveMultipleOf3 {
    public static void main(String[] args) {
        int N = 10000000;
        int cnt = 0;
        int[] arr = new int[N - 1];
        boolean[] checks = new boolean[arr.length];
        Arrays.fill(checks, true);

        for (int i = 0; i * i < arr.length; i++) {
            arr[i] = i + 2;
        }
        for (int i = 2; i < arr.length; i++) {
            for (int j = 2 * (i - 1); j < arr.length; j += i) {
                checks[j] = false;
            }
        }

        for (int i = 0; i < checks.length; i++) {
            if (checks[i]) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
