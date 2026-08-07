// Boyer-Moore Majority Voting Algorithm
public class MajorityElement {

    public static int majorityInt(int[] nums) {
        int candidate = nums[0];
        int candidateCount = 0; // uncancelled votes

        for (int num : nums) {
            if (candidateCount == 0) {
                candidate = num;
            }

            if (num == candidate) {
                candidateCount++; // add vote
            } else {
                candidateCount--; // cancel vote
            }
        }

        return candidate;
    }

    public static void main(String[] args) {
        int[] nums1 = {3,2,3};
        int[] nums2 = {2,2,1,1,1,2,2};

        System.out.println(majorityInt(nums1)); // 3
        System.out.println(majorityInt(nums2)); // 2
    }
}
