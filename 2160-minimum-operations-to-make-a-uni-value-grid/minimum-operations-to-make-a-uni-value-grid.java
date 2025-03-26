class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int rem = grid[0][0] % x;
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] % x != rem) return -1;
                list.add(grid[i][j]);
            }
        }
        Collections.sort(list);
        int median = list.get((int)Math.floor(list.size() / 2));
        int min= 0;
        for(int i : list){
            min += (Math.abs(i - median) / x);
        }
        return min;
    }
}