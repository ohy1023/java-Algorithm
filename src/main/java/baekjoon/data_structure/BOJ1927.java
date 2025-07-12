package baekjoon.data_structure;

import java.io.*;
import java.util.*;

/**
 * 백준 1927 최소 힙 (실버 2) - 자료 구조
 * <a href="https://www.acmicpc.net/problem/1927">...</a>
 */
public class BOJ1927 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int comd = Integer.parseInt(br.readLine());

            if (comd == 0) {
                if (!pq.isEmpty()) {
                    sb.append(pq.poll());
                } else {
                    sb.append(0);
                }

                sb.append("\n");
            } else {
                pq.offer(comd);
            }
        }

        System.out.println(sb);

    }

}
