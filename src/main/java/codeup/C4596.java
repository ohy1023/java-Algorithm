package codeup;

import java.util.Scanner;

public class C4596 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[9][9];
        int maxRowIdx = 0;
        int maxColIdx = 0;
        int maxValue = -2147000000;
        for (int i = 0; i<arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] > maxValue) {
                    maxValue = arr[i][j];
                    maxRowIdx = i+1;
                    maxColIdx = j+1;
                }
            }
        }

        System.out.println(maxValue);
        System.out.println(maxRowIdx + " " + maxColIdx);
    }
}
