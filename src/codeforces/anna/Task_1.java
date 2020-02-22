package codeforces.anna;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int M = input.nextInt();
        int K = input.nextInt();
        int[] data = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = input.nextInt();
        }
        divide(data, M, K);
    }

    private static void divide(int[] data, int M, int K) {
        int[] elementsInClass = new int[M + 1];
        for (int i = 0; i < data.length; i++){
            elementsInClass[data[i]]++;
        }
        int baseLength = data.length / K;
        int oneMore = data.length % K;
        int[][] result = new int[K][];
        for (int i = 0; i < K; i++) {
            result[0] = new int[baseLength + (oneMore-- > 0 ? 1 : 0)];
        }
        for (int i = 0; i < data.length; i++) {

        }
    }
}