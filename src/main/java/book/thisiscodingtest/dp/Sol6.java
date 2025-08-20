package book.thisiscodingtest.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 이것이 코딩 테스트다
 * 못생긴 수 - 다이나믹 프로그래밍
 */
public class Sol6 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        int[] dp = new int[1000];
        dp[0] = 1;

        int i2 = 0, i3 = 0, i5 = 0;
        int next2 = 2, next3 = 3, next5 = 5;

        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(next2, Math.min(next3, next5));

            if (dp[i] == next2) {
                i2++;
                next2 = dp[i2] * 2;
            }
            if (dp[i] == next3) {
                i3++;
                next3 = dp[i3] * 3;
            }
            if (dp[i] == next5) {
                i5++;
                next5 = dp[i5] * 5;
            }
        }

        System.out.println(dp[n - 1]);


    }
}
