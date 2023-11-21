package inflearn.section_06.binary_search.뮤직비디오;

import java.io.*;
import java.util.*;

/**
 * 인프런 뮤직비디오 - 이분탐색
 */
public class Main {

    public int count(int[] arr, int cap) {
        int cnt = 1, sum = 0;
        for (int x : arr) {
            if (sum + x > cap) {
                cnt++;
                sum = x;
            } else {
                sum += x;
            }
        }

        return cnt;
    }

    public int solution(int n, int m, int[] arr) {

        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt(), rt = Arrays.stream(arr).sum();

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (count(arr, mid) <= m) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        return answer;

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        int[] dvd = new int[N];


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dvd[i] = Integer.parseInt(st.nextToken());
        }

        Main main = new Main();

        System.out.println(main.solution(N, M, dvd));

    }
}
