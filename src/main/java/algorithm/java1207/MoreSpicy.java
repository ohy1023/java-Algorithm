package algorithm.java1207;

import java.util.PriorityQueue;

public class MoreSpicy {
    public int solution(int[] scoville, int K) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }

        int answer = 0;
        while (pq.peek() < K) {
            if (pq.size() == 1) {
                return -1;
            }
            int mix = pq.poll() + (pq.poll() * 2);
            pq.add(mix);
            answer++;
        }

        return answer;
    }


}
