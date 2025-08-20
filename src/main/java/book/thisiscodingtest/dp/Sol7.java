package book.thisiscodingtest.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol7 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String B = br.readLine();

        int alen = A.length();
        int blen = B.length();

        int[][] dp = new int[alen + 1][blen + 1];

        for (int i = 1; i <= blen; i++) {
            dp[0][i] = dp[0][i - 1] + 1;
        }

        for (int i = 1; i <= alen; i++) {
            dp[i][0] = dp[i][0] + 1;
        }

        for (int i = 1; i <= alen; i++) {
            for (int j = 1; j <= blen; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
            }
        }

        System.out.println(dp[alen][blen]);
    }
}
