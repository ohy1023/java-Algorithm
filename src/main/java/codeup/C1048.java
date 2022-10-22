package codeup;

import java.util.Scanner;

public class C1048 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int ans = 1;

        for (int i = 0; i < b; i++) {
           ans = ans<<1;
        }
        System.out.println(a*ans);


    }
}
