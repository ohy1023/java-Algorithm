package programmers.level3.sol92344;

/**
 * 프로그래머스 파괴되지 않은 건물 - 누적 합
 * https://school.programmers.co.kr/learn/courses/30/lessons/92344
 */
class Solution {
    static int n, m;

    public int solution(int[][] board, int[][] skill) {

        n = board.length;  // 보드의 행 크기
        m = board[0].length;  // 보드의 열 크기

        // 누적합을 위한 배열 (n+1, m+1 크기로 생성)
        int[][] cumulativeImpact = new int[n + 1][m + 1];

        // 모든 스킬을 누적합 배열에 반영
        applySkill(skill, cumulativeImpact);

        // 누적합 처리
        applyCumulativeSum(cumulativeImpact);


        // 살아남은 건물의 수를 반환
        return countSurvivingBuildings(board, cumulativeImpact);
    }


    public void applySkill(int[][] skill, int[][] cumulativeImpact) {

        for (int[] skillInfo : skill) {

            int r1 = skillInfo[1];
            int c1 = skillInfo[2];
            int r2 = skillInfo[3];
            int c2 = skillInfo[4];
            int degree = skillInfo[5] * (skillInfo[0] == 1 ? 1 : -1);  // 공격은 양수, 치유는 음수로 처리

            cumulativeImpact[r1][c1] += degree;
            cumulativeImpact[r1][c2 + 1] -= degree;
            cumulativeImpact[r2 + 1][c1] -= degree;
            cumulativeImpact[r2 + 1][c2 + 1] += degree;
        }
    }

    public void applyCumulativeSum(int[][] cumulativeImpact) {
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                cumulativeImpact[i][j] += cumulativeImpact[i][j - 1];  // 각 행의 왼쪽에서 오른쪽으로 누적합
            }
        }

        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n; i++) {
                cumulativeImpact[i][j] += cumulativeImpact[i - 1][j];  // 각 열의 위에서 아래로 누적합
            }
        }
    }

    public int countSurvivingBuildings(int[][] board, int[][] cumulativeImpact) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] > cumulativeImpact[i][j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[][]{{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}}, new int[][]{{1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2}, {1, 0, 1, 3, 3, 1}}));
//        System.out.println(s.solution(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, new int[][]{{1, 1, 1, 2, 2, 4}, {1, 0, 0, 1, 1, 2}, {2, 2, 0, 2, 0, 100}}));

    }
}