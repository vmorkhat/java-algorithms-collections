/*
O(n) time complexity, every node is visited exactly once.
Uses DFS, pre-order traversal;
 */
public class MinDepth {

    public static class TreeNode {
        int val;

        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return 1 + minDepth(root.right);
        if (root.right == null) return 1 + minDepth(root.left);
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
    
    public static void main(String[] args) {
        // Test 1: null tree -> expected 0
        TreeNode t1 = null;

        // Test 2: single node -> expected 1
        TreeNode t2 = new TreeNode(1);

        // Test 3: balanced tree -> expected 3
        //        1
        //       / \
        //      2   3
        //     / \ / \
        //    4  5 6  7
        TreeNode t3 = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6),
                        new TreeNode(7)));

        // Test 4: left-skewed tree -> expected 4
        //    1
        //   /
        //  2
        // /
        // 3
        ///
        //4
        TreeNode t4 = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3,
                                new TreeNode(4), null), null), null);

        // Test 5: deep node on an inner branch -> expected 4
        //        1
        //       / \
        //      2   3
        //       \
        //        4
        //         \
        //          5
        //         /
        //        6
        TreeNode t5 = new TreeNode(1,
                new TreeNode(2, null,
                        new TreeNode(4, null,
                                new TreeNode(5,
                                        new TreeNode(6), null))),
                new TreeNode(3));

        System.out.println("Test 1 (null tree)         | Expected: 0 | Got: " + minDepth(t1));
        System.out.println("Test 2 (single node)       | Expected: 1 | Got: " + minDepth(t2));
        System.out.println("Test 3 (balanced tree)     | Expected: 3 | Got: " + minDepth(t3));
        System.out.println("Test 4 (left-skewed)       | Expected: 4 | Got: " + minDepth(t4));
        System.out.println("Test 5 (deep inner branch) | Expected: 2 | Got: " + minDepth(t5));
    }
}
