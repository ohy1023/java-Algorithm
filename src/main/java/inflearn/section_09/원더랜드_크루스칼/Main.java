package inflearn.section_09.원더랜드_크루스칼;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 인프런 원더랜드 - 크루스칼
 */
public class Main {

    // 간선을 나타내는 클래스
    static class Edge implements Comparable<Edge> {
        int v1;
        int v2;
        int cost;

        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static int V, E, res; // 정점의 수, 간선의 수, 최종 결과 값
    static int[] parent; // 부모 노드를 나타내는 배열

    // 부모를 찾는 메서드
    static int findParent(int x) {
        if (x != parent[x]) {
            return findParent(parent[x]);
        }
        return parent[x];
    }

    // 두 집합을 합치는 메서드
    static void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력 받기
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        // 부모 배열 초기화
        parent = new int[V + 1];
        for (int i = 1; i < V + 1; i++) {
            parent[i] = i;
        }

        // 간선 정보 입력 및 정렬
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.add(new Edge(v1, v2, cost));
        }

        Collections.sort(edges);

        // 크루스칼 알고리즘 수행
        for (Edge edge : edges) {
            int v1 = edge.v1;
            int v2 = edge.v2;
            int cost = edge.cost;

            if (findParent(v1) != findParent(v2)) {
                union(v1, v2);
                res += cost;
            }
        }

        // 결과 출력
        System.out.println(res);
    }
}
