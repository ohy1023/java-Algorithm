package baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 백준 파티 (골드 3) - 다익스트라
 * https://www.acmicpc.net/problem/1238
 */
class City implements Comparable<City> {

    int index;
    int cost;

    public City(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(City o) {
        // 비교 메서드: 비용(cost)을 기준으로 오름차순 정렬
        return Integer.compare(this.cost, o.cost);
    }
}

public class BOJ1238 {

    private static int N, X;
    private static final int INF = Integer.MAX_VALUE;

    private static ArrayList<City>[] graph, reverseGraph;

    // 다익스트라 알고리즘을 수행하여 최단 거리 배열을 반환하는 메서드
    public static int[] dijkstra(ArrayList<City>[] board) {
        boolean[] check = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);

        dist[X] = 0;
        PriorityQueue<City> pq = new PriorityQueue<>();
        pq.offer(new City(X, 0));

        // 다익스트라 알고리즘 시작
        while (!pq.isEmpty()) {
            int curIdx = pq.poll().index;

            if (!check[curIdx]) {
                check[curIdx] = true;

                // 현재 정점에서 연결된 모든 인접 정점들을 확인
                for (City nextCity : board[curIdx]) {
                    // 현재까지의 최단 거리보다 더 짧은 거리를 발견한 경우 갱신
                    if (dist[nextCity.index] > dist[curIdx] + nextCity.cost) {
                        dist[nextCity.index] = dist[curIdx] + nextCity.cost;

                        // 우선순위 큐에 갱신된 정보를 추가
                        pq.offer(new City(nextCity.index, dist[nextCity.index]));
                    }
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        // 입력 받기
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        // 그래프 초기화
        graph = new ArrayList[N + 1];
        reverseGraph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        // 간선 정보 입력 및 그래프 구성
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            // 그래프와 역방향 그래프에 간선 정보 추가
            graph[start].add(new City(end, cost));
            reverseGraph[end].add(new City(start, cost));
        }

        // X에서 시작한 최단 거리 배열
        int[] dist1 = dijkstra(graph);
        // 시작점들에서 X까지의 최단 거리 배열
        int[] dist2 = dijkstra(reverseGraph);

        // 각 정점에서 X까지 갔다가 다시 돌아오는 최단 거리의 합 중 최댓값을 찾기
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, dist1[i] + dist2[i]);
        }

        // 결과 출력
        System.out.println(ans);
    }
}
