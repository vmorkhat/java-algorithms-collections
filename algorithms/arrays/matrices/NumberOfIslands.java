package matrices;

public class NumberOfIslands {

    public static int numberOfIslands(char[][] field) {
        int result = 0;

        for (int rowNumber = 0; rowNumber < field.length; rowNumber++) {
            for (int columnNumber = 0; columnNumber < field[rowNumber].length; columnNumber++) {
                if (field[rowNumber][columnNumber] == '1') {
                    result += 1;
                    callBfs(field, rowNumber, columnNumber);
                }
            }
        }

        return result;
    }

    private static void callBfs(char[][] field, int row, int column) {
        if (row < 0 || row >= field.length || column < 0 || column >= field[row].length || field[row][column] == '0') {
            return;
        }

        // set 1 as 0 == mark as visited
        // erase the entire connected island so it's not counted again.
        field[row][column] = '0';
        callBfs(field, row+1, column); // down
        callBfs(field, row-1, column); // up
        callBfs(field, row, column+1); // right
        callBfs(field, row, column-1); // left
    }

    public static void main(String[] args) {
        char[][] input = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(numberOfIslands(input)); // should be 1
    }
}
