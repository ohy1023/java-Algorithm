package baekjoon.bfs;

import java.io.*;
import java.util.*;

/**
 * 백준 인구 이동 (골드 4) - BFS
 * https://www.acmicpc.net/problem/16234
 */
public class BOJ16234 {

    static int N, L, R, day;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static ArrayList<int[]> list;

    public static int move() {
        int day = 0;
        while (true) {
            boolean flag = false;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        int sum = bfs(i, j);
                        if (list.size() > 1) {
                            applyPopulation(sum);
                            flag = true;
                        }
                    }
                }
            }

            if (!flag) return day;
            day++;
        }
    }

    public static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        list = new ArrayList<>();

        q.offer(new int[]{x, y});
        list.add(new int[]{x, y});
        visited[x][y] = true;

        int sum = map[x][y];

        while (!q.isEmpty()) {
            int[] curPoint = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curPoint[0] + dx[i];
                int ny = curPoint[1] + dy[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]){
                    int diff = Math.abs(map[curPoint[0]][curPoint[1]] - map[nx][ny]);

                    if (diff >= L && diff <= R) {
                        q.offer(new int[]{nx, ny});
                        list.add(new int[]{nx, ny});
                        sum += map[nx][ny];
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        return sum;
    }

    public static void applyPopulation(int sum) {
        int avg = sum / list.size();
        for (int[] info : list) {
            int x = info[0];
            int y = info[1];

            map[x][y] = avg;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(move());
    }
}