class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int track[][] = new int[n][m];
        for(int i[]: track){
            Arrays.fill(i, -1);
        }
        int di[] = {1,-1,0,0};
        int dj[] = {0,0,1,-1};
        Queue<int[]> q =new LinkedList<>();
        q.add(new int[]{sr, sc});
        track[sr][sc] = 1;
        int startingColor = image[sr][sc];
        image[sr][sc] = color;
        while(!q.isEmpty()){
            int cor[] = q.poll();
            for(int itr = 0; itr < 4; itr++){
                int nexti = di[itr] + cor[0];
                int nextj = dj[itr] + cor[1];
                if(nexti >= 0 && nextj >= 0 && nexti < n && nextj < m && image[nexti][nextj] == startingColor && track[nexti][nextj] == -1){
                    image[nexti][nextj] = color;
                    track[nexti][nextj] = 1;
                    q.add(new int[]{nexti, nextj});
                }
            }
        }
        return image;
    }
}