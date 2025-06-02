package baekjoon.prefix_sum;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 피아노 체조 (실버 1 ) - 누적 합
 * <a href="https://www.acmicpc.net/problem/21318">...</a>
 */
public class BOJ21318 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] mistake = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i - 1] > arr[i]) {
                mistake[i] += mistake[i - 1] + 1;
            } else {
                mistake[i] = mistake[i - 1];
            }
        }


        int Q = Integer.parseInt(br.readLine());

        for (int k = 0; k < Q; k++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            sb.append(mistake[y] - mistake[x]).append("\n");
        }

        System.out.println(sb);
    }
}
