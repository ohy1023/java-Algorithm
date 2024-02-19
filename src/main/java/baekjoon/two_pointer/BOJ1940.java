package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 1940 주몽 (실버 4) - 투 포인터
 * https://www.acmicpc.net/problem/1940
 */
public class BOJ1940 {

    /**
     * 배열에서 주어진 합이 되는 쌍의 개수를 반환하는 메서드
     * @param n 배열의 길이
     * @param target 목표 합
     * @param ingredients 주어진 배열
     * @return 합이 목표값과 일치하는 쌍의 개수
     */
    public static int solution(int n, int target, int[] ingredients) {
        int answer = 0; // 결과값 초기화

        Arrays.sort(ingredients); // 배열을 오름차순으로 정렬

        int lt = 0; // 왼쪽 포인터 초기화
        int rt = ingredients.length - 1; // 오른쪽 포인터 초기화

        while (lt < rt) { // 왼쪽 포인터가 오른쪽 포인터를 넘지 않을 때까지 반복
            int sum = ingredients[lt] + ingredients[rt]; // 현재 두 값의 합

            if (sum >= target) { // 합이 목표값보다 크거나 같으면
                rt--; // 오른쪽 포인터를 왼쪽으로 이동하여 합을 줄임
            } else { // 합이 목표값보다 작으면
                lt++; // 왼쪽 포인터를 오른쪽으로 이동하여 합을 늘림
            }
            if (sum == target) { // 합이 목표값과 같으면
                answer++; // 결과값 증가
            }
        }
        return answer; // 결과값 반환
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 재료의 개수 입력
        int M = Integer.parseInt(br.readLine()); // 목표 합 입력

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] ingredients = new int[N]; // 재료 배열 생성

        for (int i = 0; i < N; i++) {
            ingredients[i] = Integer.parseInt(st.nextToken()); // 재료 값 입력
        }

        System.out.println(solution(N, M, ingredients)); // 결과 출력
    }
}
