package baekjoon.Implementation;

import java.io.*;
import java.util.*;

/**
 * 백준 17276 - 배열 돌리기 (실버 2)
 * <a href="https://www.acmicpc.net/problem/17276">...</a>
 */
public class BOJ17276 {

    private static final int DEFAULT_ANGLE = 45;

    private static int calculateTimes(int angle) {
        int normalized = ((angle % 360) + 360) % 360;
        return normalized / DEFAULT_ANGLE;
    }

    private static int[][] turn(int n, int[][] originArr, int times) {

        int[][] arr = originArr;

        for (int t = 0; t < times; t++) {
            int[][] newArr = new int[n][n];

            for (int i = 0; i < n; i++) {
                newArr[i] = Arrays.copyOf(arr[i], n);
            }

            int mid = n / 2;

            for (int i = 0; i < n; i++) {
                newArr[i][i] = arr[mid][i];
                newArr[i][mid] = arr[i][i];
                newArr[i][n - 1 -i] = arr[i][mid];
                newArr[mid][i] = arr[n - 1 - i][i];
            }

            arr = newArr;
        }

        return arr;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int k = 0; k < T; k++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int times = calculateTimes(d);
            int[][] answer = turn(n, arr, times);

            for (int[] row : answer) {
                for (int num : row) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        }
    }
}
