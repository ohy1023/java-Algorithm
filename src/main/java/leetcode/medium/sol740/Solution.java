package leetcode.medium.sol740;


/**
 * Leetcode - Delete and Earn - DP
 * <a href="https://leetcode.com/problems/delete-and-earn/">...</a>
 */
class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] cnt = new int[10001];

        for (int num : nums) {
            cnt[num]++;
        }

        int[] dp = new int[10001];

        dp[1] = cnt[1];

        for (int i = 2; i < 10001; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + (cnt[i] * i));
        }

        return dp[10000];
    }
}