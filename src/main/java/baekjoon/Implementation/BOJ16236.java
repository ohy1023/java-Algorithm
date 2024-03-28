package baekjoon.Implementation;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 골드 3 아기 상어 - 구현
 * https://www.acmicpc.net/problem/16236
 */
public class BOJ16236 {

    static int[][] graph, dist;

    static int N;

    static int size = 2; // 상어 사이즈
    static int eat = 0; // 상어가 물고기 먹은 횟수
    static int cnt = 0; // 상어가 이동한 횟수
    static int sx = -1; // 상어의 X 좌표
    static int sy = -1; // 상어의 Y 좌표
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int minX, minY, minDist; // while문 탈출 조건으로 쓸 변수

    public static void bfs(Point p) {
        Queue<Point> queue = new LinkedList<>();

        queue.offer(p);

        while (!queue.isEmpty()) {
            Point curPoint = queue.poll();
            int x = curPoint.x;
            int y = curPoint.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < N && graph[nx][ny] <= size && dist[nx][ny] == 0) {
                    dist[nx][ny] = dist[x][y] + 1;

                    if (graph[nx][ny] != 0 && graph[nx][ny] < size) {
                        if (minDist > dist[nx][ny]) {
                            minDist = dist[nx][ny];
                            minX = nx;
                            minY = ny;
                        } else if (minDist == dist[nx][ny]) {
                            if (minX == nx) {
                                if (minY > ny) {
                                    minX = nx;
                                    minY = ny;
                                }
                            } else if (minX > nx) {
                                minX = nx;
                                minY = ny;
                            }
                        }
                    }
                    queue.offer(new Point(nx, ny));
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());

                if (graph[i][j] == 9) {
                    sx = i;
                    sy = j;
                    graph[i][j] = 0; // 상어가 있었던 위치도 이 후로 탐색해야 하므로 0으로 초기화
                }
            }
        }


        while (true) {
            dist = new int[N][N];
            minX = Integer.MAX_VALUE; // 상어에서 가장 가까이 있는 물고기 X좌표
            minY = Integer.MAX_VALUE; // 상어에서 가장 가까이 있는 물고기 Y좌표
            minDist = Integer.MAX_VALUE; // 상어에서 가장 가까이 있는 물고기 거리

            bfs(new Point(sx, sy));

            if (minX != Integer.MAX_VALUE && minY != Integer.MAX_VALUE) {
                sx = minX;
                sy = minY;
                graph[minX][minY] = 0;
                eat++;
                cnt += dist[minX][minY];

                if (eat == size) {
                    size++;
                    eat = 0;
                }
            } else {
                break;
            }
        }
        System.out.println(cnt);
    }
}
