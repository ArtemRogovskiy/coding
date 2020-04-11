package stepik.csc.algorithms.methods.solutions2018.dynamic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Calculator {

    private void run() {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Map<Integer, Integer> Operations = new HashMap<>();
        Operations.put(1, 0);
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0 && i % 3 == 0) {
                Operations.put(i, Math.min(Operations.get(i / 3), Math.min(Operations.get(i / 2), Operations.get(i -1))) + 1);
                continue;
            }
            if (i % 3 == 0) {
                Operations.put(i, Math.min(Operations.get(i / 3), Operations.get(i -1)) + 1);
                continue;
            }
            if (i % 2 == 0) {
                Operations.put(i, Math.min(Operations.get(i / 2), Operations.get(i -1)) + 1);
            } else {
                Operations.put(i, Operations.get(i -1) + 1);
            }
        }
        int k = Operations.get(n);
        System.out.println(k);
        int[] res = new int[k + 1];
        res[k] = n;
        for (int i = n; i > 1;){
            if (i % 2 == 0 && i % 3 == 0) {
                int min = Math.min(Operations.get(i / 3), Math.min(Operations.get(i / 2), Operations.get(i -1)));
                if (Operations.get(i / 3) == min){
                    res[Operations.get(i / 3)] = i / 3;
                    i = i / 3;
                } else if (Operations.get(i / 2) == min){
                    res[Operations.get(i / 2)] = i / 2;
                    i = i / 2;
                } else {
                    res[Operations.get(i - 1)] = i - 1;
                    i--;
                }
                continue;
            }
            if (i % 3 == 0) {
                int min = Math.min(Operations.get(i / 3), Operations.get(i -1));
                if (Operations.get(i / 3) == min){
                    res[Operations.get(i / 3)] = i / 3;
                    i = i / 3;
                } else {
                    res[Operations.get(i - 1)] = i - 1;
                    i--;
                }
                continue;
            }
            if (i % 2 == 0) {
                int min = Math.min(Operations.get(i / 2), Operations.get(i -1));
                if (Operations.get(i / 2) == min){
                    res[Operations.get(i / 2)] = i / 2;
                    i = i / 2;
                } else {
                    res[Operations.get(i - 1)] = i - 1;
                    i--;
                }
            } else {
                res[Operations.get(i -1)] = i - 1;
                i--;
            }
        }
        for (int i = 0; i <= k; i++)
            System.out.print(res[i] + " ");
    }


    public static void main(String[] args) {
        new Calculator().run();
    }
}
