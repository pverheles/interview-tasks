package islands;


/**
 * Given a char matrix MxN where cells marked with '~' char mean water and
 * cells marked with '*' char mean land, find number of islands (neighbour cells of '*')
 */
public class Islands {
    static int M = 6;
    static int N = 6;

    public static void main(String[] args) {

        char[][] matrix =   {
                {'~', '~', '~', '~', '~', '*',},
                {'~', '*', '*', '~', '~', '~',},
                {'~', '*', '*', '~', '~', '~',},
                {'~', '~', '~', '~', '*', '*',},
                {'~', '~', '~', '~', '~', '*',},
                {'*', '~', '~', '~', '~', '~',}
        };


        System.out.println(countIslands(matrix));

    }

    static int countIslands(char[][] sea) {
        int counter = 0;
        for (int row = 0; row < M; row++) {
            for (int col = 0; col < N; col++) {
                if (sea[row][col] == '*') {
                    counter++;
                    explore(sea, row, col);
                }
            }
        }

        return counter;
    }

    private static void explore(char[][] sea, int row, int col) {
        if (sea[row][col] == '~') {
            return;
        }

        sea[row][col] = '~';

        if (row != 0) {
            explore(sea, row - 1, col);
        }

        if (row < M - 1) {
            explore(sea, row + 1, col);
        }

        if (col != 0) {
            explore(sea, row, col - 1);
        }

        if (col < N - 1) {
            explore(sea, row, col + 1);
        }
    }
}
