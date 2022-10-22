package codeup;

import java.io.*;
import java.util.StringTokenizer;

public class C1086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        double w = Double.parseDouble(st.nextToken());
        double h = Double.parseDouble(st.nextToken());
        double d = Double.parseDouble(st.nextToken());

        double temp = (w * h * d) / (8 * 1024 * 1024);

        bw.write(String.format("%.2f MB", temp));
        bw.flush();
    }
}
