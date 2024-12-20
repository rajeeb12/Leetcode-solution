class Solution {
    public int buttonWithLongestTime(int[][] events) {
        int ans = (int)1e9;
        int maxDiff = 0, prevDiff = 0;
        for(int event[]: events){
            int diff = event[1] - prevDiff;
            if(diff > maxDiff)
            {
                ans = event[0];
                maxDiff = diff;
            }
            if(diff == maxDiff){
                ans = Math.min(ans, event[0]);
            }
            prevDiff = event[1];
        }
        return ans;
    }
}