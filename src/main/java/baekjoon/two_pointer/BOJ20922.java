package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 20922 겹치는 건 싫어 (실버 1) - 투 포인터
 * https://www.acmicpc.net/problem/20922
 */
public class BOJ20922 {

    static int[] count; // 각 숫자의 등장 횟수를 저장하는 배열

    /**
     * 겹치는 수가 최대 k개인 연속 부분 수열의 최대 길이를 구하는 메소드
     * @param n 수열의 길이
     * @param k 겹치는 수의 최대 허용 개수
     * @param arr 입력된 수열
     * @return 최대 길이
     */
    public static int solution(int n, int k, int[] arr) {
        int answer = 0; // 결과값을 저장할 변수
        int lt = 0; // 투 포인터의 왼쪽 인덱스
        int rt = 0; // 투 포인터의 오른쪽 인덱스

        while (rt < n) {
            count[arr[rt]]++; // 현재 포인터가 가리키는 수의 등장 횟수 증가

            // 현재 포인터가 가리키는 수의 등장 횟수가 k를 초과하면
            // 왼쪽 포인터를 이동시켜서 겹치는 수의 개수를 줄임
            while (count[arr[rt]] > k) {
                count[arr[lt]]--; // 왼쪽 포인터가 가리키는 수의 등장 횟수 감소
                lt++; // 왼쪽 포인터 이동
            }

            // 현재 연속 부분 수열의 길이를 구함
            int len = rt - lt + 1;

            // 현재 연속 부분 수열의 길이가 기존의 최대 길이보다 크다면 최대 길이를 갱신
            if (len > answer) {
                answer = len;
            }

            rt++; // 오른쪽 포인터 이동
        }

        return answer; // 최대 길이 반환
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수열의 길이
        int K = Integer.parseInt(st.nextToken()); // 겹치는 수의 최대 허용 개수

        int[] arr = new int[N]; // 수열을 저장할 배열
        count = new int[100001]; // 수의 등장 횟수를 저장할 배열

        // 수열 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 연속 부분 수열의 최대 길이 출력
        System.out.println(solution(N, K, arr));
    }
}
