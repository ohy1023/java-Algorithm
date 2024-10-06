package baekjoon.Implementation;

import java.io.*;
import java.util.*;

/**
 * 백준 14891 톱니바퀴 (골드 5) - 구현
 * https://www.acmicpc.net/problem/14891
 */
public class BOJ14891 {

    static int[][] gear; // 톱니바퀴 정보를 저장할 배열

    // 톱니바퀴를 돌리는 메서드
    public static void operateGear(int gearN, int direction) {
        // 왼쪽 톱니바퀴 돌리기
        leftGear(gearN - 1, -direction);
        // 오른쪽 톱니바퀴 돌리기
        rightGear(gearN + 1, -direction);
        // 현재 톱니바퀴 돌리기
        turn(gearN, direction);
    }

    // 왼쪽 톱니바퀴 돌리는 메서드
    public static void leftGear(int gearN, int direction) {
        if (gearN < 0) return;
        if (gear[gearN][2] == gear[gearN + 1][6]) return;

        leftGear(gearN - 1, -direction);
        turn(gearN, direction);
    }

    // 오른쪽 톱니바퀴 돌리는 메서드
    public static void rightGear(int gearN, int direction) {
        if (gearN > 3) return;
        if (gear[gearN][6] == gear[gearN - 1][2]) return;
        rightGear(gearN + 1, -direction);
        turn(gearN, direction);
    }

    // 톱니바퀴를 회전시키는 메서드
    public static void turn(int gearN, int direction) {
        if (direction == 1) {
            int tmp = gear[gearN][7];
            for (int i = 7; i > 0; i--) {
                gear[gearN][i] = gear[gearN][i - 1];
            }
            gear[gearN][0] = tmp;
        } else {
            int tmp = gear[gearN][0];
            for (int i = 0; i < 7; i++) {
                gear[gearN][i] = gear[gearN][i + 1];
            }
            gear[gearN][7] = tmp;
        }
    }

    // 점수 계산 메서드
    public static int calcScore() {
        int score = 0;
        for (int i = 0; i < 4; i++) {
            if (gear[i][0] == 1) {
                score += Math.pow(2, i);
            }
        }
        return score;
    }

    public static void main(String[] args) throws IOException {
        gear = new int[4][8];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 톱니바퀴 정보 입력
        for (int i = 0; i < 4; i++) {
            String[] gearInfo = br.readLine().split("");
            for (int j = 0; j < 8; j++) {
                gear[i][j] = Integer.parseInt(gearInfo[j]);
            }
        }

        int K = Integer.parseInt(br.readLine());

        // 톱니바퀴 회전 연산 수행
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int gearN = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());
            operateGear(gearN, direction);
        }

        // 결과 출력
        System.out.println(calcScore());
    }
}
