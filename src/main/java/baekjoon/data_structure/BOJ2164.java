package baekjoon.data_structure;

import java.io.*;
import java.util.*;

/**
 * 백준 2164 카드2 (실버 4) - 자료 구조
 * <a href="https://www.acmicpc.net/problem/2164">...</a>
 */
public class BOJ2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        while (q.size() > 1) {
            q.poll();
            q.offer(q.poll());
        }

        System.out.println(q.poll());

    }

}
