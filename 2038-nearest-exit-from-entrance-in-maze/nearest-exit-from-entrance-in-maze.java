class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;
        boolean visited[][] = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{entrance[0],entrance[1], 0});
        visited[entrance[0]][entrance[1]] = true;
        
        int di[] = {1, -1, 0 ,0};
        int dj[] = {0, 0, 1, -1};

        while(!q.isEmpty()){
            int temp[] = q.poll();
            int u = temp[0];
            int v = temp[1];
            int count = temp[2];

            for(int i = 0; i < 4; i++){
                int ni = u + di[i];
                int nj = v + dj[i];
                if(ni >= 0 && nj >= 0 && ni < n && nj < m && !visited[ni][nj] && maze[ni][nj] == '.'){
                    if(ni == 0 || nj == 0 || ni == n - 1 || nj == m - 1) return count + 1;
                     q.add(new int[]{ni, nj, count + 1});
                     visited[ni][nj] = true;
                }
            }
        } 
        return -1;
    }
}