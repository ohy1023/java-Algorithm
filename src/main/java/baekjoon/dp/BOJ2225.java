package baekjoon.dp;

import java.io.*;
import java.util.*;

/**
 * 백준 2225 합분해 (골드 5) - DP
 * https://www.acmicpc.net/problem/2225
 */
public class BOJ2225 {
    private static final int MOD = 1000000000;

    /**
     * 주어진 정수 N을 K개의 정수로 나타내는 방법의 수를 계산하는 메서드
     * @param n 정수 N
     * @param k 나타내는 정수의 개수 K
     * @return 방법의 수
     * @throws IOException
     */
    public static int solution(int n, int k) throws IOException {
        // DP 배열 선언 및 초기화
        int[][] dp = new int[k + 1][n + 1];
        Arrays.fill(dp[1], 1); // 초기값 설정: 1개의 수로 n을 나타내는 방법은 항상 1개
        for (int i = 1; i <= k; i++) dp[i][0] = 1; // 초기값 설정: 0을 포함하는 경우의 수는 항상 1개

        // DP를 통한 방법의 수 계산
        for (int i = 2; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                // 현재 위치의 값은 이전 위치의 값과 현재 위치에서 1을 뺀 값의 합으로 계산
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
            }
        }

        return dp[k][n]; // 결과 반환
    }

    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 결과 출력
        System.out.println(solution(N, K));
    }
}
