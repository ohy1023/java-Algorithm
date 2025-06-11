package baekjoon.Implementation;

import java.io.*;
import java.util.*;

/**
 * 백준 2852 - NBA 농구 (실버 3)
 * <a href="https://www.acmicpc.net/problem/2852">...</a>
 */
public class BOJ2852 {

    static class ScoreInfo {
        int teamNo;
        int time; // 초 단위로 저장

        public ScoreInfo(int teamNo, String timeStr) {
            this.teamNo = teamNo;
            this.time = toSeconds(timeStr);
        }
    }

    // MM:ss → 초 단위로 변환
    public static int toSeconds(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    // 초 단위 → MM:ss 문자열로 변환
    public static String toTimeFormat(int totalSeconds) {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<ScoreInfo> scores = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int teamNo = Integer.parseInt(input[0]);
            String timeStr = input[1];
            scores.add(new ScoreInfo(teamNo, timeStr));
        }

        int score1 = 0, score2 = 0;
        int winTime1 = 0, winTime2 = 0;
        int prevTime = 0;

        for (ScoreInfo score : scores) {
            int curTime = score.time;

            // 현재 시점까지 리드한 시간 누적
            if (score1 > score2) {
                winTime1 += curTime - prevTime;
            } else if (score2 > score1) {
                winTime2 += curTime - prevTime;
            }

            // 득점 반영
            if (score.teamNo == 1) {
                score1++;
            } else {
                score2++;
            }

            prevTime = curTime;
        }

        // 마지막 득점 이후부터 48:00까지 리드 팀 반영
        int endTime = toSeconds("48:00");
        if (score1 > score2) {
            winTime1 += endTime - prevTime;
        } else if (score2 > score1) {
            winTime2 += endTime - prevTime;
        }

        System.out.println(toTimeFormat(winTime1));
        System.out.println(toTimeFormat(winTime2));
    }
}
