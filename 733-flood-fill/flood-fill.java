class Pair{
    int i;
    int j;
    int color;
    public Pair(int _i,int _j,int _c)
    {
        this.i = _i;
        this.j = _j;
        this.color = _c;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr,sc,image[sr][sc]));
        
        int n = image.length;
        int m = image[0].length;
        int di[]={1,-1,0,0};
        int dj[]={0,0,1,-1};
        int visited[][] = new int[n][m];

        visited[sr][sc] = 1;

        while(!q.isEmpty())
        {
            int size= q.size();
            for(int i = 0; i < size; i++)
            {
                Pair p = q.poll();
                int x = p.i;
                int y = p.j;
                int c = p.color;

                image[x][y] = color;

                for(int k = 0; k < 4; k++)
                {
                    int ni = x + di[k];
                    int nj = y + dj[k];
                    if(ni >= 0 && nj >= 0 && ni < n && nj < m && image[ni][nj] == c && visited[ni][nj] == 0)
                    {
                        visited[ni][nj] = 1;
                        q.add(new Pair(ni,nj, c));
                    }
                }
            }
        }
        return image;
    }
}