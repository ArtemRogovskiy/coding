package stepik.csc.algorithms.methods.solutions2018.introduction;

import java.util.Scanner;

public class LargeFibonacciLastDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        if (n<=1)
            System.out.println(n);
        else if( n == 2)
            System.out.println(1);
        else {

            int a = 1, b = 1;
            for (int i=2; i< n; i++) {
                sum = (a + b)%10;
                a=b;
                b=sum;
            }
            System.out.println(sum);

        }
    }
}
