package leetcode.medium.sol378;

/**
 * Leetcode - Kth Smallest Element in a Sorted Matrix  - 이진 탐색
 * <a href="https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/">...</a>
 */
class Solution {
    static int N;

    boolean decide(int[][] matrix, int k, int mid) {

        int cnt = 0;

        int row = N - 1;
        int col = 0;

        while (row >= 0 && col < N) {
            if (matrix[row][col] > mid) {
                row--;
                cnt += col;
            } else {
                col++;
            }
        }
        cnt += (row + 1) * col;

        return cnt >= k;
    }

    public int kthSmallest(int[][] matrix, int k) {
        N = matrix.length;
        int lt = matrix[0][0];
        int rt = matrix[N - 1][N - 1];

        while (lt <= rt) {
            int mid = lt + (rt - lt) / 2;
            if (decide(matrix, k, mid)) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        return lt;
    }
}