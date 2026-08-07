import java.util.Arrays;

public class ConvertSortedArrayToBinarySearchTree {

    private static class TreeNode {
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

    // Recursive solution
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;

        int mid = nums.length / 2; // exact middle if odd, upper middle if even
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid)); // extract subarray from the both sides
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, nums.length));
        return root;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-10, -3, 0, 5, 9};

        TreeNode root = sortedArrayToBST(nums);
        System.out.println(root.val);        // 0
        System.out.println(root.left.val);   // -3
        System.out.println(root.right.val);  // 9
    }
}
