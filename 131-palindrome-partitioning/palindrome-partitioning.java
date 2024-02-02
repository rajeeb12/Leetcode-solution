class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        solve(0,s,ans,new ArrayList<>());
        return ans;
    }
    public void solve(int index,String s,List<List<String>> ans , List<String> temp)
    {
        if(index == s.length())
        {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i = index ; i < s.length(); i++)
        {
            String substr = s.substring(index, i + 1);
            if(check(substr))
            {
                temp.add(substr);
                solve(i + 1, s, ans, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
    public boolean check(String str)
    {
        if(str.length() == 0) return false;
        int start = 0 , end = str.length() - 1;

        while(start < end)
        {
            if(str.charAt(start) != str.charAt(end))
            {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}