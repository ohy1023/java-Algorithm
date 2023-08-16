package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1245 농장관리 골드 5
 */
public class BOJ1245 {

    public static int n, m;

    public static boolean flag;
    public static int[][] graph;
    public static boolean[][] visited;

    public static final int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    public static final int[] dy = {0, 0, 1, -1, 1, -1, -1, 1};

    public static void dfs(int x, int y) {

        visited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                if (graph[nx][ny] > graph[x][y]) {
                    flag = false;
                }
                if (!visited[nx][ny] && graph[nx][ny] == graph[x][y]) {
                    dfs(nx, ny);
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int res = 0;

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        graph = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                flag = true;
                if (graph[i][j] != 0 && !visited[i][j]) {
                    dfs(i, j);
                    if (flag) {
                        res++;
                    }
                }
            }
        }

        System.out.println(res);

    }
}
