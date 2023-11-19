package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2502 떡 먹는 호랑이 실버 1
 */
public class BOJ2502 {
    /**
     * 떡 먹는 호랑이 문제를 해결하는 메서드
     *
     * @param day 떡을 먹는 날짜
     * @param cnt 떡의 개수
     */
    public void solution(int day, int cnt) {
        // dp 배열 초기화
        int[] dy = new int[31];
        dy[1] = 1;
        dy[2] = 1;

        while (true) {
            // dp 배열 계산
            for (int i = 3; i <= day; i++) {
                dy[i] = dy[i - 1] + dy[i - 2];
            }

            // 떡의 개수와 일치하는 경우 출력 후 종료
            if (dy[day] == cnt) {
                System.out.println(dy[1]);
                System.out.println(dy[2]);
                break;
            }
            // 떡의 개수보다 작은 경우 두 번째 날짜의 떡 개수 증가
            else if (dy[day] < cnt) {
                dy[2]++;
            }
            // 떡의 개수보다 큰 경우 첫 번째 날짜의 떡 개수 증가하고 두 번째 날짜 초기화
            else {
                dy[1]++;
                dy[2] = dy[1];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 해결 메서드 호출
        BOJ2502 s = new BOJ2502();
        s.solution(D, K);
    }
}
