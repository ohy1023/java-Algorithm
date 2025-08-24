package book.thisiscodingtest.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 이것이 코딩 테스트다
 * 정렬된 배열에서 특정 수의 개수 구하기 - 이진 탐색
 */
public class Sol1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = binarySearchUpperBound(arr, x) - binarySearchLowerBound(arr, x);
        System.out.println(answer == 0 ? -1 : answer);

    }

    private static int binarySearchLowerBound(int[] arr, int target) {
        int lt = 0;
        int rt = arr.length - 1;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (arr[mid] < target) lt = mid + 1;
            else rt = mid - 1;
        }

        return lt;
    }

    private static int binarySearchUpperBound(int[] arr, int target) {
        int lt = 0;
        int rt = arr.length - 1;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (arr[mid] <= target) lt = mid + 1;
            else rt = mid - 1;
        }

        return lt;
    }
}
