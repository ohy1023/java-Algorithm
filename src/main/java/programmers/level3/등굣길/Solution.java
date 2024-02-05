package programmers.level3.등굣길;

/**
 * 프로그래머스 level 3 등굣길 - DP
 * https://school.programmers.co.kr/learn/courses/30/lessons/42898
 */
class Solution {
    private final int MOD = 1000000007;

    /**
     * 등굣길 최단 경로의 경우의 수를 계산하는 함수
     *
     * @param m       지도의 가로 길이
     * @param n       지도의 세로 길이
     * @param puddles 물에 잠긴 지점의 좌표 배열
     * @return 등굣길의 경우의 수
     */
    public int solution(int m, int n, int[][] puddles) {
        // 각 지점까지의 경우의 수를 저장하는 배열
        int[][] graph = new int[n + 1][m + 1];

        // 물에 잠긴 지점을 -1로 표시
        for (int[] puddle : puddles) {
            int row = puddle[1];
            int col = puddle[0];
            graph[row][col] = -1;
        }

        // 시작 지점의 경우의 수는 1로 설정
        graph[1][1] = 1;

        // DP를 이용하여 각 지점까지의 경우의 수를 계산
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (graph[i][j] == -1) {
                    // 현재 지점이 물에 잠긴 지점이라면 스킵
                    continue;
                }
                if (graph[i - 1][j] > 0) {
                    // 위쪽 지점의 경우의 수를 현재 지점에 더함
                    graph[i][j] += graph[i - 1][j] % MOD;
                }
                if (graph[i][j - 1] > 0) {
                    // 왼쪽 지점의 경우의 수를 현재 지점에 더함
                    graph[i][j] += graph[i][j - 1] % MOD;
                }
            }
        }

        // 최종 목적지의 경우의 수를 반환 (MOD로 나눈 나머지)
        return graph[n][m] % MOD;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(4, 3, new int[][]{{2, 2}}));
    }
}
