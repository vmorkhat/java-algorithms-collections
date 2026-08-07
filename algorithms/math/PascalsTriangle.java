/*
Pascal's triangle is an infinite table of binomial coefficients having a triangular shape.
In this triangle, there are units at the top and on the sides.
Each number is equal to the sum of the two numbers above it.
The lines of the triangle are symmetrical with respect to the vertical axis.

The method generateRow returns the specified string of Pascal's triangle as an array of integers.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays; // for using Arrays.ToString()

public class PascalsTriangle {
    public static int factorial(int n) { // n! = n * (n - 1) * (n  - 2) * (n - 3) * ... * 3 * 2 * 1
        int result = 1;

        for (int i = 1; i <= n; i++) { // '<=' here since we must multiply on n too
            result *= i; // result = result * i
        }
        return result;
    }

    public static int[] generateRow(int row) { // use factorial method to calculate the value of each element in the row
        int[] result = new int[row + 1]; // the numeration of rows in Pascal's triangle starts with 0
        for (int i = 0; i <= row; i++) {
            result[i] = factorial(row) / (factorial(i) * factorial(row - i));
        }
        return result;
    }


    public static List<List<Integer>> simplerPascalsTriangle(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);

        for (int i = 1; i < numRows; i++) {
            List<Integer> currentRow = new ArrayList<>();
            List<Integer> previousRow = result.get(i - 1);

            currentRow.add(1);

            for (int j = 1; j < i; j++) {
                currentRow.add(previousRow.get(j - 1) + previousRow.get(j));
            }

            currentRow.add(1);
            result.add(currentRow);
        }

        return result;
    }

    // return the array on the provided row index of the pascal's triangle
    public static List<Integer> pascalsTriangleTwo(int rowIndex) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        row.add(1);
        triangle.add(row);

        if (rowIndex == 0) {
            return row;
        }

        // should be bigger than one for index since it should start with 0
        for (int i = 1; i < rowIndex + 1; i++) {
            List<Integer> currentRow = new ArrayList<>();
            List<Integer> previousRow = triangle.get(i - 1);
            currentRow.add(1);

            for (int j = 1; j < i; j++) {
                currentRow.add(previousRow.get(j - 1) + previousRow.get(j));
            }

            currentRow.add(1);
            triangle.add(currentRow);
        }

        return triangle.get(rowIndex);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(generateRow(5)));
        System.out.println(simplerPascalsTriangle(5));

        System.out.println(pascalsTriangleTwo(3)); // should be [1,3,3,1]
    }
}
