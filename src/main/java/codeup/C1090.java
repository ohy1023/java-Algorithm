package codeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C1090 {
    long getValue(int a, int d, int n) {
        return (long) (a * Math.pow(d,(n - 1)));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        C1090 c1089 = new C1090();
        System.out.println(c1089.getValue(a,d,n));
    }
}
