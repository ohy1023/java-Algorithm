package algorithm.java1103;

public class RemoveMultipleOf3 {
    public static void main(String[] args) {
        int N = 50;
        int[] arr = new int[N-1];
        Boolean[] check = new Boolean[N-1];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i +2;
            check[i] = true;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " " + 2 * (i + 1));
        }

    }
}
