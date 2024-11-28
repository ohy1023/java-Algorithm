package baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 1916 최소비용 구하기 (골드 5) - 데이크스트라
 * https://www.acmicpc.net/problem/1916
 */
public class BOJ1916 {

    static int N, M;
    static ArrayList<ArrayList<City>> graph;
    static int[] dist;
    static boolean[] check;

    static class City implements Comparable<City> {
        int end;
        int cost;

        public City(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(City o) {
            return Integer.compare(cost, o.cost);
        }
    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<City> pq = new PriorityQueue<>();
        boolean[] check = new boolean[N + 1];
        pq.offer(new City(start, 0));
        dist[start] = 0;


        while (!pq.isEmpty()) {
            City curCity = pq.poll();
            int cur = curCity.end;

            if (!check[cur]) {
                check[cur] = true;

                for (City city : graph.get(cur)) {
                    if (!check[city.end] && dist[city.end] > dist[cur] + city.cost) {
                        dist[city.end] = dist[cur] + city.cost;
                        pq.add(new City(city.end, dist[city.end]));
                    }
                }
            }
        }
        return dist[end];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();

        dist = new int[N + 1];
        check = new boolean[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(a).add(new City(b, cost));

        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(start, end));

    }
}
