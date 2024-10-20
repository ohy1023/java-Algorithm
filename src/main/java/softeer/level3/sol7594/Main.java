package softeer.level3.sol7594;

import java.io.*;
import java.util.*;

/**
 * 소프티어 나무 조경 - DFS
 * https://softeer.ai/practice/7594
 */
public class Main {
    // 전역 변수 선언
    static int N, answer;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};  // 상, 우, 하, 좌 이동 배열
    static int[] dy = {0, 1, 0, -1};  // 상, 우, 하, 좌 이동 배열

    // DFS 함수
    public static void dfs(int depth, int sum, int maxDepth) {
        // 기저 조건: 최대 깊이에 도달하면 현재까지의 합과 비교하여 최대값 갱신
        if (depth == maxDepth) {
            answer = Math.max(answer, sum);
            return;
        }

        // 모든 좌표를 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 이미 방문한 경우 건너뜀
                if (visited[i][j]) continue;
                // 4방향 탐색
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    // 경계값 체크 및 방문 여부 체크
                    if (0 > nx || 0 > ny || nx >= N || ny >= N || visited[nx][ny]) continue;

                    // 현재 좌표와 다음 좌표를 방문 표시
                    visited[i][j] = true;
                    visited[nx][ny] = true;

                    // 다음 깊이로 DFS 호출
                    dfs(depth + 1, sum + board[i][j] + board[nx][ny], maxDepth);

                    // 백트래킹: 방문 표시 해제
                    visited[i][j] = false;
                    visited[nx][ny] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 보드 크기 입력
        N = Integer.parseInt(br.readLine());
        answer = -1;
        board = new int[N][N];
        visited = new boolean[N][N];

        // 보드 정보 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 최대 깊이 설정 (보드 크기에 따라 다름)
        int maxDepth = 4;
        if (N == 2) {
            maxDepth = 2;
        }

        // DFS 시작
        dfs(0, 0, maxDepth);

        // 결과 출력
        System.out.println(answer);
    }
}
