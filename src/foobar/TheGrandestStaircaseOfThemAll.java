package foobar;

import java.util.Scanner;

public class TheGrandestStaircaseOfThemAll {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int[] aux = new int[n + 1];
        aux[0] = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = n; j >= i; j--) {
                aux[j] += aux[j - i];
            }
        }
        return aux[n] - 1;
    }

    private static void printArray(int[] arr) {
        for(int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
