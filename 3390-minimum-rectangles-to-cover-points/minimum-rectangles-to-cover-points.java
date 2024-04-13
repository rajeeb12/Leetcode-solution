class Solution {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        Arrays.sort(points, (a,b) -> a[0] - b[0]);
    
        int n  = points.length;
        int count = 0;
        int last = -1; 
        for(int[] a: points){
            if(a[0] > last){
                count++;
                last = a[0] + w;
            }
        }
        return count;
    }
}