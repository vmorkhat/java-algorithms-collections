public class MedianOfTwoSortedArrays {
    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length]; // base for merged arrays
        int i = 0, j = 0, k = 0; // pointers for nums1, nums2 and merged arrays

        while (i < nums1.length && j < nums2.length) { // merge two arrays
            if (nums1[i] <= nums2[j]) merged[k++] = nums1[i++];
            else merged[k++] = nums2[j++];
        }

        while (i < nums1.length) merged[k++] = nums1[i++]; // append remaining elements
        while (j < nums2.length) merged[k++] = nums2[j++];

        // find the median
        int mid = merged.length / 2;
        if (merged.length % 2 == 0) return (merged[mid - 1] + merged[mid]) / 2.0; // if odd return median of two middle numbers
        else return merged[mid]; // if even return the value in the middle
    }

    public static void main (String[] args) {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};
        int[] nums3 = new int[]{1, 2};
        int[] nums4 = new int[]{3, 4};

        System.out.println(findMedianSortedArrays(nums1, nums2)); // should be 2.00000
        System.out.println(findMedianSortedArrays(nums3, nums4)); // should be 2.50000
    }
}
