class Solution {
    public int findLongestChain(int[][] pairs) {
        
        int n = pairs.length;
        
        Arrays.sort(pairs, (a,b) -> a[1] - b[1]);
        int minInt = -(int)1e9;
        int max = 0;
        for(int i = 0; i < n; i++)
        {
            if(minInt < pairs[i][0])
            {
                minInt = pairs[i][1];
                max++;
            }
        }
        return max;
    }
}