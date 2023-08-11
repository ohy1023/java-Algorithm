package likelion.java1108;

import java.util.Scanner;

public class SimpleSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = 1;
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        for (int a : arr) {
            if (a == k) {
                break;
            }
            cnt++;
        }
        if (cnt == arr.length+1) {
            cnt = -1;
        }
        System.out.println(cnt);
    }
}
