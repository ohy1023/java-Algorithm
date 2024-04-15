package baekjoon.sorting;

import java.io.*;
import java.util.*;

/**
 * 백준 1766 문제집 (골드 2) - 위상정렬
 * https://acmicpc.net/problem/1766
 */
public class BOJ1766 {
    static int N, M; // 문제의 수 N과 정보의 개수 M
    static int[] inDegree; // 진입차수를 저장하는 배열
    static ArrayList<ArrayList<Integer>> graph; // 그래프를 표현하기 위한 배열
    static StringBuilder sb = new StringBuilder(); // 결과를 저장하는 StringBuilder

    /**
     * 위상정렬 알고리즘을 수행하여 문제를 정렬하는 메소드
     *
     * @return 정렬된 문제 번호를 문자열로 반환
     */
    public static String solution() {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 우선순위 큐를 이용한 위상정렬

        // 진입차수가 0인 문제를 우선순위 큐에 넣음
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                pq.offer(i);
            }
        }

        // 우선순위 큐가 빌 때까지 반복하여 위상정렬 수행
        while (!pq.isEmpty()) {
            Integer curSubjectNo = pq.poll(); // 현재 문제 번호를 가져옴
            sb.append(curSubjectNo).append(" "); // 결과에 현재 문제 번호 추가

            // 현재 문제와 연결된 다음 문제들에 대해 진입차수 감소
            for (int nextSubjectNo : graph.get(curSubjectNo)) {
                inDegree[nextSubjectNo]--; // 진입차수 감소

                // 진입차수가 0이 되면 우선순위 큐에 추가
                if (inDegree[nextSubjectNo] == 0) {
                    pq.offer(nextSubjectNo);
                }
            }
        }

        return sb.toString(); // 결과 반환
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 문제의 수 입력
        M = Integer.parseInt(st.nextToken()); // 정보의 개수 입력

        graph = new ArrayList<>(); // 그래프 초기화
        inDegree = new int[N + 1]; // 진입차수 배열 초기화

        // 그래프 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 문제 정보 입력 및 그래프 및 진입차수 배열 업데이트
        for (int j = 0; j < M; j++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B); // A -> B 간선 추가
            inDegree[B] += 1; // B의 진입차수 증가
        }

        // 위상정렬 수행하여 결과 출력
        System.out.println(solution());
    }
}
