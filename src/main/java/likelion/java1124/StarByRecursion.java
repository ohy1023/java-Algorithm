package likelion.java1124;

import java.util.Scanner;

public class StarByRecursion {
    public String make(int n) {
        if (n == 0) {
            return "";
        }
        return "*" + make(n - 1);
    }

    public String solution(int s,int e) {
        if (s > e) {
            return "";
        }
        String str = make(s) + "\n";

        return str + solution(s + 1,e);
    }

    public static void main(String[] args) {
        StarByRecursion star = new StarByRecursion();
        Scanner sc = new Scanner(System.in);
        int end = sc.nextInt();
        String solution = star.solution(1,end);
        System.out.println(solution);
    }
}
