package programmers.level2.sol42626;

import java.util.PriorityQueue;

/**
 * 프로그래머스 Level.2 더 맵게 - 힙
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42626">...</a>
 */
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int s : scoville) {
            pq.offer(s);
        }

        while (pq.size() >= 2 && pq.peek() < K) {
            int firstFood = pq.poll();
            int secondFood = pq.poll();

            int mixFood = firstFood + secondFood * 2;

            pq.offer(mixFood);
            answer++;
        }

        return pq.peek() < K ? -1 : answer;
    }
}