package softeer.level2.sol7703;

import java.io.*;
import java.util.*;

/**
 * 소프티어 X marks the Spot (Level.2)
 * https://softeer.ai/practice/7703
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 테스트 케이스 수 입력

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String S = st.nextToken(); // 문자열 S 입력
            String T = st.nextToken(); // 문자열 T 입력

            for (int j = 0; j < S.length(); j++) {
                if (S.charAt(j) == 'X' || S.charAt(j) == 'x') {
                    sb.append(Character.toUpperCase(T.charAt(j))); // 대응되는 위치의 T 문자를 대문자로 추가
                }
            }
        }

        System.out.println(sb); // 결과 출력
    }
}
