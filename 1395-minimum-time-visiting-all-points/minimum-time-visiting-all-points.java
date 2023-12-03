class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int sum = 0;
        int size = points.length;
        for(int i = 0 ; i < size - 1; i++)
        {
            int x1 = points[i][0];
            int y1 = points[i][1];
            int x2 = points[i+1][0];
            int y2 = points[i+1][1];
            
            int dx = Math.abs(x1 - x2);
            int dy = Math.abs(y1 - y2);
            sum += Math.min(dx , dy) + Math.abs(dx - dy);
        }
        return sum;
    }
}