class Solution {
    public int equalPairs(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length; 
        HashMap<String, Integer> map = new HashMap<>();

        for(int row[]: grid)
        {
            String str = "";
            for(int i: row)
            {
                str =str + i +",";
            }
            map.put(str, map.getOrDefault(str,0) + 1);
        }
        for(int i = 0 ; i < m ; i++)
        {
            String str ="";
            for(int j = 0 ; j < n; j++)
            {
                str += grid[j][i] +",";
            }
            if(map.containsKey(str))
            {
                ans += map.get(str);
            }
        }
        return ans;
    }
}