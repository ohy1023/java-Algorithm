package softeer.level1.sol7698;

import java.io.*;

/**
 * 소프티어 개표 - 구현
 * https://softeer.ai/practice/7698
 */
public class Main {
    private static final String FIVE = "++++ ";
    private static final String ONE = "|";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            for (int j = 0; j < n / 5; j++) {
                sb.append(FIVE);
            }
            for (int k = 0; k < n % 5; k++) {
                sb.append(ONE);
            }
            sb.append("\n");
        }

        System.out.println(sb);
        
        
    }
}
