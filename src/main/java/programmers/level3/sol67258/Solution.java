package programmers.level3.sol67258;

import java.util.*;

/**
 * 프로그래머스 level 3 보석 쇼핑 - 투 포인터
 * https://school.programmers.co.kr/learn/courses/30/lessons/67258
 */
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2]; // 결과를 저장할 배열
        int kind = new HashSet<>(Arrays.asList(gems)).size(); // 보석의 종류 개수
        int length = Integer.MAX_VALUE; // 최소 길이
        int lt = 0; // 투 포인터의 왼쪽 인덱스

        Map<String, Integer> map = new HashMap<>(); // 각 보석의 개수를 저장할 Map

        // 오른쪽 포인터를 이동하며 구간을 탐색
        for (int rt = 0; rt < gems.length; rt++) {
            // 보석 개수를 Map에 업데이트
            map.put(gems[rt], map.getOrDefault(gems[rt], 0) + 1);

            // 왼쪽 포인터를 이동시켜 구간을 최소화
            while (map.get(gems[lt]) > 1) {
                map.put(gems[lt], map.get(gems[lt]) - 1);
                lt++;
            }

            // 현재 구간이 모든 종류의 보석을 포함하고 이전 길이보다 짧으면 갱신
            if (map.size() == kind && length > (rt - lt)) {
                length = rt - lt;
                answer[0] = lt + 1; // 시작 인덱스
                answer[1] = rt + 1; // 끝 인덱스
            }
        }
        return answer; // 결과 반환
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] result = s.solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"});

        // 결과 출력
        for (int r : result) {
            System.out.print(r + " ");
        }
    }
}
