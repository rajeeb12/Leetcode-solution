class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length; 
        for(int i = 0 ; i < n ; i++)
        {
            int firstDigit = matrix[i][0];
            int lastDigit = matrix[i][m-1];
            if(target >= firstDigit && target <= lastDigit)
            {
                if(bSearch(i,matrix, target)){
                    return true;
                }else{
                    return false;
                }
            }
        }
        return false;
    }
    public boolean bSearch(int row,int[][] matrix,int target)
    {
        int left = 0;
        int right = matrix[0].length-1;

        while(left <= right)
        {
            int mid = (left + right) >> 1;
            if(matrix[row][mid] == target)
            {
                return true;
            } 
            else if(matrix[row][mid] > target)
            {
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return false;
    }
}