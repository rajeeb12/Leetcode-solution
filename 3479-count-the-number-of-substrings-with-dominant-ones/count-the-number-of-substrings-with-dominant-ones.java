class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int prefix[] = new int[n];

        for(int i = 0; i < n; i++)
        {
            prefix[i] = s.charAt(i)-'0';
        }

        for(int i = 1; i < n; i++){
            prefix[i] += prefix[i - 1];
        }
        int ans = 0;
        for(int i = 0; i < n; i++)
        {
            for(int j = i; j < n; j++)
            {
                int ones = prefix[j];
                if(i != 0) ones -= prefix[i - 1];
                int zero = j - i + 1 - ones;

                if(zero * zero > ones) j += ((zero * zero) - ones - 1);

                if(zero * zero <= ones){
                    ans++;
                    if(zero * zero < ones)
                    {
                        int diff = (int) Math.sqrt(ones) - (zero);
                        int nextj = j + diff;
                        if(nextj >= n){
                            ans += (n - j - 1);
                        }else{
                            ans += diff;
                        }
                        j = nextj;
                    }
                } 

            }
        }
        return ans;
    }
}