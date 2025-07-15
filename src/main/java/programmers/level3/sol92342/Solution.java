package programmers.level3.sol92342;

/**
 * 프로그래머스 양궁 대회 - DFS
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/92342">...</a>
 */
class Solution {

    static int[] answer;
    static int[] shoot;
    static int maxDiffScore;

    public int calculateScore(int[] apeach, int[] ryan) {
        int apeachScore = 0;
        int ryanScore = 0;
        for (int i = 0; i <= 10; i++) {
            if (ryan[i] == 0 && apeach[i] == 0) continue;

            if (ryan[i] > apeach[i]) {
                ryanScore += (10 - i);
            } else {
                apeachScore += (10 - i);
            }
        }
        return ryanScore - apeachScore;
    }

    public void dfs(int depth, int arrowsLeft, final int[] info) {
        if (depth == 11) {
            shoot[10] += arrowsLeft;

            int diff = calculateScore(info, shoot);
            if (diff > 0) {
                if (diff > maxDiffScore) {
                    maxDiffScore = diff;
                    answer = shoot.clone();
                } else if (diff == maxDiffScore) {
                    for (int i = 10; i >= 0; i--) {
                        if (shoot[i] > answer[i]) {
                            answer = shoot.clone();
                            break;
                        } else if (shoot[i] < answer[i]) {
                            break;
                        }
                    }
                }
            }

            shoot[10] -= arrowsLeft;
            return;
        }

        if (info[depth] < arrowsLeft) {
            shoot[depth] = info[depth] + 1;
            dfs(depth + 1, arrowsLeft - shoot[depth], info);
            shoot[depth] = 0;
        }

        dfs(depth + 1, arrowsLeft, info);
    }


    public int[] solution(int n, int[] info) {
        answer = new int[]{-1};
        shoot = new int[11];
        maxDiffScore = Integer.MIN_VALUE;

        dfs(0, n, info);

        return answer;
    }
}