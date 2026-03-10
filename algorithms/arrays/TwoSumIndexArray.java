// Return indices of the two number from the given array that they add up to the given target.
import java.util.Arrays;

public class TwoSumIndexArray {

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) { // can also be (target == nums[i] + nums[j])
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] example = {1, 7, 3, 2};
        int target = 9;
        int[] result = twoSum(example, target);
        System.out.println(Arrays.toString(result)); // must be [1, 3]
    }
}