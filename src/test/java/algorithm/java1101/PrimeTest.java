package algorithm.java1101;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimeTest {
    @Test
    @DisplayName("모든 수를 확인하여 소수 찾기 O(N)")
    void test() {
        Prime prime = new Prime();
        int[] arr = new int[]{13, 17, 19, 23,4};
        assertTrue(prime.isPrime(arr[0]));
        assertTrue(prime.isPrime(arr[1]));
        assertTrue(prime.isPrime(arr[2]));
        assertTrue(prime.isPrime(arr[3]));
        assertFalse(prime.isPrime(arr[4]));
    }

    @Test
    @DisplayName("N/2 만큼 수를 확인하여 소수 찾기 O(N)")
    void testV2() {
        Prime prime = new Prime();
        int[] arr = new int[]{13, 17, 19, 23, 4};
        assertTrue(prime.isPrimeV2(arr[0]));
        assertTrue(prime.isPrimeV2(arr[1]));
        assertTrue(prime.isPrimeV2(arr[2]));
        assertTrue(prime.isPrimeV2(arr[3]));
        assertFalse(prime.isPrimeV2(arr[4]));

    }

    @Test
    @DisplayName("루트N 만큼 수를 확인하여 소수 찾기 O(루트N)")
    void testV3() {
        Prime prime = new Prime();
        int[] arr = new int[]{13, 17, 19, 23, 4};
        assertTrue(prime.isPrimeV3(arr[0]));
        assertTrue(prime.isPrimeV3(arr[1]));
        assertTrue(prime.isPrimeV3(arr[2]));
        assertTrue(prime.isPrimeV3(arr[3]));
        assertFalse(prime.isPrimeV3(arr[4]));

    }

}