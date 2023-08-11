package likelion.java1101;


interface StatementStrategy {
    boolean compare(int a, int b);
}
public class Prime {

    boolean someOperation(int a, int b) {
        return a < b;
    }

    boolean isPrime(int num, StatementStrategy stmt) {
        for (int j = 2; stmt.compare(j,num); j++) {
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
