package inflearn.section_01.string.숫자만_추출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int solution(String s) {
        s = s.replaceAll("\\D", ""); // 숫자가 아닌 모든 문자를 제거

        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        System.out.println(solution(input));
    }
}
