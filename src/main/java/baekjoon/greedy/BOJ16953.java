package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 16953 A -> B (실버 2) - 그리디
 * https://www.acmicpc.net/problem/16953
 */
public class BOJ16953 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // solution 함수 호출
        int answer = solution(A, B);

        // 최종 정답 출력
        System.out.println(answer);
    }

    // A에서 B로 변환하는 그리디 알고리즘
    private static int solution(int A, int B) {
        // 정답을 저장할 변수 초기화
        int answer = 0;

        // 그리디 접근: A를 B로 변환하기 위해 반복적으로 연산을 수행
        while (B > A) { // B가 A보다 작아지면 종료
            // 만약 B가 짝수라면 2로 나누기
            if (B % 2 == 0) {
                B /= 2;
            }
            // 만약 B의 일의 자릿수가 1이라면 10으로 나누기
            else if (B % 10 == 1) {
                B /= 10;
            }
            // 주어진 연산으로 A를 B로 변환할 수 없다면 -1 반환
            else {
                return -1;
            }
            // 각 연산 수행마다 정답 카운터 증가
            answer += 1;
        }

        // 변환 결과가 A보다 작아졌거나 같은 경우에는 변환 가능
        // 그렇지 않은 경우에는 변환 불가능이므로 -1 반환
        return (B == A) ? answer : -1;
    }
}
