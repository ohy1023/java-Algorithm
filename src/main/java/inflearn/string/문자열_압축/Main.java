package inflearn.string.문자열_압축;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int cnt = 1;
    static int lt = 0;
    static int rt = 1;

    public static void solution(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();

        while (lt < chars.length && rt < chars.length) {

            if (chars[lt] == chars[rt]) {
                cnt++;
            } else {
                sb.append(chars[lt]);
                if (cnt != 1) {
                    sb.append(cnt);
                }
                cnt = 1;
            }

            lt++;
            rt++;

        }

        sb.append(chars[lt]);
        if (cnt != 1) {
            sb.append(cnt);
        }


        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        solution(str);


    }
}
