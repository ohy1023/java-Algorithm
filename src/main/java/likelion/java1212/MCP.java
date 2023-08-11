package likelion.java1212;

public class MCP {
    private int solution(int[][] arr) {
        int[][] dp = new int[arr.length][arr[0].length];

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                if (i == 1) {
                    dp[i][j] = dp[i][j - 1] + arr[i][j];
                } else if (j == 1) {
                    dp[i][j] = dp[i - 1][j] + arr[i][j];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + arr[i][j];
                }
            }
            ;
        }
        return dp[arr.length - 1][arr[0].length - 1];
    }

    public static void main(String[] args) {
        MCP mcp = new MCP();
        int[][] arr = new int[][]{{0, 0, 0, 0}, {0, 1, 3, 2}, {0, 4, 6, 2}, {0, 1, 2, 4}};

        System.out.println((mcp.solution(arr)));
    }

}
