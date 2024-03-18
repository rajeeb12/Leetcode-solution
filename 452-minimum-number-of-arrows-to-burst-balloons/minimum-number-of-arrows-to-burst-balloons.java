class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;

        Arrays.sort(points,(a,b) -> Integer.compare(a[1], b[1]));
        int countArrows = 1;
        int end = points[0][1];

        for(int i = 1; i < points.length; i++)
        {
            if(end >= points[i][0])
            {
                continue;
            }
            countArrows++;
            end = points[i][1];
        }
        return countArrows;
    }
}