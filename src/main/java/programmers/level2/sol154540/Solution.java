package programmers.level2.sol154540;

import java.util.*;

/**
 * 프로그래머스 무인도 여행 (Level.2) - BFS
 * https://school.programmers.co.kr/learn/courses/30/lessons/154540
 */
class Solution {
    static int row, col;
    static char[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    /**
     * BFS를 이용하여 시작 지점부터 연결된 육지의 총 일수를 계산하는 메서드
     * @param a 시작 지점의 행 인덱스
     * @param b 시작 지점의 열 인덱스
     * @return 연결된 육지의 총 일수
     */
    public static int bfs(int a, int b) {
        int day = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{a, b});
        visited[a][b] = true;

        while (!q.isEmpty()) {
            int[] curPoint = q.poll();
            int x = curPoint[0];
            int y = curPoint[1];

            // 해당 위치의 육지에 표시된 일수를 누적
            day += Character.getNumericValue(board[x][y]);

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 유효한 범위 내에 있고, 방문하지 않았으며, 육지인 경우 탐색 진행
                if (0 <= nx && nx < col && 0 <= ny && ny < row && !visited[nx][ny] && board[nx][ny] != 'X') {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        return day;
    }

    /**
     * 주어진 지도에서 각 연결된 육지의 총 일수를 구하는 메서드
     * @param maps 입력으로 주어진 지도 배열
     * @return 각 연결된 육지의 총 일수 리스트
     */
    public List<Integer> solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();

        row = maps[0].length();
        col = maps.length;

        board = new char[col][row];
        visited = new boolean[col][row];

        // 문자열 형태의 지도를 2차원 char 배열로 변환
        for (int i = 0; i < col; i++) {
            board[i] = maps[i].toCharArray();
        }

        // 모든 지점을 방문하면서 육지인 경우 BFS 탐색을 수행하여 연결된 육지의 총 일수를 구함
        for (int j = 0; j < col; j++) {
            for (int k = 0; k < row; k++) {
                if (!visited[j][k] && board[j][k] != 'X') {
                    answer.add(bfs(j, k));
                }
            }
        }

        // 육지가 없는 경우 -1을 추가
        if (answer.isEmpty()) answer.add(-1);

        // 결과를 오름차순으로 정렬
        Collections.sort(answer);

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 예시 입력에 대한 결과 출력
        List<Integer> result = s.solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"});
        for (int r : result) {
            System.out.print(r + " ");
        }
    }
}
