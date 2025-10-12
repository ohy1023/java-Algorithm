package programmers.level2.sol181187;

/**
 * 프로그래머스 Level.2 두 원 사이의 정수 쌍 - 수학
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/181187">...</a>
 */
class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;

        for (int i = 1; i <= r2; i++) {
            int minJ = (int) Math.ceil(Math.sqrt((double) r1 * r1 - (double) i * i));
            int maxJ = (int) Math.floor(Math.sqrt((double) r2 * r2 - (double) i * i));

            answer += 4L * (maxJ - minJ + 1);
        }

        return answer;
    }
}