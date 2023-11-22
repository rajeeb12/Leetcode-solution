class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q= new LinkedList<>();
        int n =  grid.length;
        int m = grid[0].length;
        int countOranges = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j=0; j < grid[0].length; j++){
                if(grid[i][j] == 2){ // storing position of 2 in queue
                    q.add(new int[]{i,j});
                }
                if(grid[i][j] != 0){ 
                    countOranges++;
                }
            }
        } 
        if(countOranges == 0) return 0;

        int di[]= {-1,1,0,0};
        int dj[]= {0,0,-1,1};
        int minTime = 0;
        int rotten = 0;

        while(!q.isEmpty())
        {
            int size = q.size();
            rotten += size;
            for(int i = 0 ; i < size; i++)
            {
                int temp[] = q.poll();
                int x =temp[0];
                int y =temp[1];
                for(int j = 0 ; j < 4; j++)
                {
                    int nextX = x + di[j];
                    int nextY = y + dj[j];

                    if(nextX >=0 && nextY >= 0 && nextX < n && nextY < m && grid[nextX][nextY] != 2 && grid[nextX][nextY] != 0){
                        grid[nextX][nextY] = 2;
                        q.add(new int[]{nextX, nextY});
                    }
                }
            }
            minTime++;
        }
        System.out.print(rotten +""+countOranges);
        return (rotten == countOranges ? minTime - 1 : -1);

    }
}