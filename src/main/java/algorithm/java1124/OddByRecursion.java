package algorithm.java1124;

import java.util.Scanner;

public class OddByRecursion {

    public void get(int a) {
        if (a % 2 != 0) {
            System.out.print(a + " ");
        }
    }

    public void solution(int a, int b) {
        if (a > b) {
            return;
        }
        get(a);
        solution(a + 1,b);
    }


    public static void main(String[] args) {
        OddByRecursion odd = new OddByRecursion();
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        odd.solution(a,b);

    }
}
