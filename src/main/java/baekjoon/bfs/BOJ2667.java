package baekjoon.bfs;


import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 2667 단지 번호 붙이기 - 실버 1
 */
public class BOJ2667 {
    public static int n;
    public static int[][] graph;

    static Queue<Point> queue = new LinkedList<>();

    public static int bfs(int x, int y) {

        int ans = 1;

        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, -1, 0, 1};

        queue.offer(new Point(x, y));

        graph[x][y] = 0;

        while (!queue.isEmpty()) {
            Point tmp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < n && graph[nx][ny] == 1) {
                    graph[nx][ny] = 0;
                    ans++;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            String inputs = br.readLine();
            for (int j = 0; j < n; j++) {
                graph[i][j] = Character.getNumericValue(inputs.charAt(j));
            }
        }

        int total_res = 0;
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1) {
                    total_res++;
                    res.add(bfs(i, j));
                }
            }
        }

        sb.append(total_res).append("\n");

        Collections.sort(res);

        for (int i = 0; i < res.size(); i++) {
            sb.append(res.get(i)).append("\n");
        }

        System.out.println(sb);

    }
}
