package programmers.level2.sol155651;

/**
 * 프로그래머스 Level.2 호텔 대실 - 누적합
 * https://school.programmers.co.kr/learn/courses/30/lessons/155651?language=java
 */
class Solution {
    public int calcMinutes(String time) {
        String[] info = time.split(":");

        int hour = Integer.parseInt(info[0]);
        int minute = Integer.parseInt(info[1]);

        return hour * 60 + minute;
    }

    public int solution(String[][] book_time) {
        int answer = 0;

        int[] rooms = new int[60 * 24 + 10];

        for (String[] bt : book_time) {
            String startTime = bt[0];
            String endTime = bt[1];

            rooms[calcMinutes(startTime)] += 1;
            rooms[calcMinutes(endTime) + 10] -= 1;
        }

        for (int i = 1; i < 60 * 24 + 10; i++) {
            rooms[i] += rooms[i - 1];
            answer = Math.max(rooms[i], answer);
        }

        return answer;
    }
}