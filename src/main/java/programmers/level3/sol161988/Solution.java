package programmers.level3.sol161988;

/**
 * 프로그래머스 Level.3 연속 펄스 부분 수열의 합 - 투 포인터
 * https://school.programmers.co.kr/learn/courses/30/lessons/161988
 */
class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        boolean isPlus = true; // 현재 펄스의 부호를 나타내는 플래그

        long purse1 = 0; // 펄스 1의 합
        long purse2 = 0; // 펄스 2의 합

        for (int num : sequence) {
            // 펄스 1의 합 누적 (isPlus가 true인 경우 num을 더하고, false인 경우 num을 빼줌)
            purse1 += isPlus ? num : -num;
            // 펄스 2의 합 누적 (isPlus가 true인 경우 num을 빼고, false인 경우 num을 더해줌)
            purse2 += isPlus ? -num : num;

            // 각 펄스의 합이 0보다 작으면 0으로 초기화 (음수 값은 연속된 부분 수열의 합을 낮출 수 있기 때문)
            purse1 = Math.max(0, purse1);
            purse2 = Math.max(0, purse2);

            // 현재까지의 최대 부분 수열의 합 갱신
            answer = Math.max(answer, Math.max(purse1, purse2));

            // 펄스의 부호를 변경하여 다음 인덱스에 대해 계산
            isPlus = !isPlus;
        }

        return answer;
    }

    public long mySolution(int[] sequence) {
        long answer = 0;

        int size = sequence.length;

        int[] sequence1 = new int[size];
        int[] sequence2 = new int[size];

        // sequence1과 sequence2 배열을 구성하여 펄스 1과 펄스 2의 합을 계산
        for (int i = 0; i < size; i++) {
            sequence1[i] = (i % 2 == 0) ? sequence[i] : -sequence[i];
            sequence2[i] = (i % 2 == 1) ? sequence[i] : -sequence[i];
        }

        long total1 = 0;
        long total2 = 0;
        int lt1 = 0, lt2 = 0;

        // 투 포인터를 이용하여 연속된 부분 수열의 합 계산
        for (int rt = 0; rt < size; rt++) {
            // 펄스 1의 합 누적
            total1 += sequence1[rt];

            // 펄스 1의 합이 0보다 작아질 때까지 lt1을 증가시키면서 부분 수열의 합을 조절
            while (total1 < 0 && lt1 <= rt) {
                total1 -= sequence1[lt1++];
            }

            // 펄스 2의 합 누적
            total2 += sequence2[rt];

            // 펄스 2의 합이 0보다 작아질 때까지 lt2을 증가시키면서 부분 수열의 합을 조절
            while (total2 < 0 && lt2 <= rt) {
                total2 -= sequence2[lt2++];
            }

            // 현재까지의 최대 부분 수열의 합 갱신
            answer = Math.max(answer, Math.max(total1, total2));
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // 주어진 입력에 대해 각각의 메서드를 호출하여 결과 출력
        System.out.println(s.solution(new int[]{2, 3, -6, 1, 3, -1, 2, 4}));
        System.out.println(s.mySolution(new int[]{2, 3, -6, 1, 3, -1, 2, 4}));
    }
}
