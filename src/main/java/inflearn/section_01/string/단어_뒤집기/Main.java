package inflearn.section_01.string.단어_뒤집기;

import java.io.*;

public class Main {

    public static String reverseWord(String word) {
        // 함수 이용
        StringBuilder res = new StringBuilder(word).reverse();

        // 직접 구현
//        for (int i = word.length() - 1; i >= 0; i--) {
//            res.append(word.charAt(i));
//        }
        return res.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            sb.append(reverseWord(word)).append('\n');
        }
        System.out.println(sb);
    }
}
