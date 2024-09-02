class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        
        int ans[][] = new int[m][n];
        
        if((original.length > m * n) || (original.length < m * n)) return new int[][]{};

        int row = 0;
        for(int i = 0; i < original.length; i++){
            ans[row][i % n] = original[i];
            if(i % n == n - 1) row++;
        }
        return ans;
    }
}