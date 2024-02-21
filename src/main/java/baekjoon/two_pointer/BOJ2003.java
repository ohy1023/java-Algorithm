package baekjoon.two_pointer;

import java.io.*;
import java.util.*;

/**
 * 백준 2003 수들의 합 2 (실버 4) - 투 포인터
 * https://www.acmicpc.net/problem/2003
 */
public class BOJ2003 {

    /**
     * 주어진 배열에서 합이 M이 되는 부분 배열의 개수를 반환하는 메소드
     * @param N 배열의 길이
     * @param M 찾고자 하는 합
     * @param arr 주어진 배열
     * @return 부분 배열의 개수
     */
    static int solution(int N, int M, int[] arr) {
        int answer = 0; // 부분 배열의 개수를 저장할 변수
        int sum = 0; // 현재 부분 배열의 합을 저장할 변수
        int lt = 0; // 부분 배열의 왼쪽 인덱스
        int rt = 0; // 부분 배열의 오른쪽 인덱스

        // 투 포인터 알고리즘을 사용하여 부분 배열의 합이 M이 되는 경우를 찾음
        while (true) {
            if (sum >= M) { // 현재 합이 M 이상인 경우
                sum -= arr[lt++]; // 부분 배열의 왼쪽 끝 요소를 합에서 제거하고 왼쪽 인덱스를 증가시킴
            } else if (rt == N) { // 배열의 끝까지 검사한 경우 종료
                break;
            } else { // 현재 합이 M 미만이고 배열의 끝에 도달하지 않은 경우
                sum += arr[rt++]; // 부분 배열의 오른쪽 끝 요소를 합에 추가하고 오른쪽 인덱스를 증가시킴
            }
            if (sum == M) { // 현재 합이 M과 같은 경우
                answer++; // 부분 배열의 개수를 증가시킴
            }
        }

        return answer; // 부분 배열의 개수를 반환
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 배열의 길이
        int M = Integer.parseInt(st.nextToken()); // 찾고자 하는 합

        int[] arr = new int[N]; // 주어진 배열

        // 배열 요소 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 결과 출력
        System.out.println(solution(N, M, arr));
    }
}
