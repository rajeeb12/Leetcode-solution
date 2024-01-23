class Solution {
    int maxLength;
    public int maxLength(List<String> arr) {
        maxLength = 0;
        int n = arr.size();
        solve("",n - 1,arr);
        return maxLength;
    }
    public void solve(String str,int index, List<String> arr)
    {
        if(!isValid(str))
        {
            return;
        }
        maxLength = Math.max(maxLength, str.length());
        if(index < 0)
        {
            return;
        }

        solve(str, index - 1, arr);
        solve(str + arr.get(index) , index - 1, arr);
    }
    public boolean isValid(String str)
    {
        int map[] = new int[26];
        boolean flag = true;
        for(char ch : str.toCharArray())
        {
            map[ch-'a']++;
            if(map[ch - 'a'] > 1)
            {
                flag = false;
                break;
            }
        }
        return flag;
    }
}