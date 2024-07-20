class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n = rowSum.length;
        int m = colSum.length;
        int ans[][]= new int[n][m];

        int i = 0, j = 0;

        while(i < n && j < m){
            int min = Math.min(rowSum[i] , colSum[j]);
            ans[i][j] = min;
            rowSum[i] -= min;
            colSum[j] -= min;

            if(rowSum[i] == 0){
                i++;
            }
            if(colSum[j] == 0){
                j++;
            }
        }
        return ans;
    }
}