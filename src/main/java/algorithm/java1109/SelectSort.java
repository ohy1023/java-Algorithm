package algorithm.java1109;


public class SelectSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 4, 9, 10, 223, 111, 23, 3, 39};
        int minIdx = 0;

        // i가 0일때 최소값 idx 찾기
        for (int i = 1; i < arr.length; i++) {
            if (arr[0] > arr[i]) {
                minIdx = i;
            }
        }
        System.out.println(minIdx);

        // i가 0일때 최소값 idx 찾기
        for (int i = 1; i < arr.length; i++) {
            if (arr[1] > arr[i]) {
                minIdx = i;
            }
        }
        System.out.println(minIdx);


    }
}
