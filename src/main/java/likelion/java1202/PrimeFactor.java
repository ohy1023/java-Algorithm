package likelion.java1202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeFactor {
    // 소수를 구하고 소수로 나누어 떨어지면 소인수
    private int[] solution(int n) {
        int[] check = new int[n + 1];
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (check[i] == 1) continue;
            for (int j = i * i; j < n; j += i) {
                check[j] = 1;
            }
        }
        return check;
    }

    public static void main(String[] args) throws IOException {
        PrimeFactor pf = new PrimeFactor();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] sieve = pf.solution(n);
        int idx = 2;
        while (n != 1) {
            if (sieve[idx] == 0) {
                if (n % idx == 0) {
                    System.out.print(idx + " ");
                    n /= idx;
                } else {
                    idx++;
                }
            } else {
                idx++;
            }

        }
    }
}