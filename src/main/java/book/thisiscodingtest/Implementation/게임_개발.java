package book.thisiscodingtest.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 게임_개발 {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visited = new boolean[N][M];
        visited[x][y] = true;
        int answer = 1;
        int turn = 0;

        while (true) {
            d = (d + 3) % 4;
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M
                    && !visited[nx][ny] && map[nx][ny] == 0) {
                visited[nx][ny] = true;
                x = nx;
                y = ny;
                answer++;
                turn = 0;
                continue;
            } else {
                turn++;
            }


            if (turn == 4) {
                int bx = x - dx[d];
                int by = y - dy[d];

                if (bx >= 0 && by >= 0 && bx < N && by < M && map[bx][by] == 0) {
                    x = bx;
                    y = by;
                    turn = 0;
                } else {
                    break;
                }
            }
        }


        System.out.println(answer);

    }
}
