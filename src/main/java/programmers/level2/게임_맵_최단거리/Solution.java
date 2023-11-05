package programmers.level2.게임_맵_최단거리;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 프로그래머스 level 2 게임 맵 최단거리 - BFS
 * https://school.programmers.co.kr/learn/courses/30/lessons/1844?language=python3
 */
class Solution {

    /**
     * BFS를 사용하여 최단 거리를 계산하는 메서드
     *
     * @param x    시작 지점의 x 좌표
     * @param y    시작 지점의 y 좌표
     * @param maps 게임 맵을 나타내는 2D 배열
     * @return 시작 지점에서 목적지까지의 최단 거리
     */
    public int bfs(int x, int y, int[][] maps) {
        int[] dx = {-1, 0, 1, 0}; // 상, 우, 하, 좌 방향을 나타내는 배열
        int[] dy = {0, 1, 0, -1};

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y)); // 시작 지점을 큐에 추가

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            x = point.x;
            y = point.y;

            for (int i = 0; i < 4; i++) { // 상, 우, 하, 좌 방향에 대해서 탐색
                int nx = x + dx[i]; // 다음 x 좌표
                int ny = y + dy[i]; // 다음 y 좌표

                if (0 <= nx && nx < maps.length && 0 <= ny && ny < maps[0].length && maps[nx][ny] == 1) {
                    // 다음 위치가 유효하고 갈 수 있는 위치일 경우
                    maps[nx][ny] = maps[x][y] + 1; // 거리 업데이트
                    queue.offer(new Point(nx, ny)); // 다음 위치를 큐에 추가
                }
            }
        }
        return maps[maps.length - 1][maps[0].length - 1]; // 목적지까지의 최단 거리 반환
    }

    /**
     * 게임 맵의 시작점에서 목적지까지의 최단 거리를 계산하는 메서드
     *
     * @param maps 게임 맵을 나타내는 2D 배열
     * @return 시작 지점에서 목적지까지의 최단 거리
     */
    public int solution(int[][] maps) {
        int answer = bfs(0, 0, maps);

        return (answer == 1) ? -1 : answer; // 만약 시작 지점에서 목적지까지 갈 수 없으면 -1을 반환
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}));
    }
}
