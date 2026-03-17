class Solution {
    public int climbStairs(int n) {
        if(n <= 2) return n;
        int prev = 1, pprev = 2;
        for(int i = 3; i <= n; i++){
            int cur = prev + pprev;
            prev = pprev;
            pprev = cur;
        }
        return pprev;
    }
}