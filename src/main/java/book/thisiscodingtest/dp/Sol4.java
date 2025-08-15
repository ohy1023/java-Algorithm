package book.thisiscodingtest.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 이것이 코딩 테스트다
 * 효율적인 화폐 구성 - 다이나믹 프로그래밍
 */
public class Sol4 {
    private static final int MAX = 10_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] coin = new int[N];

        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[M + 1];
        Arrays.fill(dp, MAX);

        dp[0] = 0;
        for (int c : coin) {
            for (int i = c; i < M + 1; i++) {
                dp[i] = Math.min(dp[i], dp[i - c] + 1);
            }
        }

        if (dp[M] == MAX) System.out.println(-1);
        else System.out.println(dp[M]);
    }
}
