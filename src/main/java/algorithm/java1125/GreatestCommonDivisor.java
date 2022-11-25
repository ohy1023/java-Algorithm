package algorithm.java1125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GreatestCommonDivisor {
    private int solution(int a, int b) {
        if (a == b) {
            return a;
        } else if (a > b) {
            return solution(a - b, b);
        } else if (a < b) {
            return solution(a, b - a);
        }
        return 1;
    }
    public static void main(String[] args) throws IOException {
        GreatestCommonDivisor gcd = new GreatestCommonDivisor();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        System.out.println(gcd.solution(a, b));
    }
}
