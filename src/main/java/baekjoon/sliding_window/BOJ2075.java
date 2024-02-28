package baekjoon.sliding_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 백준 2075 N번째 큰 수 (실버 2) - 슬라이딩 윈도우 ( 우선순위 큐 활용 )
 * https://www.acmicpc.net/problem/2075
 */
public class BOJ2075 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 배열의 크기 입력

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 최소 힙 사용

        StringTokenizer st;

        // 첫 번째 줄의 숫자들을 우선순위 큐에 삽입
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(st.nextToken()));
        }

        // 두 번째 줄부터 N번째 줄까지 입력을 받아서 큐의 가장 작은 원소와 비교하여 큐를 유지함
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken()); // 입력된 수
                if (pq.peek() < num) { // 큐의 가장 작은 원소보다 큰 수가 들어온 경우
                    pq.poll(); // 큐에서 가장 작은 원소를 제거하고
                    pq.offer(num); // 새로운 수를 삽입하여 큐를 유지함
                }
            }
        }

        // 큐에서 가장 작은 원소가 N번째 큰 수임
        System.out.println(pq.peek());
    }
}
