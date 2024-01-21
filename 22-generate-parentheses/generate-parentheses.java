class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper("",n,0 ,0 ,ans);
        return ans;
    }
    public void helper(String str, int maxOpenBracket,int open,int close, List<String> ans)
    {
        if(str.length() == 2 * maxOpenBracket)
        {
            ans.add(str);
            return;
        }

        if(open < maxOpenBracket)
        {
            helper(str+ "(", maxOpenBracket, open + 1,close,ans);
        }
        if(close < open)
        {
            helper(str + ")" , maxOpenBracket, open, close + 1, ans);
        }
    }

}