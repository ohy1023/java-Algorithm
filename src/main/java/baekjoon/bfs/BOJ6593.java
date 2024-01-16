package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 6593 상범 빌딩 (골드 5) - BFS
 * https://www.acmicpc.net/problem/6593
 */
public class BOJ6593 {

    static int l, r, c;
    static char[][][] graph;
    static int[][][] visited;

    static class Coordinate {
        int x, y, z;

        public Coordinate(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static void BFS(int x, int y, int z) {
        int[] dx = {-1, 1, 0, 0, 0, 0};
        int[] dy = {0, 0, -1, 1, 0, 0};
        int[] dz = {0, 0, 0, 0, -1, 1};

        Queue<Coordinate> queue = new LinkedList<>();

        queue.offer(new Coordinate(x, y, z));

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();
            x = current.x;
            y = current.y;
            z = current.z;

            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];

                if (0 <= nx && nx < l && 0 <= ny && ny < r && 0 <= nz && nz < c
                        && (graph[nx][ny][nz] == '.' || graph[nx][ny][nz] == 'E') && visited[nx][ny][nz] == 0) {
                    visited[nx][ny][nz] = visited[x][y][z] + 1;
                    if (graph[nx][ny][nz] == 'E') {
                        System.out.println("Escaped in " + visited[nx][ny][nz] + " minute(s).");
                        return;
                    }
                    queue.offer(new Coordinate(nx, ny, nz));
                }
            }
        }
        System.out.println("Trapped!");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (l == 0 && r == 0 && c == 0) {
                break;
            }

            graph = new char[l][r][c];
            visited = new int[l][r][c];

            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String line = br.readLine();
                    graph[i][j] = line.toCharArray();
                }
                br.readLine();
            }

            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    for (int k = 0; k < c; k++) {
                        if (graph[i][j][k] == 'S') {
                            BFS(i, j, k);
                            break;
                        }
                    }
                }
            }
        }
    }
}