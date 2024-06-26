class Solution {
    public int maxDepth(String s) {
        int count = 0;
        int ans = 0;
        for(char c: s.toCharArray())
        {
            if(c == '(')
            {
                ans = Math.max(ans, ++count);
            }else if(c == ')')
            {
                --count;
            }
        }
        return ans;
    }
}