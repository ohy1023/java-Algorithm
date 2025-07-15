package baekjoon.data_structure;

import java.io.*;
import java.util.*;

/**
 * 백준 14425 문자열 집합 (실버 4) - 자료 구조
 * <a href="https://www.acmicpc.net/problem/14425">...</a>
 */
public class BOJ14425 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        int answer = 0;
        for (int i = 0; i < M; i++) {
            if (set.contains(br.readLine())) answer++;
        }

        System.out.println(answer);
    }
}