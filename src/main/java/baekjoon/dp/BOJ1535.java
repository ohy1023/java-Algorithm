package baekjoon.dp;

import java.io.*;
import java.util.*;

/**
 * 백준 1535 안녕 (실버 2) - DP
 * https://www.acmicpc.net/problem/1535
 */
public class BOJ1535 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 사람의 수

        int[] damage = new int[n + 1]; // 각 사람이 상처를 받을 때 받는 데미지
        int[] happiness = new int[n + 1]; // 각 사람이 상처를 받을 때 잃는 행복도

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            damage[i] = Integer.parseInt(st.nextToken());
            happiness[i] = Integer.parseInt(st2.nextToken());
        }

        int[][] dp = new int[101][n + 1]; // 누적 행복도를 저장하는 DP 배열

        for (int i = 1; i < 101; i++) { // 체력이 i일 때의 최대 행복도
            for (int j = 1; j <= n; j++) { // j번째 사람까지 고려
                if (i > damage[j]) {
                    // j번째 사람을 공격할 수 있는 경우, 상태 전환
                    // 이전 상태(dp[i - damage[j]][j - 1])의 행복도와 j번째 사람을 공격했을 때의 행복도 중 큰 값을 선택
                    dp[i][j] = Math.max(dp[i - damage[j]][j - 1] + happiness[j], dp[i][j - 1]);
                } else {
                    // j번째 사람을 공격할 수 없는 경우, 이전 상태(dp[i][j - 1])의 행복도 유지
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        System.out.println(dp[100][n]); // 100체력으로 모든 사람을 공격할 때의 최대 행복도 출력
    }
}
