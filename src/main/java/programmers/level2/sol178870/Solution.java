package programmers.level2.sol178870;

import java.io.*;

/**
 * 프로그래머스 연속된 부분 수열의 합 (Level 2) - 투 포인터
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/178870
 */
class Solution {
    /**
     * 주어진 수열에서 합이 k인 연속된 부분 수열의 시작과 끝 인덱스를 반환하는 메소드
     *
     * @param sequence 주어진 수열
     * @param k        합이 되어야 하는 값
     * @return         시작과 끝 인덱스 배열 [시작 인덱스, 끝 인덱스]
     */
    public int[] solution(int[] sequence, int k) {
        int lt = 0;   // 왼쪽 포인터
        int sum = 0;  // 부분 수열의 합
        int ans1 = 0; // 시작 인덱스
        int ans2 = 0; // 끝 인덱스
        int size = sequence.length; // 현재까지의 최소 부분 수열 길이

        // 오른쪽 포인터 이동
        for (int rt = 0; rt < sequence.length; rt++) {
            sum += sequence[rt];

            // 부분 수열의 합이 k를 초과하는 경우 왼쪽 포인터 이동
            while (sum > k) {
                sum -= sequence[lt++];
            }

            // 부분 수열의 합이 k와 같은 경우
            if (sum == k) {
                // 현재까지의 최소 부분 수열 길이보다 작은 경우
                if (rt - lt < size) {
                    ans1 = lt; // 시작 인덱스 갱신
                    ans2 = rt; // 끝 인덱스 갱신
                    size = rt - lt; // 최소 부분 수열 길이 갱신
                } else if (rt - lt == size) { // 같은 경우
                    ans1 = Math.min(ans1, lt); // 시작 인덱스 갱신
                    ans2 = Math.min(ans2, rt); // 끝 인덱스 갱신
                }
            }
        }

        return new int[]{ans1, ans2}; // 시작과 끝 인덱스 배열 반환
    }

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        int[] result = s.solution(new int[]{1, 1, 1, 2, 3, 4, 5}, 5);

        for (int r : result) {
            System.out.print(r + " ");
        }
    }
}
