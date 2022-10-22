package codeup;

import java.io.*;
import java.util.StringTokenizer;

public class C1085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        double h = Double.parseDouble(st.nextToken());
        double b = Double.parseDouble(st.nextToken());
        double c = Double.parseDouble(st.nextToken());
        double s = Double.parseDouble(st.nextToken());

        double temp = (h * b * c * s) / (8 * 1024 * 1024);

        bw.write(String.format("%.1f MB", temp));
        bw.flush();
    }
}
