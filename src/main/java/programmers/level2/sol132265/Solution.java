package programmers.level2.sol132265;

import java.util.HashSet;
import java.util.Set;

/**
 * 프로그래머스 Level.2 롤케이크 자르기
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/132265?language=java">...</a>
 */
class Solution {
    public int solution(int[] topping) {
        int answer = 0;

        Set<Integer> set = new HashSet<>();

        int[] dp1 = new int[topping.length];
        int[] dp2 = new int[topping.length];

        for (int i = 0; i < topping.length; i++) {
            set.add(topping[i]);
            dp1[i] = set.size();
        }
        set.clear();

        for (int i = topping.length - 1; i >= 0; i--) {
            set.add(topping[i]);
            dp2[i] = set.size();
        }

        for (int i = 0; i < topping.length - 1; i++) {
            if (dp1[i] == dp2[i + 1]) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2}));
        System.out.println(s.solution(new int[]{1, 2, 3, 1, 4}));
    }
}