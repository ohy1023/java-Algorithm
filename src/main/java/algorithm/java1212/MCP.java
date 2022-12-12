package algorithm.java1212;

import java.util.Arrays;

public class MCP {
    private int solution(int[][] arr) {
        int[][] dp = new int[arr.length][arr[0].length];

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                if (i == 1) {
                    dp[i][j] = dp[i][j - 1] + arr[i][j];
                } else if (j == 1) {
                    dp[i][j] = dp[i - 1][j] + arr[i][j];
                }
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return 0;
    }

    public static void main(String[] args) {
        MCP mcp = new MCP();
        int[][] arr = new int[][]{{0, 0, 0, 0}, {0, 1, 3, 2}, {0, 4, 6, 2}, {0, 1, 2, 4}};

        System.out.println((mcp.solution(arr)));
    }

}
