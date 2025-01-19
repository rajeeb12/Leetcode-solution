class Solution {
    public int trapRainWater(int[][] heightMap) {
        int n = heightMap.length, m = heightMap[0].length;
        if(n == 0 || m == 0) return 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        int visited[][] = new int[n][m];

        for(int i = 0; i < m; i++){
            pq.add(new int[]{heightMap[0][i], 0, i});
            visited[0][i] = 1;
        }
        for(int i = 0; i < n; i++){
            pq.add(new int[]{heightMap[i][0], i, 0});
            visited[i][0] = 1;
        }
        for(int i = 0; i < n; i++){
            pq.add(new int[]{heightMap[i][m - 1], i, m - 1});
            visited[i][m - 1] = 1;
        }
        for(int i = 0; i < m; i++){
            pq.add(new int[]{heightMap[n - 1][i], n - 1, i});
            visited[n - 1][i] = 1;
        }

        
        int di[] = {1,-1,0,0};
        int dj[] = {0,0,1,-1};
        int ans = 0;
        while(!pq.isEmpty())
        {
            int temp[] = pq.poll();
            int height = temp[0] , x = temp[1], y = temp[2];

            for(int i = 0; i < 4; i++){
                int nx = x + di[i];
                int ny = y + dj[i];

                int max = 0;
                if(nx >= 0 && ny >= 0 && nx < n && ny < m && visited[nx][ny] != 1){
                    ans += Math.max(0, height - heightMap[nx][ny]);
                    pq.add(new int[]{Math.max(height, heightMap[nx][ny]) , nx, ny});
                    visited[nx][ny] = 1;
                }
            }
        }
        return ans;
    }
}