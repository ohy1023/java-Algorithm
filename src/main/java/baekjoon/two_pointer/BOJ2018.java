package baekjoon.two_pointer;

import java.io.*;

/**
 * 백준 2018 수들의 합 5 (실버 5) - 투 포인터
 * <a href="https://www.acmicpc.net/problem/2018">...</a>
 */
public class BOJ2018 {
    public int solution(int N) {
        int answer = 1;
        int start = 1;
        int end = 1;
        int sum = 1;

        while (start <= N / 2) {
            if (sum < N) {
                end++;
                sum += end;
            } else if (sum == N) {
                answer++;
                sum -= start;
                start++;
            } else {
                sum -= start;
                start++;
            }

        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        BOJ2018 b = new BOJ2018();
        System.out.println(b.solution(N));
    }
}
