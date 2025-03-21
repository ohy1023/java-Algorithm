package leetcode.medium.sol304;

/**
 * Leetcode - Range Sum Query 2D - Immutable - 누적합
 * <a href="https://leetcode.com/problems/range-sum-query-2d-immutable/">...</a>
 */
class NumMatrix {
    static long[][] prefixSum;
    static int M;
    static int N;

    public NumMatrix(int[][] matrix) {
        M = matrix.length;
        N = matrix[0].length;
        prefixSum = new long[M + 1][N + 1];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                prefixSum[i + 1][j + 1] = prefixSum[i][j + 1] + prefixSum[i + 1][j] - prefixSum[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return (int) (prefixSum[row2 + 1][col2 + 1] - prefixSum[row1][col2 + 1] - prefixSum[row2 + 1][col1] + prefixSum[row1][col1]);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */