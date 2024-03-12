package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2293 동전 1 (골드 5) - DP
 * https://www.acmicpc.net/problem/2293
 */
public class BOJ2293 {
    /**
     * 동전을 사용하여 특정 가치의 합을 만들 수 있는 경우의 수를 계산하는 메서드
     *
     * @param k     목표 가치
     * @param coins 동전의 가치 배열
     * @return 특정 가치의 합을 만들 수 있는 경우의 수
     */
    public static int solution(int k, int[] coins) {
        int[] dp = new int[k + 1];
        dp[0] = 1;

        // 동전의 가치를 하나씩 확인하며 경우의 수를 갱신
        for (int coin : coins) {
            for (int i = coin; i <= k; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[k];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 동전의 종류 수
        int k = Integer.parseInt(st.nextToken()); // 목표 가치
        int[] coins = new int[n];

        // 동전의 가치 입력 받기
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        // 결과 출력
        System.out.println(solution(k, coins));
    }
}
