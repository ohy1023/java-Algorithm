package algorithm.java1118;

import java.util.Arrays;

public class MatrixAddition {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        MatrixAddition ma = new MatrixAddition();
        int[][] arr1 = {{1, 2}, {2, 3}};
        int[][] arr2 = {{3, 4}, {5, 6}};
        for (int i = 0; i < ma.solution(arr1, arr2).length; i++) {
            System.out.println(Arrays.toString(ma.solution(arr1,arr2)[i]));
        }
    }
}
