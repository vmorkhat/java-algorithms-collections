import java.util.HashSet;
import java.util.Set;

/*
Sliding window without inner loop, both pointers move forward together;
Time complexity: O(n²) in worst case, O(n) usually as each character is added at most once;
 */

public class LongestSubstring {
    private static int longestSubstring(String input) {
        int length = input.length();
        // maxLength - length of a longest substring
        // left - left boundary of a sliding window
        int maxLength = 0, left = 0;
        Set<Character> charSet = new HashSet<>();

        for (int right = 0; right < length; right++) {
            if (!charSet.contains(input.charAt(right))) {
                charSet.add(input.charAt(right)); // add new char if unique
                maxLength = Math.max(maxLength, right - left + 1); // increase maxLength
            } else {
                while (charSet.contains(input.charAt(right))) {
                    charSet.remove(input.charAt(left)); // keep removing the leftmost character from the set
                    left++; // advance left until the duplicate is gone
                }
                charSet.add(input.charAt(right)); // add new char safely
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String example1 = "bbbbb";
        String example2 = "ababb";
        String example3 = "pwwkew";

        System.out.println(longestSubstring(example1)); // should be 1
        System.out.println(longestSubstring(example2)); // should be 2
        System.out.println(longestSubstring(example3)); // should be 3
    }
}
