package baekjoon.mst;

import java.io.*;
import java.util.*;

/**
 * 백준 13418 학교 탐방하기 (골드 3) - 최소 스패닝 트리 (MST)
 * https://www.acmicpc.net/problem/13418
 */
public class BOJ13418 {

    static int N, M;
    static int[] parent;

    static Queue<Node> ascendQueue = new PriorityQueue<>();
    static Queue<Node> descendQueue = new PriorityQueue<>(Collections.reverseOrder());

    static class Node implements Comparable<Node> {

        int v1;
        int v2;
        int isDownHill;

        public Node(int v1, int v2, int isDownHill) {
            this.v1 = v1;
            this.v2 = v2;
            this.isDownHill = isDownHill;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.isDownHill, o.isDownHill);
        }
    }

    static int findParent(int a) {
        if (a != parent[a]) {
            return findParent(parent[a]);
        }
        return parent[a];
    }

    static void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];


        for (int i = 0; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int isDownHill = Integer.parseInt(st.nextToken());

            ascendQueue.add(new Node(s, e, isDownHill));
            descendQueue.add(new Node(s, e, isDownHill));
        }

        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        int maxCost = 0;
        while (!ascendQueue.isEmpty()) {
            Node cur = ascendQueue.poll();

            if (findParent(cur.v1) != findParent(cur.v2)) {
                union(cur.v1, cur.v2);

                if (cur.isDownHill == 0) {
                    maxCost++;
                }
            }
        }

        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        int minCost = 0;
        while (!descendQueue.isEmpty()) {
            Node cur = descendQueue.poll();

            if (findParent(cur.v1) != findParent(cur.v2)) {
                union(cur.v1, cur.v2);

                if (cur.isDownHill == 0) {
                    minCost++;
                }
            }
        }

        System.out.println(maxCost * maxCost - minCost * minCost);
    }
}
