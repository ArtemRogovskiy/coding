package stepik.csc.algorithms.structures.solutions2020;

import java.util.Scanner;

public class ValidBinarySearchTree {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
        }
        for (int i = 0; i < n; i++) {
            Node node = nodes[i];
            node.val = input.nextInt();
            int k = input.nextInt();
            node.left = k == -1 ? null : nodes[k];
            k = input.nextInt();
            node.right = k == -1 ? null : nodes[k];
        }
        if (nodes.length == 0 || isValid(nodes[0])) {
            System.out.println("CORRECT");
        } else {
            System.out.println("INCORRECT");
        }
    }

    private static boolean isValid(Node root) {
        return isValid(root, null, null);
    }

    private static boolean isValid(Node root, Node leftBorder, Node rightBorder) {
        if (root == null) return true;
        if (leftBorder != null && leftBorder.val > root.val
                || rightBorder != null && rightBorder.val <= root.val) {
            return false;
        }
        return isValid(root.left, leftBorder, root) && isValid(root.right, root, rightBorder);
    }

    private static class Node {
        int val;
        Node left;
        Node right;
    }
}
