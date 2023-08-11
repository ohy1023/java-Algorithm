package likelion.java1124;

import java.util.Scanner;

public class NumberByRecursion {
    public String make(int s, int e) {
        if (s > e) {
            return "";
        }
        return s + " " + make(s + 1, e);
    }

    public String solution(int s, int e) {
        if (s > e) {
            return "";
        }
        String str = make(1, s) + "\n";

        return str + solution(s + 1, e);
    }

    public static void main(String[] args) {
        NumberByRecursion num = new NumberByRecursion();
        Scanner sc = new Scanner(System.in);
        int end = sc.nextInt();
        String solution = num.solution(1, end);
        System.out.println(solution);
    }
}
