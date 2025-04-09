package leetcode.medium.sol198;

/**
 * Leetcode - House Robber - DP
 * <a href="https://leetcode.com/problems/house-robber/description/">...</a>
 */
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp0 = 0;
        int dp1 = nums[0];

        for (int i = 2; i <= n; i++) {
            int dp = Math.max(dp0 + nums[i - 1], dp1);
            dp0 = dp1;
            dp1 = dp;

        }

        return dp1;
    }
}