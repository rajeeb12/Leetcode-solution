class Solution {
    public int findLongestChain(int[][] pairs) {
        
        int n = pairs.length;
        

        Arrays.sort(pairs, (a,b) -> a[1] - b[1]);
        int max = 1;
        for(int i = 0; i < n; i++)
        {
            int si = pairs[i][0];
            int ei = pairs[i][1];
            int count = 1;
            for(int j = i + 1; j < n; j++)
            {
                if(ei < pairs[j][0]){
                    ei = pairs[j][1];
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}