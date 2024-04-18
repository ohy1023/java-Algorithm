package baekjoon.binary_search;

import java.io.*;
import java.util.*;

/**
 * 백준 3151 합이 0 (골드 4) - 이분탐색
 * https://www.acmicpc.net/problem/3151
 */
public class BOJ3151 {

    // n개 중 2개를 선택하는 조합을 계산하는 메소드
    public static int combination(int n) {
        return n * (n - 1) / 2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        // 입력을 배열에 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 배열을 오름차순으로 정렬
        Arrays.sort(arr);

        // 결과를 저장할 변수 cnt 초기화
        long cnt = 0L;

        for (int i = 0; i < N; i++) {
            if (arr[i] > 0) break; // 양수인 경우에는 종료

            int fix = arr[i]; // 고정된 값
            int lt = i + 1; // 왼쪽 포인터
            int rt = N - 1; // 오른쪽 포인터

            while (lt < rt) {
                int sum = fix + arr[lt] + arr[rt]; // 세 개의 값을 합친 값

                if (sum == 0) { // 합이 0일 때
                    int s = 1; // 왼쪽 포인터에서 중복된 값의 개수를 저장할 변수
                    int e = 1; // 오른쪽 포인터에서 중복된 값의 개수를 저장할 변수

                    if (arr[lt] == arr[rt]) { // 왼쪽과 오른쪽 값이 같으면
                        int n = rt - lt + 1; // 중복된 값의 개수 계산
                        cnt += combination(n); // 중복된 값에서 2개를 선택하는 경우의 수를 더함
                        break;
                    }

                    // 왼쪽에서 중복된 값의 개수 세기
                    while (arr[lt] == arr[lt + 1]) {
                        s++;
                        lt++;
                    }

                    // 오른쪽에서 중복된 값의 개수 세기
                    while (arr[rt] == arr[rt - 1]) {
                        e++;
                        rt--;
                    }

                    // 중복된 값의 개수를 곱하여 cnt에 더함
                    cnt += s * e;
                }

                // 합이 0보다 크면 오른쪽 포인터를 왼쪽으로 이동
                if (sum > 0) {
                    rt--;
                } else { // 합이 0보다 작으면 왼쪽 포인터를 오른쪽으로 이동
                    lt++;
                }
            }
        }

        // 결과 출력
        System.out.println(cnt);
    }
}
