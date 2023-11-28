package inflearn.section_06.binary_search.마구간_정하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 인프런 마구간 정하기 - 이분탐색
 */
public class Main {
    static StringTokenizer st;

    public int count(int[] arr, int dist) {
        int cnt = 1;
        int ep = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - ep >= dist) {
                cnt++;
                ep = arr[i];
            }
        }

        return cnt;
    }

    public int solution(int n, int c, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);

        int lt = 1;
        int rt = arr[n - 1];
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(arr, mid) >= c) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());

        int[] stables = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            stables[i] = Integer.parseInt(st.nextToken());
        }

        Main T = new Main();
        System.out.println(T.solution(N, C, stables));


    }
}
