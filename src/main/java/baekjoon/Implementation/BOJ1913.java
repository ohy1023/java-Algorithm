package baekjoon.Implementation;

import java.io.*;

/**
 * 백준 1913 - 달팽이 (실버 3)
 * https://www.acmicpc.net/problem/1913
 */
public class BOJ1913 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        int value = 1;

        int row = n / 2, col = n / 2;
        int limit = 1;

        // 방향별 이동: 상, 우, 하, 좌
        while (value <= n * n) {
            // 상
            for (int i = 0; i < limit && value <= n * n; i++) {
                map[row--][col] = value++;
            }
            // 우
            for (int i = 0; i < limit && value <= n * n; i++) {
                map[row][col++] = value++;
            }
            limit++;

            // 하
            for (int i = 0; i < limit && value <= n * n; i++) {
                map[row++][col] = value++;
            }
            // 좌
            for (int i = 0; i < limit && value <= n * n; i++) {
                map[row][col--] = value++;
            }
            limit++;
        }

        StringBuilder sb = new StringBuilder();
        int tx = 0, ty = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(map[i][j]);
                if (j < n - 1) sb.append(" ");
                if (map[i][j] == t) {
                    ty = i + 1;
                    tx = j + 1;
                }
            }
            sb.append("\n");
        }
        sb.append(ty).append(" ").append(tx);
        System.out.print(sb);
    }
}
