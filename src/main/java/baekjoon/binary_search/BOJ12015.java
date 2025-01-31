package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 12015 가장 긴 증가하는 부분 수열 2  ( 골드 2 ) - 이진 탐색
 * https://www.acmicpc.net/problem/12015
 */
public class BOJ12015 {

    static int[] memo;

    static int binarySearch(int left, int right, int key) {

        while (left < right) {
            int mid = (left + right) / 2;

            if (memo[mid] < key) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static int solution(int N, int[] numbers) {
        memo = new int[N + 1];

        int len = 0;

        for (int i = 0; i < N; i++) {
            if (numbers[i] > memo[len]) {
                len += 1;
                memo[len] = numbers[i];
            } else {
                int idx = binarySearch(0, len, numbers[i]);
                memo[idx] = numbers[i];
            }
        }

        return len;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, numbers));

    }
}
