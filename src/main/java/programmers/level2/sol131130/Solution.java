package programmers.level2.sol131130;

import java.util.*;

/**
 * 프로그래머스 Level.2 혼자 놀기의 달인 - BFS
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/131130?language=java"/>
 */
class Solution {

    int BFS(int idx, int[] cards, boolean[] check) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(cards[idx] - 1);
        check[idx] = true;
        int cnt = 1;

        while (!q.isEmpty()) {
            Integer curIdx = q.poll();

            if (!check[curIdx]) {
                check[curIdx] = true;
                q.offer(cards[curIdx] - 1);
                cnt++;
            }
        }
        return cnt;

    }

    public int solution(int[] cards) {
        int n = cards.length;
        boolean[] check = new boolean[n];
        List<Integer> groupSize = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (check[i]) continue;

            groupSize.add(BFS(i, cards, check));

        }

        if (groupSize.size() < 2) {
            return 0;
        }

        Collections.sort(groupSize, Collections.reverseOrder());

        return groupSize.get(0) * groupSize.get(1);
    }
}