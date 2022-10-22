package codeup;

public class C1859 {
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
        new C1859().f(1,5);
    }
}
