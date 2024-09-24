package baekjoon.dp;

import java.io.*;
import java.util.*;

/**
 * 백준 12865 평범한 배낭 (골드 5) - DP
 * https://www.acmicpc.net/problem/12865
 */
public class BOJ12865 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력 받기
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 물건의 수
        int K = Integer.parseInt(st.nextToken()); // 배낭의 최대 무게

        // dp 배열 초기화
        int[][] dp = new int[N + 1][K + 1]; // dp[i][j]: i번째 물건까지 고려했을 때, 배낭 무게가 j일 때의 최대 가치

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken()); // 물건의 무게
            int V = Integer.parseInt(st.nextToken()); // 물건의 가치

            for (int j = 1; j <= K; j++) {
                if (j >= W) {
                    // 현재 물건을 가방에 넣을 수 있는 경우, 넣을지 말지 선택
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W] + V); // 이전 상태의 최대 가치와 현재 물건을 넣었을 때의 최대 가치 중 큰 값 선택
                } else {
                    // 현재 물건을 가방에 넣을 수 없는 경우, 이전 상태의 최대 가치 유지
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // 결과 출력k
        System.out.println(dp[N][K]); // N번째 물건까지 고려하고, K무게의 가방에 담을 수 있는 최대 가치 출력
    }
}
