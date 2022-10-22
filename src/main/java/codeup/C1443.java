package codeup;

import java.util.Scanner;

public class C1443 {
    int[] sort(int[] arr) {

        for (int i =1; i < arr.length; i++)
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        C1443 insertSort = new C1443();
        int[] result = insertSort.sort(arr);
        for (int i : result) {
            System.out.println(i);
        }

    }
}
