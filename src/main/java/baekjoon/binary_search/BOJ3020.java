package baekjoon.binary_search;

import java.util.*;
import java.io.*;

/**
 * 백준 3020 개똥벌레 (골드 5) - 이분탐색
 * https://www.acmicpc.net/problem/3020
 */
public class BOJ3020 {

    /**
     * 이분탐색을 활용하여 높이가 h일 때 장애물의 개수를 구하는 메소드
     *
     * @param lt  왼쪽 인덱스
     * @param rt  오른쪽 인덱스
     * @param h   현재 높이
     * @param arr 장애물의 높이 배열
     * @return    높이가 h일 때 장애물의 개수
     */
    public static int binarySearch(int lt, int rt, int h, int[] arr) {
        while (lt < rt) {
            int mid = (lt + rt) / 2;

            if (arr[mid] >= h) {
                rt = mid;
            } else {
                lt = mid + 1;
            }
        }

        return arr.length - rt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int minValue = N; // 최소 장애물 개수
        int count = 0;    // 최소 장애물 개수를 가지는 구간의 개수
        int[] down = new int[N / 2]; // 아래 구간의 높이 저장 배열
        int[] up = new int[N / 2];   // 위 구간의 높이 저장 배열

        // 아래 구간과 위 구간의 높이 입력 받기
        for (int i = 0; i < N / 2; i++) {
            down[i] = Integer.parseInt(br.readLine());
            up[i] = Integer.parseInt(br.readLine());
        }

        // 높이 순으로 오름차순 정렬
        Arrays.sort(down);
        Arrays.sort(up);

        // 각 높이에 대해 이분탐색으로 장애물의 개수 확인
        for (int i = 1; i < H + 1; i++) {
            int conflict = binarySearch(0, N / 2, i, down) + binarySearch(0, N / 2, H - i + 1, up);

            // 최소 장애물 개수를 갖는 구간의 개수 확인
            if (minValue == conflict) {
                count++;
                continue;
            }

            // 최소 장애물 개수와 구간의 개수 업데이트
            if (minValue > conflict) {
                minValue = conflict;
                count = 1;
            }
        }

        // 결과 출력
        System.out.println(minValue + " " + count);
    }
}
