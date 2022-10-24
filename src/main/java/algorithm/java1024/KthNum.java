package algorithm.java1024;

import java.util.Arrays;

public class KthNum {
    public int[] solution(int[] arr, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        for (int[] command : commands) {
            int[] slicedArr = Arrays.copyOfRange(arr, command[0] - 1, command[1]);
            Arrays.sort(slicedArr);
            answer[idx++] = slicedArr[command[2] - 1];
        }
        return answer;
    }


}
