package inflearn.section_01.string.문장_속_단어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static StringBuilder sb = new StringBuilder();

    private static String solution(String st) {
        String res = "";

        int m = Integer.MIN_VALUE;

        String[] s = st.split(" ");

        for (String x : s) {
            int len = x.length();
            if (len > m) {
                m = len;
                res = x;
            }
        }

        return res;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        System.out.println(solution(st));
    }
}
