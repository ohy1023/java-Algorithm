package leetcode.medium.sol1749;

/**
 * Leetcode - Maximum Absolute Sum of Any Subarray - DP
 * <a href="https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/description/">...</a>
 */
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int ans = Math.abs(nums[0]);

        int minSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxSum = Math.max(nums[i], maxSum + nums[i]);
            minSum = Math.min(nums[i], minSum + nums[i]);
            ans = Math.max(ans, Math.max(Math.abs(maxSum), Math.abs(minSum)));
        }

        return ans;
    }
}