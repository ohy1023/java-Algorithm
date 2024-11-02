package programmers.level3.sol49189;

import java.util.*;

/**
 * 프로그래머스 level 3 가장 먼 노드 - 데이크스트라
 * https://school.programmers.co.kr/learn/courses/30/lessons/49189
 */
class Solution {
    private final int INF = Integer.MAX_VALUE;
    static int[] dist;
    static ArrayList<ArrayList<Node>> graph;

    static class Node implements Comparable<Node> {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static void dijkstra(int start) {
        dist[start] = 0;

        Queue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));

        // 다익스트라 알고리즘 수행
        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            // 현재 노드에서 인접한 노드들을 확인하여 최단 거리 갱신
            for (Node nextNode : graph.get(curNode.idx)) {
                if (dist[nextNode.idx] > dist[curNode.idx] + nextNode.cost) {
                    dist[nextNode.idx] = dist[curNode.idx] + nextNode.cost;

                    pq.offer(new Node(nextNode.idx, dist[nextNode.idx]));
                }
            }
        }

    }

    public int solution(int n, int[][] edge) {
        dist = new int[n + 1];
        Arrays.fill(dist, INF);

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 구성
        for (int[] e : edge) {
            int n1 = e[0];
            int n2 = e[1];
            graph.get(n1).add(new Node(n2, 1));
            graph.get(n2).add(new Node(n1, 1));
        }

        // 다익스트라 알고리즘 수행
        dijkstra(1);

        // 최단 거리 중 가장 먼 노드 찾기
        int cnt = 1;
        int maxDist = Integer.MIN_VALUE;

        for (int i = 1; i < dist.length; i++) {
            if (dist[i] > maxDist && dist[i] != INF) {
                maxDist = dist[i];
                cnt = 1;
            } else if (dist[i] == maxDist) {
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }
}
