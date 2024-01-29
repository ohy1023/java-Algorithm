package baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 2211 네트워크 복구 (골드 2) - 데이크스트라
 * https://www.acmicpc.net/problem/2211
 */
public class BOJ2211 {

    static class Computer implements Comparable<Computer> {
        int index; // 컴퓨터의 인덱스

        int cost; // 현재까지의 비용

        public Computer(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Computer computer) {
            return Integer.compare(this.cost, computer.cost);
        }

    }

    static int[] dist, path; // dist: 시작점에서의 최단 거리, path: 최단 경로를 저장하는 배열
    static boolean[] check; // 방문 여부를 체크하는 배열

    static HashSet<String> resultSet; // 결과를 저장하는 HashSet

    static ArrayList<Computer>[] graph; // 그래프를 표현하는 배열

    /**
     * 다익스트라 알고리즘을 이용하여 최단 경로를 찾는 메서드
     *
     * @param start 시작 노드
     */
    public static void dijkstra(int start) {

        dist[start] = 0; // 시작 노드의 거리를 0으로 초기화

        PriorityQueue<Computer> pq = new PriorityQueue<>(); // 우선순위 큐를 이용한 최소 힙

        pq.offer(new Computer(start, 0)); // 시작 노드를 큐에 삽입

        while (!pq.isEmpty()) {
            int curComputerIdx = pq.poll().index; // 현재 노드의 인덱스를 가져옴

            if (!check[curComputerIdx]) { // 해당 노드를 방문하지 않았다면
                check[curComputerIdx] = true; // 방문 처리

                for (Computer nextComputer : graph[curComputerIdx]) {
                    // 인접한 노드들에 대해 최단 거리 갱신
                    if (dist[nextComputer.index] > dist[curComputerIdx] + nextComputer.cost) {
                        dist[nextComputer.index] = dist[curComputerIdx] + nextComputer.cost;

                        // 갱신된 정보를 우선순위 큐에 삽입
                        pq.offer(new Computer(nextComputer.index, dist[nextComputer.index]));
                        path[nextComputer.index] = curComputerIdx;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 컴퓨터 개수
        int M = Integer.parseInt(st.nextToken()); // 회선 수

        path = new int[N + 1]; // 최단 경로를 저장하는 배열 초기화
        check = new boolean[N + 1]; // 방문 여부를 체크하는 배열 초기화
        resultSet = new HashSet<>(); // 결과를 저장하는 HashSet 초기화
        dist = new int[N + 1]; // 시작 노드로부터의 최단 거리 배열 초기화

        int INF = Integer.MAX_VALUE; // 무한대 값 설정

        Arrays.fill(dist, INF); // 최단 거리 배열을 무한대로 초기화

        graph = new ArrayList[N + 1]; // 그래프를 표현하는 배열 초기화
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 양방향 그래프이므로 양쪽 방향에 간선 정보 추가
            graph[s].add(new Computer(e, c));
            graph[e].add(new Computer(s, c));
        }

        dijkstra(1); // 다익스트라 알고리즘 호출

        // 각 도착지점부터 시작해서 역으로 거슬러올라가며 경로를 찾고, HashSet에 담는다.
        for (int i = 2; i <= N; i++) {
            int end = i;
            while (path[end] != 0) {
                resultSet.add(end + " " + path[end]);
                end = path[end];
            }
        }

        // 결과 출력
        System.out.println(resultSet.size());
        for (String result : resultSet) {
            System.out.println(result);
        }
    }

}
