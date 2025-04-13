package leetcode.medium.sol287;


/**
 * Leetcode - Find the Duplicate Number - 이진 탐색
 * <a href="https://leetcode.com/problems/find-the-duplicate-number/description/">...</a>
 */
class Solution {
    public int findDuplicate(int[] nums) {
        int lt = 1;
        int rt = nums.length - 1;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) cnt++;
            }

            if (cnt >= mid) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        return lt;
    }
}