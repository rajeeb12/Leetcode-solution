class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int distance[][]= new int[n][n];
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(distance[i], (int)1e9);
            distance[i][i] = 0;
        }

        for(int edge[]: edges)
        {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            distance[u][v] = wt;
            distance[v][u] = wt; 
        }
        for(int via = 0 ; via < n; via++)
        {
            for(int i = 0; i < n ; i++)
            {
                for(int j = 0 ; j < n ; j++)
                {
                    distance[i][j] = Math.min(distance[i][j], distance[i][via] + distance[via][j]);
                }
            }
        }
        int minCity = (int)1e9;
        int city = -1;
        for(int i = 0 ; i < n ; i++)
        {
            int count = 0;
            for(int j = 0; j < n; j++)
            {
                if(i == j) continue;
                if(distance[i][j] <=distanceThreshold)
                {
                    count++;
                }
            }
            if(count <= minCity)
            {
                minCity = count;
                city = i;
            }
        }
        return city;
    }
}