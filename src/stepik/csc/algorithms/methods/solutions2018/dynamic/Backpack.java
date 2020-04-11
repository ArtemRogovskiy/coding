package stepik.csc.algorithms.methods.solutions2018.dynamic;

import java.util.Scanner;

public class Backpack {

    int n;

    private int KnapsackWithoutRepsBU(int W, int[] w, int[] c){
        int[][] D = new int[W+1][n+1];
        for (int we = 0; we <= W; we++){
            D[we][0] = 0;
        }
        for (int i = 0; i <= n; i++){
            D[0][i] = 0;
        }
        for (int i = 1; i<= n; i++){
            for (int we = 1; we<= W; we++){
                D[we][i] = D[we][i - 1];
                if (w[i] <= we){
                    D[we][i] = Math.max(D[we][i], D[we-w[i]][i -1] + c[i]);
                }
            }
        }
        return D[W][n];
    }

    private void run() {
        Scanner input = new Scanner(System.in);
        int W = input.nextInt();
        n = input.nextInt();
        int[] w = new int[n+1];
        int[] c = new int[n+1];
        w[0] = 0;
        for (int i = 1; i <= n; i++){
            w[i] = input.nextInt();
        }
        int j = 0;
        for (int weigth: w ){
            c[j] = weigth;
            j++;
        }
        System.out.println(KnapsackWithoutRepsBU(W, w, c));
    }

    public static void main(String[] args) {
        new Backpack().run();
    }
}
