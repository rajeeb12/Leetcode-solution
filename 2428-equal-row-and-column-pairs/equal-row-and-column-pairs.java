class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<String, Integer> rowMap = new HashMap<>();
        HashMap<String, Integer> colMap = new HashMap<>();
        int n = grid.length, i = 0, j = 0;
        while(n-- > 0){
            StringBuilder rowString = new StringBuilder();
            for(int col = 0; col < grid.length; col++){
                rowString.append(grid[i][col]+"|");
            }
            StringBuilder colString = new StringBuilder();
            for(int row = 0; row < grid.length; row++){
                colString.append(grid[row][j]+"|");
            }
            rowMap.put(rowString.toString(), rowMap.getOrDefault(rowString.toString(), 0) + 1);
            colMap.put(colString.toString(), colMap.getOrDefault(colString.toString(), 0) + 1);
            i++;
            j++;
        }
        int ans = 0;
        for(String key: rowMap.keySet()){
            if(colMap.containsKey(key)){
                ans += (rowMap.get(key) * colMap.get(key));
            }
        }
        return ans;
    }
}