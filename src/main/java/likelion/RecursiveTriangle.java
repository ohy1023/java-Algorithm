package likelion;

public class RecursiveTriangle {
    public void f(int s,int n) {
        if (s > n) {
            return;
        }
        System.out.println("*".repeat(s));
        if (s < n) {
            s++;
            f(s,n);
        }

    }

    public static void main(String[] args) {
        new RecursiveTriangle().f(1,5);
    }
}
