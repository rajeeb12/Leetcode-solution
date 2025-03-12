class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp; 
            }
        }
        for(int i[]: matrix){
            int start = 0 , end = n - 1;
            while(start <= end){
                int temp = i[start];
                i[start] = i[end];
                i[end] = temp;
                start++;
                end--; 
            }
        }
    }
}