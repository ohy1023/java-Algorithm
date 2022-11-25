package algorithm.java1125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GreatestCommonDivisor2 {
    private int solution(int a, int b) {
        while (a != b) {
            if (a > b) {
                a -= b;
            } else if (a < b) {
                b -= a;
            }
        }
        return b;
    }

    public static void main(String[] args) throws IOException {
        GreatestCommonDivisor2 gcd = new GreatestCommonDivisor2();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        System.out.println(gcd.solution(a, b));
    }
}
