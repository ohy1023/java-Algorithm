package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 1931 회의실 배정 (실버 1) - 그리디
 * https://www.acmicpc.net/problem/1931
 */
public class BOJ1931 {

    static class MeetingRoom implements Comparable<MeetingRoom> {
        int startTime;
        int endTime;

        public MeetingRoom(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }


        @Override
        public int compareTo(MeetingRoom o) {
            if (endTime == o.endTime) return Integer.compare(this.startTime, o.startTime);
            return Integer.compare(this.endTime, o.endTime);
        }
    }


    public static int solution(MeetingRoom[] meetingRooms) {
        Arrays.sort(meetingRooms);

        int answer = 0;
        int prevEndTime = 0;

        for (MeetingRoom meeting : meetingRooms) {
            if (meeting.startTime >= prevEndTime) {
                answer++;
                prevEndTime = meeting.endTime;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        MeetingRoom[] requests = new MeetingRoom[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            requests[i] = new MeetingRoom(s, e);
        }

        System.out.println(solution(requests));

    }
}
