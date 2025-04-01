package baekjoon.prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 구간 합 구하기 4 ( 실버 3 ) - 누적 합
 * https://www.acmicpc.net/problem/11659
 */
public class BOJ11659 {

    private static int calcRangeSum(int[] arr, int s, int e) {
        return arr[e] - arr[s - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] prefixSumArr = new int[N + 1];


        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            prefixSumArr[i + 1] = arr[i] + prefixSumArr[i];
        }


        for (int j = 0; j < M; j++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            sb.append(calcRangeSum(prefixSumArr, s, e)).append("\n");
        }

        System.out.println(sb);

    }
}
