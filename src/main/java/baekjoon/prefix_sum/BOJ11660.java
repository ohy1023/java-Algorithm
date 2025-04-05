package baekjoon.prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 구간 합 구하기 5 ( 실버 1 ) - 누적 합
 * https://www.acmicpc.net/problem/11660
 */
public class BOJ11660 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] prefixSumArr = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                prefixSumArr[i][j] = arr[i - 1][j- 1] + prefixSumArr[i - 1][j] + prefixSumArr[i][j - 1] - prefixSumArr[i - 1][j - 1];
            }
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            sb.append(prefixSumArr[x2][y2] - prefixSumArr[x2][y1 - 1] - prefixSumArr[x1 - 1][y2] + prefixSumArr[x1 - 1][y1 - 1]).append("\n");
        }

        System.out.println(sb);
    }
}
