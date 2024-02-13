package inflearn.section_09.원더랜드_프림;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 인프런 원더랜드 - 프림 알고리즘
 */
public class Main {

    // 간선을 나타내는 클래스
    static class Edge implements Comparable<Edge> {

        int v; // 도착 정점
        int cost; // 간선의 가중치

        public Edge(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            // 간선의 가중치를 기준으로 오름차순 정렬
            return Integer.compare(this.cost, o.cost);
        }
    }

    static int V, E, res; // 정점의 수, 간선의 수, 최종 결과 값
    static boolean[] check; // 정점의 방문 여부를 나타내는 배열
    static ArrayList<ArrayList<Edge>> edges; // 간선 정보를 담은 리스트

    /**
     * 프림 알고리즘을 사용하여 최소 비용 신장 트리를 구하는 메서드
     */
    static void prim() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, 0)); // 시작 정점을 우선순위 큐에 추가

        while (!pq.isEmpty()) {
            Edge curNode = pq.poll(); // 현재 가장 가중치가 작은 간선을 선택

            int cv = curNode.v;

            // 해당 정점이 아직 방문되지 않았다면 선택
            if (!check[cv]) {
                check[cv] = true; // 정점을 방문으로 표시
                res += curNode.cost; // 결과값에 가중치 추가

                // 현재 정점과 연결된 간선들을 우선순위 큐에 추가
                for (Edge e : edges.get(cv)) {
                    if (!check[e.v]) {
                        pq.offer(new Edge(e.v, e.cost));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력 받기
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken()); // 정점의 수
        E = Integer.parseInt(st.nextToken()); // 간선의 수
        res = 0;

        check = new boolean[V + 1]; // 정점의 방문 여부를 나타내는 배열 초기화
        edges = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            edges.add(new ArrayList<>());
        }

        // 간선 정보 입력
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            // 양방향 간선으로 그래프에 추가
            edges.get(v1).add(new Edge(v2, cost));
            edges.get(v2).add(new Edge(v1, cost));
        }

        prim(); // 프림 알고리즘 수행

        // 결과 출력
        System.out.println(res);
    }
}
