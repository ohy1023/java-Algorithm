package algorithm.java1114;

import java.util.Arrays;

public class Prime {
    int solution(int n) {
        int cnt = 0;
        int[] arr = new int[n - 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 2;
        }
        boolean[] bl = new boolean[n - 1];
        Arrays.fill(bl, true);

        for (int i = 2; i < arr.length; i++) {
            for (int j = 2 * (i - 1); j < arr.length; j += i) {
                bl[j] = false;
            }
        }

        for (int i = 0; i < bl.length; i++) {
            if (bl[i] == true) {
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Prime prime = new Prime();
        System.out.println(prime.solution(10000000));
    }
}
