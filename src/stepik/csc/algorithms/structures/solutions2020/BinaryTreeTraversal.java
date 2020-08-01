package stepik.csc.algorithms.structures.solutions2020;

import java.util.Scanner;

public class BinaryTreeTraversal {

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
        inOrder(nodes[0]);
        System.out.println();
        preOrder(nodes[0]);
        System.out.println();
        postOrder(nodes[0]);
    }

    private static void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    private static void preOrder(Node root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    private static void postOrder(Node root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    private static class Node {
        int val;
        Node left;
        Node right;
    }
}
