package likelion.java1209;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS {

    private int solution(String str1, String str2) {
        int[][] dp = new int[str2.length() + 1][str1.length() + 1];

        for (int i = 1; i <= str2.length(); i++) {
            for (int j = 1; j <= str1.length(); j++) {
                if (str2.charAt(i - 1) == str1.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[str2.length()][str1.length()];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        LCS lcs = new LCS();
        System.out.println(lcs.solution(str1, str2));


    }
}
