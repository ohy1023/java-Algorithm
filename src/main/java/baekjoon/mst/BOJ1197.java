package baekjoon.mst;

import java.io.*;
import java.util.*;

/**
 * 백준 1197 (골드 3) - 최소 스패닝 트리 (MST)
 * https://www.acmicpc.net/problem/1197
 */
public class BOJ1197 {

    static int V, E, answer;
    static boolean[] check;
    static ArrayList<ArrayList<Node>> graph;

    static class Node implements Comparable<Node> {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    private static void prim(int start) {


        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int node = curNode.end;
            int weight = curNode.weight;

            if (check[node]) continue;
            check[node] = true;
            answer += weight;

            for (Node nextNode : graph.get(node)) {
                if (!check[nextNode.end]) {
                    pq.offer(nextNode);
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

        check = new boolean[V + 1];
        graph = new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int j = 0; j < E; j++) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(v1).add(new Node(v2, weight));
            graph.get(v2).add(new Node(v1, weight));
        }

        prim(1);

        System.out.println(answer);

    }
}