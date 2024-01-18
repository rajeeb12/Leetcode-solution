class Solution {
    public int trap(int[] h) {
        int totalSum = 0 ;
        int n = h.length;
        int prefix[] = new int[n];
        int suffix[] = new int[n];
        prefix[0] = h[0];
        suffix[n-1] = h[n-1];
        
        for(int i = 1 ; i < n ; i++)
        {
            prefix[i] = Math.max(h[i], prefix[i - 1] );
            suffix[n - i - 1] = Math.max(h[n - i - 1], suffix[n - i]);
        }

        for(int i = 0 ; i < n ; i++)
        {
            totalSum += (Math.min(prefix[i] , suffix[i]) - h[i]);
        }
        return totalSum;
    }
}