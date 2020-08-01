package leetcode;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(10);
        TreeNode right = new TreeNode(50);
        TreeNode root = new TreeNode(20, left, right);
        TreeNode root2 = new TreeNode(1, left, right);

        System.out.println(new ValidateBinarySearchTree().isValidBST(root2));
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValidLeftSubBST(null, root)
                && isValidRightSubBST(null, root);
    }

    private boolean isValidLeftSubBST(TreeNode leftLimited, TreeNode parent) {
        if (parent.left == null) return true;
        if (parent.left.val >= parent.val) return false;
        if (leftLimited != null && leftLimited.val >= parent.left.val) return false;
        return isValidLeftSubBST(leftLimited, parent.left)
                && isValidRightSubBST(parent, parent.left);
    }

    private boolean isValidRightSubBST(TreeNode rightLimited, TreeNode parent) {
        if (parent.right == null) return true;
        if (parent.val >= parent.right.val) return false;
        if (rightLimited != null && parent.right.val >= rightLimited.val) return false;
        return isValidLeftSubBST(parent, parent.right)
                && isValidRightSubBST(rightLimited, parent.right);
    }
}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
