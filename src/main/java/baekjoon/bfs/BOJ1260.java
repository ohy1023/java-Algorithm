package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 * 백준 1260 DFS와 BFS 실버 2 - DFS/BFS를 이용한 풀이
 */
public class BOJ1260 {
    public static int n, m, v;
    public static int[][] graph;
    public static boolean[] checkDfs, checkBfs;

    public static void DFS(int depth) {
        checkDfs[depth] = true;
        System.out.print((depth + 1) + " ");
        for (int i = 0; i < n; i++) {
            if (graph[depth][i] == 1 && !checkDfs[i]) {
                DFS(i);
            }
        }
    }

    public static void BFS(int depth) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(depth);
        checkBfs[depth] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print((node + 1) + " ");
            for (int i = 0; i < n; i++) {
                if (graph[node][i] == 1 && !checkBfs[i]) {
                    q.offer(i);
                    checkBfs[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        graph = new int[n][n];
        checkDfs = new boolean[n];
        checkBfs = new boolean[n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x - 1][y - 1] = graph[y - 1][x - 1] = 1;
        }

        DFS(v - 1);
        System.out.println();
        BFS(v - 1);


    }
}
