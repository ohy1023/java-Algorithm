package baekjoon.dijkstra;

import java.io.*;
import java.util.*;

/**
 * 백준 4485 녹색 옷 입은 애가 젤다지? (골드 4) - 데이크스트라
 * https://www.acmicpc.net/problem/4485
 */
public class BOJ4485 {
    static int N; // 미로의 크기
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동을 위한 배열
    static int[] dy = {0, 0, -1, 1};
    static int[][] board; // 미로 정보 저장 배열

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    // 녹색 옷 입은 애가 젤다의 최단 거리를 구하는 메소드
    public static int bfs() {
        Queue<Node> pq = new PriorityQueue<>(); // 우선순위 큐를 이용한 데이크스트라 진행
        int[][] move = new int[N][N]; // 각 지점까지의 최소 비용을 저장할 배열 초기화
        for (int i = 0; i < N; i++) {
            Arrays.fill(move[i], Integer.MAX_VALUE); // 최대값으로 초기화
        }
        pq.offer(new Node(0, 0, board[0][0])); // 시작 지점을 큐에 삽입
        move[0][0] = board[0][0]; // 시작 지점의 비용을 갱신

        // 데이크스트라 알고리즘 수행
        while (!pq.isEmpty()) {
            Node cur = pq.poll(); // 현재 위치와 비용 정보를 가져옴
            int cx = cur.x;
            int cy = cur.y;
            int cost = cur.cost;

            // 도착 지점에 도달하면 최소 비용 반환
            if (cx == N - 1 && cy == N - 1) {
                return cost;
            }

            // 상하좌우로 이동하며 최소 비용 갱신
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // 미로를 벗어나지 않고 비용이 갱신되어야 할 경우
                if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                    if (move[nx][ny] > board[nx][ny] + cost) {
                        move[nx][ny] = board[nx][ny] + cost; // 최소 비용 갱신
                        pq.offer(new Node(nx, ny, move[nx][ny])); // 큐에 새로운 위치 정보 삽입
                    }
                }
            }
        }
        return -1; // 도착 지점까지 도달할 수 없는 경우
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int problemNo = 1;
        while (true) {
            N = Integer.parseInt(br.readLine()); // 미로의 크기 입력
            if (N == 0) {
                break; // 종료 조건
            }

            board = new int[N][N]; // 미로 정보 배열 초기화

            // 미로 정보 입력
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = bfs(); // 최단 거리 계산
            sb.append("Problem ").append(problemNo++).append(": ").append(result).append("\n"); // 결과 저장
        }

        System.out.println(sb); // 결과 출력
    }
}
