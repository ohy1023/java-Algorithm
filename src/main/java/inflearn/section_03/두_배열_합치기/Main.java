package inflearn.section_03.두_배열_합치기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 인프런 강의 - 두 배열 합치기 (투 포인터 알고리즘)
 */
public class Main {
    static StringTokenizer st;

    /**
     * 두 배열을 합치는 메소드
     *
     * @param arr1 첫 번째 배열
     * @param arr2 두 번째 배열
     * @return 합쳐진 배열을 공백으로 구분하여 문자열로 반환
     */
    public String solution(int[] arr1, int[] arr2) {
        StringBuilder sb = new StringBuilder();

        int p1 = 0, p2 = 0;

        // 두 배열을 비교하여 작은 값을 StringBuilder에 추가
        while (p1 < arr1.length && p2 < arr2.length) {
            if (arr1[p1] < arr2[p2]) {
                sb.append(arr1[p1++]);
            } else {
                sb.append(arr2[p2++]);
            }
            sb.append(" ");
        }

        // 남은 요소들을 StringBuilder에 추가
        for (int i = p1; i < arr1.length; i++) {
            sb.append(arr1[i]).append(" ");
        }

        for (int j = p2; j < arr2.length; j++) {
            sb.append(arr2[j]).append(" ");
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 배열 입력
        int N = Integer.parseInt(br.readLine());
        int[] arr1 = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        // 두 번째 배열 입력
        int M = Integer.parseInt(br.readLine());
        int[] arr2 = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        // Main 객체 생성 및 결과 출력
        Main main = new Main();
        System.out.println(main.solution(arr1, arr2));
    }
}
