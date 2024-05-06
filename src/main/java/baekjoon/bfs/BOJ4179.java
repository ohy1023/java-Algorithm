package baekjoon.bfs;

import java.io.*;
import java.util.*;

/**
 * 백준 4179 불! (골드 4)
 * https://www.acmicpc.net/problem/4179
 */
public class BOJ4179 {

    static int R, C, answer;
    static char[][] map;
    static Queue<int[]> jq; // 지훈이의 위치를 저장하는 큐
    static Queue<int[]> fq; // 불의 위치를 저장하는 큐

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};

    // 지정된 위치로 이동할 수 있는지 여부를 확인하는 메서드
    static boolean canGo(int nx, int ny) {
        if (IsValid(nx, ny)) return false; // 맵을 벗어나는 경우 이동할 수 없음
        return map[nx][ny] == '.'; // 해당 위치가 빈 공간인 경우 이동할 수 있음
    }

    // 주어진 위치가 맵을 벗어나는지 여부를 확인하는 메서드
    private static boolean IsValid(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= R || ny >= C; // 주어진 위치가 맵을 벗어나는 경우 true 반환
    }

    // BFS를 통해 최단 시간을 구하는 메서드
    public static void bfs() {
        answer = Integer.MAX_VALUE; // 초기화
        while (!jq.isEmpty()) { // 지훈이의 위치를 큐에 모두 탐색할 때까지 반복
            int fs = fq.size(); // 현재 불의 큐 사이즈

            // 불의 위치를 이동시키는 과정
            for (int i = 0; i < fs; i++) {
                int[] curFire = fq.poll();
                int x = curFire[0];
                int y = curFire[1];

                // 불을 상하좌우로 이동시키며 이동 가능한 위치를 불로 채움
                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (canGo(nx, ny)) {
                        map[nx][ny] = 'F'; // 불로 채움
                        fq.offer(new int[]{nx, ny}); // 이동한 위치를 큐에 추가
                    }
                }
            }

            int js = jq.size(); // 현재 지훈이의 큐 사이즈

            // 지훈이의 위치를 이동시키는 과정
            for (int k = 0; k < js; k++) {
                int[] curJiHun = jq.poll();
                int x = curJiHun[0];
                int y = curJiHun[1];
                int minutes = curJiHun[2];

                // 지훈이를 상하좌우로 이동시키며 이동 가능한 위치를 탐색
                for (int l = 0; l < 4; l++) {
                    int nx = x + dx[l];
                    int ny = y + dy[l];

                    if (canGo(nx, ny)) {
                        map[nx][ny] = 'J'; // 지훈이로 채움
                        jq.offer(new int[]{nx, ny, minutes + 1}); // 이동한 위치와 시간을 큐에 추가
                    } else if (IsValid(nx, ny)) {
                        answer = Math.min(answer, minutes + 1); // 탈출하는 경우 최단 시간 갱신
                        return;
                    }
                }
            }
        }
    }

    // 메인 메서드
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]); // 행 개수 입력
        C = Integer.parseInt(input[1]); // 열 개수 입력

        map = new char[R][C]; // 맵 초기화
        jq = new LinkedList<>(); // 지훈이의 위치를 저장하는 큐 초기화
        fq = new LinkedList<>(); // 불의 위치를 저장하는 큐 초기화

        // 맵 정보 입력
        for (int i = 0; i < R; i++) {
            String info = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = info.charAt(j); // 각 위치의 정보 입력
                if (map[i][j] == 'F') fq.offer(new int[]{i, j}); // 불의 위치인 경우 큐에 추가
                else if (map[i][j] == 'J') jq.offer(new int[]{i, j, 0}); // 지훈이의 위치인 경우 큐에 추가
            }
        }

        bfs(); // BFS 탐색 실행

        // 결과 출력
        if (answer == Integer.MAX_VALUE) sb.append("IMPOSSIBLE\n");
        else sb.append(answer).append("\n");

        System.out.println(sb); // 결과 출력
    }
}
