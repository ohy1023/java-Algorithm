package inflearn.section_09.다익스트라_알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 인프런 다익스트라 알고리즘
 */
public class Main {

    static class Node implements Comparable<Node> {
        int idx; // 노드의 인덱스

        int cost; // 현재까지의 비용

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static int N, M; // 정점의 수, 간선의 수

    static int[] dist; // 시작점으로부터의 최단 거리를 저장하는 배열

    static ArrayList<Node>[] graph; // 그래프를 표현하는 배열

    /**
     * 다익스트라 알고리즘을 이용하여 최단 거리를 찾는 메서드
     *
     * @param start 시작 노드
     */
    public static void dijkstar(int start) {
        dist[start] = 0; // 시작 노드의 거리를 0으로 초기화

        PriorityQueue<Node> pq = new PriorityQueue<>(); // 우선순위 큐를 이용한 최소 힙

        pq.offer(new Node(start, 0)); // 시작 노드를 큐에 삽입

        while (!pq.isEmpty()) {

            Node curNode = pq.poll(); // 현재 노드를 가져옴

            for (Node nextNode : graph[curNode.idx]) {
                // 인접한 노드들에 대해 최단 거리 갱신
                if (dist[nextNode.idx] > dist[curNode.idx] + nextNode.cost) {
                    dist[nextNode.idx] = dist[curNode.idx] + nextNode.cost;

                    // 갱신된 정보를 우선순위 큐에 삽입
                    pq.offer(new Node(nextNode.idx, nextNode.cost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N + 1]; // 시작점으로부터의 최단 거리 배열 초기화
        Arrays.fill(dist, Integer.MAX_VALUE); // 최단 거리 배열을 무한대로 초기화

        graph = new ArrayList[N + 1]; // 그래프를 표현하는 배열 초기화
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            // 양방향 그래프이므로 양쪽 방향에 간선 정보 추가
            graph[start].add(new Node(end, cost));
        }

        dijkstar(1); // 다익스트라 알고리즘 호출

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < N + 1; i++) {
            sb.append(i).append(" : ");

            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("impossible");
            } else {
                sb.append(dist[i]);
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
