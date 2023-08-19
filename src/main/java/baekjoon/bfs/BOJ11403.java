package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 11403 경로 찾기 실버 1
 */
public class BOJ11403 {

    public static int n;
    public static int[][] graph, visited;
    public static int[] check;

    public static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        check = new int[n];

        queue.offer(v);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int i = 0; i < n; i++) {
                if (check[i] == 0 && graph[node][i] == 1) {
                    check[i] = 1;
                    queue.offer(i);
                    visited[v][i] = 1;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        graph = new int[n][n];
        visited = new int[n][n];


        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            bfs(i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
    }
}
