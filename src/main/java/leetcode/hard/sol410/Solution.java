package leetcode.hard.sol410;

/**
 * Leetcode - Split Array Largest Sum - 이진 탐색
 * <a href="https://leetcode.com/problems/split-array-largest-sum/description/">...</a>
 */
class Solution {
    boolean decide(int[] nums, int k, int mid) {
        int cnt = 0;
        int sum = 0;

        for (int num : nums) {
            if (num > mid) return false;

            if (num + sum > mid) {
                cnt++;
                sum = num;
            } else {
                sum += num;
            }
        }
        cnt++;


        return cnt <= k;
    }

    public int splitArray(int[] nums, int k) {
        int lt = 0;
        int rt = 1_000_000_000;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (decide(nums, k, mid)) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        return lt;
    }
}