package stepik.csc.algorithms.structures.solutions2020;

import java.util.Arrays;
import java.util.Scanner;

public class AutoProgsAnalyze {

    private static int[] parent;
    private static int[] rank;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int e = input.nextInt();
        int d = input.nextInt();
        parent = new int[n + 1]; // elements numeration from 1
        Arrays.fill(parent, -1);
        rank = new int[n + 1];
        Arrays.fill(rank, 1);
        // make sets of equals numbers. Reading of equal numbers
        for (int i = 0; i < e; i++) {
            union(input.nextInt(), input.nextInt());
        }
        // check if numbers belongs to different sets. If sets the same -> 0. Reading of not equal numbers
        for (int i = 0; i < d; i++) {
            int root1 = find(input.nextInt());
            int root2 = find(input.nextInt());
            if (root1 == root2) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }

    private static void union(int a, int b) {
        int root1 = find(a);
        int root2 = find(b);
        if (root1 == root2) {
            return;
        }
        if (rank[root1] < rank[root2]) {
            parent[root1] = root2;
        } else {
            parent[root2] = root1;
            if (rank[root1] == rank[root2]) {
                rank[root1]++;
            }
        }
    }

    private static int find(int element) {
        if (parent[element] == -1) return element;
        parent[element] = find(parent[element]);
        return parent[element];
    }
}
