package likelion.java1130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountChar {
    boolean solution(String s) {
        int cntP = 0;
        int cntY = 0;
        String upperCase = s.toUpperCase();
        for (int i = 0; i < upperCase.length(); i++) {
            if (upperCase.charAt(i) == 'P') {
                cntP++;
            } else if (upperCase.charAt(i) == 'Y') {
                cntY++;
            }
        }
        if (cntP == cntY) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        CountChar cc = new CountChar();
        System.out.println(cc.solution(s));
    }
}
