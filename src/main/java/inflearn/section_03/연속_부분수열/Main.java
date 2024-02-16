package inflearn.section_03.연속_부분수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 섹션 3.
 * 인프런 연속 부분수열 - 투포인터
 */
public class Main {

    /**
     * 주어진 배열에서 연속된 부분 수열 중 합이 목표값과 일치하는 경우의 수를 반환하는 메서드
     * @param n 배열의 길이
     * @param target 목표 합
     * @param arr 주어진 배열
     * @return 합이 목표값과 일치하는 연속된 부분 수열의 개수
     */
    public static int solution(int n, int target, int[] arr) {
        int answer = 0; // 결과 값 변수 초기화

        int lt = 0, rt = 0; // 왼쪽과 오른쪽 포인터 초기화
        int sum = 0; // 현재 부분 수열의 합을 저장할 변수 초기화
        while (rt < n) { // 오른쪽 포인터가 배열의 끝에 도달할 때까지 반복
            if (sum >= target) { // 현재 부분 수열의 합이 목표값보다 크거나 같으면
                sum -= arr[lt++]; // 왼쪽 포인터 값을 증가시키며 합에서 빼기
            } else { // 현재 부분 수열의 합이 목표값보다 작으면
                sum += arr[rt++]; // 오른쪽 포인터 값을 증가시키며 합에 더하기
            }

            if (sum == target) { // 현재 부분 수열의 합이 목표값과 일치하면
                answer++; // 결과 값 증가
            }
        }

        return answer; // 결과 값 반환
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 배열의 길이 입력
        int M = Integer.parseInt(st.nextToken()); // 목표 합 입력

        int[] arr = new int[N]; // 배열 선언

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // 배열 값 입력
        }

        System.out.println(solution(N, M, arr)); // 결과 출력
    }

}
