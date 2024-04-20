package baekjoon.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 백준 4386 별자리 만들기 (골드 3) - 최소 스패닝 트리 (MST)
 * https://www.acmicpc.net/problem/4386
 */
public class BOJ4386 {

    static class Star {
        private int idx;
        private double x;
        private double y;

        public Star(int idx, double x, double y) {
            this.idx = idx;
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge> {
        private int s;
        private int e;
        private double cost;

        public Edge(int s, int e, double cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.cost, o.cost);
        }
    }

    private static int[] parent;

    // 거리 계산
    private static double calcDist(Star star1, Star star2) {
        return Math.sqrt(Math.pow(star2.x - star1.x, 2) + Math.pow(star2.y - star1.y, 2));
    }

    private static int findParent(int x) {
        // 부모 노드를 찾아주는 함수
        if (x != parent[x]) {
            return findParent(parent[x]);
        }

        return parent[x];
    }

    private static void unionParent(int a, int b) {
        // 두 집합을 합치는 함수
        a = findParent(a);
        b = findParent(b);

        if (a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력 처리
        int n = Integer.parseInt(br.readLine());
        Star[] stars = new Star[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            stars[i] = new Star(i, x, y);
        }

        // 간선 정보 저장
        List<Edge> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double dist = calcDist(stars[i], stars[j]);

                graph.add(new Edge(stars[i].idx, stars[j].idx, dist));
            }
        }

        // 간선의 비용을 기준으로 오름차순 정렬
        Collections.sort(graph);

        // 각 정점의 부모를 자기 자신으로 초기화
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        double res = 0;

        // Kruskal's 알고리즘 수행
        for (Edge edge : graph) {
            // 두 정점이 같은 집합에 속하지 않으면 연결하고 결과에 가중치 추가
            if (findParent(edge.s) != findParent(edge.e)) {
                unionParent(edge.s, edge.e);
                res += edge.cost;
            }
        }

        System.out.println(res);
    }
}
