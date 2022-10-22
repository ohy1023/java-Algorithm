package codeup;

import java.util.Scanner;

public class C1079 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            Character ch = sc.next().charAt(0);
            if (ch == 'q') {
                System.out.println(ch);
                break;
            }
            System.out.println(ch);
        }
    }
}
