package baekjoon.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 백준 1197 최소 스패닝 트리 (골드 4) - 최소 스패닝 트리 (MST)
 * https://www.acmicpc.net/problem/1197
 */
public class BOJ1197 {

    static int[][] graph; // 그래프의 간선 정보를 담는 2차원 배열
    static int[] parent; // 각 정점의 부모를 나타내는 배열
    static int res; // 최소 스패닝 트리의 총 가중치를 저장하는 변수

    /**
     * 정점 x의 부모를 찾는 메서드
     *
     * @param x 찾고자 하는 정점
     * @return 정점 x의 부모
     */
    private static int findParent(int x) {
        // 경로 압축(Path Compression)을 이용한 재귀적 부모 찾기
        if (x != parent[x]) {
            return findParent(parent[x]);
        }
        return parent[x];
    }

    /**
     * 두 정점을 하나의 집합으로 합치는 메서드 (Union)
     *
     * @param a 합칠 정점 a
     * @param b 합칠 정점 b
     */
    private static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        // 작은 번호의 정점을 부모로 설정하여 트리의 균형을 유지
        if (a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력: 정점의 개수(V), 간선의 개수(E)
        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        graph = new int[E][3]; // 간선 정보를 담는 2차원 배열 초기화
        parent = new int[V]; // 부모 배열 초기화
        res = 0; // 결과 변수 초기화

        // 입력: 간선 정보를 그래프 배열에 저장
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
            graph[i][2] = Integer.parseInt(st.nextToken());
        }

        // 간선의 가중치를 기준으로 오름차순 정렬
        Arrays.sort(graph, Comparator.comparingInt(o -> o[2]));

        // 각 정점의 부모를 자기 자신으로 초기화
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }

        // Kruskal 알고리즘 수행
        for (int[] info : graph) {
            int s = info[0] - 1; // 출발 정점
            int e = info[1] - 1; // 도착 정점
            int cost = info[2]; // 가중치

            // 두 정점이 같은 집합에 속하지 않으면 연결하고 결과에 가중치 추가
            if (findParent(s) != findParent(e)) {
                unionParent(s, e);
                res += cost;
            }
        }

        // 최소 스패닝 트리의 총 가중치 출력
        System.out.println(res);
    }
}
