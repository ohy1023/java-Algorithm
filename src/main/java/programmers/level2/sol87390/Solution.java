package programmers.level2.sol87390;

import java.util.ArrayList;
import java.util.List;

/**
 * 프로그래머스 Level.2 n^2 배열 자르기 - 구현
 * https://school.programmers.co.kr/learn/courses/30/lessons/87390
 */
class Solution {
    public List<Long> solution(int n, long left, long right) {

        List<Long> arr = new ArrayList<>();

        for (long i = left; i < right; i++) {
            arr.add(Math.max(i / n, i % n) + 1);
        }

        return arr;
    }

}