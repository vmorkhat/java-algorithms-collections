/*
O(n) since traverses the whole array;
 */
public class RomanToInt {
    public static int romanToInt(String s) {
        int result = 0;
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            int curr = getValue(arr[i]);
            int next = (i + 1 < arr.length) ? getValue(arr[i + 1]) : 0; // get the next value, default to 0 if at the end

            if (curr < next) {
                result -= curr; // subtractive pair (e.g. IV, IX), subtract current
            } else {
                result += curr; // normal case, add current
            }
        }
        return result;
    }

    private static int getValue(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III")); // should be 3
        System.out.println(romanToInt("LVIII")); // should be 58
        System.out.println(romanToInt("MCMXCIV")); // should be 1994
    }
}
