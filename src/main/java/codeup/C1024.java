package codeup;

import java.util.Scanner;

public class C1024 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        for (int i = 0; i < str.length(); i++) {
            System.out.println("\'" + str.charAt(i) + "\'");
        }
    }
}
