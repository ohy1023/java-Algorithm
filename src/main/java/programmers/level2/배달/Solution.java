package programmers.level2.배달;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 프로그래머스 level 2 배달 - 다익스트라
 * https://school.programmers.co.kr/learn/courses/30/lessons/12978
 */
class City implements Comparable<City> {
    int index; // 도시의 인덱스
    int cost;  // 출발 도시로부터의 최소 비용

    public City(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(City o) {
        return Integer.compare(this.cost, o.cost);
    }
}

class Solution {

    static boolean[] check;      // 도시 방문 여부를 나타내는 배열
    static int[] dist;           // 출발 도시로부터의 최소 비용을 저장하는 배열
    static ArrayList<City>[] graph; // 그래프를 나타내는 리스트 배열

    /**
     * 다익스트라 알고리즘을 사용하여 최단 경로를 찾는 메소드
     *
     * @param start 출발 도시의 인덱스
     */
    public void dijkstra(int start) {
        dist[start] = 0;
        PriorityQueue<City> pq = new PriorityQueue<>();
        pq.offer(new City(start, 0));

        while (!pq.isEmpty()) {
            int curCity = pq.poll().index;

            if (!check[curCity]) {
                check[curCity] = true;

                for (City nextCity : graph[curCity]) {
                    if (dist[nextCity.index] > dist[curCity] + nextCity.cost) {
                        dist[nextCity.index] = dist[curCity] + nextCity.cost;

                        pq.offer(new City(nextCity.index, dist[nextCity.index]));
                    }
                }
            }
        }
    }

    /**
     * 주어진 도시, 도로 정보 및 최대 비용으로 도달 가능한 도시의 개수를 반환하는 메소드
     *
     * @param N    도시의 개수
     * @param road 도로 정보
     * @param K    최대 비용
     * @return 도달 가능한 도시의 개수
     */
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        // 초기화
        dist = new int[N + 1];
        check = new boolean[N + 1];
        int INF = Integer.MAX_VALUE;
        Arrays.fill(dist, INF);

        // 그래프 초기화
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 도로 정보를 그래프에 추가
        for (int[] info : road) {
            int a = info[0];
            int b = info[1];
            int cost = info[2];

            graph[a].add(new City(b, cost));
            graph[b].add(new City(a, cost));
        }

        // 다익스트라 알고리즘 수행
        dijkstra(1);

        // 최대 비용 이하인 도시의 개수 계산
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int N = 6, K = 4;
        int[][] road = new int[][]{{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}};
        System.out.println(s.solution(N, road, K));
    }
}
