package inflearn.string.대소문자_변환;

import java.io.*;

public class Main {

    public static StringBuilder sb = new StringBuilder();

    private static void solution(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLowerCase(c)) {
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(Character.toLowerCase(c));
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        solution(str);

        System.out.println(sb);

    }
}
