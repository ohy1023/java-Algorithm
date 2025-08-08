package baekjoon.sorting;

import java.io.*;
import java.util.*;

/**
 * 백준 1715 카드 정렬하기 (골드 4) - 정렬
 * https://www.acmicpc.net/problem/1715
 */
public class BOJ1715 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int sum = 0;

        for (int i = 0; i < N; i++) {
            int cardSize = Integer.parseInt(br.readLine());

            pq.offer(cardSize);
        }

        while (pq.size() >= 2) {
            Integer cardSize1 = pq.poll();
            Integer cardSize2 = pq.poll();

            int mergedSize = cardSize1 + cardSize2;

            sum += mergedSize;
            pq.offer(mergedSize);

        }

        System.out.println(sum);

    }
}
