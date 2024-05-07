package baekjoon.bfs;

import java.io.*;
import java.util.*;

/**
 * 백준 4179 불! (골드 4)
 * https://www.acmicpc.net/problem/4179
 */
public class BOJ4179_2 {

    static int R, C;
    static char[][] map;
    static int[][] fire; // 불의 확산 시간을 기록하는 배열
    static int[][] trace; // 지훈이의 이동 시간을 기록하는 배열
    static Queue<Point> jq; // 지훈이의 위치를 저장하는 큐
    static Queue<Point> fq; // 불의 위치를 저장하는 큐
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};

    // 좌표를 표현하는 클래스
    public static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // 불이 확산할 수 있는지 확인하는 메서드
    public static boolean canGoFire(int nx, int ny) {
        if (nx < 0 || ny < 0 || nx >= R || ny >= C) return false; // 맵을 벗어나는 경우
        if (map[nx][ny] == '#') return false; // 벽인 경우
        return fire[nx][ny] == Integer.MAX_VALUE; // 불이 아직 확산되지 않은 공간인 경우
    }

    // 지훈이가 이동할 수 있는지 확인하는 메서드
    public static boolean canGoJihun(int nx, int ny, int x, int y) {
        if (nx < 0 || ny < 0 || nx >= R || ny >= C) return false; // 맵을 벗어나는 경우
        if (map[nx][ny] == '#') return false; // 벽인 경우
        if (trace[nx][ny] != 0) return false; // 이미 지나간 경로인 경우
        return fire[nx][ny] > trace[x][y] + 1; // 불의 확산 시간보다 더 빨리 도착할 수 있는 경우
    }

    // 탈출 가능 여부를 확인하는 메서드
    public static boolean isExit(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= R || ny >= C; // 맵을 벗어나는 경우 (탈출 가능)
    }

    // 불의 확산을 계산하는 BFS 메서드
    public static void fireBfs() {
        while (!fq.isEmpty()) {
            Point curPoint = fq.poll();
            int x = curPoint.x;
            int y = curPoint.y;

            // 상하좌우로 불을 확산시킴
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (canGoFire(nx, ny)) {
                    fire[nx][ny] = fire[x][y] + 1;
                    fq.offer(new Point(nx, ny));
                }
            }
        }
    }

    // 지훈이의 이동을 계산하는 BFS 메서드
    public static void jihunBfs() {
        while (!jq.isEmpty()) {
            Point curPoint = jq.poll();
            int x = curPoint.x;
            int y = curPoint.y;

            // 상하좌우로 지훈이를 이동시킴
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (canGoJihun(nx, ny, x, y)) {
                    trace[nx][ny] = trace[x][y] + 1;
                    jq.offer(new Point(nx, ny));
                } else if (isExit(nx, ny)) {
                    System.out.println(trace[x][y]);
                    return;
                }
            }
        }
        System.out.println("IMPOSSIBLE"); // 탈출할 수 없는 경우
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        map = new char[R][C];
        fire = new int[R][C]; // 불의 확산 시간을 저장할 배열
        trace = new int[R][C]; // 지훈이의 이동 시간을 저장할 배열

        jq = new LinkedList<>();
        fq = new LinkedList<>();

        // 맵 정보 입력
        for (int i = 0; i < R; i++) {
            String info = br.readLine();
            for (int j = 0; j < C; j++) {
                fire[i][j] = Integer.MAX_VALUE; // 불의 확산 시간 초기화
                map[i][j] = info.charAt(j);
                if (map[i][j] == 'F') {
                    fq.offer(new Point(i, j)); // 불의 위치 큐에 추가
                    fire[i][j] = 1; // 불의 확산 시간 초기화
                } else if (map[i][j] == 'J') {
                    jq.offer(new Point(i, j)); // 지훈이의 위치 큐에 추가
                    trace[i][j] = 1; // 지훈이의 이동 시간 초기화
                }
            }
        }

        fireBfs(); // 불의 확산 계산
        jihunBfs(); // 지훈이의 이동 계산
    }
}