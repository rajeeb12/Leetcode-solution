class Pair{
    int i;
    int j;
    public Pair(int _i,int _j)
    {
        this.i = _i;
        this.j = _j;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr,sc));
        
        int curColor = image[sr][sc];
        int n = image.length;
        int m = image[0].length;
        int di[]={1,-1,0,0};
        int dj[]={0,0,1,-1};
        int visited[][] = new int[n][m];

        while(!q.isEmpty())
        {
            int size= q.size();
            for(int i = 0; i < size; i++)
            {
                Pair p = q.poll();
                int x = p.i;
                int y = p.j;

                image[x][y] = color;

                for(int k = 0; k < 4; k++)
                {
                    int ni = x + di[k];
                    int nj = y + dj[k];
                    if(ni >= 0 && nj >= 0 && ni < n && nj < m){
                        if(image[ni][nj] == color) continue;

                        if(image[ni][nj] == curColor)
                        {
                            visited[ni][nj] = 1;
                            q.add(new Pair(ni,nj));
                        }
                    }
                }
            }
        }
        return image;
    }
}