public class IsBalancedBinaryTree {

    private static class TreeNode {
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

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int leftHeight = dfsHeight(root.left);
        int rightHeight = dfsHeight(root.right);

        return Math.abs(leftHeight - rightHeight) <= 1 // return the absolute value, i.e. non-negative, should be less or equal 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    private static int dfsHeight(TreeNode node) {
        if (node == null) return 0;
        return 1 + // count provided node
                Math.max(dfsHeight(node.left), dfsHeight(node.right)); // return largest of two values, i.e. pick the tallest of the two subtrees
    }

    public static void main(String[] args) {
        // Balanced tree:
        //        1
        //       / \
        //      2   3
        //     / \
        //    4   5
        TreeNode balanced = new TreeNode(1);
        balanced.left = new TreeNode(2);
        balanced.right = new TreeNode(3);
        balanced.left.left = new TreeNode(4);
        balanced.left.right = new TreeNode(5);

        // Unbalanced tree (skewed):
        //    1
        //   /
        //  2
        // /
        //3
        TreeNode unbalanced = new TreeNode(1);
        unbalanced.left = new TreeNode(2);
        unbalanced.left.left = new TreeNode(3);

        System.out.println("Balanced tree: " + isBalanced(balanced));     // true
        System.out.println("Unbalanced tree: " + isBalanced(unbalanced)); // false
    }
}
