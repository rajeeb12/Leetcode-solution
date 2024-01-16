class Solution {
    int di[] = {-1,1,0,0};
    int dj[] = {0,0,-1,1};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m =  image[0].length;
        int vis[][]=new int[n][m];
        solve(image,sr,sc,color, n, m,vis,image[sr][sc]);

        return image;
    }
    public void solve(int image[][], int i, int j,int color,int n,int m,int[][] visited,int type)
    {
        image[i][j] = color;
        visited[i][j] = 1;

        for(int k = 0 ; k < 4; k++)
        {
            int nextI = i + di[k];
            int nextJ = j + dj[k];

            if(nextI >= 0 && nextJ >= 0 && nextI < n && nextJ < m && image[nextI][nextJ] == type && visited[nextI][nextJ] == 0)
            {
                System.out.print(nextI+" "+nextJ);
                solve(image, nextI,nextJ,color,n,m,visited, type);
            }
        }
    }
}