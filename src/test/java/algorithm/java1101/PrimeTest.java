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
        int[] arr = new int[]{13, 17, 19, 23, 4};
        assertTrue(prime.isPrime(arr[0], new StatementStrategy() {
            @Override
            public boolean compare(int a, int b) {
                return a < b;
            }
        }));
        // 내부 클래스는 가독성이 떨어지므로 람다식 사용
        assertTrue(prime.isPrime(arr[1], (a, b) -> a < b)); // 가독성을 위해 람다 사용
        assertTrue(prime.isPrime(arr[2], (a, b) -> a < b)); // 가독성을 위해 람다 사용
        assertTrue(prime.isPrime(arr[3], (a, b) -> a < b)); // 가독성을 위해 람다 사용
        assertFalse(prime.isPrime(arr[4], (a, b) -> a < b)); // 가독성을 위해 람다 사용
    }

    @Test
    @DisplayName("N/2 만큼 수를 확인하여 소수 찾기 O(N)")
    void testV2() {
        Prime prime = new Prime();
        int[] arr = new int[]{13, 17, 19, 23, 4};
        assertTrue(prime.isPrime(arr[0], new StatementStrategy() {
            @Override
            public boolean compare(int a, int b) {
                return a <= (b / 2);
            }
        }));
        assertTrue(prime.isPrime(arr[1], (a, b) -> a <= b / 2));
        assertTrue(prime.isPrime(arr[2], (a, b) -> a <= b / 2));
        assertTrue(prime.isPrime(arr[3], (a, b) -> a <= b / 2));
        assertFalse(prime.isPrime(arr[4], (a, b) -> a <= b / 2));

    }

    @Test
    @DisplayName("루트N 만큼 수를 확인하여 소수 찾기 O(루트N)")
    void testV3() {
        Prime prime = new Prime();
        int[] arr = new int[]{13, 17, 19, 23, 4};
        assertTrue(prime.isPrime(arr[1], new StatementStrategy() {
            @Override
            public boolean compare(int a, int b) {
                return a * a <= b;
            }
        }));
        assertTrue(prime.isPrime(arr[1], (a, b) -> a * a <= b));
        assertTrue(prime.isPrime(arr[2], (a, b) -> a * a <= b));
        assertTrue(prime.isPrime(arr[3], (a, b) -> a * a <= b));
        assertFalse(prime.isPrime(arr[4], (a, b) -> a * a <= b));

    }

}