package likelion.java1114;


public class Prime {
    int solution(int n) {
        int cnt = 0;
        int[] arr = new int[n - 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 2;
        }

        for (int i = 0; i * i <= n; i++) {
            if (arr[i] != 0) {
                for (int j = i * 2 + 2; j < arr.length; j += arr[i]) {
                    arr[j] = 0;
                }
            }
        }

        for (int i : arr) {
            if (i != 0) {
                cnt ++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Prime prime = new Prime();
        System.out.println(prime.solution(100000000));
    }
}
