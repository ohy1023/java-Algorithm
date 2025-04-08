package leetcode.medium.sol152;

/**
 * Leetcode - Maximum Product Subarray - DP
 * <a href="https://leetcode.com/problems/maximum-product-subarray/description/">...</a>
 */
class Solution {
    public int maxProduct(int[] nums) {
        int N = nums.length;

        int ans = nums[0];
        int maxProd = nums[0];
        int minProd = nums[0];

        for (int i = 1; i < N; i++) {
            int prod1 = maxProd * nums[i];
            int prod2 = minProd * nums[i];

            maxProd = Math.max(Math.max(prod1, prod2), nums[i]);
            minProd = Math.min(Math.min(prod1, prod2), nums[i]);

            ans = Math.max(ans, maxProd);
        }

        return ans;
    }
}