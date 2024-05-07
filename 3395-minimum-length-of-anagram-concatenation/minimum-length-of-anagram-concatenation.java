class Solution {
    public int minAnagramLength(String s) {
        int n = s.length();
        for(int i = 1; i <= n; i++)
        {
            if(n % i == 0 && solve(s, i)){
                return i;
            }
        }
        return n;
    }
    public boolean solve(String s,int k){
        int n = s.length();
        int count[] = new int[26];

        for(int i = 0; i < k; i++)
        {
            count[s.charAt(i) -'a']++;
        }
        for(int i = k ; i < n; i += k)
        {
            int count2[] = new int[26];
            for(int j = i; j < i + k; j++)
            {
                count2[s.charAt(j) -'a']++;
            }
            for(int it = 0; it < 26; it++)
            {
                if(count[it] != count2[it]) return false;
            }
        }
        return true;
    }
}