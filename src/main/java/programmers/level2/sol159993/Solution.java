package programmers.level2.sol159993;

import java.util.*;

/**
 * 프로그래머스 미로 탈출 (Level 2) - BFS
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/159993
 */
class Solution {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static String[][] board; // 미로 지도
    static int[] dx = new int[]{-1, 0, 1, 0}; // 상하좌우 이동을 위한 x 방향 배열
    static int[] dy = new int[]{0, 1, 0, -1}; // 상하좌우 이동을 위한 y 방향 배열

    // 좌표가 유효한지 확인하는 메소드
    public boolean isValid(int x, int y) {
        return 0 <= x && x < board.length && 0 <= y && y < board[0].length;
    }

    // BFS 탐색을 통해 목표 지점까지의 최단 거리를 계산하는 메소드
    public int bfs(Point point, String target) {
        boolean[][] visited = new boolean[board.length][board[0].length]; // 방문 여부 체크 배열
        int[][] result = new int[board.length][board[0].length]; // 거리를 저장할 배열

        Queue<Point> q = new LinkedList<>(); // BFS 탐색을 위한 큐
        q.offer(point); // 시작 지점을 큐에 추가
        visited[point.x][point.y] = true; // 시작 지점 방문 체크

        while (!q.isEmpty()) {
            Point curPoint = q.poll(); // 큐에서 하나의 지점을 꺼냄

            // 상하좌우 이동을 위한 반복문
            for (int i = 0; i < 4; i++) {
                int nx = curPoint.x + dx[i]; // 이동 후 x 좌표
                int ny = curPoint.y + dy[i]; // 이동 후 y 좌표

                // 이동한 좌표가 유효하고, 벽이 아니며, 방문하지 않은 경우
                if (isValid(nx, ny) && !board[nx][ny].equals("X") && !visited[nx][ny]) {
                    visited[nx][ny] = true; // 방문 체크
                    q.offer(new Point(nx, ny)); // 큐에 이동한 지점 추가
                    result[nx][ny] = result[curPoint.x][curPoint.y] + 1; // 거리 갱신
                    if (board[nx][ny].equals(target)) { // 목표 지점에 도달한 경우
                        return result[nx][ny]; // 최단 거리 반환
                    }
                }
            }
        }
        return -1; // 목표 지점에 도달하지 못한 경우
    }

    // 미로를 탐색하고 결과를 반환하는 메소드
    public int solution(String[] maps) {
        board = new String[maps.length][maps[0].length()]; // 미로 지도 배열 초기화

        Point start = null; // 시작 지점
        Point labor = null; // 노동자의 위치

        // 미로 지도를 2차원 배열로 변환하면서 시작 지점과 노동자의 위치를 찾음
        for (int i = 0; i < maps.length; i++) {
            String[] tmp = maps[i].split(""); // 문자열을 배열로 분리
            for (int j = 0; j < maps[0].length(); j++) {
                board[i][j] = tmp[j]; // 미로 지도에 각각의 문자열 저장

                if (board[i][j].equals("S")) { // 시작 지점인 경우
                    start = new Point(i, j); // 시작 지점으로 설정
                }
                if (board[i][j].equals("L")) { // 노동자의 위치인 경우
                    labor = new Point(i, j); // 노동자의 위치로 설정
                }
            }
        }

        // 시작 지점부터 노동자의 위치까지의 최단 거리를 구함
        int ans1 = bfs(start, "L");
        // 노동자의 위치부터 출구까지의 최단 거리를 구함
        int ans2 = bfs(labor, "E");

        // 두 거리 중 하나라도 도달할 수 없는 경우 -1 반환
        if (ans1 == -1 || ans2 == -1) {
            return -1;
        }
        // 두 거리를 합쳐서 반환
        return ans1 + ans2;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new String[]{"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"}));
    }
}
