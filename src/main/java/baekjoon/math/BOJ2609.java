package baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2609 최대공약수와 최소공배수 (브론즈 1) - 수학
 * https://www.acmicpc.net/problem/2609
 */
public class BOJ2609 {

    public static int gcd(int a, int b) {

        while (b != 0) {
            int r = a % b;

            a = b;
            b = r;
        }

        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int d = gcd(a, b);

        System.out.println(d);
        System.out.println(a * b / d);

    }
}
