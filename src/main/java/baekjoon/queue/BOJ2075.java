package baekjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 백준 2075 N번째 큰 수 (실버 2) - 우선순위 큐
 * https://www.acmicpc.net/problem/2075
 */
public class BOJ2075 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 크기 N의 정사각형 배열의 크기 입력

        StringTokenizer st;

        // 내림차순으로 정렬되는 우선순위 큐 생성
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // 입력을 받아서 우선순위 큐에 삽입
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                pq.offer(Integer.parseInt(st.nextToken())); // 각 행의 숫자들을 우선순위 큐에 삽입
            }
        }

        // 큐에서 크기가 N인 배열의 원소 개수(N^2)에서 N - 1만큼 poll하여 N번째로 큰 수를 찾음
        for (int i = 0; i < N - 1; i++) {
            pq.poll();
        }

        // 큐에서 가장 작은 원소가 N번째로 큰 수임
        System.out.println(pq.peek());

    }
}
