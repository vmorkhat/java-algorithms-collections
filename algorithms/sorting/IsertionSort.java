/*
Insertion sort divides an array into sorted (left) and unsorted (right) parts, and inserts elements to the sortet part
according to its position comparing them to the previous elements in the sorted part.
Works better on smaller chunks of data.
Best Time Complexity: O(n)
Average Time Complexity: O(n^2)
Worst Time Complexity: O(n^2)
Space Complexity: O(1)
 */
import java.util.Arrays;
import java.util.stream.IntStream;

public class IsertionSort<T extends Comparable<T>> {

    private final T[] items;

    public IsertionSort(T[] items) {
        this.items = items;
    }

    public void sortSimple() {
        for (int i = 1; i < items.length; i++) {
            int j = i;
            while (j > 0 && items[j].compareTo(items[j - 1]) < 0) {
                T temp = items[j];
                items[j] = items[j - 1];
                items[j - 1] = temp;
                j--;
            }
        }
    }

    public void sortStream(int index) {
        if (index > 0 && items[index].compareTo(items[index - 1]) < 0) {
            T temp = items[index];
            items[index] = items[index - 1];
            items[index - 1] = temp;
            sortStream(index - 1);
        }
    }

    public void sortStream() {
        IntStream.range(1, items.length)
                .forEach(this::sortStream);
    }

    public static void main(String[] args) {
        Integer[] exampleInt = {2, 5, 3, 1, 4};
        String[] exampleStr = {"B", "A", "C", "D", "F", "E"};
        System.out.println(Arrays.toString(exampleInt) + " | " + Arrays.toString(exampleStr));
        new IsertionSort<>(exampleInt).sortSimple();
        new IsertionSort<>(exampleStr).sortStream();
        System.out.println(Arrays.toString(exampleInt) + " | " + Arrays.toString(exampleStr));
    }
}