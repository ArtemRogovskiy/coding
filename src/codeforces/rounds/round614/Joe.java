package codeforces.rounds.round614;

import java.util.Scanner;

public class Joe {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double n = input.nextDouble();
        double res = 0.0;
        for (double i = n; i > 0; --i) {
            res += (1 / i);
        }
        System.out.println(res);
    }
}
