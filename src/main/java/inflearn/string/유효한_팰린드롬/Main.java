package inflearn.string.유효한_팰린드롬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public String solution(String s) {
        s = s.toUpperCase().replaceAll("[^A-Z]", "");
        String tmp = new StringBuilder(s).reverse().toString();

        if (s.equals(tmp)) {
            return "YES";
        }
        return "NO";
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Main main = new Main();
        String input = br.readLine();
        System.out.println(main.solution(input));

    }
}