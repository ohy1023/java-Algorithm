package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 백준 골드 3 소수의 연속합 - 투 포인터
 * https://www.acmicpc.net/problem/1644
 */
public class BOJ1644 {

    /**
     * 소수의 연속합을 구하는 메서드
     *
     * @param N 정수 N
     * @return N을 연속된 소수의 합으로 나타낼 수 있는 경우의 수
     */
    public static int solution(int N) {
        int answer = 0; // 정답 변수 초기화
        List<Integer> primeList = getPrimeList(N); // 소수 리스트 생성

        int lt = 0; // 왼쪽 포인터 초기화
        int rt = 0; // 오른쪽 포인터 초기화
        int sum = 0; // 현재 구간의 합 초기화

        // 오른쪽 포인터가 소수 리스트의 끝에 도달할 때까지 반복
        while (rt < primeList.size()) {
            sum += primeList.get(rt++); // 현재 구간의 합에 소수 추가

            // 현재 구간의 합이 N을 초과하는 경우 왼쪽 포인터를 이동하여 합을 줄임
            while (sum > N) {
                sum -= primeList.get(lt++);
            }

            // 현재 구간의 합이 N과 같으면 정답을 증가
            if (sum == N) {
                answer++;
            }
        }

        return answer; // 정답 반환
    }

    /**
     * 주어진 수보다 작은 소수 리스트를 반환하는 메서드
     *
     * @param N 정수 N
     * @return 주어진 수보다 작은 소수 리스트
     */
    private static List<Integer> getPrimeList(int N) {
        boolean[] isComposite = new boolean[N + 1]; // 합성수 여부를 저장하는 배열
        List<Integer> primes = new ArrayList<>(); // 소수 리스트 초기화

        // 에라토스테네스의 체 알고리즘을 사용하여 합성수를 제거하고 소수를 추출
        for (int i = 2; i * i <= N; i++) {
            if (!isComposite[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isComposite[j] = true;
                }
            }
        }

        // 소수를 리스트에 추가
        for (int i = 2; i <= N; i++) {
            if (!isComposite[i]) {
                primes.add(i);
            }
        }

        return primes; // 소수 리스트 반환
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(solution(N));
    }
}
