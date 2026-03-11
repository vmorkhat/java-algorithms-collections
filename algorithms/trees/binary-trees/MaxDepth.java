/*
O(n) time complexity, every node is visited exactly once.
Uses DFS, post-order traversal;
 */
public class MaxDepth {

    private class TreeNode {
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

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right)); // take the deeper subtree, +1 counts the current node itself
    }

    public static void main(String[] args) {
        MaxDepth md = new MaxDepth();

        // Test 1: null tree -> expected 0
        TreeNode t1 = null;

        // Test 2: single node -> expected 1
        TreeNode t2 = md.new TreeNode(1);

        // Test 3: balanced tree -> expected 3
        //        1
        //       / \
        //      2   3
        //     / \ / \
        //    4  5 6  7
        TreeNode t3 = md.new TreeNode(1,
                md.new TreeNode(2,
                        md.new TreeNode(4),
                        md.new TreeNode(5)),
                md.new TreeNode(3,
                        md.new TreeNode(6),
                        md.new TreeNode(7)));

        // Test 4: left-skewed tree -> expected 4
        //    1
        //   /
        //  2
        // /
        // 3
        ///
        //4
        TreeNode t4 = md.new TreeNode(1,
                md.new TreeNode(2,
                        md.new TreeNode(3,
                                md.new TreeNode(4), null), null), null);

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
        TreeNode t5 = md.new TreeNode(1,
                md.new TreeNode(2, null,
                        md.new TreeNode(4, null,
                                md.new TreeNode(5,
                                        md.new TreeNode(6), null))),
                md.new TreeNode(3));

        System.out.println("Test 1 (null tree)         | Expected: 0 | Got: " + md.maxDepth(t1));
        System.out.println("Test 2 (single node)       | Expected: 1 | Got: " + md.maxDepth(t2));
        System.out.println("Test 3 (balanced tree)     | Expected: 3 | Got: " + md.maxDepth(t3));
        System.out.println("Test 4 (left-skewed)       | Expected: 4 | Got: " + md.maxDepth(t4));
        System.out.println("Test 5 (deep inner branch) | Expected: 5 | Got: " + md.maxDepth(t5));
    }
}
