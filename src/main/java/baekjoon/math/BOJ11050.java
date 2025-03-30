package baekjoon.math;

import java.io.*;
import java.util.*;


/**
 * 백준 11050 이항 계수 1 (브론즈 1) - 수학
 * https://www.acmicpc.net/problem/11050
 */
public class BOJ11050 {

    public static int factorial(int n) {
        if (n <= 1) return 1;

        return n * factorial(n - 1);
    }

    public static int solution(int N, int K) {
        return factorial(N) / (factorial(K) * factorial(N - K));
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(solution(N, K));
    }
}
