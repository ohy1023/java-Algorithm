package leetcode.medium.sol852;


/**
 * Leetcode - Peak Index in a Mountain Array - 이진 탐색
 * <a href="https://leetcode.com/problems/peak-index-in-a-mountain-array/">...</a>
 */
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int lt = 1;
        int rt = arr.length - 2;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (arr[mid] > arr[mid + 1]) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        return lt;
    }
}