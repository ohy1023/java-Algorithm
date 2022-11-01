package algorithm.java1101;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimeTest {
    @Test
    void test() {
        Prime prime = new Prime();
        int[] arr = new int[]{13, 17, 19, 23};
        for (int i = 0; i < arr.length; i++) {
            if (prime.isPrime(arr[i])) {
                System.out.println(arr[i]);
            }
        }
    }

}