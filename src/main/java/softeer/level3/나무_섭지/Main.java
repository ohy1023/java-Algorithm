package softeer.level3.나무_섭지;

import java.io.*;
import java.util.*;

/**
 * 나무 섭지 (Level.3) - BFS
 * https://softeer.ai/practice/7726
 */
public class Main {
    static int n, m;
    static char[][] map;
    static int[][] visited;
    static int[][] trace;
    static Queue<int[]> namwoo = new LinkedList<>();
    static Queue<int[]> ghost = new LinkedList<>();
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    static final int INF = Integer.MAX_VALUE;

    // 고스트가 이동 가능한지 확인하는 메서드
    public static boolean canGoGhost(int nx, int ny) {
        if (nx < 0 || ny < 0 || nx >= n || ny >= m) return false;
        return visited[nx][ny] == INF;
    }

    // 남우가 이동 가능한지 확인하는 메서드
    static boolean canGoNamwoo(int x, int y, int nx, int ny) {
        if (nx < 0 || ny < 0 || nx >= n || ny >= m) return false;
        if (map[nx][ny] == '#') return false;
        if (trace[nx][ny] > 0) return false;
        return visited[nx][ny] > trace[x][y] + 1;
    }

    // 고스트의 BFS 탐색 메서드
    public static void bfsGhost() {
        while (!ghost.isEmpty()) {
            int[] curGhostCoordinate = ghost.poll();
            int x = curGhostCoordinate[0];
            int y = curGhostCoordinate[1];

            // 상하좌우 이동을 위한 반복문
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 이동 가능한 위치이고 방문하지 않았다면
                if (canGoGhost(nx, ny)) {
                    // 방문 표시 및 큐에 추가
                    visited[nx][ny] = visited[x][y] + 1;
                    ghost.offer(new int[]{nx, ny});
                }
            }
        }
    }

    // 남우의 BFS 탐색 메서드
    public static boolean bfsNamwoo() {
        while (!namwoo.isEmpty()) {
            int[] curNamwooCoordinate = namwoo.poll();
            int x = curNamwooCoordinate[0];
            int y = curNamwooCoordinate[1];

            // 상하좌우 이동을 위한 반복문
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 이동 가능한 위치이고 이동할 수 있다면
                if (canGoNamwoo(x, y, nx, ny)) {
                    // 경로 표시 및 큐에 추가
                    trace[nx][ny] = trace[x][y] + 1;
                    namwoo.offer(new int[]{nx, ny});
                    // 목적지인 'D'에 도달했다면 true 반환
                    if (map[nx][ny] == 'D') {
                        return true;
                    }
                }
            }
        }
        // 목적지에 도달하지 못했다면 false 반환
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        trace = new int[n][m];
        visited = new int[n][m];

        // 초기화
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], INF);
        }

        // 입력 받기
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
                // 시작 위치 및 고스트 위치 큐에 추가
                if (map[i][j] == 'N') {
                    namwoo.offer(new int[]{i, j});
                    trace[i][j] = 1;
                } else if (map[i][j] == 'G') {
                    ghost.offer(new int[]{i, j});
                    visited[i][j] = 1;
                }
            }
        }

        // 고스트의 이동 경로 탐색
        bfsGhost();
        // 남우의 이동 경로 탐색 및 탈출 여부 확인
        boolean isEscape = bfsNamwoo();

        // 결과 출력
        if (isEscape) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
