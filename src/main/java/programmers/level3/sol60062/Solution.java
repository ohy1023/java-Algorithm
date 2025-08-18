package programmers.level3.sol60062;

/**
 * 프로그래머스 level 3 외벽 점검 - 구현
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/60062">...</a>
 */
class Solution {

    int N, MinCnt;
    int[] Weak, Dist;

    public void solve(int cnt, int pos, int visited) {
        if (cnt > Dist.length) return;
        if (cnt >= MinCnt) return;

        for (int i = 0; i < Weak.length; i++) {
            int nextPos = (pos + i) % Weak.length;

            int diff = Weak[nextPos] - Weak[pos];

            if (nextPos < pos) diff += N;

            if (diff > Dist[Dist.length - cnt]) break;

            visited |= 1 << nextPos;
        }

        if (visited == (1 << Weak.length) - 1) {
            MinCnt = cnt;
            return;
        }

        for (int i = 0; i < Weak.length; i++) {
            if ((visited & (1 << i)) != 0) continue;

            solve(cnt + 1, i, visited);
        }



    }

    public int solution(int n, int[] weak, int[] dist) {

        N = n;
        Weak = weak;
        Dist = dist;
        MinCnt = 9;

        for (int i = 0; i < weak.length; i++) {
            solve(1, i, 0);
        }

        if (MinCnt == 9) return -1;
        return MinCnt;

    }
}