class Solution {
    public int nonSpecialCount(int l, int r) {
        int totalNum = r - l + 1;
        int limit = (int) Math.sqrt(r);
        boolean isPrime[] = seive(limit);
        int countPrimeSquare = 0;

        for(int i = 2; i <= limit; i++)
        {
            if(!isPrime[i])
            {
                int square = i * i;
                if(square >= l && square <= r){
                    countPrimeSquare++;
                } 
            }
        }
        return totalNum - countPrimeSquare;
    }
    public boolean[] seive(int n)
    {
        boolean notprime[] = new boolean[n + 1];

        notprime[1] = true;
        
        for(int i = 2; i <= n; i++){
            if(notprime[i]) continue;

            for(int j = i * 2 ; j <= n; j += i){
                notprime[j] = true;
            }
        }
        return notprime;
    }
}