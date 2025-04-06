package leetcode.hard.sol363;

import java.util.TreeSet;

/**
 * Leetcode - Max Sum of Rectangle No Larger Than K - DP
 * <a href="https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/description/">...</a>
 */
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length;
        int maxSum = Integer.MIN_VALUE;

        for (int r1 = 0; r1 < rows; r1++) {
            int[] colSums = new int[cols];

            for (int r2 = r1; r2 < rows; r2++) {
                for (int c = 0; c < cols; c++) {
                    colSums[c] += matrix[r2][c];
                }
            }

            maxSum = Math.max(maxSum, findMaxSubArraySum(colSums, k));

            if (maxSum == k) {
                return k;
            }
        }

        return maxSum;
    }

    private int findMaxSubArraySum(int[] colSums, int k) {
        TreeSet<Integer> prefixSums = new TreeSet<>();
        prefixSums.add(0);
        int prefixSum = 0, maxSubSum = Integer.MIN_VALUE;

        for (int colSum : colSums) {
            prefixSum += colSum;

            Integer ceil = prefixSums.ceiling(prefixSum - k);
            if (ceil != null) {
                maxSubSum = Math.max(maxSubSum, prefixSum = ceil);
            }
            prefixSums.add(prefixSum);
        }
        return maxSubSum;
    }
}