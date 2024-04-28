class Solution {
    public long minEnd(int n, int x) {
        long num = x;
        
        for(int i = n - 1; i > 0; i--)
        {
            num = (num + 1) | x;
        }
        return num;
    }
}