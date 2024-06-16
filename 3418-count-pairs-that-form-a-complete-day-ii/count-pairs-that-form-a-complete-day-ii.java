class Solution {
    
    public long countCompleteDayPairs(int[] hours) {
        int remainder[] = new int[25];
        long ans = 0;
        for(int i: hours){
            int rem = i % 24;
            int kx = remainder[(24 - rem) % 24];
            ans += kx;
            remainder[rem]++;
        }
        
        return ans;
    }
}