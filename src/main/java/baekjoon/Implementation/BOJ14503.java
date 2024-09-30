package baekjoon.Implementation;

import java.io.*;
import java.util.*;

/**
 * 백준 14503 로봇 청소기 (골드 5) - 구현
 * https://www.acmicpc.net/problem/14503
 */
public class BOJ14503 {

    // 변수 선언
    static int N, M, r, c, d, answer;
    static int[][] board;
    // 방향 배열: 북(0), 동(1), 남(2), 서(3)
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    // 청소 함수
    public static void clean(int x, int y, int d) {
        // 현재 위치를 청소한 상태(2)로 표시
        board[x][y] = 2;

        // 4방향 탐색
        for (int i = 0; i < 4; i++) {
            // 왼쪽으로 회전
            d = (d + 3) % 4;

            int nx = x + dx[d];
            int ny = y + dy[d];

            // 범위 벗어나는 경우 무시
            if (0 > nx || 0 > ny || nx >= N || ny >= M) continue;

            // 청소되지 않은 공간이 있는 경우
            if (board[nx][ny] == 0) {
                answer++; // 청소한 공간의 수 증가
                clean(nx, ny, d); // 다음 위치 청소
                return;
            }
        }

        // 후진하는 방향 계산
        int back = (d + 2) % 4;
        int bx = x + dx[back];
        int by = y + dy[back];
        // 후진할 수 있는 경우 후진
        if (bx >= 0 && by >= 0 && bx < N && by < M && board[bx][by] != 1) {
            clean(bx, by, d);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력 값 파싱
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        // 보드 초기화
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = 1; // 시작 위치도 청소한 상태로 카운트

        clean(r, c, d); // 청소 시작

        System.out.println(answer); // 결과 출력
    }
}
