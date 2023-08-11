package likelion.java1122;

public class RecursionSumArray {
    public static int sum(int[] arr, int n, int res) {
        if (n < 0) {
            return res;
        }
        res += arr[n];
        return sum(arr, n - 1, res);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7, 3, 2, 9};
        System.out.println(sum(arr, arr.length - 1, 0));

    }
}
