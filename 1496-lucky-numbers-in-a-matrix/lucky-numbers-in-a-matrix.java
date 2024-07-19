class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int minr = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            int min = matrix[i][0];
            for(int j = 1; j < m; j++){
                min = Math.min(min, matrix[i][j]);
            }
            minr = Math.max(minr, min);
        }
        
        int maxc = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++){
            int max = matrix[0][i];
            for(int j = 1; j < n; j++){
                max = Math.max(max, matrix[j][i]);
            }
            maxc = Math.min(maxc, max);
        }
        if(minr == maxc){
            return new ArrayList<>(Arrays.asList(minr));
        }
        return new ArrayList<>();
    }
}