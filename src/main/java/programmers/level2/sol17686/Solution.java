package programmers.level2.sol17686;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 프로그래머스 Level.2 파일명 정렬
 * https://school.programmers.co.kr/learn/courses/30/lessons/17686
 **/
class Solution {
    // 정규 표현식을 컴파일하여 패턴 객체를 생성합니다.
    // (\\D+): 숫자가 아닌 문자열 부분을 매칭합니다.
    // (\\d{1,5}): 최대 5자리의 숫자 부분을 매칭합니다.
    private final Pattern pattern = Pattern.compile("(\\D+)(\\d{1,5})");

    public String[] solution(String[] files) {
        // 파일 배열을 정렬합니다. 정렬 기준은 Comparator를 사용하여 정의합니다.
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 각 파일 이름에 대해 Matcher 객체를 생성합니다.
                Matcher matcher1 = pattern.matcher(o1);
                Matcher matcher2 = pattern.matcher(o2);

                // 정규 표현식 패턴과 매칭되는 경우에만 비교를 수행합니다.
                if (matcher1.find() && matcher2.find()) {
                    // 첫 번째 매칭 그룹(문자열 부분)을 대문자로 변환하여 비교합니다.
                    String head1 = matcher1.group(1).toUpperCase();
                    String head2 = matcher2.group(1).toUpperCase();

                    // 두 번째 매칭 그룹(숫자 부분)을 정수로 변환하여 비교합니다.
                    int number1 = Integer.parseInt(matcher1.group(2));
                    int number2 = Integer.parseInt(matcher2.group(2));

                    // head 부분을 비교합니다.
                    int headCompare = head1.compareTo(head2);

                    // head가 같으면 number를 비교하여 정렬합니다.
                    if (headCompare == 0) {
                        return Integer.compare(number1, number2);
                    }

                    // head가 다르면 head를 기준으로 정렬합니다.
                    return headCompare;
                }
                // 정규 표현식에 매칭되지 않으면 원래 문자열을 비교하여 정렬합니다.
                return o1.compareTo(o2);
            }
        });

        // 정렬된 파일 배열을 반환합니다.
        return files;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // 예제 테스트 케이스 1: 파일 이름들을 정렬하여 출력합니다.
        System.out.println(Arrays.toString(
                s.solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"})));

        // 예제 테스트 케이스 2: 파일 이름들을 정렬하여 출력합니다.
        System.out.println(Arrays.toString(
                s.solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II",
                        "F-14 Tomcat"})));
    }
}
