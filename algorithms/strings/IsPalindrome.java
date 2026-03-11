public class IsPalindrome {

    public static boolean isPalRecursive(String str) {
        if (str.isEmpty() || str.length() == 1) { // base
            return true;
        }

        if (str.charAt(0) == str.charAt(str.length() - 1)) {
            return isPalRecursive(str.substring(1, str.length() - 1));
        }
        return false;
    }

    public static boolean isPalIterative(String str) {
        int a = 0;
        int b = str.length() - 1;

        while (b > a) {
            if (str.charAt(a) != str.charAt(b)) {
                return false;
            }
            a++;
            b--;
        }
        return true;
    }

    public static boolean isPalInteger(int x) {
        String str = String.valueOf(x);
        int n = str.length();

        for (int i = 0; i < n/2; i++) {
            if (str.charAt(i) != str.charAt(n - i - 1)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String exampleTrue = "radar";
        String exampleFalse = "word";
        int exampleTrueInt = 121;
        int exampleFalseInt = 489;
        System.out.println(isPalRecursive(exampleTrue));
        System.out.println(isPalRecursive(exampleFalse));
        System.out.println(isPalIterative(exampleTrue));
        System.out.println(isPalIterative(exampleFalse));
        System.out.println(isPalInteger(exampleTrueInt));
        System.out.println(isPalInteger(exampleFalseInt));
    }
}