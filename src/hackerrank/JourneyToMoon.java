package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class JourneyToMoon {

    private static int[] parent;
    private static int[] rank;
    // size of set of astronauts from the same country with root i (group indicator). If i isn't root -> groups[i] = -1
    private static int[] groupSize;
    private static int totalAstronauts;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); // number of astronauts
        int p = input.nextInt(); // number of pairs
        int[][] pairs = new int[p][2];
        for (int i = 0; i < p; i++) {
            pairs[i][0] = input.nextInt();
            pairs[i][1] = input.nextInt();
        }
        System.out.println(journeyToMoon(n, pairs));
    }

    static long journeyToMoon(int n, int[][] astronaut) {
        parent = new int[n];
        Arrays.fill(parent, -1);
        rank = new int[n];
        groupSize= new int[n];
        Arrays.fill(groupSize, 1);
        for (int i = 0; i < astronaut.length; i++) {
            union(astronaut[i][0], astronaut[i][1]);
        }
        return getPairsNumber(n);
    }

    private static void union(int a, int b) {
        int root1 = find(a);
        int root2 = find(b);
        if (root1 == root2) {
            return;
        }
        if (rank[root1] < rank[root2]) {
            parent[root1] = root2;
            groupSize[root2] += groupSize[root1];
            groupSize[root1] = -1;
        } else {
            parent[root2] = root1;
            groupSize[root1] += groupSize[root2];
            groupSize[root2] = -1;
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

    private static long getPairsNumber(int n) {
        long result = 0;
        totalAstronauts = n;
        for (int item : groupSize) {
            if (item != -1) {
                totalAstronauts -= item;
                result += totalAstronauts * item;
            }
        }
        return result;
    }
}
