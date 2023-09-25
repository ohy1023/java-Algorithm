package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 2252 줄 세우기 (골드 3) - 위상 정렬
 * https://www.acmicpc.net/problem/2252
 */
public class BOJ2252 {

    /**
     * 위상 정렬을 수행하여 결과를 출력하는 함수
     *
     * @param graph    그래프
     * @param indegree 노드의 진입차수 배열
     */
    public static void topologySort(ArrayList<ArrayList<Integer>> graph, int[] indegree) {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();

        // 진입차수가 0인 노드들을 큐에 삽입
        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            int now = queue.poll();
            sb.append(now).append(" "); // 결과에 현재 노드 추가

            // 현재 노드와 연결된 노드들의 진입차수를 감소시키고, 진입차수가 0이면 큐에 삽입
            for (int x : graph.get(now)) {
                indegree[x]--;
                if (indegree[x] == 0) {
                    queue.offer(x);
                }
            }
        }

        System.out.println(sb); // 결과 출력
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정점의 개수
        int m = Integer.parseInt(st.nextToken()); // 간선의 개수

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // 그래프
        int[] indegree = new int[n + 1]; // 노드의 진입차수 배열

        // 그래프 초기화
        for (int i = 0; i <= n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 입력 및 진입차수 계산
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b); // 노드 a에서 노드 b로 가는 간선 추가
            indegree[b]++; // 노드 b의 진입차수 증가
        }

        topologySort(graph, indegree); // 위상 정렬 수행
    }
}
