package programmers.level2.sol147354;

import java.util.*;

/**
 * 프로그래머스 Level.2 테이블 해시 함수 - 정렬
 * https://school.programmers.co.kr/learn/courses/30/lessons/147354
 */
class Solution {
    /**
     * 주어진 데이터 배열에서 지정된 열을 기준으로 정렬하여 해시 함수 값을 계산하는 메서드
     * @param data      정수형 2차원 배열
     * @param col       정렬 기준이 되는 열
     * @param row_begin 계산에 포함되는 행의 시작 인덱스
     * @param row_end   계산에 포함되는 행의 끝 인덱스
     * @return          계산된 해시 함수 값
     */
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        // 주어진 열을 기준으로 데이터 배열을 정렬
        Arrays.sort(data, (o1, o2) -> {
            if (o1[col - 1] == o2[col - 1]) return Integer.compare(o2[0], o1[0]); // 열 값이 같으면 첫 번째 열을 기준으로 내림차순 정렬
            return Integer.compare(o1[col - 1], o2[col - 1]); // 열 값이 다르면 해당 열을 기준으로 오름차순 정렬
        });

        // 주어진 범위 내의 행에 대해 해시 함수 값을 계산
        for (int i = row_begin; i <= row_end; i++) {
            int S_i = 0;
            for (int d : data[i - 1]) {
                S_i += d % i; // 각 원소를 해당 행 인덱스로 나눈 나머지 값을 누적
            }

            // 계산된 해시 함수 값을 이전 결과와 XOR 연산하여 업데이트
            answer = (answer ^ S_i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 예시 입력에 대한 해시 함수 값 출력
        System.out.println(s.solution(new int[][]{{2, 2, 6}, {1, 5, 10}, {4, 2, 9}, {3, 8, 3}}, 2, 2, 3));
    }
}
