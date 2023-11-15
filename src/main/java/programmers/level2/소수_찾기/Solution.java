package programmers.level2.소수_찾기;

import java.util.HashSet;

/**
 * 프로그래머스 level 2 소수 찾기
 * https://school.programmers.co.kr/learn/courses/30/lessons/42839?language=java
 */
class Solution {
    /**
     * 주어진 숫자로 만들 수 있는 소수의 개수를 반환하는 메서드
     *
     * @param numbers 조합하여 만들 수 있는 숫자 문자열
     * @return 소수의 개수
     */
    public int solution(String numbers) {
        // 중복을 허용하지 않는 Set 자료구조 사용
        HashSet<Integer> set = new HashSet<>();
        // 순열 생성 메서드 호출
        permutation("", numbers, set);

        // 결과값 초기화
        int answer = 0;

        // Set에 저장된 숫자들을 확인하며 소수 여부 판별
        while (set.iterator().hasNext()) {
            int a = set.iterator().next();
            set.remove(a);

            // 2는 소수이므로 무조건 카운트
            if (a == 2) {
                answer++;
            }
            // 홀수이고 소수인 경우 카운트
            if (a % 2 != 0 && isPrime(a)) {
                answer++;
            }
        }

        return answer;
    }

    /**
     * 주어진 숫자가 소수인지 판별하는 메서드
     *
     * @param n 판별할 숫자
     * @return 소수 여부
     */
    public boolean isPrime(int n) {
        // 0과 1은 소수가 아님
        if (n == 0 || n == 1) {
            return false;
        }

        // 3부터 숫자의 제곱근까지 홀수로 나누어지는지 확인하여 소수 여부 판별
        for (int i = 3; i <= (int) Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 순열을 생성하는 메서드
     *
     * @param prefix 현재까지의 순열
     * @param str    남은 숫자들
     * @param set    중복을 허용하지 않는 Set 자료구조
     */
    public void permutation(String prefix, String str, HashSet<Integer> set) {
        int n = str.length();

        // 빈 문자열이 아니면 Set에 추가
        if (!prefix.equals("")) {
            set.add(Integer.valueOf(prefix));
        }

        // 재귀적으로 순열 생성
        for (int i = 0; i < n; i++) {
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), set);
        }
    }

    public static void main(String[] args) {
        // 예시 테스트
        Solution s = new Solution();
        System.out.println(s.solution("011"));
    }
}
