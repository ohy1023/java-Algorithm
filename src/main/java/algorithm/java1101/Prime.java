package algorithm.java1101;

public class Prime {
    boolean isPrime(int num) {
        for (int j = 2; j < num; j++) {
            if (num % j == 0) {
                return false;
            }
        }
        return true;
    }

    boolean isPrimeV2(int num) {
        for (int j = 2; j <= num/2; j++) {
            if (num % j == 0) {
                return false;
            }
        }
        return true;
    }

    boolean isPrimeV3(int num) {
        for (int j = 2; j * j <= num; j++) {
            if (num % j == 0) {
                return false;
            }
        }
        return true;
    }

}
