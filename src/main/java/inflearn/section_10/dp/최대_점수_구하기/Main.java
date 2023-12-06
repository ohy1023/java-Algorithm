package inflearn.section_10.dp.최대_점수_구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 인프런 최대 점수 구하기 - 냅색 알고리즘
 */
public class Main {

    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력값을 구분하기 위한 StringTokenizer 객체 생성
        StringTokenizer st;

        // 첫 줄에서 문제의 조건인 N과 M을 입력 받음
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 문제의 개수
        int M = Integer.parseInt(st.nextToken()); // 제한 시간

        // 각 시간별 최대 점수를 저장할 배열 생성
        int[] dp = new int[M + 1];

        // 각 문제의 점수와 소요 시간을 입력 받아서 처리
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            // 현재 문제의 점수와 소요 시간을 변수에 저장
            int score = Integer.parseInt(st.nextToken());
            int hour = Integer.parseInt(st.nextToken());

            // 배낭 알고리즘 수행 (역순으로 진행)
            for (int j = M; j >= hour; j--) {
                // 현재 시간에서 해당 문제를 풀었을 때의 최대 점수 계산
                dp[j] = Math.max(dp[j], dp[j - hour] + score);
            }
        }

        // 최종적으로 제한 시간 M에서 얻을 수 있는 최대 점수 출력
        System.out.println(dp[M]);
    }
}
