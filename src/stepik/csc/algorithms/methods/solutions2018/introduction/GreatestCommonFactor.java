package stepik.csc.algorithms.methods.solutions2018.introduction;

import java.util.Scanner;

public class GreatestCommonFactor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(method(a,b));

    }
    static int method( int a, int b) {
        while ((a!=0) & (b!=0)) {
            if (a>=b) {
                a = a % b;
            }
            else b = b % a;
        }
        if (a==0)
            return b;
        else if (b==0)
            return a;
        return 0;
    }
}
