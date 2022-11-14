package algorithm.java1114;

import java.util.Arrays;

public class PrimeCount {
    int count(int n) {
        int cnt = 0;
        boolean[] bl = new boolean[n + 1];
        Arrays.fill(bl,true);
        for (int i = 2; i < bl.length; i++) {
            if (bl[i] == true) {
                bl[i] = false;
                cnt++;
                for (int j = i; j < bl.length; j+=i) {
                    bl[j] = false;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        PrimeCount pc = new PrimeCount();
        System.out.println(pc.count(100000000));
    }
}
