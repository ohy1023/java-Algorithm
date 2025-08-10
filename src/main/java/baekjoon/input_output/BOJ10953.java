package baekjoon.input_output;

import java.io.*;
import java.util.*;

public class BOJ10953 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), ",");

            int A = Integer.parseInt(st.nextToken());
            int B= Integer.parseInt(st.nextToken());

            sb.append(A + B).append("\n");
        }

        System.out.println(sb);
    }
}
