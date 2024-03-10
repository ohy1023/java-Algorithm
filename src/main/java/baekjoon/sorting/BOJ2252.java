package baekjoon.sorting;

import java.io.*;
import java.util.*;

/**
 * 백준 2252 줄 세우기 (골드 3) - 위상정렬
 * https://www.acmicpc.net/problem/2252
 */
public class BOJ2252 {

    static int N;
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> q;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] edge;

    public static void topologySort() {
        // 진입 차수가 0인 학생들을 큐에 추가
        for (int i = 1; i <= N; i++) {
            if (edge[i] == 0) {
                q.offer(i);
            }
        }

        // 위상정렬 실행
        while (!q.isEmpty()) {
            int studentNo = q.poll(); // 큐에서 학생 번호 추출
            sb.append(studentNo).append(" "); // 정답에 학생 번호 추가

            // 현재 학생이 가리키는 학생들의 진입 차수 감소 및 0이 되면 큐에 추가
            for (int a : graph.get(studentNo)) {
                edge[a]--; // 현재 학생이 가리키는 학생의 진입 차수 감소

                // 진입 차수가 0이 되면 큐에 추가
                if (edge[a] == 0) {
                    q.offer(a);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 학생의 수
        int M = Integer.parseInt(st.nextToken()); // 비교 횟수

        // 그래프 생성
        graph = new ArrayList<>();
        for (int i = 0; i <= N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선의 개수 배열
        edge = new int[N + 1];
        // 위상정렬을 위한 큐
        q = new LinkedList<>();

        // 그래프 구성 및 간선의 개수 계산
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // a가 b보다 앞에 있어야 함을 표현하기 위해 그래프에 추가
            graph.get(a).add(b);
            // b의 진입 차수 증가
            edge[b] += 1;
        }

        // 위상정렬
        topologySort();

        // 결과 출력
        System.out.println(sb);
    }
}
