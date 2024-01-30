package programmers.level3.순위;

/**
 * 프로그래머스 level 3 순위 - 플로이드 워샬
 * https://school.programmers.co.kr/learn/courses/30/lessons/49191
 */
class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;

        // 승패 결과를 저장할 이차원 배열
        // board[i][j]가 1이면 i가 j에게 이겼음을 의미
        // board[i][j]가 -1이면 i가 j에게 졌음을 의미
        int[][] board = new int[n + 1][n + 1];

        // 주어진 경기 결과를 이차원 배열에 반영
        for (int[] result : results) {
            board[result[0]][result[1]] = 1;  // result[0]이 result[1]을 이겼음
            board[result[1]][result[0]] = -1; // result[1]이 result[0]을 이겼음
        }

        // 플로이드-와샬 알고리즘을 이용하여 전체 승패 관계를 갱신
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    // i가 k를 이기고, k가 j를 이겼을 경우, i가 j를 이겼음을 의미
                    if (board[i][k] == 1 && board[k][j] == 1) {
                        board[i][j] = 1;
                        board[j][i] = -1;
                    }
                    // i가 k에게 졌고, k가 j에게 졌을 경우, i가 j에게 졌음을 의미
                    if (board[i][k] == -1 && board[k][j] == -1) {
                        board[i][j] = -1;
                        board[j][i] = 1;
                    }
                }
            }
        }

        // 각 선수에 대해 전적이 완전한 경우를 확인하고, answer를 증가
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (board[i][j] != 0) cnt++; // 전적이 있는 경우 cnt를 증가
            }
            if (cnt == n - 1) answer++; // 전적이 완전한 경우 answer를 증가
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 예제 테스트
        System.out.println(s.solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
    }
}
