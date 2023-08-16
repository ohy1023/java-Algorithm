package baekjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 백준 2231 부분합 브론즈 2
 */
public class BOJ2231 {

    public static int res, lengthN;

    public static void solution(int num) {
        for (int i = (num - (lengthN * 9)); i < num; i++) {
            int sum = 0;
            int tmp = i;
            sum += tmp;
            while (tmp > 0) {
                sum += (tmp % 10);
                tmp /= 10;
            }
            if (sum == num) {
                res = i;
                break;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strN = br.readLine();
        lengthN = strN.length();
        int n = Integer.parseInt(strN);

        res = 0;
        solution(n);
        System.out.println(res);
    }
}
