package stepik.csc.algorithms.methods.solutions2018.introduction;

import java.util.Scanner;

public class SmallFibonacciNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n<=1)
            System.out.println(n);
        else if( n == 2)
            System.out.println(1);
        else {
            int sum = 0;
            int a = 1, b = 1;
            for (int i=2; i< n; i++) {
                sum = a + b;
                a=b;
                b=sum;
            }
            System.out.println(sum);

        }
    }
}
