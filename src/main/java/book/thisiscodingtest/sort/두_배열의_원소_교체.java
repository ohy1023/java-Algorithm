package book.thisiscodingtest.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두_배열의_원소_교체 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr1 = new int[N];
        int[] arr2 = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for (int i = 0; i < K; i++) {
            if (arr1[i] < arr2[N - i - 1]) {
                int tmp = arr1[i];
                arr1[i] = arr2[N - i - 1];
                arr2[N - i - 1] = tmp;
            } else {
                break;
            }
        }

        System.out.println(Arrays.stream(arr1).sum());

    }
}
