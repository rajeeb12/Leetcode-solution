class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        for(int[] m: matrix)
        {
            int low = 0, high = m.length - 1;
            while(low <= high)
            {
                int mid = (low + high) >> 1;
                if(m[mid] == target)
                {
                    return true;
                }else if(m[mid] < target){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}