package baekjoon.bfs;

import java.io.*;
import java.util.*;

/**
 * 백준 탈출 (골드 4) - BFS
 * https://www.acmicpc.net/problem/3055
 */
public class BOJ3055 {
    public static int R, C;
    public static String[][] map;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static Queue<int[]> q = new LinkedList<>(); // 고슴도치의 이동을 위한 큐
    public static Queue<int[]> water = new LinkedList<>(); // 물의 이동을 위한 큐
    public static int answer = Integer.MAX_VALUE; // 최종 답을 저장하는 변수

    /**
     * 유효한 좌표인지 확인하는 메서드
     *
     * @param x 행 좌표
     * @param y 열 좌표
     * @return 유효한 좌표인지 여부
     */
    public static boolean isValid(int x, int y) {
        return 0 <= x && x < R && 0 <= y && y < C;
    }

    /**
     * BFS를 통해 고슴도치의 이동과 물의 이동을 처리하는 메서드
     */
    public static void bfs() {
        while (!q.isEmpty()) {
            // 물의 이동 처리
            int len = water.size();
            for (int i = 0; i < len; i++) {
                int[] curInfo = water.poll();
                int x = curInfo[0];
                int y = curInfo[1];

                // 상하좌우로 이동하며 물을 채워넣는다.
                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (isValid(nx, ny) && map[nx][ny].equals(".")) {
                        map[nx][ny] = "*"; // 물로 채워넣음
                        water.offer(new int[]{nx, ny}); // 새로운 물의 위치를 큐에 추가
                    }
                }
            }

            // 고슴도치의 이동 처리
            len = q.size();
            for (int k = 0; k < len; k++) {
                int[] curInfo = q.poll();
                int x = curInfo[0];
                int y = curInfo[1];
                int minutes = curInfo[2]; // 현재까지 이동한 시간

                // 상하좌우로 이동하며 이동 가능한 경우를 처리
                for (int l = 0; l < 4; l++) {
                    int nx = x + dx[l];
                    int ny = y + dy[l];

                    if (isValid(nx, ny)) {
                        // 이동할 수 있는 빈 공간인 경우
                        if (map[nx][ny].equals(".")) {
                            map[nx][ny] = "S"; // 고슴도치 이동 표시
                            q.offer(new int[]{nx, ny, minutes + 1}); // 새로운 위치와 시간을 큐에 추가
                        }
                        // 도착 지점에 도달한 경우
                        else if (map[nx][ny].equals("D")) {
                            answer = Math.min(minutes + 1, answer); // 현재까지 걸린 시간과 이전에 저장된 최솟값 중 작은 값을 선택
                            return; // 탐색 종료
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new String[R][C];

        // 맵 초기화
        for (int i = 0; i < R; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                map[i][j] = split[j];
                if (map[i][j].equals("S")) {
                    q.offer(new int[]{i, j, 0}); // 고슴도치의 초기 위치를 큐에 추가
                } else if (map[i][j].equals("*")) {
                    water.offer(new int[]{i, j}); // 물의 초기 위치를 큐에 추가
                }
            }
        }

        // BFS 수행
        bfs();

        // 결과 출력
        System.out.println(answer == Integer.MAX_VALUE ? "KAKTUS" : answer);
    }
}
