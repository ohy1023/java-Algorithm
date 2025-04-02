package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 11054 가장 긴 바이토닉 부분 수열 ( 골드 4 ) - DP
 * https://www.acmicpc.net/problem/11054
 */
public class BOJ11054 {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Integer[] r_dp = new Integer[N];	// LIS
        int[] l_dp = new int[N];	// LDS

        for (int i = 0; i < N; i++) {
            LIS(i,r_dp,numbers);
        }

        for (int i = N - 1; i >= 0; i--) {
            l_dp[i] = 1;
            for (int j = N - 1; j > i; j--) {
                if (numbers[i] > numbers[j] && l_dp[i] < l_dp[j] + 1) {
                    l_dp[i] = l_dp[j] + 1;
                }
            }
        }


        int answer = 0;

        for (int i = 0; i < N; i++) {
            if (answer < r_dp[i] + l_dp[i]) {
                answer = r_dp[i] + l_dp[i];
            }
        }

        System.out.println(answer - 1);
    }

    private static int LIS(int i, Integer[] rDp, int[] numbers) {
        if (rDp[i] == null) {
            rDp[i] = 1;
        }

        for (int j = i - 1; j >= 0; j--) {
            if (numbers[i] > numbers[j]) {
                rDp[i] = Math.max(rDp[i], LIS(j, rDp, numbers) + 1);
            }
        }

        return rDp[i];
    }
}
