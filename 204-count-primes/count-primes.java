class Solution {
    public int countPrimes(int n) {
        int isPrime[]= new int[n + 1];

        for(int i = 2 ; i*i < n ; i++)
        {
            for(int j = i*i ; j < n; j += i)
            { 
                isPrime[j] = 1;
            }
        }   
        int count = 0;
        for(int i = 2; i < n; i++)
        {
            count += (isPrime[i] == 0 ? 1 : 0);
        }
        return count;
    }
}