package likelion.java1123;

import java.util.Scanner;

public class FactorialCalculation {
    public int solution(int num) {
        if (num == 1) {
            return 1;
        }
        return num * solution(num - 1);
    }

    public static void main(String[] args) {
        FactorialCalculation fc = new FactorialCalculation();
        Scanner sc = new Scanner(System.in);
        System.out.println(fc.solution(sc.nextInt()));
    }
}
