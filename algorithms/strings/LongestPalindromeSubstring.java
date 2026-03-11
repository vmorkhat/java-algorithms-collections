/*
O(n^2) time complexity, since does more than a single linear scan of the passed string;
Expand around center algorithm, as pointers move in opposite direction (two pointer motion), but it is re-initialized at every center.
Also, two pointers are usually O(n);
*/
public class LongestPalindromeSubstring {

    private static String longestPalindrome(String str) {
        int start = 0, maxLen = 1; // any single character is a palindrome, so minimum length is 1

        // visit every character as a potential palindrome center
        for (int i = 0; i < str.length(); i++) {

            // --- Odd-length expansion ---
            // both pointers start at the same character (single center, e.g. "racecar" -> 'e')
            int l1 = i, r1 = i;
            while (l1 >= 0 && r1 < str.length() && str.charAt(l1) == str.charAt(r1)) { // characters must mirror each other
                if (r1 - l1 + 1 > maxLen) { // check if this expansion beat the current best
                    maxLen = r1 - l1 + 1; // r - l + 1 converts pointer positions to a length
                    start = l1;           // record where this palindrome begins
                }
                l1--; // expand outward
                r1++;
            }

            // --- Even-length expansion ---
            // pointers start on adjacent characters (no single center, e.g. "abba" -> between b's)
            int l2 = i, r2 = i + 1;
            while (l2 >= 0 && r2 < str.length() && str.charAt(l2) == str.charAt(r2)) { // characters must mirror each other
                if (r2 - l2 + 1 > maxLen) { // check if this expansion beat the current best
                    maxLen = r2 - l2 + 1;
                    start = l2;
                }
                l2--; // expand outward
                r2++;
            }
        }

        // slice out the longest palindrome found using start index and length
        return str.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        String input1 = "badad";
        String input2 = "cbbd";
        System.out.println(longestPalindrome(input1)); // "badad" -> odd-length, center is 'd', result: "adada" or "badad"
        System.out.println(longestPalindrome(input2)); // "cbbd" -> even-length, center between b's, result: "bb"
    }
}
