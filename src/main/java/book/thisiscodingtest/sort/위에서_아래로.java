package book.thisiscodingtest.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 위에서_아래로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int max = 100_001;
        int[] count = new int[max];

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            count[num]++;
        }

        for (int i = max - 1; i > 0; i--) {
            for (int j = 0; j < count[i]; j++) {
                System.out.print(i + " ");
            }
        }
    }
}
