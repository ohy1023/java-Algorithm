package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

/**
 * 백준 2293 동전 2 (골드 5) - DP
 * https://www.acmicpc.net/problem/2294
 */
public class BOJ2294 {

    /**
     * 동전으로 만들 수 있는 가치의 최소 개수를 계산하는 메서드
     * @param k 목표 가치
     * @param coins 동전의 가치 배열
     * @return 목표 가치를 만들기 위한 최소 동전 개수, 만들 수 없는 경우 -1을 반환
     */
    public static int solution(int k, int[] coins) {
        int[] dp = new int[k + 1];

        Arrays.fill(dp, Integer.MAX_VALUE - 1); // 최소값을 구하기 위해 초기값 설정
        dp[0] = 0; // 가치 0을 만드는데 필요한 동전 개수는 0개

        // 동전의 가치를 하나씩 확인하면서 dp 배열을 갱신
        for (int coin : coins) {
            for (int i = coin; i <= k; i++) {
                dp[i] = Math.min(dp[i - coin] + 1, dp[i]); // 현재 동전을 사용하여 가치 i를 만들 수 있는지 확인
            }
        }

        // 목표 가치를 만들 수 없는 경우 -1 반환
        if (dp[k] == Integer.MAX_VALUE - 1)
            return -1;
        else
            return dp[k]; // 목표 가치를 만들기 위한 최소 동전 개수 반환
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 동전의 종류 수
        int k = Integer.parseInt(st.nextToken()); // 목표 가치
        int[] coins = new int[n]; // 동전의 가치를 저장할 배열

        // 동전의 가치를 입력받음
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        // 동전으로 만들 수 있는 가치의 최소 개수를 출력
        System.out.println(solution(k, coins));
    }
}
