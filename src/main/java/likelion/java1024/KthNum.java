package likelion.java1024;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthNum {
    public int[] solutionByArray(int[] arr, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        for (int[] command : commands) {
            int[] slicedArr = Arrays.copyOfRange(arr, command[0] - 1, command[1]);
            Arrays.sort(slicedArr);
            answer[idx++] = slicedArr[command[2] - 1];
        }
        return answer;
    }

    private int[] arr;

    public int getKthNum(int[] command) {
        int frIdx = command[0];
        int toIdx = command[1];
        int nth = command[2];
        int result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = frIdx - 1; i < toIdx; i++) {
            pq.add(arr[i]);
        }
        for (int i = 0; i < nth; i++) {
            result = pq.poll();
        }
        return result;
    }

    public int[] solutionByPriorityQueue(int[] arr, int[][] commands) {
        this.arr = arr;
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            answer[i] = getKthNum(commands[i]);
        }
        return answer;
    }

}
