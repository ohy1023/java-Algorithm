package baekjoon.math;

import java.io.*;

/**
 * 백준 4563 리벤지 오브 피타고라스 (골드 5) - 수학
 * https://www.acmicpc.net/problem/4563
 */
public class BOJ4563 {

    public static int solution(int A) {

        int cnt = 0;
        long aSquared = (long) A * A;

        for (int K = 1; K < A; K++) {
            if (aSquared % K == 0 && (aSquared / K - K) % 2 == 0) {
                long B = (aSquared / K - K) / 2;

                if (B <= A) break;
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int A = Integer.parseInt(br.readLine());

            if (A == 0) break;

            System.out.println(solution(A));
        }

    }
}