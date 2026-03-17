class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int rows = matrix.length, columns = matrix[0].length;
        int height[] = new int[columns];
        int ans = 0;

        for(int row = 0; row < rows; row++)
        {
            for(int j = 0; j < columns; j++){
                if(matrix[row][j] == 1){
                    height[j] += 1;
                }else{
                    height[j] = 0;
                }
            }

            int temp[] = new int[columns];
            for(int i = 0; i < columns; i++){
                temp[i] = height[i];
            }
            // sort pillar
            Arrays.sort(temp);

            for(int j = 0; j < columns; j++){
                ans = Math.max(ans, temp[j] * (columns - j));
            }
        }
        return ans;
    }
}