package baekjoon.dp;

import java.io.*;
import java.util.*;

/**
 * 백준 4781 사탕 가게 (골드 4) - DP
 */
public class BOJ4781 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            // n: 사탕의 종류 수, m: 사용할 수 있는 돈(센트 단위로 변환)
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = (int) (Double.parseDouble(st.nextToken()) * 100 + 0.1);

            // 종료 조건
            if (n == 0 && m == 0) break;

            // dp 배열 초기화, dp[j]: 돈 j 센트로 얻을 수 있는 최대 칼로리
            int[] dp = new int[m + 1];

            // 각 사탕의 정보 입력 및 dp 갱신
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken()); // 칼로리
                int p = (int) (Double.parseDouble(st.nextToken()) * 100 + 0.1); // 가격

                // dp 배열 갱신
                for (int j = p; j <= m; j++) {
                    dp[j] = Math.max(dp[j], dp[j - p] + c); // 현재 가격에서 해당 사탕을 구매했을 때의 최대 칼로리
                }
            }

            // 결과 출력
            System.out.println(dp[m]);
        }
    }
}
