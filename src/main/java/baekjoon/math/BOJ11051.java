package baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 백준 11051 이항 계수 2 (실버 2) - 수학
 * https://www.acmicpc.net/problem/11051
 */
public class BOJ11051 {

    private static final int MOD = 10007;
    static int[][] dp;

    public static void BC(int N, int K) {
        if (dp[N][K] > 0) {
            return;
        }

        if (K == N || K == 0) {
            dp[N][K] = 1;
            return;
        }

        BC(N - 1, K - 1);
        BC(N - 1, K);

        dp[N][K] = (dp[N - 1][K - 1] + dp[N - 1][K]) % MOD;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp = new int[1001][1001];

        BC(N,K);

        System.out.println(dp[N][K]);
    }
}
