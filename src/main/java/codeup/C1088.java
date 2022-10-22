package codeup;

import java.io.*;

public class C1088 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        for (int i = 1; i <= num; i++) {
            if (i % 3 != 0) {
                bw.write(i + " ");
            }
        }
        bw.flush();
    }
}
