package algorithm.java1108;

import java.util.Scanner;

public class BinarySearch {

    int printIdx(int[] arr, int k) {
        int st = 0;
        int en = arr.length - 1;
        int idx = -1;
        while (st <= en) {
            int mid = (st + en) / 2;
            if (arr[mid] < k) {
                st = mid + 1;
            } else if (arr[mid] > k) {
                en = mid - 1;
            } else {
                idx = mid + 1;
                break;
            }
        }
        return idx;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);
        BinarySearch bs = new BinarySearch();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(bs.printIdx(arr,k));


    }
}
