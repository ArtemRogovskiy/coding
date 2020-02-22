package codeforces.rounds.round614;

import java.util.Scanner;

public class Neko {

    static Integer blocks = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int q = input.nextInt();
        boolean[][] grid = new boolean[2 + 1][n + 1];
        for (int i = 0; i < q; ++i) {
            int r = input.nextInt();
            int c = input.nextInt();
            add(r, c, grid);
            if (blocks == 0 && !grid[1][1] && !grid[2][n])
                System.out.println("Yes");
            else System.out.println("No");
        }
    }

    private static void add(int r, int c, boolean[][] grid) {
        if (!grid[r][c]) {
            for (int i = 0; i < 3; ++i) {
                if (c - 1 + i >= 1 && c - 1 + i <= grid[0].length - 1 && grid[3 - r][c - 1 + i]) blocks++;
            }
        } else {
            for (int i = 0; i < 3; ++i) {
                if (c - 1 + i >= 1 && c - 1 + i <= grid[0].length - 1 && grid[3 - r][c - 1 + i]) blocks--;
            }
        }
        grid[r][c] = !grid[r][c];
    }
}
