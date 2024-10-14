package softeer.level2.sol6284;

import java.io.*;
import java.util.*;

/**
 * 소프티어 진정한 효도 (Level.2)
 * https://softeer.ai/practice/6284
 */
public class Main {
    private static final Long MOD = 1000000007L;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        Long K = Long.parseLong(st.nextToken());
        Long P = Long.parseLong(st.nextToken());
        Long N = Long.parseLong(st.nextToken());

        for (int i = 0; i < N; i++) {
            K *= P % MOD;
        }

        System.out.println(K);
    }
}
