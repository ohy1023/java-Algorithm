package programmers.level2.sol181188;

import java.util.Arrays;

/**
 * 프로그래머스 레벨 2 요격 시스템 - 그리디 알고리즘
 * https://school.programmers.co.kr/learn/courses/30/lessons/181188
 */
class Solution {

    /**
     * 모든 폭격 미사일을 요격하는데 필요한 요격 미사일의 수를 반환하는 메서드
     *
     * @param targets 비행기들의 위치 정보를 담은 2차원 배열
     * @return 모든 폭격 미사일을 요격하는데 필요한 요격 미사일의 수
     */
    public int solution(int[][] targets) {
        // 미사일의 위치 정보를 마지막 좌표 기준으로 오름차순 정렬한다.
        Arrays.sort(targets, (o1, o2) -> {
            if (o1[1] == o2[1]) return Integer.compare(o1[0], o2[0]);
            return Integer.compare(o1[1], o2[1]);
        });

        int answer = 0;
        int prevPos = 0;

        for (int[] target : targets) {
            int s = target[0];
            int e = target[1];

            if (s >= prevPos) {
                prevPos = e;
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[][]{{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}}));
    }

}
