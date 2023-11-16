package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 18310 안테나 실버 3 - 이분탐색
 * https://www.acmicpc.net/problem/18310
 */
public class BOJ18310 {

    /**
     * 주어진 집의 위치에서 안테나를 설치할 위치를 찾는 메서드
     *
     * @param n      집의 수
     * @param houses 집의 위치 배열
     * @return 안테나를 설치할 위치
     */
    public int solution(int n, int[] houses) {
        // 집의 위치를 정렬
        Arrays.sort(houses);

        // 집의 수가 짝수일 때 중간에 위치한 집을 반환
        if (n % 2 == 0) {
            return houses[n / 2 - 1];
        }
        // 집의 수가 홀수일 때 중간에 위치한 집을 반환
        else {
            return houses[n / 2];
        }
    }

    public static void main(String[] args) throws IOException {
        // BOJ18310 인스턴스 생성
        BOJ18310 main = new BOJ18310();
        // 입력 받기 위한 BufferedReader 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 집의 수 입력
        int N = Integer.parseInt(br.readLine());

        // 집의 위치를 저장할 배열 생성
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] houses = new int[N];

        // 집의 위치 입력
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(st.nextToken());
        }

        // 결과 출력
        System.out.println(main.solution(N, houses));
    }
}
