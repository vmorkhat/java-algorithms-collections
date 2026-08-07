import java.util.Stack;

public class SingleNumber {

    public static int singleNumber(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else {
            Stack<Integer> stack = new Stack<>();
            for (int num : nums) {
                if (stack.contains(num)) {
                    stack.remove((Integer) num); // cast to Integer to force the value-based overload
                } else {
                    stack.push(num);
                }
            }

            return stack.pop();
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 2, 1};
        int[] nums2 = {4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums1)); // 1
        System.out.println(singleNumber(nums2)); // 4
    }
}
