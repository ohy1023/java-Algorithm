package baekjoon.two_pointer;

import java.io.*;
import java.util.*;

/**
 * 백준 2470 두 용액 (골드 5) - 투 포인터
 * https://www.acmicpc.net/problem/2470
 */
public class BOJ2470 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] liquid = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            liquid[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(liquid);


        int[] answer = new int[2];
        int min = Integer.MAX_VALUE;

        int lt = 0;
        int rt = N - 1;

        while (lt < rt) {

            int value = liquid[lt] + liquid[rt];

            if (Math.abs(value) < min) {
                min = Math.abs(value);

                answer[0] = liquid[lt];
                answer[1] = liquid[rt];

                if (value == 0) break;
            }

            if (value < 0) lt++;
            else rt--;

        }


        System.out.println(answer[0] + " " + answer[1]);

    }
}
