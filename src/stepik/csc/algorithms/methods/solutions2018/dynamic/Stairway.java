package stepik.csc.algorithms.methods.solutions2018.dynamic;

import java.util.Scanner;

public class Stairway {

    private int MaxSum2(int[] a) {
        int a1;
        int a2;
        int res = 0;
        if (a.length == 1){
            return a[0];
        } else {
            a1 = 0;
            a2 = a[0];
            for (int i = 2; i < a.length + 1; i ++ ){
                res  = Math.max(a1, a2) + a[i-1];
                a1 = a2;
                a2 = res;
            }
        }
        return res;
    }

    private void run() {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = input.nextInt();
        }
        int l = A.length;
        System.out.println(MaxSum2(A));
    }

    public static void main(String[] args) {
        new Stairway().run();
    }
}
