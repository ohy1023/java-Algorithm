package baekjoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 21918 전구 (브론즈 2) - 구현
 * <a href="https://www.acmicpc.net/problem/21918">...</a>
 */
public class BOJ21918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] bulb = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            bulb[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            switch (a) {
                case 1:
                    bulb[b - 1] = c;
                    break;
                case 2:
                    for (int j = b - 1; j < c; j++) {
                        bulb[j] = 1 - bulb[j]; // 간소화
                    }
                    break;
                case 3:
                    for (int j = b - 1; j < c; j++) {
                        bulb[j] = 0;
                    }
                    break;
                case 4:
                    for (int j = b - 1; j < c; j++) {
                        bulb[j] = 1;
                    }
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int b : bulb) {
            sb.append(b).append(" ");
        }
        System.out.println(sb);
    }
}