package baekjoon.dfs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2606 바이러스 실버 3
 */
public class BOJ2606 {

    static int[][] graph;
    static boolean[] visit;

    static int n, m;
    static int res = 0;

    public static void DFS(int depth) {

        visit[depth] = true;

        for (int i = 1; i < n + 1; i++) {
            if (graph[depth][i] == 1 && !visit[i]) {
                res++;
                DFS(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new int[n + 1][n + 1];
        visit = new boolean[n + 1];

        StringTokenizer st;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = graph[b][a] = 1;
        }

        DFS(1);

        System.out.println(res);

    }
}
