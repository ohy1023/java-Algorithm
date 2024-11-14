package baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 1753 최단경로 (골드 4) - 데이크스트라
 * https://www.acmicpc.net/problem/1753
 */
public class BOJ1753 {

    static int V, E;
    static ArrayList<ArrayList<Node>> graph;
    static int[] dist;

    static class Node {
        int end;
        int weight;

        public Node (int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    private static void dijkstra(int start) {

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        pq.offer(new Node(start,0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.end;

            if (dist[cur] != curNode.weight) continue;

            for (Node node : graph.get(cur)) {
                if (dist[node.end] > dist[cur] + node.weight) {
                    dist[node.end] = dist[cur] + node.weight;
                    pq.offer(new Node(node.end,dist[node.end]));
                }
            }
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        dist = new int[V + 1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v,w));
        }

        dijkstra(K);

        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dist[i]);
        }

    }
}
