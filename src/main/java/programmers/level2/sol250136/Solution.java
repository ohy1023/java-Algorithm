package programmers.level2.sol250136;

import java.awt.*;
import java.util.*;

/**
 * 프로그래머스 석유 시추 (Level 2) - BFS
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/250136?language=java
 */
class Solution {

    static int row, col;
    static int[][] fragments; // 각 섬의 번호를 저장하는 배열
    static Map<Integer, Integer> fragmentsInfo = new HashMap<>(); // 각 섬의 크기를 저장하는 맵
    static boolean[][] visited; // 방문 여부를 저장하는 배열
    static int fragmentIdx = 1; // 섬의 번호를 할당하기 위한 인덱스
    static int[] dx = new int[]{-1, 0, 1, 0}; // 상하좌우 이동을 위한 배열
    static int[] dy = new int[]{0, 1, 0, -1}; // 상하좌우 이동을 위한 배열

    // 섬을 탐색하고 각 섬의 번호와 크기를 저장하는 메소드
    public void exploreIsland(int x, int y, int[][] land) {
        Point start = new Point(x, y);
        visited[x][y] = true;
        fragments[x][y] = fragmentIdx; // 현재 위치의 섬 번호 설정
        int landCount = 0; // 섬의 크기를 저장할 변수

        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            landCount++;
            x = current.x;
            y = current.y;

            // 상하좌우로 이동하면서 섬을 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 이동한 위치가 유효하고, 방문하지 않았고, 육지(1)인 경우 탐색 진행
                if (isValid(nx, ny) && !visited[nx][ny] && land[nx][ny] == 1) {
                    visited[nx][ny] = true; // 방문 표시
                    fragments[nx][ny] = fragmentIdx; // 섬 번호 설정
                    queue.offer(new Point(nx, ny)); // 큐에 추가하여 다음 탐색 진행
                }
            }
        }

        fragmentsInfo.put(fragmentIdx++, landCount); // 섬의 번호와 크기 저장
    }

    // 주어진 좌표가 유효한 범위에 속하는지 확인하는 메소드
    private boolean isValid(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }

    // 석유 시추 결과를 반환하는 메소드
    public int solution(int[][] land) {
        int maxLandCount = 0;
        row = land.length;
        col = land[0].length;
        fragments = new int[row][col];
        visited = new boolean[row][col];

        // 모든 육지를 탐색하며 섬의 번호와 크기를 구함
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (land[r][c] == 1 && !visited[r][c]) {
                    exploreIsland(r, c, land);
                }
            }
        }

        // 각 열마다 각 섬의 크기를 확인하여 최대 석유 시추량을 구함
        for (int c = 0; c < col; c++) {
            Set<Integer> fragmentTypes = new HashSet<>();
            int tmpMaxAmount = 0;
            for (int r = 0; r < row; r++) {
                if (fragments[r][c] > 0) {
                    fragmentTypes.add(fragments[r][c]); // 해당 열에 있는 섬의 번호 추가
                }
            }

            // 각 섬의 크기를 합하여 최대 석유 시추량을 계산
            for (Integer frg : fragmentTypes) {
                tmpMaxAmount += fragmentsInfo.get(frg);
            }

            maxLandCount = Math.max(maxLandCount, tmpMaxAmount);
        }
        return maxLandCount;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] land = {
                {0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {1, 1, 0, 0, 0, 1, 1, 0},
                {1, 1, 1, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 1, 1}
        };
        System.out.println(s.solution(land)); // 결과 출력
    }
}
