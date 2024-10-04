package baekjoon.Implementation;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 14889 스타트와 링크 (실버 1) - 구현
 * https://www.acmicpc.net/problem/14889
 */
public class BOJ14889 {

    // 변수 선언
    static int N, answer;
    static boolean[] visited;
    static int[][] board;

    // 두 팀의 점수 차이를 계산하는 메서드
    public int calcDiffScore() {
        int score1 = 0;
        int score2 = 0;

        // 모든 쌍에 대해 점수를 계산
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (visited[i] && visited[j]) {
                    score1 += board[i][j];
                } else if (!visited[i] && !visited[j]) {
                    score2 += board[i][j];
                }
            }
        }

        // 두 팀의 점수 차이를 반환
        return Math.abs(score2 - score1);
    }

    // 재귀적으로 팀을 나누는 메서드
    public void recurse(int idx, int depth) {
        // N/2명의 팀원이 선택된 경우 점수 차이 계산
        if (depth == N / 2) {
            answer = Math.min(answer, calcDiffScore());
            return;
        }

        // 재귀 호출을 통해 팀을 나눔
        for (int i = idx; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                recurse(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    // 문제 해결 메서드
    public int solution() {
        answer = Integer.MAX_VALUE;

        visited = new boolean[N + 1];

        recurse(1, 0);

        return answer;
    }

    // 메인 메서드
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N + 1][N + 1];

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        BOJ14889 s = new BOJ14889();
        System.out.println(s.solution());
    }
}
