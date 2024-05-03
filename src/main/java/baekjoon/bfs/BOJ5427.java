package baekjoon.bfs;

import java.io.*;
import java.util.*;

/**
 * 백준 5427 불 (골드 4) - BFS
 * https://www.acmicpc.net/problem/5427
 */
public class BOJ5427 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<int[]> sg;
    static Queue<int[]> fire;
    static char[][] map;
    static int h, w, answer;

    /**
     * 주어진 좌표가 유효한지 확인하는 메서드
     * @param x 행 좌표
     * @param y 열 좌표
     * @return 유효 여부 (범위 내인지)
     */
    public static boolean isValid(int x, int y) {
        return 0 <= x && x < h && 0 <= y && y < w;
    }

    /**
     * 불과 상근이의 이동을 BFS로 처리하는 메서드
     */
    public static void bfs() {
        answer = Integer.MAX_VALUE;

        while (!sg.isEmpty()) {
            // 불을 한 칸 퍼뜨림
            int len = fire.size();
            for (int i = 0; i < len; i++) {
                int[] info = fire.poll();
                int x = info[0];
                int y = info[1];

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    // 다음 위치가 유효하고 비어있는 경우에만 불을 퍼뜨림
                    if (isValid(nx, ny) && map[nx][ny] == '.') {
                        map[nx][ny] = '*';
                        fire.offer(new int[]{nx, ny});
                    }
                }
            }

            // 상근이의 이동 처리
            len = sg.size();
            for (int k = 0; k < len; k++) {
                int[] info = sg.poll();
                int x = info[0];
                int y = info[1];
                int second = info[2];

                for (int l = 0; l < 4; l++) {
                    int nx = x + dx[l];
                    int ny = y + dy[l];

                    // 다음 위치가 유효한 빈 공간인 경우에만 이동하고 시간 증가
                    if (isValid(nx, ny) && map[nx][ny] == '.') {
                        map[nx][ny] = '@';
                        sg.offer(new int[]{nx, ny, second + 1});
                    }
                    // 다음 위치가 범위 밖인 경우에는 탈출 성공
                    else if (!isValid(nx, ny)) {
                        answer = Math.min(answer, second + 1);
                        return;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            map = new char[h][w];
            sg = new LinkedList<>();
            fire = new LinkedList<>();

            for (int j = 0; j < h; j++) {
                String info = br.readLine();
                for (int k = 0; k < w; k++) {
                    map[j][k] = info.charAt(k);
                    if (map[j][k] == '@') {
                        sg.offer(new int[]{j, k, 0});
                    } else if (map[j][k] == '*') {
                        fire.offer(new int[]{j, k});
                    }
                }
            }

            bfs();

            if (answer == Integer.MAX_VALUE) {
                sb.append("IMPOSSIBLE\n");
            } else {
                sb.append(answer).append("\n");
            }
        }

        System.out.println(sb);
    }
}
