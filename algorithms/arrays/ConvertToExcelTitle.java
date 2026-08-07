// bijective base-26
public class ConvertToExcelTitle {
    public static String convertToExcelTitle(int input) {
        if (input == 0) {
            return "";
        }

        input--; // otherwise will do 26 % 26 = 0, need 0-indexed range

        char letter = (char) ('A' + input % 26);
        return convertToExcelTitle(letter / 26) + letter;
    }

    public static void main(String[] args) {
        int test1 = 1;
        int test2 = 28;
        int test3 = 701;
        System.out.println(test1); // A
        System.out.println(test2); // AB
        System.out.println(test3); // ZY
    }
}
