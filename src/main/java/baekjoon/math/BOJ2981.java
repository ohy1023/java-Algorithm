package baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 백준 2981 검문 (골드 4) - 수학
 * https://www.acmicpc.net/problem/2981
 */
public class BOJ2981 {


    private static int gcd(int a, int b) {
        while(b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(numbers);

        int gcdVal = numbers[1] - numbers[0];

        for(int i = 2; i < N; i++) {
            gcdVal = gcd(gcdVal, numbers[i] - numbers[i - 1]);
        }

        for(int i = 2; i <= gcdVal; i++) {

            if(gcdVal% i == 0) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb.toString().trim());
    }
}
