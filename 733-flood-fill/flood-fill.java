class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int track[][] = new int[image.length][image[0].length];
        for(int i[]: track){
            Arrays.fill(i, -1);
        }
        dfs(image,sr, sc, color, image[sr][sc], track);
        return image;
    }
    public void dfs(int image[][],int r,int c,int color,int originalColor,int track[][]){
        if(r < 0 || c < 0 || r >= image.length || c >= image[0].length || track[r][c] != -1) return;

        if(image[r][c] != originalColor) return;

        image[r][c] = color;
        track[r][c] = 1;

        dfs(image, r + 1, c, color, originalColor, track);
        dfs(image, r - 1, c, color, originalColor, track);
        dfs(image, r, c + 1, color, originalColor, track);
        dfs(image, r, c - 1, color, originalColor, track);
    }
}