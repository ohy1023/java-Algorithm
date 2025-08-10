package baekjoon.input_output;

import java.io.*;

public class BOJ11721 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();


        for (int i = 0; i < line.length(); i+= 10) {
            if (i + 10 >= line.length()) {
                System.out.println(line.substring(i));
            } else {
                System.out.println(line.substring(i, i + 10));
            }
        }

        System.out.println(sb);
    }
}
