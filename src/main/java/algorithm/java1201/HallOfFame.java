package algorithm.java1201;

import java.util.Arrays;
import java.util.PriorityQueue;

public class HallOfFame {
    private int[] solution(int k, int[] score) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int[] answer = new int[score.length];
        for (int j = 0; j < score.length; j++) {
            if (queue.size() < k) {
                queue.offer(score[j]);
            } else if (score[j] > queue.peek()) {
                queue.poll();
                queue.offer(score[j]);
            }
            answer[j] = queue.peek();

        }
        return answer;

    }

    public static void main(String[] args) {
        HallOfFame hall = new HallOfFame();
        int[] arr = new int[]{10, 100, 20, 150, 1, 100, 200};
        System.out.println(Arrays.toString(hall.solution(3, arr)));
    }
}
