package programmers.level2.sol12939;

import java.util.*;

/**
 * 프로그래머스 Level.2 최댓값과 최솟값
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12939?language=java">...</a>
 */
class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        while (st.hasMoreElements()) {
            int n = Integer.parseInt(st.nextToken());

            max = Math.max(n, max);
            min = Math.min(n, min);
        }

        return min + " " + max;
    }
}