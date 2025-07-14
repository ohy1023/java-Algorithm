package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 백준 11279 최대 힙 (실버 2) - 자료 구조
 * <a href="https://www.acmicpc.net/problem/11279">...</a>
 */
public class BOJ11279 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

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
