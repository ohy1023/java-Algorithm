package inflearn.string.가장_짧은_문자_거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.abs;

public class Main {

    static int[] res;

    static List<Integer> tmp;

    public static void solution(String s, char t) {
        tmp = new ArrayList<>();
        res = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t) {
                tmp.add(i);
            }
        }


        for (int i = 0; i < s.length(); i++) {
            int temp = Integer.MAX_VALUE;
            for (Integer index : tmp) {
                if (abs(index) - i < temp) {
                    temp = abs(index - i);
                }
            }
            res[i] = temp;
        }
        for (int re : res) {
            System.out.print(re + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();
        String t = st.nextToken();

        solution(s, t.charAt(0));


    }
}
