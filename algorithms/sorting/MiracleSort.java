/*
This is a meme sorting which takes array and checks whether it sorted without actually doing something.
You have to wait for a miracle to happen, but it won't, so take charge of your life yourself!
 */
public class MiracleSort {

    public static void miracleSort(int[] items) {
        boolean sorted = true;

        while (!sorted) {
            sorted = true;
            for (int i = 1; i < items.length; i++) {
                if (items[i] < items[i - 1]) {
                    sorted = false;
                    break;
                }
            }
        }
    }
}