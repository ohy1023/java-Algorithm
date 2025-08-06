package baekjoon.sorting;

import java.io.*;
import java.util.*;

/**
 * 백준 18310 안테나 실버 3 - 정렬
 * https://www.acmicpc.net/problem/18310
 */
public class BOJ18310 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] houses = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(houses);

        System.out.println(houses[(N - 1) / 2]);

    }
}
