class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 1; j < m; j++){
                matrix[i][j] += matrix[i][j - 1];  
            }
        }
        int ans = 0;
        for(int sc = 0; sc < m ; sc++)
        {
           for(int j = sc; j < m; j++){
                HashMap<Integer,Integer> map = new HashMap<>();
                int curSum = 0;
                map.put(0, 1);
                for(int row = 0; row < n; row++){
                    curSum += (sc > 0 ? matrix[row][j] - matrix[row][sc - 1] : matrix[row][j]);
                    int diff = curSum - target;
                    if(map.containsKey(diff)){
                        ans += map.get(diff);
                    }
                    map.put(curSum , map.getOrDefault(curSum, 0) + 1);
                }
            }
        }
        return ans;
    }
}