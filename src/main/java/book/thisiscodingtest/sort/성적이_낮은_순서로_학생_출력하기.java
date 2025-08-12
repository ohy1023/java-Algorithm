package book.thisiscodingtest.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 성적이_낮은_순서로_학생_출력하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int max = 100;
        List<String>[] buckets = new ArrayList[101];

        for (int i = 0; i <= max; i++) {
            buckets[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int score = Integer.parseInt(st.nextToken());

            buckets[score].add(name);
        }

        StringBuilder sb = new StringBuilder();
        for (int score = 1; score <= 100; score++) {
            for (String name : buckets[score]) {
                sb.append(name).append(' ');
            }
        }

        System.out.println(sb);

    }
}
