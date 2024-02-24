package baekjoon.sliding_window;

import java.io.*;
import java.util.*;

/**
 * 백준 10025 게으른 백곰 (실버 3) - 슬라이딩 윈도우
 * https://www.acmicpc.net/problem/10025
 */
public class BOJ10025 {

    /**
     * 게으른 백곰이 얻을 수 있는 최대 얼음량을 구하는 메소드
     * @param n 얼음덩어리의 개수
     * @param k 얼음덩어리 간의 거리
     * @param arr 얼음덩어리의 정보를 담은 배열
     * @return 최대 얼음량
     */
    static int solution(int n, int k, int[] arr) {
        int sum = 0; // 슬라이딩 윈도우 내의 얼음량을 저장할 변수
        int window = 1 + (2 * k); // 슬라이딩 윈도우의 크기

        // 초기 슬라이딩 윈도우 합 계산
        for (int i = 0; i < window && i <= 1000000; i++) {
            sum += arr[i];
        }

        int answer = sum; // 초기 최대 얼음량

        // 슬라이딩 윈도우 이동
        for (int i = window; i <= 1000000; i++) {
            // 새로운 요소 추가 및 이전 요소 제거
            sum -= arr[i - window];
            sum += arr[i];

            // 최대 얼음량 갱신
            if (sum > answer) {
                answer = sum;
            }
        }

        return answer; // 최대 얼음량 반환
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 얼음덩어리의 개수 입력
        int K = Integer.parseInt(st.nextToken()); // 얼음덩어리 간의 거리 입력

        int[] arr = new int[1000001]; // 얼음덩어리의 정보를 담을 배열

        // 얼음덩어리의 정보 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken()); // 얼음량 입력
            int idx = Integer.parseInt(st.nextToken()); // 위치 입력
            arr[idx] = g; // 해당 위치에 얼음량 저장
        }

        // 결과 출력
        System.out.println(solution(N, K, arr));
    }
}
