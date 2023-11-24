package inflearn.section_07.dfs.미로탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 인프런 미로탐색 - DFS
 */
public class Main {

    // 정답을 저장하는 변수
    static int answer = 0;

    // 상, 우, 하, 좌로 이동하는 배열
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    // 미로의 상태를 나타내는 2차원 배열
    static int[][] board;

    // 깊이 우선 탐색 (DFS) 메서드
    public void DFS(int x, int y) {
        // 목적지인 (7, 7)에 도달했을 경우
        if (x == 7 && y == 7) {
            // 정답을 1 증가시킴
            answer++;
        }

        // 상, 우, 하, 좌로 이동
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 미로의 범위를 벗어나지 않고, 이동하려는 칸이 벽이 아닌 경우
            if (1 <= nx && nx <= 7 && 1 <= ny && ny <= 7 && board[nx][ny] == 0) {
                // 이동하려는 칸을 방문했다고 표시
                board[nx][ny] = 1;
                // 다음 칸으로 이동
                DFS(nx, ny);
                // 이동한 칸을 초기화 (다른 경로에서 이 칸을 방문할 수 있도록)
                board[nx][ny] = 0;
            }
        }
    }

    // 미로를 탐색하고 찾은 경로의 개수를 반환하는 메서드
    public int solution(int[][] board) {
        // 시작 지점을 방문했다고 표시
        board[1][1] = 1;

        // DFS 탐색 시작
        DFS(1, 1);

        // 찾은 경로의 개수 반환
        return answer;
    }

    // 메인 메서드
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 미로의 상태를 나타내는 2차원 배열 초기화
        board = new int[8][8];

        // 미로의 상태 입력 받기
        for (int i = 1; i <= 7; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 7; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // Main 객체 생성
        Main main = new Main();

        // 미로를 탐색하고 찾은 경로의 개수 출력
        System.out.println(main.solution(board));
    }
}
