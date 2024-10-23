package softeer.level3.sol7727;

import java.io.*;
import java.util.*;

/**
 * 소프티어 함께하는 효도 (Level.3) - DFS
 * https://softeer.ai/practice/7727
 */
public class Main {
    static int n, m, answer;
    static int[][] maps;
    static List<Point> friendList;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void DFS(int depth, int friendCnt, int sum, int x, int y) {
        answer = Math.max(answer, sum);

        if (depth == 3) {
            if (friendCnt + 1 < m) {
                DFS(0, friendCnt + 1, sum, friendList.get(friendCnt + 1).x, friendList.get(friendCnt + 1).y);
            }
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (ny>=1 && ny<= n && nx>=1 && nx<= n) {
                    int value = maps[nx][ny];
                    maps[nx][ny] = 0;
                    DFS(depth + 1, friendCnt, sum + value, nx, ny);
                    maps[nx][ny] = value;
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

        maps = new int[n + 1][n + 1];
        answer = 0;

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int sum = 0;
        friendList = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            friendList.add(new Point(x, y));
            sum += maps[x][y];
            maps[x][y] = 0;
        }

        DFS(0, 0, sum, friendList.get(0).x, friendList.get(0).y);
        System.out.println(answer);
    }
}
