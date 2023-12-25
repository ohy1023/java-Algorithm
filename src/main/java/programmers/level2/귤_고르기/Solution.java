package programmers.level2.귤_고르기;

import java.util.*;

/**
 * 프로그래머스 귤 고르기 (level.2) - 해쉬
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/138476
 */
class Solution {

    /**
     * 귤 고르기 문제 해결 메서드
     *
     * @param k         최소한으로 고를 귤의 개수
     * @param tangerine 귤의 크기 배열
     * @return 최소한으로 고를 귤의 개수
     */
    public int solution(int k, int[] tangerine) {
        // 귤의 크기와 개수를 저장하는 HashMap 생성
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        // 귤의 크기별 개수를 HashMap에 저장
        for (int size : tangerine) {
            hashMap.put(size, hashMap.getOrDefault(size, 0) + 1);
        }

        // 귤의 개수를 내림차순으로 정렬한 리스트 생성
        ArrayList<Integer> valueList = new ArrayList<>(hashMap.values());
        valueList.sort(Comparator.reverseOrder());

        // 귤을 고르는 과정에서 누적된 개수와 최소로 고를 귤의 개수를 비교하면서 최소 개수 찾기
        int sumCnt = 0;
        int answer = 0;
        for (Integer value : valueList) {
            // 현재 귤의 개수를 누적하여 최소로 골라야 하는 귤의 개수(k)와 비교
            if (sumCnt + value >= k) {
                // 최소 개수를 충족하면 반복 중단
                answer++;
                break;
            } else {
                // 아직 최소 개수를 충족하지 못했을 경우 현재 귤을 추가하고 반복 계속
                sumCnt += value;
                answer++;
            }
        }

        return answer;
    }

    /**
     * 테스트용 메인 메서드
     *
     * @param args 커맨드 라인 인수 (사용하지 않음)
     */
    public static void main(String[] args) {
        Solution s = new Solution();

        // 테스트 케이스 실행 및 결과 출력
        System.out.println(s.solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
    }
}
