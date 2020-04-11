package stepik.csc.algorithms.methods.solutions2018.divideandrule;

import java.util.Scanner;

public class CountingSort {

    private void run() {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] A = new int[n];
        for (int i = 0; i<n; i++){
            A[i] = input.nextInt();
        }
        int[] B = new int[10];
        int[] a = new int[n];
        for ( int j = 0; j < n; j ++){
            B[A[j]-1] = B[A[j]-1]+1;
        }
        for (int i = 1; i < 10; i++){
            B[i] = B[i] + B[i -1];
        }
        for (int j = n - 1; j > -1; j--){
            a[B[A[j]-1]-1] = A[j];
            B[A[j]-1] = B[A[j]-1] -1;
        }
        for (int i = 0; i < n; i++){
            System.out.print(a[i]+ " ");
        }
    }

    public static void main(String[] args) {
        new CountingSort().run();
    }
}
