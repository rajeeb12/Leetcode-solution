class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        if(s.length() == 0) return ans;
        HashSet<String> set = new HashSet<>();
        for(String str: wordDict){
            set.add(str);
        }
        solve(0,s,set,ans,"");
        return ans;
    }
    public void solve(int index,String s,HashSet<String> set,List<String> ans,String temp)
    {
        if(index == s.length()){
            ans.add(temp.substring(0,temp.length() - 1));
            return;
        }

        for(int i = index; i < s.length(); i++)
        {
            String substr = s.substring(index, i + 1);
            if(set.contains(substr)){
                solve(i + 1, s,set, ans, temp+substr+" ");
            }
        }
    }
}