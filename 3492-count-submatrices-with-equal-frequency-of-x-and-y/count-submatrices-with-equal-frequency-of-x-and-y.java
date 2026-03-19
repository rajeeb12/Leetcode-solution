class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int nRows = grid.length;
        int nCols = grid[0].length;

        int[][] pSumX = new int[nRows + 1][nCols + 1];
        int[][] pSumY = new int[nRows + 1][nCols + 1];

        // Calculate prefix sums for 'X' and 'Y'
        for (int row = 0; row < nRows; ++row) {
            for (int col = 0; col < nCols; ++col) {
                pSumX[row + 1][col + 1] = pSumX[row][col + 1] + pSumX[row + 1][col] - pSumX[row][col] + (grid[row][col] == 'X' ? 1 : 0);
                pSumY[row + 1][col + 1] = pSumY[row][col + 1] + pSumY[row + 1][col] - pSumY[row][col] + (grid[row][col] == 'Y' ? 1 : 0);
            }
        }

        int count = 0;

        for (int startRow = 0; startRow < nRows; ++startRow) {
            for (int startCol = 0; startCol < nCols; ++startCol) {
                if (startRow == 0 && startCol == 0) {
                    for (int endRow = startRow; endRow < nRows; ++endRow) {
                        for (int endCol = startCol; endCol < nCols; ++endCol) {
                            int countX = pSumX[endRow + 1][endCol + 1] - pSumX[startRow][endCol + 1] - pSumX[endRow + 1][startCol] + pSumX[startRow][startCol];
                            int countY = pSumY[endRow + 1][endCol + 1] - pSumY[startRow][endCol + 1] - pSumY[endRow + 1][startCol] + pSumY[startRow][startCol];
                            if (countX == countY && countX > 0) {
                                count++;
                            }
                        }
                    }
                }
            }
        }

        return count;
    }
}