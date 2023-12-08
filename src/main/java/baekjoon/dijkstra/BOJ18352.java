package baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 백준 특정 거리의 도시 찾기 ( 실버 2 ) - 데이크스트라
 * https://www.acmicpc.net/problem/18352
 */
class Node implements Comparable<Node> {

    int index;
    int cost;

    public Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.cost, o.cost);
    }
}

public class BOJ18352 {
    static boolean[] check;
    static int[] dist;

    static ArrayList<Node>[] graph;


    public void dijkstra(int start) {

        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));


        while (!pq.isEmpty()) {
            int curIdx = pq.poll().index;

            if (!check[curIdx]) {
                check[curIdx] = true;

                for (Node nextNode : graph[curIdx]) {
                    if (dist[nextNode.index] > dist[curIdx] + nextNode.cost) {
                        dist[nextNode.index] = dist[curIdx] + nextNode.cost;

                        pq.offer(new Node(nextNode.index, dist[nextNode.index]));
                    }
                }
            }
        }


    }

    public String solution(int n, int m, int k, int x, int[][] info) {
        StringBuilder sb = new StringBuilder();

        check = new boolean[n + 1];
        dist = new int[n + 1];

        int INF = Integer.MAX_VALUE;

        Arrays.fill(dist, INF);

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] ints : info) {
            int v = ints[0];
            int w = ints[1];
            graph[v].add(new Node(w, 1));
        }

        dijkstra(x);

        //최소거리 출력
        for (int i = 1; i <= n; i++) {
            if (dist[i] == k) {
                sb.append(i).append("\n");
            }
        }

        if (sb.toString().isEmpty()) {
            return "-1";
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        // 도시의 개수
        int N = Integer.parseInt(st.nextToken());

        // 도로의 개수
        int M = Integer.parseInt(st.nextToken());

        // 거리 정보
        int K = Integer.parseInt(st.nextToken());

        // 출발 도시의 번호
        int X = Integer.parseInt(st.nextToken());

        int[][] info = new int[M][2];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            info[i][0] = A;
            info[i][1] = B;
        }


        BOJ18352 b = new BOJ18352();
        System.out.println(b.solution(N, M, K, X, info));
    }


}
