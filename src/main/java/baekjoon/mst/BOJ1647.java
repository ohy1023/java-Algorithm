package baekjoon.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 백준 1647 도시 분할 계획 (골드 4) - 최소 스패닝 트리 (MST)
 * https://www.acmicpc.net/problem/1647
 */
public class BOJ1647 {

    static int[] parent;
    static ArrayList<City> cities;

    static class City implements Comparable<City> {
        int from;
        int to;
        int cost;

        public City(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(City o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    private static int findParent(int n) {
        if (n != parent[n]) {
            parent[n] = findParent(parent[n]);
        }
        return parent[n];
    }

    private static void union(int n1, int n2) {
        int a = findParent(n1);
        int b = findParent(n2);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    private static int kruskal() {
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (City city : cities) {
            if (findParent(city.from) != findParent(city.to)) {
                union(city.from, city.to);
                sum += city.cost;
                max = Math.max(city.cost, max);
            }
        }

        return sum - max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        cities = new ArrayList<>();

        parent = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            cities.add(new City(a, b, c));
        }

        Collections.sort(cities);

        System.out.println(kruskal());
    }
}
