package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 11052 카드 구매하기 (실버 1) - DP
 * <a href="https://www.acmicpc.net/problem/11052">...</a>
 */
public class BOJ11052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] pay = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            pay[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i - j] + pay[j], dp[i]);
            }
        }

        System.out.println(dp[N]);
    }
}
