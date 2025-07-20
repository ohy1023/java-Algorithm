package baekjoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 16926 배열 돌리기 1 - 구현
 * <a href="https://www.acmicpc.net/problem/16926">...</a>
 */
public class BOJ16926 {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int layerCnt = Math.min(N, M) / 2;

        for (int i = 0; i < R; i++) {
            for (int j = 1; j <= layerCnt; j++) {
                int temp = arr[j][j];
                int x = j;
                int y = j;
                int dir = 0;

                while (dir < 4) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    if (nx >= j && ny >= j && nx <= N - j + 1 && ny <= M - j + 1) {
                        arr[x][y] = arr[nx][ny];
                        x = nx;
                        y = ny;
                    } else {
                        dir++;
                    }
                }

                arr[j + 1][j] = temp;

            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}
