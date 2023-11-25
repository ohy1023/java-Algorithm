package inflearn.section_07.bfs.미로의_최단거리_통로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 인프런 미로의 최단거리 통로 - BFS
 */

// Point 클래스 정의 (좌표를 저장하는 클래스)
class Point {
    public int x, y;

    // 생성자
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    // 상, 우, 하, 좌로 이동하는 배열
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    // 미로의 상태를 나타내는 2차원 배열
    static int[][] board, dis;

    // BFS 메서드
    public void BFS(int x, int y) {
        // 큐를 생성하고 시작점을 추가
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        // 시작점을 방문했다고 표시
        board[x][y] = 1;

        // BFS 탐색
        while (!queue.isEmpty()) {
            // 큐에서 한 점을 꺼냄
            Point point = queue.poll();

            // 상, 우, 하, 좌로 이동
            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                // 미로의 범위를 벗어나지 않고, 이동하려는 칸이 벽이 아닌 경우
                if (1 <= nx && nx <= 7 && 1 <= ny && ny <= 7 && board[nx][ny] == 0) {
                    // 이동하려는 칸을 방문했다고 표시
                    board[nx][ny] = 1;
                    // 큐에 이동한 칸 추가
                    queue.offer(new Point(nx, ny));
                    // 시작점으로부터의 거리를 계산하여 저장
                    dis[nx][ny] = dis[point.x][point.y] + 1;
                }
            }
        }
    }

    // 메인 메서드
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 미로의 상태를 나타내는 2차원 배열과 거리 정보를 저장하는 배열 초기화
        board = new int[8][8];
        dis = new int[8][8];

        // 미로의 상태 입력 받기
        for (int i = 1; i <= 7; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 7; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // Main 객체 생성
        Main main = new Main();

        // BFS로 미로를 탐색하고, 도착점까지의 최단 거리 출력
        main.BFS(1, 1);

        // 도착점에 도달할 수 없는 경우 -1 출력, 그렇지 않으면 최단 거리 출력
        if (dis[7][7] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(dis[7][7]);
        }
    }
}
