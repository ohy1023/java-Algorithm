package book.thisiscodingtest.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 왕실의_나이트 {

    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String coordinates = br.readLine();

        int x = coordinates.charAt(0) - 'a' + 1;
        int y = coordinates.charAt(1) - '0';

        int answer = 0;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (1 <= nx && nx <= 8 && 1 <= ny && ny <= 8) {
                answer++;
            }
        }

        System.out.println(answer);

    }
}
