package programmers.level3.sol60062;

import java.util.*;

/**
 * 프로그래머스 level 3 외벽 점검 - 구현
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/60062">...</a>
 */
class Solution {
    public int solution(int n, int[] weak, int[] dist) {
        int W = weak.length;
        int D = dist.length;
        int answer = D + 1;

        Integer[] extWeek = new Integer[W * 2];
        
        for (int i = 0; i < W; i++) {
            extWeek[i] = weak[i];
            extWeek[i + W] = weak[i] + n;
        }

        List<int[]> permutations = new ArrayList<>();
        permute(dist, 0, permutations);

        for (int start = 0; start < W; start++) {
            for (int[] friends : permutations) {
                int count = 1;
                int limit = extWeek[start] + friends[count - 1];

                for (int idx = start; idx < start + W; idx++) {
                    if (extWeek[idx] > limit) {
                        count++;
                        if (count > D) break;
                        limit = extWeek[idx] + friends[count - 1];
                    }
                }

                answer = Math.min(count, answer);
            }
        }


        return answer > D ? -1 : answer;
    }

    private void permute(int[] arr, int depth, List<int[]> result) {
        if (arr.length == depth) {
            result.add(arr.clone());
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            swap(arr, depth, i);
            permute(arr, depth + 1, result);
            swap(arr, depth, i);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(12, new int[]{1, 5, 6, 10}, new int[]{1, 2, 3, 4,}));
    }
}