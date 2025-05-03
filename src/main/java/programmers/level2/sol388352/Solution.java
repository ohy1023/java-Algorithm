package programmers.level2.sol388352;

import java.util.*;

/**
 * 프로그래머스 비밀 코드 해독 - 완전 탐색, 백 트래킹
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/388352">...</a>
 */
class Solution {

    private int answer = 0;
    private List<Set<Integer>> setList;

    public int solution(int n, int[][] q, int[] ans) {
        setList = new ArrayList<>();

        for (int[] question : q) {
            Set<Integer> numSet = new HashSet<>();
            for (int num : question) {
                numSet.add(num);
            }
            setList.add(numSet);
        }

        generateCombinations(0, 1, n, new int[5], q, ans);
        return answer;
    }

    private void generateCombinations(int cnt, int cur, int n, int[] arr, int[][] q, int[] ans) {
        if (cnt == 5) {
            if (isValidCombination(arr, ans)) {
                answer++;
            }
            return;
        }

        for (int i = cur; i <= n; i++) {
            arr[cnt] = i;
            generateCombinations(cnt + 1, i + 1, n, arr, q, ans);
        }
    }

    private boolean isValidCombination(int[] arr, int[] ans) {
        for (int i = 0; i < setList.size(); i++) {
            int count = 0;
            for (int num : arr) {
                if (setList.get(i).contains(num)) {
                    count++;
                }
            }
            if (count != ans[i]) {
                return false;
            }
        }
        return true;
    }
}
