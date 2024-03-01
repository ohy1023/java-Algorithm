package baekjoon.sliding_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2531 회전 초밥 (실버 1) - 슬라이딩 윈도우
 * https://www.acmicpc.net/problem/2531
 */
public class BOJ2531 {

    static int n, d, k, c; // 초밥 접시 수, 초밥 가짓수, 연속해서 먹는 접시 수, 쿠폰 번호

    static int[] sushi, check; // 초밥 배열, 초밥 종류 체크 배열

    /**
     * 최대로 먹을 수 있는 초밥 종류 수 반환
     */
    public static int solution() {
        check[c] = 3001; // 쿠폰 번호 초밥은 항상 먹을 수 있도록 특별한 값을 설정
        int count = 1; // 현재 먹을 수 있는 초밥 종류 수를 나타내는 변수
        // 초기 연속해서 먹는 초밥 수만큼의 초밥 종류 수를 계산
        for (int i = 0; i < k; i++) {
            if (check[sushi[i]] == 0) // 해당 종류의 초밥을 아직 먹지 않았으면
                count++; // 먹을 수 있는 초밥 종류 수 증가
            check[sushi[i]]++; // 해당 종류의 초밥을 먹은 횟수 증가
        }
        int max = count; // 초기 최대 초밥 종류 수는 초기 설정한 초밥 종류 수와 같음

        // 슬라이딩 윈도우를 이용하여 최대 초밥 종류 수를 계산
        for (int i = 0; i < n - 1; i++) {
            int s_id = sushi[i]; // 윈도우의 첫 번째 초밥 종류
            int e_id = sushi[i + k < n ? i + k : (i + k) % n]; // 윈도우의 마지막 초밥 종류
            if (--check[s_id] == 0) // 윈도우에서 첫 번째 초밥 종류의 먹은 횟수를 감소시킨 후 0이 되면
                count--; // 먹을 수 있는 초밥 종류 수 감소
            if (++check[e_id] == 1) // 윈도우에서 마지막 초밥 종류의 먹은 횟수를 증가시킨 후 1이 되면
                count++; // 먹을 수 있는 초밥 종류 수 증가
            max = Math.max(max, count); // 현재까지의 최대 초밥 종류 수 갱신
        }
        return max; // 최대 초밥 종류 수 반환
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 초밥 접시 수 입력
        d = Integer.parseInt(st.nextToken()); // 초밥 가짓수 입력
        k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수 입력
        c = Integer.parseInt(st.nextToken()); // 쿠폰 번호 입력

        sushi = new int[n]; // 초밥 배열 초기화
        check = new int[d + 1]; // 초밥 종류 체크 배열 초기화

        // 초밥 정보 입력
        for (int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solution()); // 최대로 먹을 수 있는 초밥 종류 수 출력
    }
}
