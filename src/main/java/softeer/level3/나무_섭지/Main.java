package softeer.level3.나무_섭지;

import java.io.*;
import java.util.*;

/**
 * 소프티어 나무 섭지 (Level.3) - BFS
 * https://softeer.ai/practice/7726
 */
public class Main {
    static int n, m; // 맵의 크기
    static char[][] board; // 맵 정보
    static int[][] namwooVisited; // 남우의 이동 경로 기록
    static int[][] ghostVisited; // 고스트의 이동 경로 기록
    static Queue<int[]> namwoo = new LinkedList<>(); // 남우의 BFS 큐
    static Queue<int[]> ghost = new LinkedList<>(); // 고스트의 BFS 큐
    static int[] dx = new int[]{-1, 0, 1, 0}; // 방향 배열 (상, 좌, 하, 우)
    static int[] dy = new int[]{0, -1, 0, 1}; // 방향 배열 (상, 좌, 하, 우)

    // 고스트의 BFS
    public static void ghostBfs() {
        while (!ghost.isEmpty()) {
            int[] ghostCoord = ghost.poll();
            int x = ghostCoord[0];
            int y = ghostCoord[1];

            for (int i = 0; i < 4; i++) {
                int gx = x + dx[i];
                int gy = y + dy[i];

                if (gx < 0 || gy < 0 || gx >= n || gy >= m) continue; // 범위를 벗어나면 무시
                if (ghostVisited[gx][gy] > 0) continue; // 이미 방문한 곳이면 무시
                ghost.offer(new int[]{gx, gy}); // 큐에 추가
                ghostVisited[gx][gy] = ghostVisited[x][y] + 1; // 이동 거리 기록
            }
        }
    }

    // 남우의 BFS
    public static boolean namwooBfs() {
        while (!namwoo.isEmpty()) {
            int[] namwooCoord = namwoo.poll();
            int x = namwooCoord[0];
            int y = namwooCoord[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue; // 범위를 벗어나면 무시
                if (board[nx][ny] == '#') continue; // 벽이면 무시
                if (namwooVisited[nx][ny] > 0) continue; // 이미 방문한 곳이면 무시
                if (namwooVisited[x][y] + 1 >= ghostVisited[nx][ny]) continue; // 고스트가 도착할 곳이면 무시
                namwoo.offer(new int[]{nx, ny}); // 큐에 추가
                namwooVisited[nx][ny] = namwooVisited[x][y] + 1; // 이동 거리 기록

                if (board[nx][ny] == 'D') return true; // 도착 지점에 도달하면 true 반환
            }
        }

        return false; // 탈출 실패
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        ghostVisited = new int[n][m];
        namwooVisited = new int[n][m];

        for (int i = 0; i < n; i++) {
            char[] info = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                board[i][j] = info[j];
                if (board[i][j] == 'G') { // 고스트의 위치
                    ghost.offer(new int[]{i, j});
                    ghostVisited[i][j] = 1;
                } else if (board[i][j] == 'N') { // 남우의 위치
                    namwoo.offer(new int[]{i, j});
                    namwooVisited[i][j] = 1;
                }
            }
        }

        ghostBfs(); // 고스트의 BFS 실행

        boolean isEscape = namwooBfs(); // 남우의 BFS 실행

        if (isEscape) {
            System.out.println("Yes"); // 탈출 성공
        } else {
            System.out.println("No"); // 탈출 실패
        }
    }
}
