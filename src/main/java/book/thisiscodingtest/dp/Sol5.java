package book.thisiscodingtest.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 이것이 코딩 테스트다
 * 금광 - 다이나믹 프로그래밍
 */
public class Sol5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            int[][] arr = new int[n + 1][m + 1];

            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < m + 1; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[n + 2][m + 1];

            for (int i = 1; i < n + 1; i++) {
                dp[i][1] = arr[i][1];
            }

            for (int j = 1; j < m + 1; j++) {
                for (int i = 1; i < n + 1; i++) {
                    int max = Math.max(dp[i][j - 1], Math.max(dp[i - 1][j - 1], dp[i + 1][j - 1]));

                    dp[i][j] = max + arr[i][j];
                }
            }

            int answer = -1;

            for (int i = 1; i < n + 1; i++) {
                answer = Math.max(dp[i][m], answer);
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}
