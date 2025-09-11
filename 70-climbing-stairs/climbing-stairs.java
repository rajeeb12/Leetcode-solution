class Solution {
    public int climbStairs(int n) {
        int cur = 0, prev = 1, prevprev = 1;

        for(int i = 2; i <= n; i++){
            cur = prev + prevprev;
            prevprev = prev;
            prev = cur;
        }
        return prev;
    }
}