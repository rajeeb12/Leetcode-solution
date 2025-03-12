class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int r1 = 0, r2 = matrix.length - 1, c1 = 0, c2 = matrix[0].length - 1;
        List<Integer> ans = new ArrayList<>();
        while(r1 <= r2 && c1 <= c2){

            for(int j = c1; j <= c2; j++){
                ans.add(matrix[r1][j]);
            }
            r1++;

            for(int i = r1; i <= r2; i++){
                ans.add(matrix[i][c2]);
            }
            c2--;

            if(r1 <= r2){
                for(int j = c2; j >= c1; j--){
                    ans.add(matrix[r2][j]);
                }
                r2--;
            }
            if(c1 <= c2){
                for(int i = r2; i >= r1; i--){
                    ans.add(matrix[i][c1]);
                }
                c1++;
            }
        }
        return ans;
    }
}