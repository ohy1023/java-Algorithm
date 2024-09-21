package baekjoon.dp;

import java.io.*;
import java.util.*;

/**
 * 백준 7579 앱 (골드 3) - DP
 * https://www.acmicpc.net/problem/7579
 */
public class BOJ7579 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] usage = new int[N + 1];
        int[] cost = new int[N + 1];
        int maxCost = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            usage[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            maxCost += cost[i];
        }

        int[][] dp = new int[N + 1][maxCost + 1];
        int answer = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            int u = usage[i];
            int c = cost[i];

            for (int j = 0; j <= maxCost; j++) {
                if (j >= c) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - c] + u);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

                if (dp[i][j] >= M) answer = Math.min(answer, j);
            }
        }

        System.out.println(answer);
    }
}