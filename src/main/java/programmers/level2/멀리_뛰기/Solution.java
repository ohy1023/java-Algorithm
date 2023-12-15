package programmers.level2.멀리_뛰기;

/**
 * 프로그래머스 멀리 뛰기 (Level 2) - DP
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12914
 */
class Solution {

    // 멀리 뛸 수 있는 방법의 수를 반환하는 함수
    public long solution(int n) {
        // 동적 계획법을 위한 배열 선언 및 초기화
        int[] dp = new int[2001];
        dp[1] = 1;
        dp[2] = 2;

        // Bottom-up 방식의 동적 계획법을 이용하여 각 위치마다의 방법의 수 계산
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }

        // n번째 위치의 방법의 수 반환
        return dp[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // 예시로 주어진 입력에 대한 결과 출력
        System.out.println(s.solution(4));
    }
}
