package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 11047 동전 0 (실버 4) - DP
 * https://www.acmicpc.net/problem/11047
 */
public class BOJ11047 {

    /**
     * 동전 개수를 최소로 사용하여 금액 K를 만들기 위한 동적 프로그래밍 알고리즘
     *
     * @param N     동전의 종류 수
     * @param K     만들고자 하는 금액
     * @param coins 각 동전의 가치를 담은 배열
     * @return 동전을 최소로 사용하여 만들 수 있는 금액 K의 동전 개수
     */
    public static int solution(int N, int K, int[] coins) {
        // 동적 프로그래밍 배열 초기화
        int[] dp = new int[K + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // 초기값 설정

        // 각 동전의 가치를 반복하며 동적 프로그래밍 배열 업데이트
        for (int coin : coins) {
            for (int i = coin; i < K + 1; i++) {
                // 동전을 사용하지 않는 경우 또는 현재 동전을 사용하여 갱신
                dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
            }
        }

        return dp[K]; // 최종적으로 만들 수 있는 금액 K의 동전 개수 반환
    }

    public static void main(String[] args) throws IOException {
        // 입력 처리를 위한 BufferedReader 및 StringTokenizer 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 동전의 종류 수 및 만들고자 하는 금액 입력
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 각 동전의 가치를 담은 배열 초기화
        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        // 동전을 최소로 사용하여 만들 수 있는 금액 K의 동전 개수 출력
        System.out.println(solution(N, K, coins));
    }
}
