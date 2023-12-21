class Comp implements Comparator<int[]>{
    public int compare(int[] a , int[] b)
    {
        return a[0] - b[0];
    }
}
class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, new Comp());
        int max = 0;
        for(int i= 1; i < points.length; i++)
        {
            int x = points[i][0];
            int y = points[i-1][0];

            max= Math.max(max, x - y); 
        }
        return max;
    }
}