package softeer.level2.sol7368;

import java.io.*;
import java.util.*;

/**
 * 소프티어 위험한 효도 - 수학
 * https://softeer.ai/practice/7368
 */
public class Main {

    public static void main(String[] args) throws IOException {
        // 입력을 받기 위해 BufferedReader를 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력 받은 한 줄을 공백을 기준으로 나누기 위해 StringTokenizer를 사용
        StringTokenizer st = new StringTokenizer(br.readLine());

        // a, b, d 값을 입력받아 정수로 변환
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        // 결과 값을 저장할 변수 초기화
        int res = 0;

        // 술래에게 갈때 멈춘 횟수를 계산
        int n = (d > a) ? d / a : 0;
        // 출발선으로 돌아갈때 멈춘 횟수를 계산
        int m = (d > b) ? d / b : 0;

        // 총 시간 계산: 2 * d는 왕복 거리, n * b는 갈때 기다리는 시간, m * a는 돌아올 때 기다리는 시간
        res += 2 * d + n * b + m * a;

        // 최종 결과 출력
        System.out.println(res);

    }
}
