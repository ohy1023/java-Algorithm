package algorithm.java1111;

/**
 * 1. 각 배열의 인덱스 값을 기준으로 비트연산자 or로 10진수 추출
 * 2. 10진수 -> 2진수 변경
 * 3. 새로운 배열에 값을 담고
 * 4. 1이면 #으로, 0이면 공백으로 치환
 */
public class SecretMap {

    String solution(int[] arr1, int[] arr2) {
        int
        for (int i = 0; i < arr1.length; i++) {
            int num = arr1[i] | arr2[i];
        }
    }
    public static void main(String[] args) {
        int num = 9 | 30;
        String binaryString = Integer.toBinaryString(num);
        System.out.println(binaryString);
    }
}
