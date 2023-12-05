class Solution {
    public int numberOfMatches(int n) {
        int totalMatch = 0;

        while(true)
        {
            if(n == 1) break;
            if(n %2 == 0)
            {
                totalMatch += (n/2);
                n /= 2;
            }else{
                totalMatch += ((n-1) / 2);
                n = ((n - 1) / 2) + 1;
            }
        }
        return totalMatch;
    }
}