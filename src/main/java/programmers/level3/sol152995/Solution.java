package programmers.level3.sol152995;

import java.util.*;

/**
 * 프로그래머스 인사고과 - 정렬
 * https://school.programmers.co.kr/learn/courses/30/lessons/152995?language=java
 */
class Solution {
    public int solution(int[][] scores) {
        int[] target = scores[0];

        Arrays.sort(scores, (o1, o2) -> {
            if (o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
            return Integer.compare(o2[0], o1[0]);
        });

        int maxScore = 0;
        int answer = 1;

        for (int i = 0; i < scores.length; i++) {
            if (scores[i][1] < maxScore) {
                if (scores[i][0] == target[0] && scores[i][1] == target[1]) return -1;
            } else {
                maxScore = Math.max(scores[i][1], maxScore);
                if (target[0] + target[1] < scores[i][0] + scores[i][1]) {
                    answer++;
                }
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[][]{{2, 2}, {1, 4}, {3, 2}, {3, 2}, {2, 1}}));
    }
}