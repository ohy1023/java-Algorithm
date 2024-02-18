package inflearn.section_03.최대_매출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 섹션 3
 * 인프런 최대 매출 - 슬라이딩 윈도우
 */
public class Main {

    /**
     * 최대 매출을 구하는 메서드
     * @param N 매출 데이터의 개수
     * @param window 슬라이딩 윈도우의 크기
     * @param arr 매출 데이터 배열
     * @return 슬라이딩 윈도우 내의 최대 매출
     */
    public static int solution(int N, int window, int[] arr) {
        int answer = 0; // 최대 매출을 저장하는 변수
        boolean flag = false; // 윈도우의 크기를 초과하여 루프를 실행할 때를 체크하기 위한 플래그
        int sum = 0; // 슬라이딩 윈도우 내의 매출 합을 저장하는 변수
        for (int i = 0; i < N; i++) {
            if (i == window - 1) { // 윈도우의 크기에 도달했을 때
                flag = true; // 플래그를 true로 설정하여 이후 루프에서 조건을 체크할 수 있도록 함
            }
            if (i >= window) { // 윈도우 크기를 초과하여 데이터를 추가할 때
                sum -= arr[i - window]; // 이전 윈도우의 맨 앞의 값을 합에서 제거
            }
            sum += arr[i]; // 현재 윈도우의 매출을 합에 추가

            if (flag && sum > answer) { // 윈도우의 크기에 도달하고 합이 최대 매출보다 크면
                answer = sum; // 최대 매출을 갱신
            }
        }

        return answer; // 최대 매출 반환
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 매출 데이터의 개수 입력
        int K = Integer.parseInt(st.nextToken()); // 슬라이딩 윈도우의 크기 입력

        int[] incomes = new int[N]; // 매출 데이터 배열 선언

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            incomes[i] = Integer.parseInt(st.nextToken()); // 매출 데이터 입력
        }

        System.out.println(solution(N, K, incomes)); // 최대 매출 출력
    }
}
