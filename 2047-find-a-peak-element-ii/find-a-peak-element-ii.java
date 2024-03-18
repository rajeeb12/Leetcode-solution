class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int low = 0, high = m - 1;
        while(low <= high)
        {
            int mid = (low + high) >> 1;
            int row = findMax(mat,mid,n);

            int leftValue = mid - 1 >= 0 ? mat[row][mid - 1] : -1;
            int rightValue = mid + 1 < m ? mat[row][mid + 1] : -1;
            if(mat[row][mid] > leftValue && mat[row][mid] > rightValue)
            {
                return new int[]{row, mid};
            }else if(mat[row][mid] < leftValue)
            {
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return new int[]{-1,-1};
    }
    public int findMax(int mat[][],int col,int n)
    {
        int maxRow = 0;
        int max = 0;  
        for(int i = 0 ; i < n; i++)
        {
            if(max < mat[i][col])
            {
                maxRow = i;
                max = mat[i][col];
            }
        }
        return maxRow; 
    }
}