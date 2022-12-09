package algorithm.java1209;


public class LCS {
    public static void main(String[] args) {
        String str1 = "ABCDCBA"; // -> j로 놓고 안쪽에서 반복 ( 열 )
        String str2 = "DCABDC"; // -> i로 놓고 바깥쪽에서 반복 ( 행 )


        int[][] dp = new int[str2.length() + 1][str1.length() + 1];

        for (int i = 1; i <= str2.length(); i++) {
            for (int j = 1; j <= str1.length(); j++) {
                if (str2.charAt(i - 1) == str1.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    if (dp[i - 1][j] > dp[i][j - 1]) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
