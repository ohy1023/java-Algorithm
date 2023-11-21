package inflearn.section_01.string.암호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static StringBuilder sb = new StringBuilder();

    public void solution(String s) {
        s = s.replaceAll("#", String.valueOf(1)).replaceAll("\\*", String.valueOf(0));

        int code = Integer.parseInt(s, 2);

        sb.append((char) code);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main main = new Main();
        int n = Integer.parseInt(br.readLine());

        String str = br.readLine();

        for (int i = 0; i < str.length() / 7; i++) {
            String substring = str.substring(i * 7, (i * 7) + 7);
            main.solution(substring);
        }

        System.out.println(sb);
    }
}
