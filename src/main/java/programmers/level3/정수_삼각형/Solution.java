package programmers.level3.정수_삼각형;

/**
 * 프로그래머스 level 3 정수 삼각형 - DP
 * https://school.programmers.co.kr/learn/courses/30/lessons/43105
 */
class Solution {
    /**
     * 주어진 정수 삼각형에서 가장 위쪽부터 시작하여 아래쪽으로 내려가면서 합이 최대가 되는 경로의 합을 구하는 메서드입니다.
     *
     * @param triangle 정수 삼각형 배열
     * @return 가장 위쪽부터 시작하여 아래쪽으로 내려가면서 합이 최대가 되는 경로의 합
     */
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];

        // 각 층마다 최적의 합을 계산하는 루프
        for (int i = 1; i < triangle.length; i++) {
            dp[i][0] = dp[i - 1][0] + triangle[i][0];

            // 각 층의 중간 요소에 대해 최적의 합을 계산하는 루프
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
            }

            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
        }

        // 마지막 층에서 최대값을 찾아 반환
        for (int i = 0; i < triangle.length; i++) {
            answer = Math.max(dp[triangle.length - 1][i], answer);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // 예제 입력을 활용한 테스트
        System.out.println(s.solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }
}
