class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(color == image[sr][sc]) return image;
        
        dfs(image,sr, sc, color, image[sr][sc]);
        return image;
    }
    public void dfs(int image[][],int r,int c,int color,int originalColor){
        if(r < 0 || c < 0 || r >= image.length || c >= image[0].length) return;

        if(image[r][c] != originalColor) return;

        image[r][c] = color;

        dfs(image, r + 1, c, color, originalColor);
        dfs(image, r - 1, c, color, originalColor);
        dfs(image, r, c + 1, color, originalColor);
        dfs(image, r, c - 1, color, originalColor);
    }
}