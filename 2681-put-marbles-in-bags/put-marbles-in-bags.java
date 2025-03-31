class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        long pairSum[] = new long[n - 1];
        
        for(int i = 0; i < n - 1; i++){
            long sum = weights[i] + weights[i + 1];
            pairSum[i] = sum;
        }

        Arrays.sort(pairSum);
        // left will give min sum, and have to take k - 1 pairs - for doubt dry 
        // right will give max sum, and have to take k - 1 pairs - for doubt dry 
        long min = 0;
        long max = 0;
        for(int i = 0; i < k - 1; i++){
            min += pairSum[i];
            max += pairSum[pairSum.length - i - 1];
        }
        return max - min;
    }
}