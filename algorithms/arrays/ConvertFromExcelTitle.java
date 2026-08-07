// A is worth 1, B is worth 26 (base) + B's value (2) => AB is 28
public class ConvertFromExcelTitle {

    public static int convertFromExcelTitle(String input) {
        int result = 0;

        for (char ch : input.toCharArray()) {
            int value = ch - 'A' + 1; // convert the letter to its number: A=1, B=2, ..., Z=26
            result = result * 26 + value; // shift existing total left one place, add new digit
        }

        return result;
    }

    public static void main(String[] args) {
        String test1 = "A";
        String test2 = "AB";
        String test3 = "ZY";

        System.out.println(convertFromExcelTitle(test1)); // 1
        System.out.println(convertFromExcelTitle(test2)); // 28
        System.out.println(convertFromExcelTitle(test3)); // 701
    }
}
