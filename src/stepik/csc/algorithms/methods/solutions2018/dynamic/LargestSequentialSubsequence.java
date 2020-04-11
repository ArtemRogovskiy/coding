package stepik.csc.algorithms.methods.solutions2018.dynamic;

import java.util.Scanner;

public class LargestSequentialSubsequence {

    private int LISBottomUp(int[] A){
        int n = A.length;
        int[] D = new int[n];
        for (int i = 0; i < n; i++){
            D[i] = 1;
            for (int j = 0; j < i; j++){
                if ((A[i] % A[j] == 0 ) && (D[j] + 1 > D[i])){
                    D[i] = D[j] + 1;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++){
            if (ans < D[i]){
                ans = D[i];
            }
        }
        return ans;
    }

    private void run() {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++){
            A[i] = input.nextInt();
        }
        System.out.println(LISBottomUp(A));
    }

    public static void main(String[] args) {
        new LargestSequentialSubsequence().run();
    }
}
