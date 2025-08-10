package baekjoon.input_output;

import java.io.*;
import java.util.*;

public class BOJ1924 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dayByMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] daysOfWeek = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int totalDays = 0;
        for (int month = 1; month < x; month++) {
            totalDays += dayByMonth[month];
        }
        totalDays += y;

        int dayIndex = (totalDays - 1) % 7;

        System.out.println(daysOfWeek[dayIndex]);
    }
}