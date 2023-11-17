package programmers.level3.기둥과_보_설치;

/**
 * 프로그래머스 level 3 기둥과 보 설치 - 구현
 * https://school.programmers.co.kr/learn/courses/30/lessons/60061
 */

class Solution {

    static boolean[][] pillar;
    static boolean[][] bar;

    public boolean checkPillar(int x, int y) {
        if (y == 0 || pillar[x][y - 1]) {
            return true;
        }

        if ((x > 0 && bar[x - 1][y]) || bar[x][y]) {
            return true;
        }

        return false;
    }

    public boolean checkBar(int x, int y) {
        if (pillar[x][y - 1] || pillar[x + 1][y - 1]) {
            return true;
        }
        if (x > 0 && bar[x - 1][y] && bar[x + 1][y]) {
            return true;
        }
        return false;
    }

    public boolean canDelete(int x, int y) {
        for (int i = Math.max(x - 1, 0); i < x + 2; i++) {
            for (int j = y; j < y + 2; j++) {
                if (pillar[i][j] && !checkPillar(i, j)) {
                    return false;
                }
                if (bar[i][j] && !checkBar(i, j)) {
                    return false;
                }
            }
        }

        return true;

    }

    public int[][] solution(int n, int[][] build_frame) {

        pillar = new boolean[n + 2][n + 2];
        bar = new boolean[n + 2][n + 2];

        int count = 0;

        for (int[] bf : build_frame) {
            int x = bf[0];
            int y = bf[1];
            int kind = bf[2];
            int cmd = bf[3];

            // 기둥일 경우
            if (kind == 0) {
                // 설치
                if (cmd == 1) {
                    if (checkPillar(x, y)) {
                        pillar[x][y] = true;
                        count++;
                    }
                }
                // 삭제
                else {
                    pillar[x][y] = false;
                    if (!canDelete(x, y)) {
                        pillar[x][y] = true;
                    } else {
                        count--;
                    }

                }
            }
            // 보일 경우
            else {
                // 설치
                if (cmd == 1) {
                    if (checkBar(x, y)) {
                        bar[x][y] = true;
                        count++;
                    }
                }
                // 삭제
                else {
                    bar[x][y] = false;
                    if (!canDelete(x, y)) {
                        bar[x][y] = true;
                    } else {
                        count--;
                    }

                }
            }
        }


        int[][] answer = new int[count][3];
        count = 0;

        for (int x = 0; x <= n; ++x) {
            for (int y = 0; y <= n; ++y) {
                if (pillar[x][y]) {
                    answer[count][0] = x;
                    answer[count][1] = y;
                    answer[count++][2] = 0;
                }

                if (bar[x][y]) {
                    answer[count][0] = x;
                    answer[count][1] = y;
                    answer[count++][2] = 1;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(5, new int[][]{{0, 0, 0, 1}, {2, 0, 0, 1}, {4, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {2, 1, 1, 1}, {3, 1, 1, 1}, {2, 0, 0, 0}, {1, 1, 1, 0}, {2, 2, 0, 1}}));

    }
}