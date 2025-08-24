package book.thisiscodingtest.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 이것이 코딩 테스트다
 * 고정점 찾기 - 이진 탐색
 */
public class Sol2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0;
        int rt = arr.length - 1;

        int answer = -1;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (mid == arr[mid]) {
                answer = mid;
                break;
            } else if (mid < arr[mid]) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        System.out.println(answer);
    }

}
