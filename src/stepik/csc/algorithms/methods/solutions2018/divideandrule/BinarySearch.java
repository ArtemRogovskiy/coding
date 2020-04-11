package stepik.csc.algorithms.methods.solutions2018.divideandrule;

import java.util.Scanner;

public class BinarySearch {

    public void run() {
        Scanner input = new Scanner( System.in);
        int n = input.nextInt();
        int[] A = new int[100000];
        for (int i = 0; i< n; i++){
            A[i]=input.nextInt();
        }
        int k = input.nextInt();

        // Algorithm
        for (int i = 0; i < k; i++){
            int b = input.nextInt();
            int l = 0;
            int r = n;
            int mark = 0;
            while (l <= r) {
                int m = (l+r)/2;
                if ( A[m] == b){
                    System.out.print(m+1 + " " );
                    mark = b;
                    break;
                } else if (A[m] > b){
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
            if (mark == 0) {
                System.out.print(-1 + " ");
            }

        }
    }
    public static void main(String[] args) {
        new BinarySearch().run();
    }
}
