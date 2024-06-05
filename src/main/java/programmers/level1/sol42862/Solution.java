package programmers.level1.sol42862;

import java.util.*;

/**
 * 프로그래머스 Level.1 체육복 - 그리디
 * https://school.programmers.co.kr/learn/courses/30/lessons/42862?language=java
 */
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 초기 체육 수업을 들을 수 있는 학생 수는 전체 학생 수에서 체육복을 잃어버린 학생 수를 뺀 값
        int answer = n - lost.length;

        // 잃어버린 학생과 여벌 체육복을 가진 학생 배열을 정렬
        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 잃어버린 학생과 여벌 체육복을 가진 학생이 겹치는 경우 처리
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    answer++; // 체육복을 입을 수 있는 학생 수 증가
                    lost[i] = -1; // 처리된 학생을 표시
                    reserve[j] = -1; // 처리된 학생을 표시
                    break;
                }
            }
        }

        // 남은 잃어버린 학생들에게 여벌 체육복을 빌려주는 경우 처리
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]) {
                    answer++; // 체육복을 입을 수 있는 학생 수 증가
                    reserve[j] = -1; // 처리된 학생을 표시
                    break;
                }
            }
        }

        return answer; // 체육복을 입을 수 있는 총 학생 수 반환
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // 테스트 케이스 실행
        System.out.println(s.solution(5, new int[]{2, 4}, new int[]{1, 3, 5})); // 결과: 5
    }
}
