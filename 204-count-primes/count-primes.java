class Solution {
    public int countPrimes(int n) {
        if(n == 0 || n == 1 ) return 0;
        int prime[] = seive(n);
        int count = 0;
        for(int i = 2; i < n; i++){
            if(prime[i] == 1) count++;
        }
        return count;
    }
    public int[] seive(int n)
    {
        int arr[] = new int[n + 1];
        Arrays.fill(arr, 1);

        for(int i = 2; i <= n; i++)
        {
            if(arr[i] == 0) continue;
            for(int j = 2 * i ; j <= n; j +=i){
                arr[j] = 0;
            }
        }
        return arr;
    }
}