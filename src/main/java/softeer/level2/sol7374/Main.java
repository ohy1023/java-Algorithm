package softeer.level2.sol7374;

import java.io.*;
import java.util.*;

/**
 * 소프티어 진정한 효도 (Level.2)
 * https://softeer.ai/practice/7374
 */
public class Main {

    /**
     * 주어진 세 수 a, b, c에 대해 중간값을 구하고, 각 숫자와 중간값과의 차이의 절대값을 모두 더한 값을 반환하는 메서드.
     *
     * @param a 첫 번째 숫자
     * @param b 두 번째 숫자
     * @param c 세 번째 숫자
     * @return a, b, c를 중간값으로 만드는 데 필요한 비용
     */
    public static int calcCost(int a, int b, int c) {
        // 중간값 계산
        int value = a + b + c - Math.min(Math.min(a, b), c) - Math.max(Math.max(a, b), c);
        // 각 숫자와 중간값과의 차이의 절대값을 모두 더한 비용 반환
        return Math.abs(value - a) + Math.abs(value - b) + Math.abs(value - c);
    }

    // 최빈값을 활용한 비용 계산
    public static int calcCostByCheckArr(int a, int b, int c) {
        // 높이 개수를 저장할 배열
        int[] count = new int[4];

        // 개수 세기
        count[a]++;
        count[b]++;
        count[c]++;

        // 가장 많이 나온 값 찾기
        int maxCount = 0;
        for (int i = 1; i <= 3; i++) {
            if (count[i] > count[maxCount]) {
                maxCount = i;
            }
        }

        // 비용 계산
        return Math.abs(maxCount - a) + Math.abs(maxCount - b) + Math.abs(maxCount - c);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        // 입력받은 땅의 높이 정보를 저장할 배열
        int[][] map = new int[3][3];

        // 땅의 높이 정보 입력받기
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                // 각 위치의 땅의 높이 입력받기
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 최소 비용 초기화
        int answer = Integer.MAX_VALUE;

        // 각 행에 대해 최소 비용 계산
        for (int i = 0; i < 3; i++) {
            // 행에 대한 비용 계산
            int rowCost = calcCost(map[i][0], map[i][1], map[i][2]);
            // 열에 대한 비용 계산
            int colCost = calcCost(map[0][i], map[1][i], map[2][i]);

            // 행과 열 중 더 작은 비용으로 최소 비용 업데이트
            answer = Math.min(answer, Math.min(rowCost, colCost));
        }
        System.out.println(calcCost(4, 1, 7));

        // 최소 비용 출력
        System.out.println(answer);
    }
}
