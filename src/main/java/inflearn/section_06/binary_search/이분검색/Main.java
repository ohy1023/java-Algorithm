package inflearn.section_06.binary_search.이분검색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 인프런 이분검색 - 이분탐색
 */
public class Main {

    /**
     * 이분검색을 통해 배열에서 특정 값의 위치를 찾는 메서드
     *
     * @param n       배열의 크기
     * @param m       찾고자 하는 값
     * @param numbers 정렬된 배열
     * @return 찾고자 하는 값의 위치 (인덱스 + 1), 찾지 못한 경우 -1 반환
     */
    public int solution(int n, int m, int[] numbers) {
        // 배열 정렬
        Arrays.sort(numbers);
        // 결과값 초기화
        int res = -1;

        // 이분탐색을 위한 왼쪽(Low)과 오른쪽(High) 포인터 초기화
        int lt = 0, rt = n - 1;

        // 이분탐색 수행
        while (lt <= rt) {
            // 중간 값 계산
            int mid = (lt + rt) / 2;

            // 중간 값이 찾고자 하는 값인 경우 결과값 갱신하고 종료
            if (numbers[mid] == m) {
                res = mid + 1; // 배열 인덱스는 0부터 시작하므로 +1
                break;
            }
            // 중간 값이 찾고자 하는 값보다 큰 경우, 오른쪽 범위를 좁힘
            else if (numbers[mid] > m) {
                rt = mid - 1;
            }
            // 중간 값이 찾고자 하는 값보다 작은 경우, 왼쪽 범위를 좁힘
            else {
                lt = mid + 1;
            }
        }
        // 결과 반환
        return res;
    }

    public static void main(String[] args) throws IOException {
        // 입력을 위한 BufferedReader 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N, M 입력
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 배열 입력
        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // Main 인스턴스 생성
        Main main = new Main();

        // 결과 출력
        System.out.println(main.solution(N, M, nums));
    }
}
