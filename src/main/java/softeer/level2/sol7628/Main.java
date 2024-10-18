package softeer.level2.sol7628;

import java.io.*;
import java.util.*;

/**
 * 소프티어 연탄의 크기 (Level.2)
 * https://softeer.ai/practice/7628
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] radii = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            radii[i] = Integer.parseInt(st.nextToken());
        }

        // 최대 반지름 값을 기준으로 배열 크기를 설정
        int maxRadius = 100;
        int[] count = new int[maxRadius + 1];

        // 각 반지름의 약수에 대해 카운트 증가
        for (int radius : radii) {
            for (int div = 1; div <= radius; div++) {
                if (radius % div == 0) {
                    count[div]++;
                }
            }
        }

        // 최대 카운트 찾기
        int maxCount = 0;
        for (int i = 2; i <= maxRadius; i++) { // 연탄의 반지름은 1보다 커야 함
            if (count[i] > maxCount) {
                maxCount = count[i];
            }
        }

        System.out.println(maxCount);
    }
}
