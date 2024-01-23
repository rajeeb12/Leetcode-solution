class Solution {
    public int maxLength(List<String> arr) {
        int n = arr.size();
        return solve("",n - 1,arr);
    }
    public int solve(String str,int index, List<String> arr)
    {
        if(index < 0)
        {
            int map[] = new int[26];
            boolean flag = true;
            for(char ch : str.toCharArray())
            {
                map[ch-'a']++;
                if(map[ch - 'a'] > 1){
                    flag = false;
                    break;
                }
            }
            if(flag)
            {
                return str.length();
            }else{
                return -(int)1e9;
            }
        }

        int notPick = solve(str, index - 1, arr);
        int pick = solve(str + arr.get(index) , index - 1, arr);

        return Math.max(pick , notPick);
    }
}