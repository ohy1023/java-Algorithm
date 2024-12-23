package baekjoon.two_pointer;

import java.io.*;
import java.util.*;

/**
 * 백준 14912 용액 합성하기 (골드 5) - 투 포인터
 * https://www.acmicpc.net/problem/14912
 */
public class BOJ14912 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] liquid = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            liquid[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = N - 1;

        while (start < end) {
            int sum = liquid[start] + liquid[end];

            if (Math.abs(min) > Math.abs(sum)) {
                min = sum;
            }

            if (sum == 0) {
                break;
            }
            else if (sum > 0) {
                end--;
            }
            else {
                start++;
            }
        }

        System.out.println(min);
    }
}
