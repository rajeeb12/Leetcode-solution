class Solution {
    public int numberOfBeams(String[] bank) {
        // optimising space
        // storing previous count in prev named variable.
        int prev = 0;
        int ans = 0;
        for(String str: bank)
        {
            int count = 0;
            for(char ch: str.toCharArray())
            {
                if(ch == '1') count++;
            }
            if(count == 0) continue;
            ans += (count * prev);
            prev = count;
        }
        return ans;
    }
}